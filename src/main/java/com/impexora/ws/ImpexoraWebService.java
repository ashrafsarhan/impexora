/**
 * 
 */
package com.impexora.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.impexora.commons.CommonConstants;
import com.impexora.commons.ResponseStatus;
import com.impexora.commons.ValidationUtils;
import com.impexora.model.ResponseWrapper;
import com.impexora.model.SolrHost;
import com.impexora.request.RequestValidator;
import com.impexora.service.ImpexoraService;
import com.sun.istack.NotNull;

/**
 * @author ashraf_sarhan
 * 
 */
@WebService
public class ImpexoraWebService {

	private static Logger logger = Logger.getLogger(ImpexoraWebService.class
			.getSimpleName());

	@Autowired
	private ImpexoraService impexoraService;

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseWrapper impexer(@QueryParam("command") @DefaultValue(CommonConstants.STATUS) @NotNull String command,
			@QueryParam("solr") @NotNull String solr,
			@QueryParam("email") String email,
			@Context HttpServletResponse httpServletResponse) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		if (RequestValidator.validateCommand(command, responseWrapper, httpServletResponse)) {

			List<SolrHost> solrHosts = RequestValidator.validateParams(solr, responseWrapper,
					httpServletResponse);

			if (ValidationUtils.isNotNullAndEmpty(solrHosts)) {
				logger.debug("Solr Hosts: " + solrHosts.toString());

				List<String> emails = new ArrayList<String>();
				logger.debug("Emails: " + emails.toString());

				try {
					// Start business logic
					logger.debug("Executing Impexora WS business logic ....");
					String impexoraStatus = impexoraService.impexer(command,
							solrHosts, emails, responseWrapper);
					responseWrapper.setMessage(impexoraStatus);
					responseWrapper
							.setStatus(ResponseStatus.SUCCESS.toString());
					httpServletResponse.setStatus(HttpStatus.SC_OK);
					return responseWrapper;
				} catch (Exception e) {
					logger.error("Internal server error: " + e.getMessage());
					responseWrapper.setStatus(ResponseStatus.ERROR.toString());
					responseWrapper.setMessage("Internal server error: "
							+ e.getMessage());
					httpServletResponse
							.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);

					return responseWrapper;

				}
			}
		}

		return responseWrapper;

	}
}
