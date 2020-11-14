package inkorgstrappbadkar.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;


import mvctemplate.controller.Controller;
import mvctemplate.dao.ObjectStreamDAO;
import mvctemplate.view.CommandLineView;
import mvctemplate.view.View;
import inkorgstrappbadkar.model.Bathtub;
import inkorgstrappbadkar.model.Inbox;
import inkorgstrappbadkar.model.Model;
import util.parser.Callable;
import util.parser.ChoiceToken;
import util.parser.Command;
import util.parser.FloatToken;
import util.parser.IntegerToken;
import util.parser.StringToken;
import util.parser.Token;

public class ControllerImplementation {
	
	private Controller controller;
	private Model model;
	private View view;

	public ControllerImplementation(Controller controller) {
		
		this.controller = controller;
		model = (inkorgstrappbadkar.model.Model)controller.getModel();
		view = controller.getView();
		
		
		Command command;
		ChoiceToken choiceToken;
		
		
		// Startar ett nytt spel
		// start game period goal  
		command = new Command();
		command.add(new StringToken("start"));
		command.add(new StringToken("game"));
		command.add(new IntegerToken());
		command.add(new IntegerToken());
		command.addCallable(new Callable() {
			public void exec(List<Token> tokens) {
				startGame(tokens);
			}});
		controller.add(command);
				
		
		
		// Add event-kommandot
		// Lägger till ett event  
		command = new Command();
		command.add(new StringToken("add"));
		command.add(new StringToken("event"));
		command.addCallable(new Callable() {
			public void exec(List<Token> tokens) {
				addEvent(tokens);
			}});
		controller.add(command);
		
		
		// Add event-kommandot
		// Lägger till ett event  
		command = new Command();
		command.add(new StringToken("add"));
		command.add(new StringToken("secondary"));
		command.addCallable(new Callable() {
			public void exec(List<Token> tokens) {
				addSecondaryEvent(tokens);
			}});
		controller.add(command);
		
		
				


	}
	
	

	protected void startGame(List<Token> tokens) {
		// start game period goal
		
		dao.getModel().add(new Bathtub(date, period, goal)); 
		
		
		
		
	}

	public void addInbox(String inboxName) {
		
		dao.getModel().add(new Inbox(inboxName));
		
	}
	
	public void registerEvent(int inboxIndex, String event) {
		model.registerEvent(inboxIndex, event);
	}
	
	
	public void endSession() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		dao.persist();
		System.exit(0);
		
	}


	public void endGame() throws FileNotFoundException, IOException {
		dao.persist();
				
	}
	
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		Controller controller = null;
		
		controller = new Controller(new ObjectStreamDAO());
		
		ControllerImplementation controllerImplementation = new ControllerImplementation(controller);
		
		View view = new CommandLineView(controller);
		controller.setView(view);
		
		view.run();
		
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

	

}
