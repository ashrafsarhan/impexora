/**
 * 
 */
package com.impexora.response;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.impexora.model.SolrHost;
import com.impexora.model.SolrResponse;
import com.impexora.model.StatusMessage;

/**
 * @author ashraf_sarhan
 *
 */
public class SolrResponseParser {
	
	private static Logger logger = Logger.getLogger(SolrResponseParser.class.getSimpleName());
	
	public static SolrResponse parseSolrResponse(SolrHost solrHost, String response) throws JsonProcessingException, IOException {

		logger.debug("Parsing solr response ....");
		
		logger.debug("response: " + response);
		
		SolrResponse solrResponse = new SolrResponse();
		
		StatusMessage statusMessage = new StatusMessage();

		solrResponse.setSolrHost(solrHost);

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(response);

		//QTime
		JsonNode responseHeader = rootNode.path("responseHeader");
		Long qTime = responseHeader.get("QTime").getLongValue();
		solrResponse.setqTime(qTime);

		//command
		JsonNode command = rootNode.path("command");
		String comm = command.getTextValue();
		solrResponse.setCommand(comm);

		//status
		JsonNode status = rootNode.path("status");
		String stat = status.getTextValue();
		solrResponse.setStatus(stat);

		//statusMessages
		JsonNode statusMessages = rootNode.path("statusMessages");
		
		if (statusMessages != null) {
			
			//Total Requests made to DataSource
			String totalDsRequests = statusMessages.get("Total Requests made to DataSource").getTextValue();
			statusMessage.setTotalDsRequests(totalDsRequests);

			//Total Rows Fetched
			String totalFetchedRows = statusMessages.get("Total Rows Fetched").getTextValue();
			statusMessage.setTotalFetchedRows(totalFetchedRows);

			//Total Documents Skipped
			String totalSkippedDocs = statusMessages.get("Total Documents Skipped").getTextValue();
			statusMessage.setTotalSkippedDocs(totalSkippedDocs);

			//Full Dump Started
			String fullDumpStarted = statusMessages.get("Full Dump Started").getTextValue();
			statusMessage.setFullDumpStarted(fullDumpStarted);

			//"" empty key
			String message = statusMessages.get("").getTextValue();
			statusMessage.setMessage(message);

			//Committed
			String committed = statusMessages.get("Committed").getTextValue();
			statusMessage.setCommitted(committed);

			//Total Documents Processed
			String totalProcessedDocs = statusMessages.get("Total Documents Processed").getTextValue();
			statusMessage.setTotalProcessedDocs(totalProcessedDocs);

			//Time taken
			String takenTime = statusMessages.get("Time taken").getTextValue();
			statusMessage.setTakenTime(takenTime);
			
			// Set statusMessages into solr response
			solrResponse.setStatusMessage(statusMessage);
			
		}

		return solrResponse;
	}

}
