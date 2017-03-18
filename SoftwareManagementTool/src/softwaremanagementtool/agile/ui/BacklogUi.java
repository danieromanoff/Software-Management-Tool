package softwaremanagementtool.agile.ui;

import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.backlogview.BacklogViewController;
import softwaremanagementtool.agile.backlogview.ProductBacklogViewController;
import softwaremanagementtool.agile.changereqview.ChangeReqViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

public class BacklogUi extends BaseUi<ProductBacklogViewController> {
	
	private AnchorPane blEntryPane;
  private UserStoryViewController userStoryController;
  private BacklogViewController backlogViewController;
  private ChangeReqViewController changeReqController;
  
  private final String FXML_PROD_BACKLOG_VIEW = "agile/backlogview/ProductBacklogView.fxml";
  private final String FXML_BACKLOG_VIEW = "agile/backlogview/BacklogView.fxml";
  private final String FXML_USER_STORY_VIEW = "agile/userstoryview/UserStoryView.fxml";
  private final String FXML_CHANGE_REQ_VIEW = "agile/changereqview/ChangeReqView.fxml";
  
  public BacklogUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_PROD_BACKLOG_VIEW);
  	classController.setAgileProject(agilePrj);
  	    
    // The Backlog view
  	backlogViewController = (BacklogViewController) loadSubView(classController.getBacklogListPane(), FXML_BACKLOG_VIEW);
  	backlogViewController.setAgilePrj(agilePrj, agilePrj.getBacklogList());
  	backlogViewController.setDisplayUi(this);
    blEntryPane = classController.getBacklogEntryPane();
    
    userStoryController = (UserStoryViewController) loadSubView(blEntryPane, FXML_USER_STORY_VIEW);
    userStoryController.setPane( (AnchorPane) blEntryPane.getChildren().get(0));
    userStoryController.setAgilePrj(agilePrj);
    userStoryController.setVisable(false);
    changeReqController = (ChangeReqViewController) loadSubView(blEntryPane, FXML_CHANGE_REQ_VIEW);
    changeReqController.setPane( (AnchorPane) blEntryPane.getChildren().get(1));
    changeReqController.setAgilePrj(agilePrj);
    changeReqController.setVisable(false);
  }
  
  
  public void showBacklogEntry(BacklogEntry blEntry) throws IOException {
    if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
        userStoryController.showUserStoryDetails((UserStory) blEntry);
        userStoryController.setVisable(true);
        changeReqController.setVisable(false);
      }
      else if (blEntry.getType().equals("ChangeRequest")) {
      	changeReqController.showChangeRequestDetails((ChangeRequest) blEntry);
      	userStoryController.setVisable(false);
      	changeReqController.setVisable(true);
      }
    } 
    else 
    {
  
    }   
  }
  
  public void updateBacklogItem() {
    BacklogEntry blEntry = backlogViewController.getSelectedItem();
    updateBacklogItem(blEntry);
  }
  
  public void updateBacklogItem(BacklogEntry blEntry) {
    if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
        userStoryController.updateUserStoryDetails((UserStory) blEntry);
      }
      else if (blEntry.getType().equals("ChangeRequest")) {
      	changeReqController.updateChangeRequestDetails((ChangeRequest) blEntry);
      }
    } 
    else 
    {
      
    }
  
  }
  
  public void addUserStory(UserStory userStory)  {
    userStoryController.showUserStoryDetails(userStory);
    backlogViewController.setLast();
    
  } 
  
  public void addChangeRequest(ChangeRequest changeRequest) {
    changeReqController.showChangeRequestDetails(changeRequest);
    backlogViewController.setLast();

  } 
  
  public void leavingBacklogEntry(BacklogEntry blEntry) {
  	boolean changes = false;
    if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
      	changes = userStoryController.anyChanges((UserStory) blEntry);
      }
      else if (blEntry.getType().equals("ChangeRequest")) {
      	changes = changeReqController.anyChanges((ChangeRequest) blEntry);
      }
      if (changes) {
      	// check to save
      //	Alert alert = new Alert(AlertType.CONFIRMATION);
     // 	alert.setTitle("Save Changes");
      //	alert.setHeaderText("Changes Made, Do you want to save?");
     // 	alert.setContentText("OK to save; Cancel to discard");

     // 	Optional<ButtonType> result = alert.showAndWait();
     // 	if (result.get() == ButtonType.OK){
      	if (SaveAlert.save()) {
      		updateBacklogItem(blEntry);
      	} 
      }
    } 
  }
}
