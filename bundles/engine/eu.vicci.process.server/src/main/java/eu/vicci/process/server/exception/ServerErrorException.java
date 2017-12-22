package eu.vicci.process.server.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerErrorException extends Exception implements ExceptionMapper<ServerErrorException> {
	private static final long serialVersionUID = 1L;
	
	public ServerErrorException() {
		this("some error happened on the process engine");
	}
	
	public ServerErrorException(String message, Object... args) {
		this(String.format(message, args));		
	}
	
	public ServerErrorException(String message) {
		super(message);
	}

	@Override
	public Response toResponse(ServerErrorException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(exception.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}
	
	

}
