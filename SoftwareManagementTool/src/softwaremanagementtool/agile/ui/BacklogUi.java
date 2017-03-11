package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.backlogview.BacklogViewController;
import softwaremanagementtool.agile.backlogview.ProductBacklogViewController;
import softwaremanagementtool.agile.changereqview.ChangeReqViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

public class BacklogUi {
	
	private AgileProject agilePrj;
	private BacklogViewController controller;
	AnchorPane prodBlLayout ;
	
	private AnchorPane blEntryPane;
  private UserStoryViewController userStoryController;
  private BacklogViewController backlogViewController;
  private ChangeReqViewController changeReqController;
	
  public BacklogUi(AgileProject parent) throws IOException {
  	agilePrj = parent;
  	FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/ProductBacklogView.fxml"));
    prodBlLayout = loader.load();
    ProductBacklogViewController controller = (ProductBacklogViewController)loader.getController();
    controller.setAgileProject(agilePrj);  
   
    
    // The Backlog view
    FXMLLoader blLoader = new FXMLLoader();
    blLoader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/BacklogView.fxml"));
    AnchorPane blLayout = blLoader.load();
    backlogViewController = (BacklogViewController)blLoader.getController();
    
    // Set callback
    backlogViewController.setAgilePrj(agilePrj);
    AnchorPane blPane = controller.getBacklogPane();
    blEntryPane = backlogViewController.getBacklogEntryPane();
    
    // Adjust with re-size
    blPane.getChildren().add(blLayout);
    AnchorPane.setTopAnchor(blLayout, 0.0);
    AnchorPane.setLeftAnchor(blLayout, 0.0);
    AnchorPane.setRightAnchor(blLayout, 0.0);
    AnchorPane.setBottomAnchor(blLayout, 0.0);
    initUserStoryView();
  }
  
  private void initUserStoryView() throws IOException 
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryView.fxml"));
    AnchorPane userstoryPane = (AnchorPane) loader.load();
    userStoryController = (UserStoryViewController)loader.getController();
    
    // Set Callback
    userStoryController.setAgilePrj(agilePrj);
    
    // Allow re-size
    blEntryPane.getChildren().add(userstoryPane);
    AnchorPane.setTopAnchor(userstoryPane, 0.0);
    AnchorPane.setLeftAnchor(userstoryPane, 0.0);
    AnchorPane.setRightAnchor(userstoryPane, 0.0);
    AnchorPane.setBottomAnchor(userstoryPane, 0.0);
  }
  
  public void show() {
		agilePrj.getMainLayout().setCenter(prodBlLayout);
	}
  
  public void showBacklogEntry(BacklogEntry blEntry) throws IOException {
    if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
        userStoryController.showUserStoryDetails((UserStory) blEntry);
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
