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
@XmlRootElement(name= "statusMessages")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusMessage {
	
	//Total Requests made to DataSource
	@XmlElement(name= "Total Requests made to DataSource")
	private String totalDsRequests; 
	
	//Total Rows Fetched
	@XmlElement(name= "Total Rows Fetched")
	private String totalFetchedRows;
	
	//Total Documents Skipped
	@XmlElement(name= "Total Documents Skipped")
	private String totalSkippedDocs;
	
	//Full Dump Started
	@XmlElement(name= "Full Dump Started")
	private String fullDumpStarted;
	
	//"" empty key
	@XmlElement(name= "Message")
	private String message;
	
	//Committed
	@XmlElement(name= "Committed")
	private String committed;
	
	//Total Documents Processed
	@XmlElement(name= "Total Documents Processed")
	private String totalProcessedDocs;
	
	//Time taken
	@XmlElement(name= "Time taken")
	private String takenTime;

	public String getTotalDsRequests() {
		return totalDsRequests;
	}

	public void setTotalDsRequests(String totalDsRequests) {
		this.totalDsRequests = totalDsRequests;
	}

	public String getTotalFetchedRows() {
		return totalFetchedRows;
	}

	public void setTotalFetchedRows(String totalFetchedRows) {
		this.totalFetchedRows = totalFetchedRows;
	}

	public String getTotalSkippedDocs() {
		return totalSkippedDocs;
	}

	public void setTotalSkippedDocs(String totalSkippedDocs) {
		this.totalSkippedDocs = totalSkippedDocs;
	}

	public String getFullDumpStarted() {
		return fullDumpStarted;
	}

	public void setFullDumpStarted(String fullDumpStarted) {
		this.fullDumpStarted = fullDumpStarted;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCommitted() {
		return committed;
	}

	public void setCommitted(String committed) {
		this.committed = committed;
	}

	public String getTotalProcessedDocs() {
		return totalProcessedDocs;
	}

	public void setTotalProcessedDocs(String totalProcessedDocs) {
		this.totalProcessedDocs = totalProcessedDocs;
	}

	public String getTakenTime() {
		return takenTime;
	}

	public void setTakenTime(String takenTime) {
		this.takenTime = takenTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((committed == null) ? 0 : committed.hashCode());
		result = prime * result
				+ ((fullDumpStarted == null) ? 0 : fullDumpStarted.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((takenTime == null) ? 0 : takenTime.hashCode());
		result = prime * result
				+ ((totalDsRequests == null) ? 0 : totalDsRequests.hashCode());
		result = prime
				* result
				+ ((totalFetchedRows == null) ? 0 : totalFetchedRows.hashCode());
		result = prime
				* result
				+ ((totalProcessedDocs == null) ? 0 : totalProcessedDocs
						.hashCode());
		result = prime
				* result
				+ ((totalSkippedDocs == null) ? 0 : totalSkippedDocs.hashCode());
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
		StatusMessage other = (StatusMessage) obj;
		if (committed == null) {
			if (other.committed != null)
				return false;
		} else if (!committed.equals(other.committed))
			return false;
		if (fullDumpStarted == null) {
			if (other.fullDumpStarted != null)
				return false;
		} else if (!fullDumpStarted.equals(other.fullDumpStarted))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (takenTime == null) {
			if (other.takenTime != null)
				return false;
		} else if (!takenTime.equals(other.takenTime))
			return false;
		if (totalDsRequests == null) {
			if (other.totalDsRequests != null)
				return false;
		} else if (!totalDsRequests.equals(other.totalDsRequests))
			return false;
		if (totalFetchedRows == null) {
			if (other.totalFetchedRows != null)
				return false;
		} else if (!totalFetchedRows.equals(other.totalFetchedRows))
			return false;
		if (totalProcessedDocs == null) {
			if (other.totalProcessedDocs != null)
				return false;
		} else if (!totalProcessedDocs.equals(other.totalProcessedDocs))
			return false;
		if (totalSkippedDocs == null) {
			if (other.totalSkippedDocs != null)
				return false;
		} else if (!totalSkippedDocs.equals(other.totalSkippedDocs))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return ObjectUtility.toStringFor(this);
	}

}
