package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.driver.robot.util.Speed;
import eu.vicci.driver.turtlebot.TurtleBot;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

/**
 * Process for evaluating the fbs with low battery values.
 */
public class MoveTurtleBatteryCheck  implements ProcessStepWorker {
	private static final Logger LOG = LoggerFactory.getLogger(MoveTurtle.class);	
	private static final String host = "";
	private static final String port = "";
	private static final Speed speed = new Speed(50); 
	private static final double curveRadius = 0;
	private static final int waitTime = 800;
	
	//to fake the bat level
	private static final boolean fakeBattery = false;
	private static final Integer normalBatLevel = 52;
	private static final Integer lowBatteryLevel = 49;
	
	private static final String utilClassName = "eu.vicci.process.server.util.Util";
	private static final String setStaticMethodName = "returnStaticBatteryLevel";
	private static final String setStaticLevelMethodName = "setStaticBatteryLevel";
	
	private Method returnStaticBatteryLevelMethod;
	private Method setStaticBatteryLevelMethod;
	

	@Override
	public List<DataTypeInstance> work(Context context) {
		TurtleBot robot = new TurtleBot(host, port);
		try {			
			robot.connect();
			LOG.debug("connected to turtle on {}:{}", host, port);
			robot.move(speed, curveRadius);
			Thread.sleep(waitTime);
			robot.stopMovement();
			
			if(fakeBattery)	
				setStaticBatteryLevelMethod.invoke(null, lowBatteryLevel);
			
			Thread.sleep(waitTime);
			robot.move(speed, curveRadius);
			Thread.sleep(waitTime);
			robot.stopMovement();
			
			if(fakeBattery)	
				setStaticBatteryLevelMethod.invoke(null, normalBatLevel);
			
			LOG.debug("moving the turtle finished");			
		} catch (Exception e) {
			try {
				if(fakeBattery) 
					setStaticBatteryLevelMethod.invoke(null, normalBatLevel);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		
			throw new RuntimeException(e);
		}		
		
		return context.endParameter;
	}

	@Override
	public void deploy() {
		if(!fakeBattery)
			return;
		try {
			Class<?> utilClazz = Class.forName(utilClassName);
			returnStaticBatteryLevelMethod = utilClazz.getDeclaredMethod(setStaticMethodName, boolean.class);
			setStaticBatteryLevelMethod = utilClazz.getDeclaredMethod(setStaticLevelMethodName, Integer.class);
			
			returnStaticBatteryLevelMethod.invoke(null, true);
			setStaticBatteryLevelMethod.invoke(null, normalBatLevel);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
