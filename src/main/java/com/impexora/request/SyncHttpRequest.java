/**
 * 
 */
package com.impexora.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.impexora.commons.CommonConstants;
import com.impexora.model.SolrHost;

/**
 * @author ashraf_sarhan
 * 
 */
public class SyncHttpRequest {

	private static Logger logger = Logger.getLogger(SyncHttpRequest.class
			.getSimpleName());

	public static HttpResponse executeReq(SolrHost solrHost, String command) {

		HttpResponse response = null;
		
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			String solrHostUrl = buildSolrHostUrl(solrHost, command);
			logger.debug("SolrHostURL: " + solrHostUrl);

			HttpGet getRequest = new HttpGet(solrHostUrl);
			getRequest.addHeader("accept", "application/json");

			response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return response;
	}

	public static String buildSolrHostUrl(SolrHost solrHost, String command) {

		logger.debug("Building solr host URL ....");

		StringBuilder solrHostURL = new StringBuilder();
		solrHostURL.append(CommonConstants.URL_HTTP_HEADER);
		solrHostURL.append(solrHost.getHost());
		solrHostURL.append(CommonConstants.URL_PORT_DELIMITER);
		solrHostURL.append(solrHost.getPort());
		solrHostURL.append(CommonConstants.URL_DELIMITER);
		solrHostURL.append(CommonConstants.SOLR_CONTEXT);
		solrHostURL.append(CommonConstants.URL_DELIMITER);
		solrHostURL.append(solrHost.getCore());
		solrHostURL.append(CommonConstants.URL_DELIMITER);
		solrHostURL.append(CommonConstants.DATA_IMPORT);
		solrHostURL.append(command);
		solrHostURL.append(CommonConstants.URL_AND);
		solrHostURL.append(CommonConstants.FORMAT_PARAM);
		solrHostURL.append(CommonConstants.URL_EQUALS);
		solrHostURL.append(CommonConstants.JSON_FORMAT);

		return solrHostURL.toString();

	}

	public static String getResponseBody(HttpResponse response) {
		
		String output = null;
		
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			logger.debug("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;
	}

}
