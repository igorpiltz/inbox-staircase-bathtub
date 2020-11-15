package inkorgstrappbadkar.view;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import inkorgstrappbadkar.model.Inbox;
import mvctemplate.model.Model;
import mvctemplate.view.View;
import util.parser.Command;
import util.parser.UserInterruptException;

/**
 * En View där vi väljer kommando med hjälp av en siffra och sedan frågar vad vi vill i konsolen.  
 * 
 * @author igor
 *
 */

public class ConsoleButtonView implements View {
	/*
	 *
	 * 
	 * if (action == ViewAction.ADDINBOX) {
			// Add an inbox
					
			System.out.println("Add an inbox.");
			System.out.println("Inbox name?");
			String inboxName = buf.readLine();
			
			if (inboxName.length() == 0) {
				System.out.println("Invalid name!");
			}
	
			controller.addInbox(inboxName);
					
		}
	
		if (action == ViewAction.ADDEVENT) {
			// Register an event on an inbox
					
			
			System.out.println("Which inbox?");
			String inboxString = buf.readLine();
			
			if (inboxString.length() == 0) {
				System.out.println("Invalid name!");
			}
	
			System.out.println("Event?");
			String event = buf.readLine();
			
			
			int inboxIndex = Integer.parseInt(inboxString)-1;
			
			
							
			controller.registerEvent(inboxIndex, event);
			
			
		}
		
		
		
		if (action == ViewAction.STARTGAME) {
			// Start a new game.
					
			System.out.println("Start a new game.");
			System.out.println("What period in days? (Default: 7)");
			String periodStr = buf.readLine();
			int period;
			if (periodStr.length() == 0)
				period = 7;
			else {
				period = Integer.parseInt(periodStr);
			}
	
			
			
			int goal = 0;
				
			System.out.println("Starting game now with period of " + period + " days and goal of " + goal);
			System.out.println("Yes/no");
			String startStr = buf.readLine();
			if (startStr.equalsIgnoreCase("yes")) {
				controller.startNewGame(new Date(), period, goal);
				out.println("Game Started"); 
			}
			
		}
	
		if (action == ViewAction.SHOWINBOXES) {
			List<Inbox> list = controller.getAllInboxes();
						
			System.out.println("**** Inbox List ****");
			for (int index = 0; index < list.size(); index++) {
				System.out.println("" + (index+1) + ". " + list.get(index));
			}
			System.out.println("");
			System.out.println(controller.getModel().getBathtub().toStringLong());
			
		}
		
		
		if (action == ViewAction.QUIT) {
			controller.endSession();				
		}

	 * 
	 * 
	 * 
	 */
	
	
	
	public ConsoleButtonView() {
		
	}
	
	public void showChoices() {
		/*
		for (int index = 0; index < choices.size(); index++) {
			boolean foundChoice = false;
			if (choices.get(index) == ViewAction.QUIT) {
				System.out.println("" + (index+1) + ". Quit");
				foundChoice = true;
			}
			
			if (choices.get(index) == ViewAction.ADDINBOX) {
				System.out.println("" + (index+1) + ". Add an inbox.");
				foundChoice = true;
			}
			
			if (choices.get(index) == ViewAction.ADDEVENT) {
				System.out.println("" + (index+1) + ". Add an event.");
				foundChoice = true;
			}
			
			if (choices.get(index) == ViewAction.STARTGAME) {
				System.out.println("" + (index+1) + ". Start a new game.");
				foundChoice = true;
			}
			
			if (choices.get(index) == ViewAction.SHOWINBOXES) {
				System.out.println("" + (index+1) + ". Show all inboxes.");
				foundChoice = true;
			}
			
			
			if (!foundChoice)
				throw new AssertionError(choices.get(index));
		}
		
		
		
		String input = buf.readLine();
		
		System.out.println("Pressed: \"" + input + "\"");
		
		ViewAction action = null;
		try {
			int choiceIndex = Integer.parseInt(input)-1;
		
			action = choices.get(choiceIndex);
		} catch (NumberFormatException e) {
			System.out.println("Bad input!");
		}
		
		System.out.println("Action: " + action);
			 
		
		
		if (action == ViewAction.ADDINBOX) {
			// Add an inbox
			
			
			System.out.println("Add an inbox.");
			System.out.println("Inbox name?");
			String inboxName = buf.readLine();
			
			if (inboxName.length() == 0) {
				System.out.println("Invalid name!");
			}
	
			controller.addInbox(inboxName);
			
			
		}
	
		if (action == ViewAction.ADDEVENT) {
			// Register an event on an inbox
					
			
			System.out.println("Which inbox?");
			String inboxString = buf.readLine();
			
			if (inboxString.length() == 0) {
				System.out.println("Invalid name!");
			}
	
			System.out.println("Event?");
			String event = buf.readLine();
			
			
			int inboxIndex = Integer.parseInt(inboxString)-1;
			
			
							
			controller.registerEvent(inboxIndex, event);
			
			
		}
		
		
		
		if (action == ViewAction.STARTGAME) {
			// Start a new game.
					
			System.out.println("Start a new game.");
			System.out.println("What period in days? (Default: 7)");
			String periodStr = buf.readLine();
			int period;
			if (periodStr.length() == 0)
				period = 7;
			else {
				period = Integer.parseInt(periodStr);
			}
	
			
			
			int goal = 0;
				
			System.out.println("Starting game now with period of " + period + " days and goal of " + goal);
			System.out.println("Yes/no");
			String startStr = buf.readLine();
			if (startStr.equalsIgnoreCase("yes")) {
				controller.startNewGame(new Date(), period, goal);
				out.println("Game Started"); 
			}
			
		}
	
		if (action == ViewAction.SHOWINBOXES) {
			List<Inbox> list = controller.getAllInboxes();
						
			System.out.println("**** Inbox List ****");
			for (int index = 0; index < list.size(); index++) {
				System.out.println("" + (index+1) + ". " + list.get(index));
			}
			System.out.println("");
			System.out.println(controller.getModel().getBathtub().toStringLong());
			
		}
		
		
		if (action == ViewAction.QUIT) {
			controller.endSession();				
		}
		
		
		choices.clear();
		
		*/
	}

	@Override
	public void messageToUser(Object actualString) {
		// TODO Auto-generated method stub
		throw new AssertionError();
		
	}

	@Override
	public String askQuestion(Object question) throws IOException, UserInterruptException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean askYesnoQuestion(String question) throws IOException, UserInterruptException {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void startMessage() {
		// TODO Auto-generated method stub
		throw new AssertionError();
		
	}

	@Override
	public void addChoice(Command command) {
		// TODO Auto-generated method stub
		throw new AssertionError();
		
	}

	@Override
	public void showStatus(Model model) {
		// TODO Auto-generated method stub
		throw new AssertionError();
		
	}

	@Override
	public void printControlScheme(List<Command> commandList) {
		// TODO Auto-generated method stub
		throw new AssertionError();
		
	}

	

}
