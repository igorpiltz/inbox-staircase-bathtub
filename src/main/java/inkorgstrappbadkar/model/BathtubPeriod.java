package inkorgstrappbadkar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BathtubPeriod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start;
	private Date end;
	private List<PointsEvent> eventList = new ArrayList<PointsEvent>();

	public BathtubPeriod(Date start, Date end) {
		this.start = start;
		this.end = end; 
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public void addEvent(PointsEvent event) {
		eventList.add(event);				
	}

}
