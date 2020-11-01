package inkorgstrappbadkar.model;

import java.util.Date;

/**
 * En klass som representerar att ett badkar får ett visst antal poäng vid en viss tidpunkt. 
 * 
 * @author igor
 *
 */

public class PointsEvent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int points;
	private Date time;

	public PointsEvent(int points) {
		this.points = points;
		time = new Date();
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}
