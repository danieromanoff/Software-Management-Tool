package softwaremanagementtool.smtmainview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import softwaremanagementtool.SoftwareManagementToolMain;

/**
 * @New Agile Project Window
 *
 */
public class NewAgileProjectController {
	 private SoftwareManagementToolMain smt;
  
    @FXML
  
    TextField tfProjectName = new TextField();
    @FXML
  
    TextField tfDescription = new TextField();
  
    @FXML
  
    TextField tfLanguage = new TextField();

  
    @FXML
      public void Saveproj() throws IOException {

    	smt.SaveProj();

      }
    public void setSmt(SoftwareManagementToolMain inSmt) {
        smt = inSmt;
      }

      
    @FXML
      public void Cancelproj () {

        System.out.println ("Process Cancel");

      }
   
 
 

}

  
  
  
  
  

