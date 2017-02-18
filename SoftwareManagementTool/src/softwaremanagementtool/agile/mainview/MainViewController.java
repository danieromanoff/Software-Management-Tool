package softwaremanagementtool.agile.mainview;

import java.io.IOException;

import javafx.fxml.FXML;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;

public class MainViewController {

  private AgileProject agilePrj;
  
  
  @FXML
  private void goBacklog() throws IOException {
    AgileProject.showBacklog();
  }
  
  public void setAgileProject(AgileProject inPrj) {
    agilePrj = inPrj;
  }
  
  public void setPrjName(String inName) {
    // TBD set Name
  }

}
