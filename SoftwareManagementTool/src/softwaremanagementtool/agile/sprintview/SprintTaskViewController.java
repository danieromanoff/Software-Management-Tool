package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;

public class SprintTaskViewController {

//setting table field
  @FXML
  private TextField id;
  @FXML
  private TextField assignee;
  @FXML
  private TextField theTask;
  @FXML
  private TextField estTime;
  @FXML
  private TextField actTime;
  @FXML
  private TextField backlogRef;
  @FXML
  private TextField status;

  // Reference to the main application.
  private AgileProject agilePrj;


  public SprintTaskViewController() {
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
  
  public void showSprint(Sprint sprint) {
		//id.setText(Integer.toString(sprint.getID()));
	}
  
  public void saveSprint(Sprint sprint) {
		// sprint.setState(status.getValue());
	}
}
