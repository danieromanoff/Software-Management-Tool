package softwaremanagementtool;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;
import softwaremanagementtool.smtmainview.SmtMainViewControl;

public class SoftwareManagementToolMain extends Application {

  private Stage primaryStage;
  private BorderPane mainLayout;
  private SmtMainViewControl controller;
  
  private AgileProject agilePrj;
	
  @Override
  public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Software Management Tool"); 	
    showWindow();
  }
	
	private void showWindow() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SoftwareManagementToolMain.class.getResource("smtmainview/SmtMainView.fxml"));
		mainLayout = loader.load();
		
	  controller = (SmtMainViewControl)loader.getController();
    controller.setSmt(this);
		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		showSplash();
	}
	
	private void showSplash() throws IOException {
	  FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("smtmainview/SmtSplashView.fxml"));
    AnchorPane splashLayout = loader.load();
    mainLayout.setCenter(splashLayout);
	}
		
	public void openAgile(String mode) throws IOException {
	  closePrj();
    agilePrj = new AgileProject(mode, primaryStage, mainLayout); // TODO pass agilePrjData
    if (agilePrj != null)
    {
    	controller.showAgileMenu(true);
    }
  }
	
	public void showAgileDashboard() throws IOException {
    if (agilePrj != null)
    {
    	agilePrj.showDashboard();
    }
  }
	
	public void showAgileBacklog() throws IOException {
    if (agilePrj != null)
    {
    	agilePrj.showBacklog();
    }
  }
	
	public void showAgileSprint() throws IOException {
    if (agilePrj != null)
    {
    	agilePrj.showSprintView();
    }
	}
    
  public void showAgileReports() throws IOException {
    if (agilePrj != null)
    {
    	agilePrj.showReportsView();
    }
  }
    
	public void save()  {
		System.out.println("Save");
	    if (agilePrj != null )
	    {
	      agilePrj.save();
	    }
	  }
	
	public void editProp()  {
    if (agilePrj != null )
    {
      // TODO agilePrj.editProp();
    }
  }
	 
	public void closePrj() throws IOException  {
    if (agilePrj != null )
    {
      // TODO agilePrj.close();
      agilePrj = null;
    }
    controller.showAgileMenu(false);
    showSplash();
  }
	
	public void exit() throws IOException  {
	   closePrj();
	   primaryStage.close();
   }
	 
	public static void main(String[] args) {
		launch(args);
	}
}
