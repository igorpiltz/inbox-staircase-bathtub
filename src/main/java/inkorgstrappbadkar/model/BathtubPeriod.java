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
	
	private double runOff = 0;
	private double buffer = 0;
	private double bufferAfterDiff = 0;

	
	public int totalPoints() {
		int totalPoints = 0; 
		
		for (int index = 0; index < eventList.size(); index++) {
			totalPoints += eventList.get(index).getPoints();
		}
		return totalPoints;
	}
	
	
	
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



	public double getRunOff() {
		return runOff;
	}



	public double getBuffer() {
		return buffer ;
	}



	public void setRunOff(double runOff) {
		this.runOff = runOff;
	}



	public double getBufferAfterDiff() {
		return bufferAfterDiff;
	}



	public void setBuffer(double buffer) {
		this.buffer = buffer;
	}



	public void setBufferAfterDiff(double bufferAfterDiff) {
		this.bufferAfterDiff = bufferAfterDiff;
	}

}
