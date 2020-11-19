package inkorgstrappbadkar.model;

import java.util.Date;

public class ProcessedEvent implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String upto;
	private Date when;

	public ProcessedEvent(String upto) {
		this.upto = upto;
		when = new Date();
	}
	
	public String toString() {
		return upto;
	}

	public Date getTime() {
		return when;
	}

}
