package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import softwaremanagementtool.agile.Sprint;

public class SprintRetrospectViewController {

	@FXML
  private TextArea good;
	@FXML
  private TextArea bad;
	
	public void showSprint(Sprint sprint) {
		good.setText(sprint.getRetrospectiveWell());
		bad.setText(sprint.getRetrospectiveNotSo());
		
		setEditable(sprint.getState().equals(Sprint.STATE_REVIEW));
	}
	
	private void setEditable(boolean edit) {
		good.setEditable(edit);
		bad.setEditable(edit);
	}
	
	public void saveSprint(Sprint sprint) {
		sprint.setRetrospectiveWell(good.getText());
		sprint.setRetrospectiveNotSo(bad.getText());
	}
}
