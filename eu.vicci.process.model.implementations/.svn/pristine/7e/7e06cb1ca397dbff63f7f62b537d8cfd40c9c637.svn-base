package eu.vicci.process.model.sofiainstance.util;

import java.util.List;
import java.util.Timer;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartPortInstance;
import eu.vicci.process.model.sofiainstance.State;

/**
 * 
 * @author Reik M�ller
 * 
 */
public class ProcessStepUtil {

	public static boolean execute(ProcessStepInstance inst) {
		InternalProcessStepInterface instUtil = null;
		if (inst instanceof InternalProcessStepInterface)
			instUtil = (InternalProcessStepInterface) inst;
		instUtil.logInfo(inst.getExecutionState().toString()
				+ " permission: " + inst.getPermission());
		try {
			switch (inst.getExecutionState()) {
			default:
				System.out.println("Execution denied. state: "
						+ inst.getExecutionState());
				break;

			// if the ProcessStep has never been called before the state is
			// INACTIVE. On the first call the state will be changed to ACTIVE
			case INACTIVE:
				instUtil.logInfo("-------------> execution started");
				instUtil.changeExecutionState(State.ACTIVE);
				inst.execute();
				return true;

				// the processStep has been already completed. The Process may
				// have been blocked when processing another ProcessStep.
				// the forwardReactivation() calls following steps without
				// parameters
			case EXECUTED:
				instUtil.forwardReactivation();
				return true;

				// the processStep had been called already but due to missing
				// permissions or inactive StartPorts not been executed
			case ACTIVE:
				if (instUtil.allStartPortsActive()) {
					switch (inst.getPermission()) {
					case GRANTED:
						instUtil.cancelTimer();
						instUtil.changeExecutionState(State.EXECUTING);
						instUtil.startSubProcesses();
						instUtil.aggregateStartParameter();
						instUtil.work();
						instUtil.activateControlEndPorts();
						instUtil.activateDataEndPorts();
						instUtil.changeExecutionState(State.EXECUTED);
						instUtil.logInfo("-------------> execution finished");
						return true;

					case DENIED:
						// TODO inform user that the process is blocked
						return false;

					case DELAYED:
						instUtil.executeDelay();
						return false;
					default:
						break;

					}
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Setting the a new execution permission. In case that the ProcessStep
	 * might be activated but blocked (for example by the execution permission
	 * "execution denied" the ProcessStep will be activated immediately.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 * @param newPermission
	 *            The new execution permission
	 */
	public static void setPermission(ProcessStepInstance inst,
			ExecutionPermission newPermission) {
		if (inst.getExecutionState() == State.ACTIVE)
			inst.execute();
	}

	/**
	 * Setting an new delay. The delay describes how much time the process step
	 * waits between getting an activation that leads to the execution of the
	 * process step and the access of the execution routine. In case that the
	 * process step is already in the delay phase setting a new delay
	 * reschedules the the process step. Thus the delay can be shortened or
	 * extended.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 * @param newDelay
	 *            The new delay in milliseconds.
	 */
	public static void setDelay(ProcessStepInstance inst, long newDelay) {
		// set new delay
		inst.setDelay(newDelay);
		if (inst instanceof InternalProcessStepInterface) {
			InternalProcessStepInterface utilInst = (InternalProcessStepInterface) inst;

			// if the processStep start is already scheduled, it must be
			// rescheduled
			if (utilInst.getTimer() != null && utilInst.getTimerTask() != null) {
				utilInst.getTimerTask().cancel();
				utilInst.getTimer().schedule(utilInst.getTimerTask(), newDelay);
			}
		}
	}

	/**
	 * Checks if the AND aspect of the ProcessStep is full filled, meaning
	 * whether all in going Ports are activated. Please note that there might be
	 * ports that are not necessary for execution. These are marked with an
	 * optional flag and are considered in the AND-aspect decision.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 * @return True if all StartPorts are activated. False if one or more
	 *         StartPorts are not activated.
	 */

	public static boolean allPortsActive(ProcessStepInstance inst) {
		boolean isAllActive = true;
		for (PortInstance port : inst.getPorts()) {
			if (port instanceof StartPortInstance) {
				Port p = (Port) port.getPortType();
				if (port.getExecutionState() == State.INACTIVE
						&& !p.isOptional())
					isAllActive = false;
			}
		}
		return isAllActive;
	}

	/**
	 * Forwards a start or execute call in the case that the ProcessStep is in
	 * state EXECUTED.<br>
	 * <br>
	 * This method is used to propagate the reactivating start or execute call
	 * after the entire process had been paused or stopped. The ProcessStep
	 * itself will not be executed again.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void forwardReactivation(ProcessStepInstance inst) {
		for (PortInstance port : inst.getPorts()) {
			if (port instanceof EndPortInstance)
				port.activate(null);
		}
	}

	/**
	 * Changing execution state.<br>
	 * <br>
	 * This method sets the ExecutionState and can be used to perform standard
	 * behavior related to execution state changes like informing the user
	 * interfaces.
	 * 
	 * @param state
	 *            The new ExecutionState
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void changeExecutionState(ProcessStepInstance inst,
			State state) {
		System.out.println(inst.getProcessStepType().getName()
				+ ".changeState() oldstate:" + inst.getExecutionState()
				+ "    newstate:" + state);
		inst.setExecutionState(state);
	}

	/**
	 * Telling the StartPorts to execute linked SubProcessSteps.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void startSubProcesses(ProcessStepInstance inst) {
		for (PortInstance port : inst.getPorts()) {
			if (port instanceof StartPortInstance) {
				StartPortInstance startPort = (StartPortInstance) port;
				startPort.executeSubSteps();
			}
		}
	}

	/**
	 * Canceling timer to give free resources and to let the application
	 * terminate correctly.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void cancelTimer(ProcessStepInstance inst) {
		if (inst instanceof InternalProcessStepInterface) {
			InternalProcessStepInterface utilInst = (InternalProcessStepInterface) inst;

			if (utilInst.getTimer() != null) {
				utilInst.getTimer().cancel();
			}
		}
	}

	/**
	 * Getting the parameter from StartDataPorts.<br>
	 * <br>
	 * This method aggregates all parameters from all StartDataPorts and
	 * provides them by filling the field StartParameter.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void aggregateStartParameter(ProcessStepInstance inst) {
		if (inst instanceof InternalProcessStepInterface) {
			InternalProcessStepInterface utilInst = (InternalProcessStepInterface) inst;
			for (PortInstance port : inst.getPorts()) {
				if (port instanceof DataPortInstance) {
					DataPortInstance dataPortInstance = (DataPortInstance) port;
					utilInst.getStartParameter().add(
							dataPortInstance.getDataInstance());
				}
			}
		}
	}

	/**
	 * Activating outgoing data ports.<br>
	 * <br>
	 * This method fills all EndDataPorts with their respective information
	 * simply by matching the names of all items of the field 'returnValue' and
	 * the names of the data fields of all EndDataPorts.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void activateDataEndPorts(ProcessStepInstance inst) {
		if (inst instanceof InternalProcessStepInterface) {
			InternalProcessStepInterface utilInst = (InternalProcessStepInterface) inst;
			if (!utilInst.getReturnValues().isEmpty()) {

				for (PortInstance port : inst.getPorts()) {
					if (port instanceof EndDataPortInstance) {
						DataPortInstance port1 = (DataPortInstance) port;
						for (DataTypeInstance dataInstance : utilInst
								.getReturnValues()) {
							// preparing names for matching
							String dataId = dataInstance.getDataTypeType()
									.getName();
							String wantedDataId = port1.getDataInstance()
									.getDataTypeType().getName();
							// matching names
							if (dataId.equals(wantedDataId)) {
								port.activate(dataInstance);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Activating outgoing control ports.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void activateControlEndPorts(ProcessStepInstance inst) {
		for (PortInstance port : inst.getPorts()) {
			if (port instanceof EndControlPortInstance) {
				port.activate(null);
			}
		}
	}

	/**
	 * Delays the execution for a certain time span. <br>
	 * <br>
	 * The delay used has to be specified by using the method configure(). The
	 * standard delay is specified in the constructor. Using the timer the
	 * control flow goes directly back to the caller. A delay of zero can be
	 * used to decouple the control flow but this is neither the correct way to
	 * do so (please use the flag "isDecoupled" in the configuration class) nor
	 * is it recommended due to overhead.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 */
	public static void executeDelay(ProcessStepInstance inst) {
		if (inst instanceof InternalProcessStepInterface) {
			InternalProcessStepInterface utilInst = (InternalProcessStepInterface) inst;

			if (utilInst.getTimer() == null) {
				Timer timer = new Timer();
				ProcessStepTimerTask timerTask = new ProcessStepTimerTask(inst);
				timer.schedule(timerTask, inst.getDelay());
				System.err.println("Timer scheduled");
			}
		}
	}

	public static void deploy(ProcessStepInstance inst, MappingUtil mapper) {
		if (inst.getExecutionState() == State.UNDEPLOYED) {
			// System.out.println("processstep.deploy()"
			// + inst.getProcessStepType().getId() + " UTIL");
			inst.setExecutionState(State.INACTIVE);

			// deploy sub-steps
			if (inst.getProcessStepType() instanceof CompositeStep) {
				CompositeStep parentStep = (CompositeStep) inst
						.getProcessStepType();
				List<ProcessStep> steps = parentStep.getSubSteps();
				for (ProcessStep step : steps) {
					ProcessStepInstance instance = mapper.mapProcessStep(step);
					instance.deploy(mapper);
					inst.getSubSteps().add(instance);
				}
			}

			// deploy ports
			for (Port p : inst.getProcessStepType().getPorts()) {
				// System.out.println("port " + p.getId() + " get's deployed");
				if (p instanceof Port) {
					// check if the port is already mapped
					boolean isMapped = false;
					for (PortInstance instance : inst.getPorts()) {
						if (instance.getPortType().getId().equals(p.getId()))
							isMapped = true;
					}
					if (!isMapped) {
						PortInstance portInstance = mapper.mapPort(p);
						inst.getPorts().add(portInstance);
						portInstance.deploy(mapper);
					}
				}
			}
			// System.out.println("processstep.deploy END() "
			// + inst.getProcessStepType().getId() + " UTIL");

		} else {

		}

	}

	public static void configure(ProcessStepInstance inst, Configuration conf) {
		boolean correctId = false;

		System.out.println("configure step: "
				+ inst.getProcessStepType().getId());

		if (inst.getProcessStepType().getId().equals(conf.getInstanceId())) {
			configure1(inst, conf);
			correctId = true;

		} else if (conf.getInstanceId() == null) {
			configure1(inst, conf);
		}

		if (inst.getProcessStepType() instanceof CompositeStep
				&& correctId == false) {
			for (ProcessStepInstance inst3 : inst.getSubSteps()) {
				inst3.configure(conf);
			}
		}
	}
	
	public static void consoleOutput(ProcessStepInstance inst, String info) {
		System.out.println(inst.getClass().getSimpleName() + ": " + info);
	}

	private static void configure1(ProcessStepInstance inst, Configuration conf) {
		// decouple following steps
		if (conf.isDecoupleNextSteps()) {
			System.out.println("following steps decoupled");
			for (PortInstance portInstance : inst.getPorts()) {
				// if (portInstance instanceof EndPortInstance) {
				portInstance.setDecoupled(true);
				// }
			}
		}

		// set delay
		if (conf.getDelay() >= 0) {
			inst.setDelay(conf.getDelay());
		}

		// set permission
		if (conf.getPermission() != null) {
			inst.setPermission(conf.getPermission());
		}
	}

}
