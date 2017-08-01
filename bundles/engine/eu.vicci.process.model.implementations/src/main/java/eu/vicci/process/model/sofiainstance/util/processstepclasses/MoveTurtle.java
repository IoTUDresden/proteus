package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.driver.robot.util.Speed;
import eu.vicci.driver.turtlebot.TurtleBot;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class MoveTurtle implements ProcessStepWorker {
	private static final Logger LOG = LoggerFactory.getLogger(MoveTurtle.class);
	
	private static final String host = "";
	private static final String port = "";
	private static final Speed speed = new Speed(50); 
	private static final double curveRadius = 0;
	private static final int waitTime = 800;

	@Override
	public List<DataTypeInstance> work(Context context) {
		TurtleBot robot = new TurtleBot(host, port);
		try {			
			robot.connect();
			LOG.debug("connected to turtle on {}:{}", host, port);
			robot.move(speed, curveRadius);
			Thread.sleep(waitTime);
			robot.stopMovement();
			Thread.sleep(waitTime);
			robot.move(speed, curveRadius);
			Thread.sleep(waitTime);
			robot.stopMovement();
			LOG.debug("moving the turtle finished");			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		
		return context.endParameter;
	}

	@Override
	public void deploy() {
		
	}

}
