package eu.vicci.process.model.sofiainstance.impl.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.OSGiInvokeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.util.ProcessStepUtil;
import eu.vicci.process.osgi.BundleManager;
import eu.vicci.process.osgi.OSGiRuntime;

public class OSGiInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements
		OSGiInvokeInstance {

	private List<DataTypeInstance> parameter = new ArrayList<DataTypeInstance>();
	private List<String> parameterNames = null;
	private OSGiRuntime runtime = null;
	private Method serviceMethod = null;
	private Object serviceClient = null;
	private String methodename = "";
	private String parameterTypeNamesSring = null;
	private OSGiInvoke invokeModelStep = null;

	/**
	 * Deploys the ProcessStep before execution.
	 * 
	 * By deploying ProcessSteps explicitly before executing them it becomes
	 * possible to validate the ProcessInstance. More over ProcessSteps that
	 * need some time for initializing (e.g. external devices) do so at a less
	 * critical point in time. Also the user has time for configuring the
	 * ProcessInstance according to his/her wishes.
	 * 
	 * @param mapper
	 *            MappingUtil is needed for the deployment process (e.g. to
	 *            avoid unwanted duplicates)
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	//TODO OSGI deployment is broken
	// remove absolute paths
	public void onDeploy(MappingUtil mapper, ActorRef parent) {
		super.deploy(mapper, parent);
		
		try {

			invokeModelStep = (OSGiInvoke) this.getProcessStepType();

			// getting the OSGi framework and start it if necessary
			runtime = OSGiRuntime.getInstance();
			if (runtime.getState().equals("stopped")) {
				runtime.start();
			}

			// getting the frameworks BundleContext and search for the
			// needed
			// service
			BundleContext context = runtime.getFramework().getBundleContext();
			ServiceReference reference = context
					.getServiceReference("eu.vicci.process.osgi.client.OSGiBridge");

			// check if the service was found
			if (reference == null) {
				// no service available -> getting the BundleManager an
				// install
				// the corresponding Bundle that provides that service and
				// search again
				BundleManager manager = BundleManager.getInstance();
				
				// correct path is needed!
				manager.installBundle("file:C:/eclipse_kepler/workspace_vicci4/eu.vicci.process.test/bundles/plugins/"
						+ invokeModelStep.getBundleName()); // eu.vicci.process.osgi.client_1.0.0.201308271604.jar
				// start is needed!
				reference = context.getServiceReference("eu.vicci.process.osgi.client.OSGiBridge");
			}

			// creating a "client"
			serviceClient = context.getService(reference);

			// searching in the client for the right method
			Class c = serviceClient.getClass();
			serviceMethod = c.getMethod(methodename);

			if (serviceMethod == null) {
				System.out.println("Methode nicht gefunden!");
			}

			// making the parameter Types accessible
			parameterNames = new ArrayList<String>();
			String[] typenames = parameterTypeNamesSring.split(":");
			for (String s : typenames) {
				if (!s.equals("")) {
					parameterNames.add(s);
				}
			}

			ProcessStepUtil.deploy(this, mapper);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
		try {
			// defining the service parameter as an Object array
			Object[] parameterValues = new Object[parameterNames.size()];
			int i = 0;
			for (String typename : parameterNames) {
				for (DataTypeInstance dataValue : parameter) {
					if (typename.equals(dataValue.getDataTypeType().getName())) {
						setParameter(parameterValues, i, dataValue);
					}
				}
				i++;
			}
			Object callReturnValue = serviceMethod.invoke(serviceClient, parameterValues);

			// handle return
			returnValues.add(convertToDataTypeInstance(callReturnValue));

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private Object[] setParameter(Object[] vektor, int pos, DataTypeInstance parameter) {

		if (parameter instanceof StringTypeInstance) {
			vektor[pos] = ((StringTypeInstance) parameter).getValue();
		}

		if (parameter instanceof BooleanTypeInstance) {
			vektor[pos] = ((BooleanTypeInstance) parameter).isValue();
		}

		if (parameter instanceof DoubleTypeInstance) {
			vektor[pos] = new Double(((DoubleTypeInstance) parameter).getValue());
		}

		if (parameter instanceof IntegerTypeInstance) {
			vektor[pos] = new Integer(((IntegerTypeInstance) parameter).getValue());
		}
		return vektor;
	}

	private DataTypeInstance convertToDataTypeInstance(Object o) {
		DataTypeInstance instance = null;
		if (o instanceof String) {
			StringTypeInstance si = new StringTypeInstanceImplCustom();
			si.setValue((String) o);
			instance = si;
		}

		if (o instanceof Integer) {
			IntegerTypeInstance ii = new IntegerTypeInstanceImplCustom();
			ii.setValue(((Integer) o).intValue());
			instance = ii;
		}

		if (o instanceof Double) {
			DoubleTypeInstance di = new DoubleTypeInstanceImplCustom();
			di.setValue(((Double) o).doubleValue());
			instance = di;
		}

		if (o instanceof Boolean) {
			BooleanTypeInstance bi = new BooleanTypeInstanceImplCustom();
			bi.setValue(((Boolean) o).booleanValue());
			instance = bi;
		}

		return instance;
	}
}
