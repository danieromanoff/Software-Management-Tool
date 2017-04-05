package softwaremanagementtool;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import softwaremanagementtool.agile.AgilePrjData;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.smtmainview.SmtMainViewControl;

public class SoftwareManagementToolMain extends Application {

  private Stage primaryStage;
  private BorderPane mainLayout;
  private SmtMainViewControl controller;
  
  private AgileProject agilePrj;
  private AgilePrjData agilePrjData;
	
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
		
	private void tempCreateData() {
		
		agilePrjData = new AgilePrjData();
		agilePrjData.addUser("Jack");
		agilePrjData.addUser("Jill");
		agilePrjData.addUser("Danielle");
		agilePrjData.addUser("Siddhesh");
		agilePrjData.addUser("Steve");
		agilePrjData.addUser("Varun");
		
		agilePrjData.setName("Gedcom");
		agilePrjData.setDescription("This project provides a program to validate Gedcom files");
	}
	
	public void openAgile(String mode) throws IOException {
		closePrj();
	  try {
	  	if (mode.equals("NEW")) tempCreateData(); // TODO temp
      agilePrj = new AgileProject(mode, new File("test.xml"), agilePrjData, primaryStage, mainLayout);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  agilePrj = null;
	  }
    
    if (agilePrj != null)
    {
    	controller.showAgileMenu(true);
    } else {
    	closePrj();
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
  
  public void showBurndownLinePoints() throws IOException {
    if (agilePrj != null)
    {
    	agilePrj.showBurndownLinePoints();
    }
  }
    
	public void save()  {
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
