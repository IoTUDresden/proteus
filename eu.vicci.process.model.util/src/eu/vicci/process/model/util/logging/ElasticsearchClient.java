package eu.vicci.process.model.util.logging;

import feign.RequestLine;

public interface ElasticsearchClient {

	@RequestLine("POST /mapek-2016-12/timer/")
	void postDecember2016(String timer);

}
