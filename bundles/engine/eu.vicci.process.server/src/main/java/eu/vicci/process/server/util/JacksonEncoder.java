package eu.vicci.process.server.util;

import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

/**
 * We are run into version conflicts so a simple encoder for feign.
 * 
 * https://github.com/OpenFeign/feign/tree/master/jackson
 */
public class JacksonEncoder implements Encoder {
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void encode(Object object, Type type, RequestTemplate template) throws EncodeException {
		try {
			template.body(mapper.writeValueAsString(object));
		} catch (Exception e) {
			throw new EncodeException(e.getMessage(), e);
		}
	}

}
