package inkorgstrappbadkar.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import inkorgstrappbadkar.controller.Controller;
import inkorgstrappbadkar.controller.ViewAction;
import inkorgstrappbadkar.model.Inbox;
import inkorgstrappbadkar.model.Model;

/**
 * implementerar view:en som en konsol. Vi ska väl bara behöva trycka på en knapp för att starta nästa steg. 
 * 
 */

public class CommandLineView implements View {
	
		
	private Controller controller;
	private PrintStream out = System.out;
	private List<ViewAction> choices = new ArrayList<ViewAction>();
	private BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

	public CommandLineView(Controller controller) {
		this.controller = controller;		
	}

	

	@Override
	public void startMessage() {
		System.out.println("Inkorgstrappbadkar");
	}

	@Override
	public void addChoice(ViewAction action) {
		choices.add(action);
	}

	@Override
	public void showChoices() throws IOException {
		
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
			for (int index = 0; index < list.size(); index++) {
				System.out.println("" + (index+1) + ". " + list.get(index));
			}
			System.out.println("");
			
		}
		
		
		if (action == ViewAction.QUIT) {
			controller.endSession();				
		}
		
		
		choices.clear();
	}



	@Override
	public void showStatus(Model model) {
		System.out.println(model.toString());
	}
	
}
