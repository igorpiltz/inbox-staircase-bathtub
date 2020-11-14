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

public class CommandLineViewImpl extends mvctemplate.view.CommandLineView implements View {
	
		
	private Controller controller;
	private PrintStream out = System.out;
	private List<ViewAction> choices = new ArrayList<ViewAction>();
	private BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

	

	

	@Override
	public void startMessage() {
		System.out.println("Inkorgstrappbadkar");
	}

	@Override
	public void addChoice(ViewAction action) {
		choices.add(action);
	}

	


	@Override
	public void showStatus(Model model) {
		System.out.println(model.toString());
	}
	
}
