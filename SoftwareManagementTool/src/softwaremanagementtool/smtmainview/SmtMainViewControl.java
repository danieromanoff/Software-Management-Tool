package softwaremanagementtool.smtmainview;

import java.io.IOException;

import javafx.fxml.FXML;
import softwaremanagementtool.SoftwareManagementToolMain;

public class SmtMainViewControl {

  private SoftwareManagementToolMain smt;
  
  @FXML
  private void goNewAgile() throws IOException {
    smt.newAgile();
  }
  
  public void setSmt(SoftwareManagementToolMain inSmt) {
    smt = inSmt;
  }
  
}
