package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.SprintTask;

public class SprintTaskViewController {

//setting table field
  @FXML
  private TextField id;
  @FXML
  private TextField assignee;
  @FXML
  private TextField theTask;
  @FXML
  private TextField estTime;
  @FXML
  private TextField actTime;
  @FXML
  private TextField backlogRef;
  @FXML
  private ComboBox<String> status;

  // Reference to the main application.
  private AgileProject agilePrj;
  private AnchorPane thisPane;

  public SprintTaskViewController() {
  }
  
  @FXML
  private void initialize() {
    // Clear user story details.
    clearSprintTaskDetails();    
    for (String usStatus : SprintTask.STATUS) {
      status.getItems().add(usStatus);
    }
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
  
  public void setPane(AnchorPane inPane) {
    this.thisPane = inPane;
  }
  
  public void setVisable(boolean visable) {
    thisPane.setVisible(visable);
  }
  
  public void showSprintTaskDetails(SprintTask sprinttask) {
    if (sprinttask != null) {
      id.setText(Integer.toString(sprinttask.getID()));
      assignee.setText(sprinttask.getAssignee());      
      theTask.setText(sprinttask.getTheTask());
      estTime.setText(sprinttask.getEstTime());
      actTime.setText(sprinttask.getActTime());
      backlogRef.setText(sprinttask.getBacklogRef());
      status.setPromptText(sprinttask.getStatus());
    }
  }
    
    public void updateSprintTaskDetails(SprintTask sprinttask) {
      if (sprinttask != null) {
        sprinttask.setAssignee(assignee.getText());
        sprinttask.setTheTask(theTask.getText());
        sprinttask.setEstTime(estTime.getText());
        sprinttask.setActTime(actTime.getText());
        sprinttask.setBacklogRef(backlogRef.getText());
        sprinttask.setStatus(status.getPromptText());
      }
    }
    private void clearSprintTaskDetails() {
      id.setText("");
      assignee.setText(""); 
      theTask.setText("");  
      backlogRef.setText("");
      status.setPromptText("");
    }
}
