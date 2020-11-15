package inkorgstrappbadkar.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import mvctemplate.controller.Controller;
import mvctemplate.dao.DAO;
import mvctemplate.dao.ObjectStreamDAO;
import mvctemplate.view.CommandLineView;
import mvctemplate.view.View;
import inkorgstrappbadkar.model.Bathtub;
import inkorgstrappbadkar.model.Inbox;
import inkorgstrappbadkar.model.Model;
import util.parser.Callable;
import util.parser.ChoiceToken;
import util.parser.Command;
import util.parser.IntegerToken;
import util.parser.RestOfLineToken;
import util.parser.StringToken;
import util.parser.Token;

public class ControllerImplementation {
	
	
	private Controller controller;
	private Model model;
	private View view;
	private DAO dao;

	public ControllerImplementation(Controller controller) {
		
		this.controller = controller;
		model = (inkorgstrappbadkar.model.Model)controller.getModel();
		view = controller.getView();
		dao = controller.getDAO();
		
		
		
		
		// Startar ett nytt spel
		// start game period goal  
		controller.add(new StartGame());		
		
		// Add inbox-kommandot
		// Lägger till ett event
		// add inbox inbox-name
		controller.add(new AddInbox());
		
		// Add event-kommandot
		// Lägger till ett event  
		// add event [InboxNumber] [EventString]
		controller.add(new AddEvent());
		
		controller.add(new ShowInboxes());
		controller.add(new ExitProgram());

	}
	
	


	
	/**
	 * start game period goal
	 * 
	 * @author igor
	 *
	 */
	public class StartGame extends Command implements Callable {
		public StartGame() {
			add(new StringToken("start"));
			add(new StringToken("game"));
			add(new IntegerToken());
			add(new IntegerToken());
			addCallable(this);
		}
		
		public void exec(List<Token> tokens) {
			model.add(new Bathtub(
					new Date(), 
					((IntegerToken)tokens.get(2)).getNumber(), 
					((IntegerToken)tokens.get(3)).getNumber()));
		}
		
	}

	
	/**
	 * add inbox inbox-name
	 * @author igor
	 *
	 */
	public class AddInbox extends Command implements Callable {
		public AddInbox() {
			add(new StringToken("add"));
			add(new StringToken("inbox"));
			add(new RestOfLineToken());
			
			addCallable(this);
		}
		
		public void exec(List<Token> tokens) {
			model.add(new Inbox(tokens.get(2).getParsedString()));
		}
		
	}

	
	/**
	 * add event [InboxNumber] [EventString]
	 * @author igor
	 *
	 */
	public class AddEvent extends Command implements Callable {
		public AddEvent() {
			add(new StringToken("add"));
			add(new StringToken("event"));
			add(new IntegerToken());
			add(new RestOfLineToken());
			
			addCallable(this);
		}
		
		public void exec(List<Token> tokens) {
			throw new AssertionError();
		}
		
	}
	
	public class ShowInboxes extends Command implements Callable {
		public ShowInboxes() {
			add(new StringToken("show"));
			add(new StringToken("inboxes"));
			
			addCallable(this);
		}
		
		public void exec(List<Token> tokens) {
			throw new AssertionError();
		}
	}
	
	
	public class ExitProgram extends Command implements Callable {
		public ExitProgram() {
			ChoiceToken token = new ChoiceToken();
			token.add("quit");
			token.add("exit");
			
			add(token);
					
			addCallable(this);
		}
		
		public void exec(List<Token> tokens) {
			try {
				dao.persist();
			} catch (IOException e) {

				view.messageToUser(e.toString());
				return; 
			}
			System.exit(0);
		}
	}

		
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		Controller controller = null;
		View view = new CommandLineView();
		
		
		controller = new Controller(new ObjectStreamDAO(), view);
		
		ControllerImplementation controllerImplementation = new ControllerImplementation(controller);
			
		
		controllerImplementation.run();
		
	}

	private void run() throws IOException {
		
		view.startMessage();
		
		while(true) {
			
			
			if (model.getBathtub() == null) {
				view.addChoice(new StartGame());
				view.addChoice(new ExitProgram());
				view.showChoices();
			} else {
				view.showStatus(model);
				view.addChoice(new AddEvent());
				view.addChoice(new AddInbox());
				view.addChoice(new ShowInboxes());
				view.addChoice(new ExitProgram());
				view.showChoices();
				
			}

			
			dao.persist();
				
		}
		
	}
}
