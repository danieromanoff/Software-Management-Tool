package softwaremanagementtool.agile;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import softwaremanagementtool.SoftwareManagementToolMain;

import softwaremanagementtool.agile.ui.BacklogUi;
import softwaremanagementtool.agile.ui.DashboardUi;
import softwaremanagementtool.agile.ui.ReportsUi;
import softwaremanagementtool.agile.ui.SprintUi;
import softwaremanagementtool.agile.UserStory;



public class AgileProject {
  
   /**
   *  Class Attributes
   */
  private String projectName;
  private BorderPane mainLayout;
  private Stage primaryStage;
  private ProductBacklog productBacklog;
  private SprintList sprintList;
	private SprintUi sprintUi;
	private DashboardUi dashboardUi;
	private BacklogUi backlogUi;
	private ReportsUi reportsUi;

  /**
   *  Constructor
   */
  public AgileProject(String prjName, Stage inStage, BorderPane inLayout) throws IOException {
    projectName = prjName;
    primaryStage = inStage;
    mainLayout = inLayout;
    productBacklog = new ProductBacklog();
    sprintList = new SprintList();
    // Create views
    sprintUi = new SprintUi(this);
    dashboardUi = new DashboardUi(this);
    backlogUi = new BacklogUi(this);
    reportsUi = new ReportsUi(this);
    
    showDashboard();
  }

  /**
   *  Scene methods
   *  
   */
  public void showDashboard() throws IOException {
    dashboardUi.show();
  }

  public  void showBacklog() throws IOException {
    // Frame to hold backlog view
  	backlogUi.show();
  }
  
  public  void showSprintView() throws IOException {
  	sprintUi.show();
  }
  
  public  void showReportsView() throws IOException {
    reportsUi.show();
  }
  
  /**
   *  Back log methods 
   *  
   */
  public void showBacklogEntry(BacklogEntry blEntry) throws IOException {
  	backlogUi.showBacklogEntry(blEntry);
  }
  
  public void updateBacklogItem() {
  	backlogUi.updateBacklogItem();
  }
  
  public void newUserStory() throws IOException {
    UserStory newUserStory = new UserStory();
    newUserStory.setID(productBacklog.nextId());
    getBacklogList().add(newUserStory);
    backlogUi.addUserStory(newUserStory);
    
  } 
  
  public void newChangeRequest() throws IOException {
    ChangeRequest newChangeRequest = new ChangeRequest();
    newChangeRequest.setID(productBacklog.nextId());
    getBacklogList().add(newChangeRequest);
    backlogUi.addChangeRequest(newChangeRequest);

  } 

  public ObservableList<BacklogEntry> getBacklogList() {
    return productBacklog.backlogList();
  }
  
  /**
   *  
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