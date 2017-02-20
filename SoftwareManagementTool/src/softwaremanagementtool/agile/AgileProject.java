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
import softwaremanagementtool.agile.mainview.MainViewController;
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
    showAgileMain();
    
  }

  public void showAgileMain() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/mainview/AgileMainView.fxml"));
       
    AnchorPane agileLayout = loader.load();
    
    MainViewController controller = (MainViewController)loader.getController();
    
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

  public Stage getPrimaryStage() {
      return primaryStage;
  }
  
//display the list of the user story
  public ObservableList<UserStory> getUserStoryData() {
      return userstoryData;
  }
  
  
}
