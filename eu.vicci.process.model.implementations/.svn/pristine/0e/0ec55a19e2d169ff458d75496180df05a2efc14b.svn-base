package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl;

public class ConditionInstanceImplCustom extends ConditionInstanceImpl {

	@Override
	public boolean evaluate() throws UnsupportedOperationException {
		Condition condition = this.getIfConditionType();
		Comparator comparator = condition.getComparator();
		DataTypeInstance leftSide = getLeftSide().getDataInstance();
		DataTypeInstance rightSide = getRightSide().getDataInstance();

		// compareTo is used, else the equal method and hashcode has to be implemented
		// in all DataTypeInstances. Attention: 'string'.compareTo('sTRing') is 32!

		int cmpResult = leftSide.compareTo(rightSide);	
		
		switch (comparator) {

		case DISTINCT:
			if (cmpResult != 0)
				return true;
			return false;

		case EQUAL:
			if (cmpResult == 0)
				return true;
			return false;

		case IDENTIC:
			// TODO Implent IDENTIC case for Condition solving
			throw new UnsupportedOperationException("Implemet IDENTIC Case for Condition solving!");

		case GREATER_THAN:
			if(cmpResult > 0)
				return true;
			return false;

		case GREATER_THAN_OR_EQUAL:
			if(cmpResult > 0 || cmpResult == 0)
				return true;
			return false;

		case SMALLER_THAN:
			if(cmpResult < 0)
				return true;
			return false;

		case SMALLER_THAN_OR_EQUAL:
			if(cmpResult < 0 || cmpResult == 0)
				return true;
			return false;

		default:
			throw new IllegalArgumentException("A unknown Comparator is used for a condition!");
		}
	}
}
