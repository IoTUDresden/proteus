/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2012 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    cbrand - Bug 377475 - Fix AbstractCustomFeature.execute and canExecute
 *
 * </copyright>
 *
 *******************************************************************************/
package eu.vicci.process.graphiti.feature;

import java.util.Map;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.Invoke;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.Transition;

public class RenameTaskFeature extends AbstractCustomFeature {

    private boolean hasDoneChanges = false;

    public RenameTaskFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public String getName() {

        return "Re&name Task"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {

        return "Change the name of the Task"; //$NON-NLS-1$
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a Task is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object object = getBusinessObjectForPictogramElement(pes[0]);
            if (object instanceof Invoke)
                ret = true;
            if (object instanceof Transition)
                ret = true;
        }
        return ret;
    }

    @Override
    public void execute(ICustomContext context) {

        PictogramElement[] pes = context.getPictogramElements();

        if (pes != null && pes.length == 1) {
            Object object = getBusinessObjectForPictogramElement(pes[0]);

            if (object instanceof ProcessStep) {
            	ProcessStep invoke = (ProcessStep) object;
                String currentName = invoke.getName();
                final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
                        AttributeMap.instance().getObjectMap(object);
                
                // ask user for a new name
                String newName = Util.askString("Rename Task", getDescription(), currentName); //$NON-NLS-1$

                if (newName != null && !newName.equals(currentName)) {

                    this.hasDoneChanges = true;
                    invoke.setName(newName);
                    updatePictogramElement(pes[0]);
                    
                    if (map != null) {
                        org.eclipse.graphiti.mm.algorithms.Text text = map.get("name");
                        if (text != null)
                            text.setValue("name: " + newName);
                    }
                }
            }

            if (object instanceof Transition) {
                Transition trans = (Transition) object;

                String currentName = trans.getName();

                // ask user for a new name
                String newName = Util.askString("Rename Task", getDescription(), currentName); //$NON-NLS-1$

                if (newName != null && !newName.equals(currentName)) {

                    this.hasDoneChanges = true;
                    trans.setName(newName);

                    Util.redrawConnectionDecorator(trans, getDiagram());
                    updatePictogramElement(pes[0]);
                }
            }
        }
    }

    @Override
    public boolean hasDoneChanges() {

        return this.hasDoneChanges;
    }
}
