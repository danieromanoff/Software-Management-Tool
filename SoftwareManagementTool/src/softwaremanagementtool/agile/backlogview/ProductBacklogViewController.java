package softwaremanagementtool.agile.backlogview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;

public class ProductBacklogViewController {
	
	private AgileProject agilePrj;
  @FXML
  private AnchorPane backlogListPane;
  @FXML
  private AnchorPane backlogEntryPane;

	public AnchorPane getBacklogListPane() {
		return backlogListPane;
	}
	
	public AnchorPane getBacklogEntryPane() {
		return backlogEntryPane;
	}
	 
	public void setAgileProject(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
	
	@FXML
  private void goNewUserStory() throws IOException {
		agilePrj.newUserStory();
  }
   
  @FXML
  private void goNewChangeRequest() throws IOException {
  	agilePrj.newChangeRequest();
  }

  @FXML
  private void goSaveBacklogItem() {
  	agilePrj.updateBacklogItem();
  }
}
