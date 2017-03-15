package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import softwaremanagementtool.agile.Sprint;

public class SprintReviewViewController {

	@FXML
  private TextField totalSloc;
	
	public void showSprint(Sprint sprint) {
	  totalSloc.setText(Integer.toString(sprint.getEndSloc()));
	}
	
	public void saveSprint(Sprint sprint) {
	  sprint.setEndSloc(Integer.parseInt(totalSloc.getText()));
	}
}
