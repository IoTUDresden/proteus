package eu.vicci.process.model.util.logging;

import feign.Param;
import feign.RequestLine;

public interface ElasticsearchClient {

	/**
	 * Posts the log to elastic search.
	 * 
	 * @param year
	 *            the year e.g. 2016 as string
	 * @param month
	 *            the month e.g. 06 as string
	 * @param timer
	 */
	@RequestLine("POST /mapek-{year}-{month}/timer/")
	void post(@Param("year") String year, @Param("month") String month, String timer);

}
