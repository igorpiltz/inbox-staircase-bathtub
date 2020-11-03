package inkorgstrappbadkar.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import inkorgstrappbadkar.model.Bathtub;
import inkorgstrappbadkar.model.Inbox;
import inkorgstrappbadkar.model.Model;
import inkorgstrappbadkar.view.CommandLineView;
import inkorgstrappbadkar.view.View;
import util.parser.CommandLineParser;




public class Controller {
	
	
	private DAO dao;
	private CommandLineParser parser;
	private View view;
	private Model model;
	

	public Controller(DAO dao) {
		this.dao = dao;
		
		parser = new CommandLineParser();
		
		model = dao.getModel();
		
		
	
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		Controller controller = null;
		
		controller = new Controller(new ObjectStreamDAO());
		
		
		View view = new CommandLineView(controller);
		controller.setView(view);
		
		controller.run();
		
				
	}
	
	
	
	

	


	private void setView(View view) {
		this.view = view;
	}

	private void run() throws IOException {
		// TODO Auto-generated method stub
		
		view.startMessage();
		
		while(true) {
			
			
			if (model.getBathtub() == null) {
				view.addChoice(ViewAction.STARTGAME);
				view.addChoice(ViewAction.QUIT);
				view.showChoices();
			} else {
				view.showStatus(model);
				view.addChoice(ViewAction.ADDEVENT);
				view.addChoice(ViewAction.ADDINBOX);
				view.addChoice(ViewAction.SHOWINBOXES);
				view.addChoice(ViewAction.QUIT);
				view.showChoices();
				
			}

			
			dao.persist();
				
		}
		
	}

	public void endGame() throws FileNotFoundException, IOException {
		dao.persist();
				
	}

	public String getState() {
		if (dao.getModel() != null) 
			return dao.getModel().toString();
		else return "No Game Started.";
	}

	public void endSession() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		dao.persist();
		System.exit(0);
		
	}

	public void startNewGame(Date date, int period, int goal) {
		dao.getModel().add(new Bathtub(date, period, goal)); 
		
				
	}

	public void addInbox(String inboxName) {
		
		dao.getModel().add(new Inbox(inboxName));
		
	}

	public void registerEvent(int inboxIndex, String event) {
		model.registerEvent(inboxIndex, event);
	}

	public List<Inbox> getAllInboxes() {
		return model.getInboxList();
	}
}
