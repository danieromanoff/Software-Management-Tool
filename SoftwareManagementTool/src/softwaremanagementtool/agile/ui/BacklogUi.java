package softwaremanagementtool.agile.ui;

import java.io.IOException;

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
  	backlogViewController.setAgilePrj(agilePrj);
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
    System.out.println(blEntry.getID());
    if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
        userStoryController.updateUserStoryDetails((UserStory) blEntry);
        userStoryController.setVisable(true);
      }
      else if (blEntry.getType().equals("ChangeRequest")) {
      	changeReqController.showChangeRequestDetails((ChangeRequest) blEntry);
      	userStoryController.setVisable(false);
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
}
