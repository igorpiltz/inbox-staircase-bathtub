package inkorgstrappbadkar.model;

import java.util.ArrayList;
import java.util.List;

public class Model implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bathtub bathtub;
	private List<Inbox> inboxList = new ArrayList<Inbox>();
	private List<Inbox> inboxToProcessList = new ArrayList<Inbox>();
	private int pointsToAward;
	

	public void checkConsistency() {
		if (inboxList == null)
			inboxList = new ArrayList<Inbox>();
		if (inboxToProcessList == null)
			inboxToProcessList = new ArrayList<Inbox>();
	}

	
	
	
	public String toString() {
				
		if (bathtub == null)
			return "No Game started yet";
		else {
			StringBuffer buf = new StringBuffer();
			buf.append(bathtub);
			buf.append("\n");
			for (int index = 0; index < inboxToProcessList.size(); index++) {
				buf.append("" + (index+1) + ". " + inboxToProcessList.get(index).toString() + "\n");
			}
			
			return buf.toString();
		}
			
			
			
				
	}



	public void add(Bathtub bathtub) {
		// TODO Auto-generated method stub
		this.bathtub = bathtub;
		inboxToProcessList = new ArrayList<Inbox>(inboxList);
		pointsToAward = 1;
	}



	public void add(Inbox inbox) {
		inboxList.add(inbox);
		inboxToProcessList.add(inbox);
	}

	
	public Bathtub getBathtub() {
		return bathtub;
	}



	public Inbox getInboxToProcess(int inboxIndex) {
		return inboxToProcessList.get(inboxIndex);
	}



	public void registerEvent(int inboxIndex, String event) {
		inboxToProcessList.get(inboxIndex).add(event);
		inboxToProcessList.remove(inboxIndex);
		
		bathtub.addPoints(pointsToAward);
		pointsToAward++;
		
		
		if (inboxToProcessList.size() == 0) {
			inboxToProcessList = new ArrayList<Inbox>(inboxList);
			pointsToAward = 1;
		}
	}
	
	public List<Inbox> getInboxList() {
		return inboxList;
	}

}
