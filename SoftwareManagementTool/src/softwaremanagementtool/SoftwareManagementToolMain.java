package softwaremanagementtool;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import softwaremanagementtool.agile.AgilePrjData;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.smtmainview.NewAgileProjectController;
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
	
	public void NewAgile(String mode) throws IOException {
	    

	    if (mode.equals("NEW")){
	          
	     
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(SoftwareManagementToolMain.class.getResource("smtmainview/NewAgileProject.fxml"));
	        AnchorPane Newlayout = loader.load();
	        mainLayout.setCenter(Newlayout);
	        NewAgileProjectController proj = (NewAgileProjectController)loader.getController();
	        proj.setSmt(this);
	    }
	}
	    
	 public void SaveProj() throws IOException{    
	        
	        FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Save file");
	        
	        fileChooser.getExtensionFilters().addAll(
	                new ExtensionFilter("XML Files", "*.xml"));
	        File savedFile = fileChooser.showSaveDialog(null);
	        tempCreateData();
	        agilePrj = new AgileProject("NEW", savedFile, agilePrjData, primaryStage, mainLayout);
	        if (agilePrj != null)
	        {
	        	controller.showAgileMenu(true);
	        } else {
	        	closePrj();
	        }
	        
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
	
	public void OpenAgile(String mode) throws IOException {
				   
		
	
		closePrj();
	  try {
		  FileChooser fc = new FileChooser();
			fc.setTitle("Open Existing Project");
			File selectedFile = fc.showOpenDialog(null);
			if (selectedFile != null){
				tempCreateData();
			
//					  
		  
	  	//if (mode.equals("Open")) tempCreateData(); // TODO temp
               agilePrj = new AgileProject(mode, selectedFile, agilePrjData, primaryStage, mainLayout);
			}
	  }
               catch (Exception e) {
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
  public void GoAbout() throws IOException{
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Software Management Tool");
	    alert.setHeaderText(null);
	    alert.setContentText("Version 1.0");

	    alert.showAndWait();
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
