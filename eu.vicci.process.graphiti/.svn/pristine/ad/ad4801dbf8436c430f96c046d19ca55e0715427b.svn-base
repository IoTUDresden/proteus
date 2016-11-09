package eu.vicci.process.graphiti.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.vicci.process.model.sofia.HTTPverb;
import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.RESTInvoke;
import eu.vicci.process.model.sofia.ROSInvoke;
import eu.vicci.process.model.sofia.SOAPInvoke;
import eu.vicci.process.model.sofia.SeMiWaInvoke;
import eu.vicci.process.model.sofia.SeMiWaRequest;
import eu.vicci.process.model.sofia.TriggeredEvent;
import eu.vicci.process.model.sofia.XMLRPCInvoke;

public class DirectEditFeature extends AbstractDirectEditingFeature {

	private String propertyTitle;

	public DirectEditFeature(IFeatureProvider fp) {

		super(fp);
	}

	@Override
	public int getEditingType() {

		return TYPE_TEXT;
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {		
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		// System.out.println(ga);
		// support direct editing, if it is a Task, and the user clicked
		// directly on the text and not somewhere else in the rectangle
		if ((bo instanceof ProcessStep) && (ga instanceof Text))
			return true;

		// direct editing not supported in all other cases
		return false;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		String string = "";
		// return the current name of the Task
//		PictogramElement pe = context.getPictogramElement();
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
//		Object bo = getBusinessObjectForPictogramElement(pe);

		if (ga instanceof Text) {
			for (Property prop : ga.getProperties()) {
				if (prop.getKey().equals("name")) {
					string = ((Text) ga).getValue();
					propertyTitle = prop.getValue();
					string = string.replaceFirst(propertyTitle+":", "");
					string = string.trim();
					break;
				}
			}
		}

		return string;
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {

		// if (value.length() < 1)
		// return "Please enter a task name.";

		if (value.contains("\n"))
			return "Line breakes are not allowed in task names.";

		// null means, that the value is valid
		return null;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		// set the new name for the MOF class
		PictogramElement pe = context.getPictogramElement();
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		ProcessStep task = (ProcessStep) getBusinessObjectForPictogramElement(pe);
//		Object bo = getBusinessObjectForPictogramElement(pe);
//		final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
//                AttributeMap.instance().getObjectMap(bo);
		
		if(propertyTitle.equals("name")){
			task.setName(value);
		}
		if(propertyTitle.equals("type")){
			task.setType(value);
		}
		if(propertyTitle.equals("resource")){
			task.setResource(value);
		}
		
		if(task instanceof OSGiInvoke){			
			OSGiInvoke inv = (OSGiInvoke) task;
			
			if(propertyTitle.equals("service")){
				inv.setServiceClassName(value);
			}
			if(propertyTitle.equals("method")){
				inv.setMethodName(value);
			}
			if(propertyTitle.equals("parameter")){
				inv.setParameterTypes(value);
			}
			if(propertyTitle.equals("bundle")){
				inv.setBundleName(value);
			}
		}
		
		if(task instanceof SOAPInvoke){			
			SOAPInvoke inv = (SOAPInvoke) task;
			
			if(propertyTitle.equals("server")){
				inv.setServerUri(value);
			}
			if(propertyTitle.equals("method")){
				inv.setMethodName(value);
			}
			if(propertyTitle.equals("wsdl")){
				inv.setWsdlUri(value);
			}
			if(propertyTitle.equals("config")){
				inv.setConfigFile(value);
			}
		}
		
		if(task instanceof RESTInvoke){			
			RESTInvoke inv = (RESTInvoke) task;
			
			if(propertyTitle.equals("server")){
				inv.setServerUri(value);
			}
			if(propertyTitle.equals("method")){
				inv.setHTTPMethod(HTTPverb.get(value));
			}			
		}
		
		if(task instanceof ROSInvoke){			
			ROSInvoke inv = (ROSInvoke) task;
			
			if(propertyTitle.equals("server")){
				inv.setServerUri(value);
			}
			if(propertyTitle.equals("service")){
				inv.setServiceName(value);
			}
		}
		
		if(task instanceof XMLRPCInvoke){			
			XMLRPCInvoke inv = (XMLRPCInvoke) task;
			
			if(propertyTitle.equals("server")){
				inv.setServerUri(value);
			}
			if(propertyTitle.equals("method")){
				inv.setMethodName(value);
			}
			if(propertyTitle.equals("start sequence")){
				inv.setStartParameterSequence(value);
			}
			if(propertyTitle.equals("end sequence")){
				inv.setEndParameterSequence(value);
			}
		}
		
		if(task instanceof SeMiWaInvoke){			
			SeMiWaInvoke inv = (SeMiWaInvoke) task;
			
			if(propertyTitle.equals("service")){
				inv.setServiceName(value);
			}
			if(propertyTitle.equals("nodeID")){
				inv.setNodeId(value);
			}			
		}
		
		if(task instanceof SeMiWaRequest){			
			SeMiWaRequest req = (SeMiWaRequest) task;
			
			if(propertyTitle.equals("ssil")){
				req.setSSILStatement(value);
			}		
		}
		
		if(task instanceof TriggeredEvent){			
			TriggeredEvent evt = (TriggeredEvent) task;
			
			if(propertyTitle.equals("EPL")){
				evt.setEPLStatement(value);
			}		
		}
		
		if(propertyTitle!=null && !propertyTitle.equals("") && ga instanceof Text){
			((Text)ga).setValue(propertyTitle+": "+value);
		}

		updatePictogramElement(((Shape) pe).getContainer());
		return;
	}
}
