/**
 * 
 */
package com.impexora.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author ashraf_sarhan
 *
 */
@XmlRootElement(name = "ImpexoraResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResponseWrapper {
	
	private List<SolrResponse> solrResponses;
	
	private String status;
	
	private String message;

	public List<SolrResponse> getSolrResponses() {
		return solrResponses;
	}

	public void setSolrResponses(List<SolrResponse> solrResponses) {
		this.solrResponses = solrResponses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
