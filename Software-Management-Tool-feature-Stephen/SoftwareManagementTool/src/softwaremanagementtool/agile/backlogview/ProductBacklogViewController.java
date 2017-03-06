package softwaremanagementtool.agile.backlogview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;

public class ProductBacklogViewController {
	
	private AgileProject agilePrj;
  @FXML
  private AnchorPane backlogPane;

	public AnchorPane getBacklogPane() {
		return backlogPane;
	}

	public void setAgileProject(AgileProject inPrj) {
		agilePrj = inPrj;
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
   /*	UserStory selectedUserStory = userstoryTable.getSelectionModel().getSelectedItem();
       if (selectedUserStory != null) {
           boolean okClicked = mainApp.showUserStoryEditDialog(selectedUserStory);
           if (okClicked) {
               showUserStoryDetails(selectedUserStory);
           }

       } 
       else 
       {
           Alert alert = new Alert(AlertType.WARNING);
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("No Selection");
           alert.setHeaderText("No user story Selected");
           alert.setContentText("Please select a user story from the table.");
           
           alert.showAndWait();
       } */
   }
}
