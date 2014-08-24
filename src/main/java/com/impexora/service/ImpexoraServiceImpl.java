/**
 * 
 */
package com.impexora.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.impexora.model.ResponseWrapper;
import com.impexora.model.SolrHost;
import com.impexora.model.SolrResponse;
import com.impexora.request.AsyncHttpRequest;
import com.impexora.response.SolrResponseParser;
import com.ning.http.client.Response;

/**
 * @author ashraf_sarhan
 *
 */
@Service
public class ImpexoraServiceImpl implements ImpexoraService {


	private static Logger logger = Logger.getLogger(ImpexoraServiceImpl.class
			.getSimpleName());
	
	public String impexer(String command, List<SolrHost> solrHosts, List<String> emails, ResponseWrapper responseWrapper) throws Exception {
		
		List<Response> responses = new ArrayList<Response>();
//		List<HttpResponse> responses = new ArrayList<HttpResponse>();
		
		List<SolrResponse> solrResponses = new ArrayList<SolrResponse>();

		for (SolrHost sh : solrHosts) {
			
			// Start AsyncHttpRequests
			Response response = AsyncHttpRequest.executeReq(sh,
					command.toLowerCase());
			responses.add(response);
			String resString = response.getResponseBody();
			
			//Just to test SyncHttpRequests
//			HttpResponse response = SyncHttpRequest.executeReq(sh, command.toLowerCase());
//			responses.add(response);
//			String resString = SyncHttpRequest.getResponseBody(response);
			
			SolrResponse solrResponse = SolrResponseParser.parseSolrResponse(sh, resString);
			solrResponses.add(solrResponse);
			logger.debug("SolrResponse: " + solrResponse.toString());
		}
		
		responseWrapper.setSolrResponses(solrResponses);
		
		if (solrHosts.size() == responses.size()) {
			return "Impexora finished "+ command +" command for all requested cores successfully";
		} else {
			return "Impexora didn't finish "+ command +" command for all requested cores successfully";
		}
		
	}

}
