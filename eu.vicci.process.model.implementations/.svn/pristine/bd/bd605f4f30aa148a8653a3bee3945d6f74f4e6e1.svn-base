/*******************************************************************************
 * Copyright (c) 2013 Martin Franke (martin.franke@tu-dresden.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Martin Franke (martin.franke@tu-dresden.de)- initial API and implementation
 ******************************************************************************/
package eu.vicci.process.semiwa.commands;

import java.util.HashMap;

import eu.vicci.semiwa.node.impl.SeMiWaNodeProxy;
import eu.vicci.semiwa.node.tasking.command.abstrClasses.TaskingCommand;

/**
 * The Class AddTwoInts, using the command pattern.
 */
public class AddTwoInts extends TaskingCommand<Integer> {

	/**
	 * Instantiates a new adds the two ints.
	 */
	public AddTwoInts(SeMiWaNodeProxy receiver, HashMap<String, String> params) {
		super(receiver, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.vicci.semiwa.node.tasking.command.abstrClasses.TaskingCommand#processTask
	 * ()
	 */
	@Override
	protected Integer processTask() {

		Integer a = Integer.parseInt(this.getParams().get("param1"));
		Integer b = Integer.parseInt(this.getParams().get("param2"));

		return a + b;
	}

}
