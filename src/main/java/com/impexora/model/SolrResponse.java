/**
 * 
 */
package com.impexora.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.impexora.commons.ObjectUtility;

/**
 * @author ashraf_sarhan
 *
 */
@XmlRootElement(name= "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class SolrResponse {

	@XmlElement(name= "solrHost")
	private SolrHost solrHost;

	//QTime
	@XmlElement(name= "QTime")
	private Long qTime;

	//command
	@XmlElement(name= "command")
	private String command;

	//status
	@XmlElement(name= "status")
	private String status;

	//statusMessages
	@XmlElement(name= "statusMessages")
	private StatusMessage statusMessage;
	

	public SolrHost getSolrHost() {
		return solrHost;
	}



	public void setSolrHost(SolrHost solrHost) {
		this.solrHost = solrHost;
	}



	public Long getqTime() {
		return qTime;
	}



	public void setqTime(Long qTime) {
		this.qTime = qTime;
	}



	public String getCommand() {
		return command;
	}



	public void setCommand(String command) {
		this.command = command;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public StatusMessage getStatusMessage() {
		return statusMessage;
	}



	public void setStatusMessage(StatusMessage statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((qTime == null) ? 0 : qTime.hashCode());
		result = prime * result
				+ ((solrHost == null) ? 0 : solrHost.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusMessage == null) ? 0 : statusMessage.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolrResponse other = (SolrResponse) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (qTime == null) {
			if (other.qTime != null)
				return false;
		} else if (!qTime.equals(other.qTime))
			return false;
		if (solrHost == null) {
			if (other.solrHost != null)
				return false;
		} else if (!solrHost.equals(other.solrHost))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusMessage == null) {
			if (other.statusMessage != null)
				return false;
		} else if (!statusMessage.equals(other.statusMessage))
			return false;
		return true;
	}



	@Override
	public String toString()
	{
		return ObjectUtility.toStringFor(this);
	}

}
