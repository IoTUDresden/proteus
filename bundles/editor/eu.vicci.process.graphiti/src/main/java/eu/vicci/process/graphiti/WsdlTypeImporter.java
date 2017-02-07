package eu.vicci.process.graphiti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import com.predic8.schema.Element;
import com.predic8.schema.Schema;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;

import eu.vicci.process.graphiti.types.BooleanTypeCreateFeature;
import eu.vicci.process.graphiti.types.ComplexTypeCreateFeature;
import eu.vicci.process.graphiti.types.DoubleTypeCreateFeature;
import eu.vicci.process.graphiti.types.IntegerTypeCreateFeature;
import eu.vicci.process.graphiti.types.StringTypeCreateFeature;
import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.StringType;

public class WsdlTypeImporter {
	public static void parse(final String wsdlUri, final ProcessFeatureProvider pfp, final ContainerShape target, final Diagram diagram) {
		
		if (wsdlUri.length() > 3 && wsdlUri.toLowerCase().contains("wsdl")) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(target);
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

                protected void doExecute() {

					WSDLParser parser = new WSDLParser();

					Definitions defs = parser.parse(wsdlUri);

					int yPosition = 30;

					for (Schema schema : defs.getSchemas()) {

						for (com.predic8.schema.ComplexType ct : schema.getComplexTypes()) {
							System.out.println(ct.getName());
							ComplexType ctObject = createComplexType(pfp, target, ct.getName());
							for (Element elem : ct.getSequence().getElements()) {
								if (elem.getType().getLocalPart().toLowerCase().equals("string"))
									createStringType(pfp, Util.getContainerForBusinessObject(diagram, ctObject), elem.getName());
								if (elem.getType().getLocalPart().toLowerCase().equals("integer"))
									createIntegerType(pfp, Util.getContainerForBusinessObject(diagram, ctObject), elem.getName());
								if (elem.getType().getLocalPart().toLowerCase().equals("double"))
									createDoubleType(pfp, Util.getContainerForBusinessObject(diagram, ctObject), elem.getName());
								if (elem.getType().getLocalPart().toLowerCase().equals("boolean"))
									createBooleanType(pfp, Util.getContainerForBusinessObject(diagram, ctObject), elem.getName());
							}
							GraphicsAlgorithm ga = Util.getContainerForBusinessObject(diagram, ctObject).getGraphicsAlgorithm();
							ga.setX(target.getGraphicsAlgorithm().getWidth() - ga.getWidth() - 10);
							ga.setY(yPosition);
							yPosition += ga.getHeight() + 10;
						}
					}
					target.getGraphicsAlgorithm().setHeight(Math.max(target.getGraphicsAlgorithm().getHeight(), yPosition));
				}
			});
		}
	}

	protected static void createIntegerType(ProcessFeatureProvider pfp, ContainerShape target, String name) {
		IntegerTypeCreateFeature itc = new IntegerTypeCreateFeature(pfp);
		CreateContext context = new CreateContext();
		IntegerType it = (IntegerType) itc.create(context)[0];

		ILinkService ls = Graphiti.getLinkService();

		EObject parent = ls.getBusinessObjectForLinkedPictogramElement(target);
		if (parent instanceof ComplexType) {
			it.setBelongsTo((ComplexType) parent);
		}

		AddContext addContext = new AddContext();
		addContext.setNewObject(it);
		addContext.setTargetContainer(target);
		IAddFeature add = pfp.getAddFeature(addContext);

		if (addContext != null && add != null)
			add.add(addContext);

	}

	protected static void createDoubleType(ProcessFeatureProvider pfp, ContainerShape target, String name) {
		DoubleTypeCreateFeature dtc = new DoubleTypeCreateFeature(pfp);
		CreateContext context = new CreateContext();
		DoubleType dt = (DoubleType) dtc.create(context)[0];
		dt.setName(name);


		ILinkService ls = Graphiti.getLinkService();

		EObject parent = ls.getBusinessObjectForLinkedPictogramElement(target);
		if (parent instanceof ComplexType) {
			dt.setBelongsTo((ComplexType) parent);
		}

		AddContext addContext = new AddContext();
		addContext.setNewObject(dt);
		addContext.setTargetContainer(target);
		IAddFeature add = pfp.getAddFeature(addContext);

		if (addContext != null && add != null)
			add.add(addContext);

	}

	protected static void createStringType(ProcessFeatureProvider pfp, ContainerShape target, String name) {
		StringTypeCreateFeature stc = new StringTypeCreateFeature(pfp);
		CreateContext context = new CreateContext();
		StringType st = (StringType) stc.create(context)[0];
		st.setName(name);


		ILinkService ls = Graphiti.getLinkService();

		EObject parent = ls.getBusinessObjectForLinkedPictogramElement(target);
		if (parent instanceof ComplexType) {
			st.setBelongsTo((ComplexType) parent);
		}

		AddContext addContext = new AddContext();
		addContext.setNewObject(st);
		addContext.setTargetContainer(target);
		IAddFeature add = pfp.getAddFeature(addContext);

		if (addContext != null && add != null)
			add.add(addContext);

	}

	protected static void createBooleanType(ProcessFeatureProvider pfp, ContainerShape target, String name) {
		BooleanTypeCreateFeature btc = new BooleanTypeCreateFeature(pfp);
		CreateContext context = new CreateContext();
		BooleanType bt = (BooleanType) btc.create(context)[0];
		bt.setName(name);


		ILinkService ls = Graphiti.getLinkService();

		EObject parent = ls.getBusinessObjectForLinkedPictogramElement(target);
		if (parent instanceof ComplexType) {
			bt.setBelongsTo((ComplexType) parent);
		}

		AddContext addContext = new AddContext();
		addContext.setNewObject(bt);
		addContext.setTargetContainer(target);
		IAddFeature add = pfp.getAddFeature(addContext);

		if (addContext != null && add != null)
			add.add(addContext);

	}

	private static ComplexType createComplexType(ProcessFeatureProvider pfp, ContainerShape target, String name) {
		ComplexTypeCreateFeature ctc = new ComplexTypeCreateFeature(pfp);
		CreateContext context = new CreateContext();
		ComplexType ct = (ComplexType) ctc.create(context)[0];
		ct.setName(name);
		ILinkService ls = Graphiti.getLinkService();

		EObject parent = ls.getBusinessObjectForLinkedPictogramElement(target);

		if (parent instanceof ComplexType) {
			ct.setBelongsTo((ComplexType) parent);
		}

		AddContext addContext = new AddContext();
		addContext.setNewObject(ct);
		addContext.setTargetContainer(target);
		IAddFeature add = pfp.getAddFeature(addContext);

		if (addContext != null && add != null)
			add.add(addContext);

		return ct;
	}
}
