package inkorgstrappbadkar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inbox implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<ProcessedEvent> events = new ArrayList<ProcessedEvent>();
	
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
	public List<ProcessedEvent> getEvents() {
		return events;
	}

	/**
	 * @param processedTo the processedTo to set
	 */
	public void setEvents(List<ProcessedEvent> events) {
		this.events = events;
	}

	public String toString() {
		if (events.size() > 0)
			return name + " : " + events.get(events.size() - 1);
		else return name + " : ";
	}

	public void addEvent(String event) {
		events.add(new ProcessedEvent(event));
	}

	
	public Date lastEventDate() {
		// TODO Auto-generated method stub
		if (events.size() == 0)
			return null;
		
		Date lastDate = events.get(0).getTime();
		for (int index = 1; index < events.size(); index++) {
			if (lastDate.before(events.get(index).getTime()))
				lastDate = events.get(index).getTime();
		}

		return lastDate;
	}
	
}
