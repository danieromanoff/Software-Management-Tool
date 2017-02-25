package softwaremanagementtool.agile;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryEditDialogController;
import softwaremanagementtool.agile.userstoryview.UserStoryOverviewController;
import softwaremanagementtool.smtmainview.SmtMainViewControl;

public class AgileProject {

  private String projectName;
  private BorderPane mainLayout;
  private Stage primaryStage;
  
//user story data as an observable list of user stories.
  private ObservableList<UserStory> userstoryData = FXCollections.observableArrayList();
  
  
  public AgileProject(String prjName, Stage inStage, BorderPane inLayout) throws IOException {
    projectName = prjName;
    primaryStage = inStage;
    mainLayout = inLayout;
    showDashboard();
    
  }

  public void showDashboard() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/dashboardview/DashboardView.fxml"));
       
    AnchorPane agileLayout = loader.load();
    
    DashboardViewController controller = (DashboardViewController)loader.getController();
    
    controller.setAgileProject(this); 
    controller.setPrjName(projectName); 

    mainLayout.setCenter(agileLayout);
    
  }

  public  void showBacklog() {
    // TODO Auto-generated method stub
    System.out.println("showBacklog");
    try {
      showUserStoryOverview();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  //user story default view
  public void showUserStoryOverview() throws IOException 
  {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/userstoryview/UserStoryOverview.fxml"));
          AnchorPane userstoryOverview = (AnchorPane) loader.load();
          mainLayout.setCenter(userstoryOverview);
          UserStoryOverviewController controller = loader.getController();
          controller.setMainApp(this);
  }
  
//opens the editor window to edit the user story
  public boolean showUserStoryEditDialog(UserStory userstory) 
  {
      try {
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
      catch (IOException e) 
      {
          e.printStackTrace();
          return false;
      }
  }

  
  public  void showSprint() throws IOException {
    // TODO
    System.out.println("showSprint");
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/sprintview/SprintView.fxml"));
    AnchorPane sprintLayout = (AnchorPane) loader.load();
    mainLayout.setCenter(sprintLayout);
    SprintViewController controller = loader.getController();
    
  }
  
  public  void showReports() throws IOException {
    // TODO 
    System.out.println("showReports");
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/reportsview/ReportsView.fxml"));
    AnchorPane reportsLayout = (AnchorPane) loader.load();
    mainLayout.setCenter(reportsLayout);
    SprintViewController controller = loader.getController();
  }
  
  public Stage getPrimaryStage() {
      return primaryStage;
  }
  
//display the list of the user story
  public ObservableList<UserStory> getUserStoryData() {
      return userstoryData;
  }
  
  
}
