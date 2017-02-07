package eu.vicci.process.graphiti.execution.debug.model;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;

public class ProcessMarker extends PlatformObject implements IMarker  {

	@Override
	public void delete() throws CoreException {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getAttribute(String attributeName) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttribute(String attributeName, int defaultValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAttribute(String attributeName, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAttribute(String attributeName, boolean defaultValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAttributes() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAttributes(String[] attributeNames) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreationTime() throws CoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IResource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSubtypeOf(String superType) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttribute(String attributeName, int value) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String attributeName, Object value) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String attributeName, boolean value) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttributes(String[] attributeNames, Object[] values) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttributes(Map<String, ? extends Object> attributes) throws CoreException {
		// TODO Auto-generated method stub
		
	}

}
