package softwaremanagementtool.agile;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.mainview.MainViewController;
import softwaremanagementtool.smtmainview.SmtMainViewControl;

public class AgileProject {

  private String projectName;
  private BorderPane mainLayout;
  
  
  public AgileProject(String prjName, BorderPane inLayout) throws IOException {
    projectName = prjName;
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
 }
  
}
