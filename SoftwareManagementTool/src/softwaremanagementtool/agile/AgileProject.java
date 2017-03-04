package softwaremanagementtool.agile;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.backlogview.BacklogViewController;
import softwaremanagementtool.agile.backlogview.ProductBacklogViewController;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryEditDialogController;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;


public class AgileProject {

  private String projectName;
  private BorderPane mainLayout;
  private Stage primaryStage;
  private AnchorPane blEntryPane;
  private UserStoryViewController userStoryController;
  private ProductBacklog productBacklog;
  
  /**
   * 
   */
  public AgileProject(String prjName, Stage inStage, BorderPane inLayout) throws IOException {
    projectName = prjName;
    primaryStage = inStage;
    mainLayout = inLayout;
    productBacklog = new ProductBacklog();
    showDashboard();
  }

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void showDashboard() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/dashboardview/DashboardView.fxml"));
    AnchorPane dbLayout = loader.load();    
    DashboardViewController controller = (DashboardViewController)loader.getController();
    controller.setAgileProject(this); 
    controller.setPrjName(projectName); 
    AnchorPane.setTopAnchor(dbLayout, 0.0);
    AnchorPane.setLeftAnchor(dbLayout, 0.0);
    AnchorPane.setRightAnchor(dbLayout, 0.0);
    AnchorPane.setBottomAnchor(dbLayout, 0.0);
    mainLayout.setCenter(dbLayout);
  }

  public  void showBacklog() throws IOException {
  	 FXMLLoader loader = new FXMLLoader();
     loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/ProductBacklogView.fxml"));
     AnchorPane prodBlLayout = loader.load();
     ProductBacklogViewController controller = (ProductBacklogViewController)loader.getController();
     controller.setAgileProject(this);  
     mainLayout.setCenter(prodBlLayout);
     
     FXMLLoader blLoader = new FXMLLoader();
     blLoader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/BacklogView.fxml"));
     AnchorPane blLayout = blLoader.load();
     BacklogViewController blController = (BacklogViewController)blLoader.getController();
     AnchorPane blPane = controller.getBacklogPane();
     blEntryPane = blController.getBacklogEntryPane();
     blController.setAgilePrj(this);
     blPane.getChildren().add(blLayout);
     AnchorPane.setTopAnchor(blLayout, 0.0);
     AnchorPane.setLeftAnchor(blLayout, 0.0);
     AnchorPane.setRightAnchor(blLayout, 0.0);
     AnchorPane.setBottomAnchor(blLayout, 0.0);
     showUserStory();
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
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
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void showUserStory() throws IOException 
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryView.fxml"));
    AnchorPane userstoryPane = (AnchorPane) loader.load();
    

    userStoryController = (UserStoryViewController)loader.getController();
    userStoryController.setAgilePrj(this);
    blEntryPane.getChildren().add(userstoryPane);
    AnchorPane.setTopAnchor(userstoryPane, 0.0);
    AnchorPane.setLeftAnchor(userstoryPane, 0.0);
    AnchorPane.setRightAnchor(userstoryPane, 0.0);
    AnchorPane.setBottomAnchor(userstoryPane, 0.0);
  }
    
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void newUserStory() throws IOException {
  	UserStory tempUserStory = new UserStory();
  	tempUserStory.setID(productBacklog.nextId());
    boolean okClicked = showUserStoryEditDialog(tempUserStory);
    if (okClicked) {
      getBacklogList().add(tempUserStory);
    }
  } 
  
  /**
   *  History - Initials, Date, Description
   *  TODO
   *
   */
  public void newChangeRequest() throws IOException {
  	ChangeRequest tempChangeReq = new ChangeRequest();
   // boolean okClicked = showUserStoryEditDialog(tempUserStory);
   // if (okClicked) {
   //   getBacklogList().add(tempChangeReq);
   // }
  } 

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public boolean showUserStoryEditDialog(UserStory userstory) throws IOException 
  { 
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryEditDialog.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage dialogStage = new Stage();
    dialogStage.setTitle("Edit User Story");
    dialogStage.initModality(Modality.WINDOW_MODAL);
    dialogStage.initOwner(primaryStage);
    Scene scene = new Scene(page);
    dialogStage.setScene(scene);
    UserStoryEditDialogController controller = loader.getController();
    controller.setDialogStage(dialogStage);
    controller.setUserStory(userstory);
    //showandwait method to keep the window open till the completion of user action
    dialogStage.showAndWait();
    return controller.isOkClicked();
     
  }

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public  void showSprint() throws IOException {
    // TODO
    System.out.println("showSprint");
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintView.fxml"));
    AnchorPane sprintLayout = (AnchorPane) loader.load();
    mainLayout.setCenter(sprintLayout);
    SprintViewController controller = loader.getController();
    
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public  void showReports() throws IOException {
    // TODO 
    System.out.println("showReports");
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/reportsview/ReportsView.fxml"));
    AnchorPane reportsLayout = (AnchorPane) loader.load();
    mainLayout.setCenter(reportsLayout);
    SprintViewController controller = loader.getController();
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }
  

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public ObservableList<BacklogEntry> getBacklogList() {
    return productBacklog.backlogList();
  }
  
  
}
