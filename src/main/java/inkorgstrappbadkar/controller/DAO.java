package inkorgstrappbadkar.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import inkorgstrappbadkar.model.Model;

public interface DAO {
	
	public void persist() throws FileNotFoundException, IOException;

	public Model getModel();

	public void setModel(Model model);

}
