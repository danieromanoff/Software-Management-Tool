package softwaremanagementtool.agile.mainview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import softwaremanagementtool.agile.AgileProject;

public class MainViewController {
  
  private AgileProject agilePrj;
  
  @FXML
  private void GoToReports(ActionEvent Reports) {
      // Button was clicked, do something...
      
  }  
  
  @FXML
  private void GoToBackLog() {
      // Button was clicked, do something...
    agilePrj.showBacklog();
  } 
  
  @FXML
  private void GoToSprints(ActionEvent Sprints) {
      // Button was clicked, do something...
      
  }  

  public void setAgileProject(AgileProject inPrj) {
    agilePrj = inPrj;
  }
  
  public void setPrjName(String inName) {
    // TBD set Name
  }
  
  
}
