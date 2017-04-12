package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;

public class SprintInfoViewController {
	
	private AgileProject agilePrj;
	@FXML
  private TextField id;
	@FXML
  private DatePicker startDate;
	@FXML
  private DatePicker endDate;
	@FXML
  private ComboBox<String> status;

	@FXML
  private void initialize() {
   
  	for (String state : Sprint.STATE) {
  		status.getItems().add(state);
  	}
  }
	
	public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
	
	public void showSprint(Sprint sprint) {
	  id.setText(Integer.toString(sprint.getID()));
	  status.setValue(sprint.getState());
	  startDate.setValue(sprint.getStartDate());
	  endDate.setValue(sprint.getEndDate());
	}
	
	public void saveSprint(Sprint sprint) {
	  sprint.setStartDate(startDate.getValue());
	  sprint.setEndDate(endDate.getValue());
	  agilePrj.sprintStateChangeReq(sprint, status.getValue());
	}
}
