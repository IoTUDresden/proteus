package eu.vicci.process.server.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestException extends Exception implements ExceptionMapper<BadRequestException> {
	
	private static final long serialVersionUID = 1L;
	
	public BadRequestException() {
		this("some or more arguments are missing or invalid");
	}
	
	public BadRequestException(String message, Object... args){
		this(String.format(message, args));
	}
	
	public BadRequestException(String message){
		super(message);
	}

	@Override
	public Response toResponse(BadRequestException arg0) {
		return Response.status(Status.BAD_REQUEST)
				.entity(arg0.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
