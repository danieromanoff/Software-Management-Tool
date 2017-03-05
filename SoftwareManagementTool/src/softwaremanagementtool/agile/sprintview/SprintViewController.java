/**
 * 
 */
package softwaremanagementtool.agile.sprintview;

import java.io.IOException;

import javafx.fxml.FXML;
import softwaremanagementtool.agile.AgileProject;


public class SprintViewController {

	private AgileProject agilePrj;
	
	@FXML
  private void goNewSprint() throws IOException {
		 agilePrj.newSprint();
  }
	
	public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
	
}
