package inkorgstrappbadkar.model;

import java.util.Date;

/**
 * En runda av processande inkorgar. 
 */


import java.util.List;

public class ProcessingRound implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Inbox> inboxList;
	private Date start;

	public ProcessingRound(List<Inbox> inboxList) {
		this.inboxList = inboxList;
		start = new Date();
		
	}

}
