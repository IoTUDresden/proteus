package eu.vicci.process.graphiti.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.sofia.Nameable;

public class ValidationTreeDialog extends TitleAreaDialog {

    private class Status {

        private Color fgColor;
        private Color bgColor;
        private boolean filled;

        public Color getFgColor() {
            return fgColor;
        }

        public Color getBgColor() {
            return bgColor;
        }

        public boolean isFilled() {
            return filled;
        }

        Status(Color fgColor, Color bgColor, boolean filled) {

            this.fgColor = fgColor;
            this.bgColor = bgColor;
            this.filled = filled;
        }
    }

    Iterable<ConstraintStatus> status = null;
    Map<EObject, TreeItem> map = null;
    IFeatureProvider featureProvider = null;
    Set<PictogramElement> selected = null;

    Map<PictogramElement, Status> originalStatus = null;

    private static final IColorConstant HIGHLIGHT =
            new ColorConstant(255, 180, 180);

    Image okImage = null;
    Image errorImage = null;
    Image warningImage = null;

    public ValidationTreeDialog(IFeatureProvider provider, Shell parent,
            Iterable<ConstraintStatus> status) {

        super(parent);
        this.status = status;
        featureProvider = provider;

        map = new HashMap<EObject, TreeItem>();
        selected = new HashSet<PictogramElement>();
        originalStatus = new HashMap<PictogramElement, Status>();

        okImage = Util.loadImage("media/ok.png", true);
        warningImage = Util.loadImage("media/warning.png", true);
        errorImage = Util.loadImage("media/error.png", true);
    }

    private TreeItem buildTree(TreeItem root, EObject object, ConstraintStatus status, Image errorIcon) {

        TreeItem item = null;
        if (map.containsKey(object)) {
            item = map.get(object);
            if (status != null && object == status.getTarget()) {
                item.setText(item.getText() + "\n" + status.getMessage());
                @SuppressWarnings("unchecked")
                Set<EObject> objects = (Set<EObject>) item.getData("EObjects");
                objects.add(object);
                Set<EObject> locus = status.getResultLocus();
                if (locus != null && !locus.isEmpty())
                    for (EObject o : locus)
                        objects.add(o);
                item.setImage(errorIcon);
            }
            return item;
        }

        // root reached
        if (object.eContainer() == null)
            item = new TreeItem(root, SWT.BORDER);
        else
            item = new TreeItem(buildTree(root, object.eContainer(), status,
                    errorIcon), SWT.BORDER);

        String name = null;
        String id = null;
        String type = object.getClass().getSimpleName();

        if (object instanceof Nameable)
            name = ((Nameable) object).getName();
        if (object instanceof Identifiable)
            id = ((Identifiable) object).getId();

        item.setText(type + " (id: " + id + ") (name: " + name + ")");
        if (status != null && object == status.getTarget()) {
            item.setText(item.getText() + "  --> " + status.getMessage());
            Set<EObject> objects = new HashSet<EObject>();
            objects.add(object);
            Set<EObject> locus = status.getResultLocus();
            if (locus != null && !locus.isEmpty())
                for (EObject o : locus)
                    objects.add(o);

            item.setData("EObjects", objects);
            item.setImage(errorIcon);
        }

        map.put(object, item);
        return item;
    }

    @Override
    protected void setShellStyle(int newShellStyle) {

        super.setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
        setBlockOnOpen(false);
        setDialogHelpAvailable(false);
    }

    @Override
    protected void okPressed() {

        for (PictogramElement element : selected) {
            GraphicsAlgorithm g = element.getGraphicsAlgorithm();
            if (g instanceof RoundedRectangle) {
                Status status = originalStatus.get(element);
                if (status != null) {
                    ((RoundedRectangle) g).setFilled(status.isFilled());
                    ((RoundedRectangle) g).setForeground(status.getFgColor());
                    ((RoundedRectangle) g).setBackground(status.getBgColor());
                }
            }
        }

        super.okPressed();
    }

    @Override
    protected void handleShellCloseEvent() {

        for (PictogramElement element : selected) {
            GraphicsAlgorithm g = element.getGraphicsAlgorithm();
            if (g instanceof RoundedRectangle) {
                Status status = originalStatus.get(element);
                if (status != null) {
                    ((RoundedRectangle) g).setFilled(status.isFilled());
                    ((RoundedRectangle) g).setForeground(status.getFgColor());
                    ((RoundedRectangle) g).setBackground(status.getBgColor());
                }
            }
        }

        super.handleShellCloseEvent();
    }

    private void expand(Tree tree) {

        for (TreeItem i : tree.getItems())
            expand(i);
    }

    private void expand(TreeItem item) {

        item.setExpanded(true);
        for (TreeItem i : item.getItems())
            expand(i);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {

        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    @Override
    protected Control createDialogArea(Composite parent) {

        Composite contents = new Composite(parent, SWT.NONE);
        contents.setLayoutData(new GridData(GridData.FILL_BOTH));

        final Tree tree = new Tree(contents, SWT.MULTI | SWT.BORDER);
        tree.setBounds(0, 0, 600, 400);

        TreeItem root = new TreeItem(tree, SWT.BORDER);
        root.setText("Validation Result");
        Image errorIcon = Util.loadImage("media/error-small.png", true);

        for (ConstraintStatus s : status)
            buildTree(root, s.getTarget(), s, errorIcon);

        if (root.getItemCount() > 0) {
            setTitle("Validation failed");
            setTitleImage(errorImage);
        } else {
            setTitle("Validation succeeded");
            setTitleImage(okImage);
            root.dispose();
        }

        expand(tree);

        tree.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(Event e) {
                TreeItem[] selection = tree.getSelection();
                for (TreeItem item : selection) {

                    final Set<PictogramElement> elements = new HashSet<PictogramElement>();
                    @SuppressWarnings("unchecked")
                    Set<EObject> objects = (Set<EObject>) item.getData("EObjects");
                    if (objects != null) {
                        for (EObject object : objects) {
                            PictogramElement element =
                                    featureProvider.getPictogramElementForBusinessObject(object);
                            if (element != null)
                                elements.add(element);
                        }
                    }

                    Display.getDefault().asyncExec(new Runnable() {
                        @Override
                        public void run() {

                            Vector<PictogramElement> dirty = new Vector<PictogramElement>();

                            for (PictogramElement s : selected) {
                                if (s != null) {
                                    dirty.add(s);
                                    GraphicsAlgorithm g = s.getGraphicsAlgorithm();
                                    if (g instanceof RoundedRectangle) {
                                        Status status = originalStatus.get(s);
                                        if (status != null) {
                                            ((RoundedRectangle) g).setFilled(status.isFilled());
                                            ((RoundedRectangle) g).setForeground(status.getFgColor());
                                            ((RoundedRectangle) g).setBackground(status.getBgColor());
                                        }
                                    }
                                }
                            }

                            selected.clear();

                            for (PictogramElement element : elements) {
                                if (element != null) {

                                    GraphicsAlgorithm g = element.getGraphicsAlgorithm();
                                    if (!originalStatus.containsKey(element)) {
                                        if (g instanceof RoundedRectangle) {
                                            RoundedRectangle r = (RoundedRectangle) g;
                                            Status status =
                                                    new Status(r.getForeground(), r.getBackground(), r.getFilled());
                                            originalStatus.put(element, status);
                                        }
                                    }

                                    selected.add(element);
                                    dirty.add(element);
                                    if (g instanceof RoundedRectangle) {
                                        IGaService gaService = Graphiti.getGaService();
                                        ((RoundedRectangle) g).setFilled(true);
                                        ((RoundedRectangle) g).setBackground(gaService.manageColor(featureProvider.getDiagramTypeProvider().getDiagram(), HIGHLIGHT));
                                    }
                                }
                            }

                            if (dirty.size() > 0) {
                                featureProvider.getDiagramTypeProvider().getNotificationService().updatePictogramElements(dirty.toArray(new PictogramElement[dirty.size()]));
                                featureProvider.getDiagramTypeProvider()
                                        .getDiagramBehavior().refresh();
                            }
                        }
                    });
                }
            }
        });

        return contents;
    }
}
