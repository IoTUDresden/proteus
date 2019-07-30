package eu.vicci.process.model.sofiainstance.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;

//TODO change impl to the newer CloseableClient
@SuppressWarnings("deprecation")
public class RESTInvokeWorker {
	public static final String placeHolderOpenhab = "<{openhab}>";

	boolean sysout = true;

	DefaultHttpClient client = null;
	String uri = null;

	public RESTInvokeWorker(String uri) {
		client = new DefaultHttpClient();
		this.uri = uri;
		replaceUriWithVar();
	}
	
	private void replaceUriWithVar(){
		if(uri == null && !uri.isEmpty())return;
		if(uri.startsWith(placeHolderOpenhab)){
			String ohUri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.OPENHAB_URI);
			if(ohUri == null){
				throw new RuntimeException("failed to resolve oh ip");
			}
			uri = uri.replace(placeHolderOpenhab, ohUri);
		}
	}

	public String executeXMLGetCall() throws Exception {
		syso(".executeXMLGetCall();");
		String xml = "";
		HttpGet get = new HttpGet(uri);

		HttpResponse response = client.execute(get);

		response.getStatusLine().getStatusCode();

		System.out.println(" Call returned with statuscode: "
				+ response.getStatusLine().getStatusCode());

		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				long len = entity.getContentLength();
				if (len != -1 && len < 2048) {
					xml = EntityUtils.toString(entity);
				} else {
					ContentType contentType = ContentType.getOrDefault(entity);
					Charset charset = contentType.getCharset();

					StringBuilder inputStringBuilder = new StringBuilder();
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), charset));

					String line = bufferedReader.readLine();

					while (line != null) {
						inputStringBuilder.append(line);
						inputStringBuilder.append('\n');
						line = bufferedReader.readLine();
					}
					xml = inputStringBuilder.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml;

	}

	public boolean executeXMLPostCall(String xml) throws Exception {
		syso(".executeXMLPostCall()");
		syso(" parameter: " + xml);
		syso(" URI: " + uri);

		HttpPost post = new HttpPost(uri);

		StringEntity entity = new StringEntity(xml);
		post.setEntity(entity);

		HttpResponse response = client.execute(post);
		response.getStatusLine().getStatusCode();

		System.out.println(" Call returned with statuscode: "
				+ response.getStatusLine().getStatusCode());

		switch (response.getStatusLine().getStatusCode()) {
		
		case 200:
			return true;
		
		case 201:
			return true;
		
		default:
			return false;
		}
	}

	public boolean executeXMLDeleteCall() throws Exception {
		syso(".executeXMLDeleteCall()");
		syso(" URI: " + uri);

		HttpDelete delete = new HttpDelete(uri);

		HttpResponse response = client.execute(delete);
		response.getStatusLine().getStatusCode();

		System.out.println(" Call returned with statuscode: "
				+ response.getStatusLine().getStatusCode());

		switch (response.getStatusLine().getStatusCode()) {
		
		case 200:
			return true;
		
		case 201:
			return true;
		
		default:
			return false;
		}
	}
	
	

	//this was changed to json cause nobody uses xml
	public boolean executeXMLPutCall(String xml) throws Exception {
		syso(".executeXMLPutCall()");
		syso(" parameter: " + xml);
		syso(" URI: " + uri);

		HttpPut put = new HttpPut(uri);

		StringEntity entity = new StringEntity(xml, ContentType.APPLICATION_JSON);
		put.setEntity(entity);

		HttpResponse response = client.execute(put);
		response.getStatusLine().getStatusCode();

		System.out.println(" Call returned with statuscode: "
				+ response.getStatusLine().getStatusCode());

		switch (response.getStatusLine().getStatusCode()) {
		
		case 200:
			return true;
		
		case 201:
			return true;
		
		default:
			return false;
		}
	}

	private void syso(String s) {
		if (sysout) {
			System.out.println("RestInvokeWorker" + s);
		}
	}
}
