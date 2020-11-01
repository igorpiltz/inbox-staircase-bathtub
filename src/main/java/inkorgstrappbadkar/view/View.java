package inkorgstrappbadkar.view;

import java.io.IOException;

import inkorgstrappbadkar.controller.ViewAction;
import inkorgstrappbadkar.model.Model;

public interface View {

	void startMessage();

	void showChoices() throws IOException;

	void addChoice(ViewAction action);

	void showStatus(Model model);

}
