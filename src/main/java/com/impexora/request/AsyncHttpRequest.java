/**
 * 
 */
package com.impexora.request;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.impexora.commons.CommonConstants;
import com.impexora.model.SolrHost;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

/**
 * @author ashraf_sarhan
 *
 */
@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
public class AsyncHttpRequest {
	
	private static Logger logger = Logger.getLogger(AsyncHttpRequest.class.getSimpleName());

	public static Response executeReq(SolrHost solrHost, String command) {
				
		Response response = null;
		
		try {
	    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	    
	    String solrHostUrl = buildSolrHostUrl(solrHost, command);
	    logger.debug("SolrHostURL: " + solrHostUrl);
	    
	    Future<Response> f = asyncHttpClient.prepareGet(solrHostUrl)
			      .execute(new AsyncCompletionHandler(){

			    @Override
			    public Response onCompleted(Response response) throws Exception{
			        // Do something with the Response
			        return response;
			    }

			    @Override
			    public void onThrowable(Throwable t){
			        // Something wrong happened.
			    }
			});
	    
         response = f.get();
	    
		} catch (IOException e) {
			logger.error("IO error in processing AsyncHttpClient: " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			logger.error("Interrupted error in processing AsyncHttpClient: " + e.getMessage());
			e.printStackTrace();
		} catch (ExecutionException e) {
			logger.error("Interrupted error in processing AsyncHttpClient: " + e.getMessage());
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
		solrHostURL.append(CommonConstants.URL_AND);
		solrHostURL.append("indent");
		solrHostURL.append(CommonConstants.URL_EQUALS);
		solrHostURL.append("true");
		
		return solrHostURL.toString();
		
	}

}
