package inkorgstrappbadkar.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Ett badkar
 * 
 * @author igor
 *
 */

public class Bathtub implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start;
	private int period;		// i dagar
	private int goal;
	private List<PointsEvent> pointsEvents = new ArrayList<PointsEvent>();
	private List<BathtubPeriod> periodList = new ArrayList<BathtubPeriod>();
	
	public static final double acceleration = 0.1;
	
	
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param start start date
	 * @param period period in days
	 * @param goal the number of points achieve to end the game. Zero if unending.  
	 */
	public Bathtub(Date start, int period, int goal) {
		this.start = start;
		this.period = period;
		this.goal = goal;
	}
	
	public void addPoints(int points) {
		PointsEvent pEvent = new PointsEvent(points);
		pointsEvents.add(pEvent);
		update();
	}
	
	/** 
	 * Uppdatera den interna tillståndet utgående från pointsEvents. 
	 */
	public void update() {
		// Först så måste vi beräkna tidsintervallen.
		// Vi lägger alla beräkningar i en lista av BathtubPeriod
		// som innehåller samma data som Calc-dokumentet. 
		
		// Först så måste vi sortera pointsEvents på datum. 
		Collections.sort(pointsEvents, new java.util.Comparator<PointsEvent> () {
			@Override
			public int compare(PointsEvent o1, PointsEvent o2) {
				return o1.getTime().compareTo(o2.getTime());
			}
		});
		
		// Här börjar vi iterera BathtubPeriod från början.
		Date end = new Date(start.getTime() + period*24*60*60*1000);
		BathtubPeriod startPeriod = new BathtubPeriod(start, end);
		
		// Sedan så kollar vi om vi har fler PointsEvents i listan som vi inte har
		// processat som ligger inom tidsintervallet. Om inte så går vi vidare på något sätt.
		
		BathtubPeriod currentPeriod = startPeriod;
		
		periodList.add(currentPeriod);
		for (int index = 0; index < pointsEvents.size(); index++) {
			PointsEvent event = pointsEvents.get(index);
			if (event.getTime().after(currentPeriod.getStart()) && event.getTime().before(currentPeriod.getEnd()))
				currentPeriod.addEvent(event);
			else {
				Date startDate = new Date(currentPeriod.getEnd().getTime());	// inga hål i tidslinjen
				Date endDate = new Date(startDate.getTime() + period*24*60*60*1000);
				currentPeriod = new BathtubPeriod(startDate, endDate);
				periodList.add(currentPeriod);
				
			}
		}
		
		// Nu har vi lagt alla Events i BathtubPeriods. 
		// Då är det bara att beräkna parametrar samma som calc-dokumentet. 
		for (int index = 0; index < periodList.size(); index++) {
			BathtubPeriod previous = null;
			if (index == 0) {
				previous = new BathtubPeriod(new Date(), new Date());
				
				
			} else previous = periodList.get(index);
			
			
			BathtubPeriod period = periodList.get(index);
			
			// Borde göra eller RunOff
			// Den gamla + gammal Borde-Diff eller RunOffDiff
			period.setRunOff(previous.getRunOff() - previous.getBuffer()*acceleration);
			
			// Buffer före diff eller bara Buffer
			// förra bufferEfterDiff + dennas poäng - dennas runOff
			period.setBuffer(previous.getBufferAfterDiff() + period.totalPoints() - period.getRunOff());
			
			// BufferAfterDiff
			// Pull off 10% off Buffer or = Buffer - Buffer*0.1
			period.setBufferAfterDiff(period.getBuffer() - period.getBuffer()*acceleration);
			
			
		}
		
		
		
		
	}
	
	
	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
	/**
	 * @return the goal
	 */
	public int getGoal() {
		return goal;
	}
	/**
	 * @param goal the goal to set
	 */
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public String toString() {
		return "Bathtub " + format.format(start);
	}

}
