package eu.vicci.process.server.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundErrorException extends Exception implements ExceptionMapper<NotFoundErrorException> {

	private static final long serialVersionUID = 1L;
	
	public NotFoundErrorException() {
		this("resource could not be found");
	}
	
	public NotFoundErrorException(String message, Object... args) {
		this(String.format(message, args));		
	}
	
	public NotFoundErrorException(String message) {
		super(message);
	}

	@Override
	public Response toResponse(NotFoundErrorException exception) {
		return Response.status(Status.NOT_FOUND)
				.entity(exception.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
