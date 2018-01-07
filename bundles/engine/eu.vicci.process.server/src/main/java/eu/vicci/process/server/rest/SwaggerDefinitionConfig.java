package eu.vicci.process.server.rest;

import javax.ws.rs.ext.Provider;

import eu.vicci.process.server.http.ProteusHttpServer;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
		basePath = ProteusHttpServer.REST_BASE_PATH,
		info = @Info(
				description = "Accessing the PROtEUS runtime via REST",
				version = "v1",
				title = "PROtEUS REST API",
				contact = @Contact(
							name = "IoTUDresden",
							url = "https://github.com/IoTUDresden"
						)				
				)
)
@Provider
public interface SwaggerDefinitionConfig {
	//this is auto-applied during package scan
}
