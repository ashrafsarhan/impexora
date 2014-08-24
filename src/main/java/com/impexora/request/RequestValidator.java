/**
 * 
 */
package com.impexora.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.impexora.commons.CommonConstants;
import com.impexora.commons.ResponseStatus;
import com.impexora.commons.ValidationUtils;
import com.impexora.model.ResponseWrapper;
import com.impexora.model.SolrHost;

/**
 * @author ashraf_sarhan
 *
 */
public class RequestValidator {
	
	private static Logger logger = Logger.getLogger(RequestValidator.class.getSuperclass());
	
	public static List<SolrHost> validateParams(String solr,
			ResponseWrapper responseWrapper,
			HttpServletResponse httpServletResponse) {

		if (ValidationUtils.isNotNullAndEmpty(solr)) {

			// create ObjectMapper instance
			ObjectMapper mapper = new ObjectMapper();

			try {
				List<SolrHost> solrHosts = mapper.readValue(solr,
						new TypeReference<List<SolrHost>>() {
						});

				// Set a logger message here

				return solrHosts;

			} catch (JsonParseException e) {

				logger.error("JsonParse error in solr parameter: "
						+ e.getMessage());
				responseWrapper.setStatus(ResponseStatus.ERROR.toString());
				responseWrapper
						.setMessage("JsonParse error in solr parameter: "
								+ e.getMessage());
				httpServletResponse
						.setStatus(HttpStatus.SC_UNPROCESSABLE_ENTITY);

				return null;

			} catch (JsonMappingException e) {

				logger.error("JsonMapping error in solr parameter: "
						+ e.getMessage());
				responseWrapper.setStatus(ResponseStatus.ERROR.toString());
				responseWrapper
						.setMessage("JsonMapping error in solr parameter: "
								+ e.getMessage());
				httpServletResponse
						.setStatus(HttpStatus.SC_UNPROCESSABLE_ENTITY);

				return null;

			} catch (IOException e) {

				logger.error("IO error in solr parameter: " + e.getMessage());
				responseWrapper.setStatus(ResponseStatus.ERROR.toString());
				responseWrapper.setMessage("IO error in solr parameter: "
						+ e.getMessage());
				httpServletResponse
						.setStatus(HttpStatus.SC_UNPROCESSABLE_ENTITY);

				return null;

			}
		} else {
			logger.error("The solr parameter is required");
			responseWrapper.setStatus(ResponseStatus.ERROR.toString());
			responseWrapper
					.setMessage("Bad request: The solr parameter is required");
			httpServletResponse.setStatus(HttpStatus.SC_BAD_REQUEST);

			return null;

		}
	}

	public static boolean validateCommand(String command,
			ResponseWrapper responseWrapper,
			HttpServletResponse httpServletResponse) {

		boolean isValidAction = false;

		for (String s : CommonConstants.ACTIONS) {
			if (s.equalsIgnoreCase(command)) {
				isValidAction = true;
				break;
			}
		}

		if (!isValidAction) {
			logger.error("The solr command is not supported");
			responseWrapper.setStatus(ResponseStatus.ERROR.toString());
			responseWrapper
					.setMessage("Bad request: Provide a valid solr command");
			httpServletResponse.setStatus(HttpStatus.SC_BAD_REQUEST);
		}

		return isValidAction;
	}

}
