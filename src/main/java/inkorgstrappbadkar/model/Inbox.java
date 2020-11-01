package inkorgstrappbadkar.model;

import java.util.ArrayList;
import java.util.List;

public class Inbox implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<ProcessedEvent> processedTo = new ArrayList<ProcessedEvent>();
	
	public Inbox(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the processedTo
	 */
	public List<ProcessedEvent> getProcessedTo() {
		return processedTo;
	}

	/**
	 * @param processedTo the processedTo to set
	 */
	public void setProcessedTo(List<ProcessedEvent> processedTo) {
		this.processedTo = processedTo;
	}

	public String toString() {
		if (processedTo.size() > 0)
			return name + " : " + processedTo.get(processedTo.size() - 1);
		else return name + " : ";
	}

	public void addEvent(String event) {
		processedTo.add(new ProcessedEvent(event));
	}

	public void add(String event) {
		processedTo.add(new ProcessedEvent(event));
	}
	
}
