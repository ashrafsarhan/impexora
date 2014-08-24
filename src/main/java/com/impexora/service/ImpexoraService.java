/**
 * 
 */
package com.impexora.service;

import java.util.List;

import com.impexora.model.ResponseWrapper;
import com.impexora.model.SolrHost;


/**
 * @author ashraf_sarhan
 *
 */
public interface ImpexoraService {
	
	public String impexer(String command, List<SolrHost> solrHosts, List<String> emails, ResponseWrapper responseWrapper) throws Exception;

}
