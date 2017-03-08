package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SprintBacklogViewController {

	 @FXML
	  private AnchorPane detailsPane;
	
	public AnchorPane getBacklogEntryPane() {
		return detailsPane;
	}
}
