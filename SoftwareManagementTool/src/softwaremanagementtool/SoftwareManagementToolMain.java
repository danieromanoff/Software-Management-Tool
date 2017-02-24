package softwaremanagementtool;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.mainview.MainViewController;
import softwaremanagementtool.smtmainview.SmtMainViewControl;

/**
 * @author Stephen
 *
 */
public class SoftwareManagementToolMain extends Application {

  private Stage primaryStage;
  private BorderPane mainLayout;
  private SmtMainViewControl controller;
  
  private AgileProject agilePrj;
	
  /**
   *  History - Initials, Date, Description
   *  sm  12/17/17  Creation
   *
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Software Management Tool"); 	
    showWindow();
  }
	
	/**
	 *  History - Initials, Date, Notes
	 *  sm  12/17/17  Creation
	 *  
	 */
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
		
	/**
	 *  History - Initials, Date, Description
	 *  
	 *
	 */
	public void openAgile(String mode) throws IOException {
	  closePrj();
    agilePrj = new AgileProject(mode, primaryStage, mainLayout); // TODO pass agilePrjData
    if (agilePrj != null)
    {
    	controller.showAgileMenu(true);
    }

  }
	
	/**
	 *  History - Initials, Date, Description
	 *  sm 2/23/17  Creation
	 *
	 */
	public void save()  {
	    if (agilePrj != null )
	    {
	      // TODO agilePrj.save();
	    }
	  }
	
	public void editProp()  {
    if (agilePrj != null )
    {
      // TODO agilePrj.editProp();
    }
  }
	 
   /**
	 *  History - Initials, Date, Description
	 *  sm 2/23/17  Creation
	 *
   */
	public void closePrj() throws IOException  {
    if (agilePrj != null )
    {
      // TODO agilePrj.close();
      agilePrj = null;
    }
    controller.showAgileMenu(false);
    showSplash();
  }
	
	 /**
	 *  History - Initials, Date, Description
	 *  sm 2/23/17  Creation
	 * @throws IOException 
	 *
	 */
	public void exit() throws IOException  {
	   closePrj();
	   primaryStage.close();
   }
	 
	/**
	 *  History - Initials, Date, Notes
	 *  sm  12/17/17  Creation
	 *
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
