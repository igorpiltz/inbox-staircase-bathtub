package inkorgstrappbadkar.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The parameters of one game.
 * 
 * @author igor
 *
 */
public class Game extends mvctemplate.model.Game implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start, end;
	private Bathtub bathtub;
	private List<Inbox> inboxList = new ArrayList<Inbox>();
	private List<ProcessingRound> roundList = new ArrayList<ProcessingRound>();
	private int pointsToAward;
	private VictoryCondition condition;
	
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String getState() {
		StringBuffer buf = new StringBuffer();
		
		buf.append(toString() + "\n");
		buf.append("*****  TO PROCESS  *****");
		buf.append("\n");
		for (int index = 0; index < inboxList.size(); index++) {
			Inbox inbox = inboxList.get(index);
			
			if (inbox.lastEventDate() != null) {
				if (inbox.lastEventDate().after(roundList.get(roundList.size()-1).getStart()))
					continue;
			}
				
			buf.append("" + (index) + ". " + inboxList.get(index) + "\n");
		}
		
		
		return buf.toString();
		
	}
	
	
	
	public Game() {
		start = new Date();
		roundList.add(new ProcessingRound(start));

	}
	
	
	public Game(Date start) {
		this.start = start;
		roundList.add(new ProcessingRound(start));
	}
	
	
	public Game(Date start, int period, int goal) {
		this.start = start;
		roundList.add(new ProcessingRound(start));
		bathtub = new Bathtub(start, period, goal);
	}


	public void add(Inbox inbox) {
		inboxList.add(inbox);
	}
	

	public void registerEvent(int inboxIndex, String event) {
		
		inboxList.get(inboxIndex).addEvent(event);
		if (bathtub != null)
			bathtub.addPoints(pointsToAward);
		pointsToAward++;
		
	
		boolean finished = true;
		
		for (int index = 0; index < inboxList.size(); index++) {
			Inbox inbox = inboxList.get(index);
			if (inbox.lastEventDate() != null) {
				if (inbox.lastEventDate().before(roundList.get(roundList.size()-1).getStart()))
					finished = false;
			} else finished = false;
		}

		
		if (finished) {
			roundList.add(new ProcessingRound(new Date()));
			pointsToAward = 1;
		}
	}
	
	public List<Inbox> getInboxList() {
		return inboxList;
	}

	
	

	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Game (" + format.format(start) + "), round " + roundList.size());
		
		return buf.toString();
		
	}

	
	public void setVictoryCondition(VictoryCondition condition) {
		this.condition = condition;
		if (condition != null)
			condition.setGame(this);
	}



	public VictoryCondition getCondition() {
		return condition;
	}



	public Date getStart() {
		return start;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public void setStart(Date start) {
		this.start = start;
	}	
}