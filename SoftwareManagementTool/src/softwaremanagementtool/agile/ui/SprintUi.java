package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.sprintview.SprintBacklogViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

public class SprintUi {
	
	private AgileProject agilePrj;
	private SprintViewController sprintController;
	AnchorPane sprintLayout;
	
	public  SprintUi(AgileProject parent) throws IOException {
		agilePrj = parent;
    // TODO  
		
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintView.fxml"));
    sprintLayout = (AnchorPane) loader.load();
    sprintController = loader.getController();
    sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintLayout, 0.0);
    AnchorPane.setLeftAnchor(sprintLayout, 0.0);
    AnchorPane.setRightAnchor(sprintLayout, 0.0);
    AnchorPane.setBottomAnchor(sprintLayout, 0.0);
      
    initSprintInfo();
    initSprintBacklog();
    initSprintTasks();
    initSprintReview();
    initSprintRetrospect();
     
	}
	
	private void initSprintInfo() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintInfoView.fxml"));
    AnchorPane sprintInfoPane = (AnchorPane) loader.load();
    sprintController.getSprintInfoPane().getChildren().add(sprintInfoPane);
  
   // sprintController = loader.getController();
   // sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintInfoPane, 0.0);
    AnchorPane.setLeftAnchor(sprintInfoPane, 0.0);
    AnchorPane.setRightAnchor(sprintInfoPane, 0.0);
    AnchorPane.setBottomAnchor(sprintInfoPane, 0.0);
	}
	

	private void initSprintBacklog() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintBacklogView.fxml"));
    AnchorPane sprintBacklogPane = (AnchorPane) loader.load();
    sprintController.getSprintBacklogPane().getChildren().add(sprintBacklogPane);
  
    SprintBacklogViewController backlogViewController = loader.getController();
   // sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintBacklogPane, 0.0);
    AnchorPane.setLeftAnchor(sprintBacklogPane, 0.0);
    AnchorPane.setRightAnchor(sprintBacklogPane, 0.0);
    AnchorPane.setBottomAnchor(sprintBacklogPane, 0.0);
    
    AnchorPane detailsPane = backlogViewController.getBacklogEntryPane();
    initUserStoryView(detailsPane);
    // showChangeReqView
	}
	
	 private void initUserStoryView(AnchorPane parent) throws IOException 
	  {
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryView.fxml"));
	    AnchorPane userstoryPane = (AnchorPane) loader.load();
	    //userStoryController = (UserStoryViewController)loader.getController();
	    
	    // Set Callback
	    //userStoryController.setAgilePrj(this);
	    
	    // Allow re-size
	    parent.getChildren().add(userstoryPane);
	    AnchorPane.setTopAnchor(userstoryPane, 0.0);
	    AnchorPane.setLeftAnchor(userstoryPane, 0.0);
	    AnchorPane.setRightAnchor(userstoryPane, 0.0);
	    AnchorPane.setBottomAnchor(userstoryPane, 0.0);
	    
	    userstoryPane.setVisible(false);
	    
	  }

  private void initSprintTasks() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintTasksView.fxml"));
    AnchorPane sprintTasksPane = (AnchorPane) loader.load();
    sprintController.getSprintTaskPane().getChildren().add(sprintTasksPane);
  
   // sprintController = loader.getController();
   // sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintTasksPane, 0.0);
    AnchorPane.setLeftAnchor(sprintTasksPane, 0.0);
    AnchorPane.setRightAnchor(sprintTasksPane, 0.0);
    AnchorPane.setBottomAnchor(sprintTasksPane, 0.0);
	}
 
  private void initSprintReview() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintReviewView.fxml"));
    AnchorPane sprintReviewPane = (AnchorPane) loader.load();
    sprintController.getSprintReviewPane().getChildren().add(sprintReviewPane);
  
   // sprintController = loader.getController();
   // sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintReviewPane, 0.0);
    AnchorPane.setLeftAnchor(sprintReviewPane, 0.0);
    AnchorPane.setRightAnchor(sprintReviewPane, 0.0);
    AnchorPane.setBottomAnchor(sprintReviewPane, 0.0);
	}
	
	private void initSprintRetrospect() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintRetrospectView.fxml"));
    AnchorPane sprintRetrospectPane = (AnchorPane) loader.load();
    sprintController.getSprintRetrospctPane().getChildren().add(sprintRetrospectPane);
  
   // sprintController = loader.getController();
   // sprintController.setAgilePrj(agilePrj);
     // Allow re-size
    AnchorPane.setTopAnchor(sprintRetrospectPane, 0.0);
    AnchorPane.setLeftAnchor(sprintRetrospectPane, 0.0);
    AnchorPane.setRightAnchor(sprintRetrospectPane, 0.0);
    AnchorPane.setBottomAnchor(sprintRetrospectPane, 0.0);
	}
	
	public void show() {
		agilePrj.getMainLayout().setCenter(sprintLayout);
	}
}
