package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;

public class SprintBacklogViewController {

	private AgileProject agilePrj;
	@FXML
	private AnchorPane detailsPane;
	@FXML
	private AnchorPane sprintBlPane;
	@FXML
	private AnchorPane productBlPane;
	@FXML
	private Button blButton;
	
	public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
	
	public AnchorPane getBacklogEntryPane() {
		return detailsPane;
	}
	public AnchorPane getSprintBacklogPane() {
		return sprintBlPane;
	}
	public AnchorPane getProductBacklogPane() {
		return productBlPane;
	}
	
	public void showSprint(Sprint sprint) {
		//id.setText(Integer.toString(sprint.getID()));
	}
	
	public void saveSprint(Sprint sprint) {
		// sprint.setState(status.getValue());
	}
	
	public void setButtonAdd() {
		blButton.setText("Add to Sprint");
		blButton.setVisible(true);
	}
	
	public void setButtonRemove() {
		blButton.setText("Remove from Sprint");
		blButton.setVisible(true);
	}
	
	@FXML
	private void goButton() {
		agilePrj.moveSprintBacklogItem();
	}
}
