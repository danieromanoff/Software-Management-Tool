package softwaremanagementtool.smtmainview;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import softwaremanagementtool.SoftwareManagementToolMain;

public class SmtMainViewControl {

  private SoftwareManagementToolMain smt;
  @FXML
  private Menu menuEdit;
  @FXML
  private Menu menuAgile;
  @FXML
  private MenuItem menuSave;
  @FXML
  private MenuItem menuClose;
  
  @FXML
  private void goNewAgile() throws IOException {
    smt.openAgile("NEW");
  }
  
  @FXML
  private void goOpenAgile() throws IOException {
    smt.openAgile("OPEN");
  }
  
  @FXML
  private void goClose() throws IOException {
    smt.closePrj();
  }
  
  @FXML
  private void goExit() throws IOException {
    smt.exit();
  }
  
  @FXML
  private void goEditProp() throws IOException {
    smt.editProp();
  }
  
  public void setSmt(SoftwareManagementToolMain inSmt) {
    smt = inSmt;
  }
  
  public void showAgileMenu(boolean showit) {
  	menuAgile.setVisible(showit);
  	menuEdit.setVisible(showit);
  	menuSave.setDisable(!showit);
  	menuClose.setDisable(!showit);
  }
  
}
