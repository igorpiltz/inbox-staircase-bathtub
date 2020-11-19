package inkorgstrappbadkar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Model extends mvctemplate.model.Model implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public void checkConsistency() {
		if (getOldGames() == null)
			setOldGames(new ArrayList());
	}

	
	
	
	public String getState() {
				
		if (getCurrentGame() == null) {
			StringBuffer buf = new StringBuffer();
			for (int index = 0; index < getOldGames().size(); index++) {
				buf.append("" + (index+1) + ". " + getOldGames().get(index).toString() + "\n");
			}
			buf.append("No Game started yet");
			return buf.toString();
		} else {
			StringBuffer buf = new StringBuffer();
			buf.append(((inkorgstrappbadkar.model.Game)getCurrentGame()).getState());
			buf.append("\n");
			
			
			return buf.toString();
		}
			
			
			
				
	}




	

	

	



}
