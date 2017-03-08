package softwaremanagementtool.agile;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.backlogview.BacklogViewController;
import softwaremanagementtool.agile.backlogview.ProductBacklogViewController;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;
import softwaremanagementtool.agile.changereqview.ChangeReqViewController;


public class AgileProject {
  
   /**
   *  Class Attributes
   */
  private String projectName;
  private BorderPane mainLayout;
  private Stage primaryStage;
  private AnchorPane blEntryPane;
  private UserStoryViewController userStoryController;
  private BacklogViewController backlogViewController;
  SprintViewController sprintController;
  private ProductBacklog productBacklog;
  private SprintList sprintList;
	private SprintUi theSprintUi;
  
  /**
   *  Constructor
   */
  public AgileProject(String prjName, Stage inStage, BorderPane inLayout) throws IOException {
    projectName = prjName;
    primaryStage = inStage;
    mainLayout = inLayout;
    productBacklog = new ProductBacklog();
    sprintList = new SprintList();
    showDashboard();
  }

  /**
   *  Scene methods
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
    // Frame to hold backlog view
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/ProductBacklogView.fxml"));
    AnchorPane prodBlLayout = loader.load();
    ProductBacklogViewController controller = (ProductBacklogViewController)loader.getController();
    controller.setAgileProject(this);  
    mainLayout.setCenter(prodBlLayout);
    
    // The Backlog view
    FXMLLoader blLoader = new FXMLLoader();
    blLoader.setLocation(SoftwareManagementToolMain.class.getResource("agile/backlogview/BacklogView.fxml"));
    AnchorPane blLayout = blLoader.load();
    backlogViewController = (BacklogViewController)blLoader.getController();
    
    // Set callback
    backlogViewController.setAgilePrj(this);
    AnchorPane blPane = controller.getBacklogPane();
    blEntryPane = backlogViewController.getBacklogEntryPane();
    
    // Adjust with re-size
    blPane.getChildren().add(blLayout);
    AnchorPane.setTopAnchor(blLayout, 0.0);
    AnchorPane.setLeftAnchor(blLayout, 0.0);
    AnchorPane.setRightAnchor(blLayout, 0.0);
    AnchorPane.setBottomAnchor(blLayout, 0.0);
    showUserStoryView();
  }
  
  private void showUserStoryView() throws IOException 
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryView.fxml"));
    AnchorPane userstoryPane = (AnchorPane) loader.load();
    userStoryController = (UserStoryViewController)loader.getController();
    
    // Set Callback
    userStoryController.setAgilePrj(this);
    
    // Allow re-size
    blEntryPane.getChildren().add(userstoryPane);
    AnchorPane.setTopAnchor(userstoryPane, 0.0);
    AnchorPane.setLeftAnchor(userstoryPane, 0.0);
    AnchorPane.setRightAnchor(userstoryPane, 0.0);
    AnchorPane.setBottomAnchor(userstoryPane, 0.0);
  }
  
  public  void showSprintView() throws IOException {
    // TODO    
  	theSprintUi = new SprintUi(this);
    sprintController = loader.getController();
    sprintController.setAgilePrj(this);
    // Allow re-size
   
    AnchorPane.setTopAnchor(sprintLayout, 0.0);
    AnchorPane.setLeftAnchor(sprintLayout, 0.0);
    AnchorPane.setRightAnchor(sprintLayout, 0.0);
    AnchorPane.setBottomAnchor(sprintLayout, 0.0);
    
  }
  
  public  void showReportsView() throws IOException {
    // TODO     
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/reportsview/ReportsView.fxml"));
    AnchorPane reportsLayout = (AnchorPane) loader.load();
    mainLayout.setCenter(reportsLayout);
    SprintViewController controller = loader.getController();
  }
  
  /**
   *  Back log methods 
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
  
  public void newUserStory() throws IOException {
    UserStory tempUserStory = new UserStory();
    tempUserStory.setID(productBacklog.nextId());
    getBacklogList().add(tempUserStory);
    userStoryController.showUserStoryDetails(tempUserStory);
    backlogViewController.setLast();
    
  } 
  
  public void newChangeRequest() throws IOException {
    ChangeRequest tempChangeReq = new ChangeRequest();
    // TODO
  } 

  public ObservableList<BacklogEntry> getBacklogList() {
    return productBacklog.backlogList();
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }
  
  public BorderPane getMainLayout() {
    return mainLayout;
  }

  /**
   *  Sprint Methods
   *  
   *
   */
  public void newSprint() throws IOException {
    Sprint newSprint = new Sprint();
    newSprint.setID(sprintList.nextId());
    sprintList.sprintList().add(newSprint);
    //sprintViewController.showUserSprint(newSprint); TODO
    //sprintViewController.setLastListItem();
  	
    
  }
  
}  