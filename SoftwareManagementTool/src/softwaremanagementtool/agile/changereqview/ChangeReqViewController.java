package softwaremanagementtool.agile.changereqview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.UserStory;



/**
 * @author Stephen
 *
 */
public class ChangeReqViewController {

//setting table field
  @FXML
  private TextField iDText;
  @FXML
  private TextField titleText;
  @FXML
  private TextArea ChangeReqText;
  @FXML
  private ComboBox<String> reason;
  @FXML
  private DatePicker date;
  @FXML
  private ComboBox<Integer> priority;
  @FXML
  private ComboBox<Integer> storyPoints;
  @FXML
  private ComboBox<String> state;
  @FXML
  private TextField sprintIdText;

  // Reference to the main application.
  private AgileProject agilePrj;
  private AnchorPane thisPane;

  public ChangeReqViewController() {
  }

  @FXML
  private void initialize() {
    // Clear change request details.
    clearChangeRequestDetails();    
    for (Integer prior : BacklogEntry.PRIORITIES) {
      priority.getItems().add(prior);
    }
    for (Integer points : BacklogEntry.STORY_POINTS) {
      storyPoints.getItems().add(points);
    }
    for (String usState : ChangeRequest.STATE) {
      state.getItems().add(usState);
    }
    for (String reasons : ChangeRequest.REASON) {
      reason.getItems().add(reasons);
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

  private void setEditable(boolean edit) {
  	titleText.setEditable(edit);
  	ChangeReqText.setEditable(edit);
  	sprintIdText.setEditable(edit);
  	priority.setDisable(!edit);
  	date.setDisable(!edit);
  	storyPoints.setDisable(!edit);
  	reason.setDisable(!edit);
  }
  
  public void showChangeRequestDetails(ChangeRequest changereq) {
    if (changereq != null) {
      iDText.setText(Integer.toString(changereq.getID()));
      titleText.setText(changereq.getTitle());      
      ChangeReqText.setText(changereq.getChangeRequest());
      priority.setValue(changereq.getPriority());
      state.setValue(changereq.getState());
      reason.setValue(changereq.getReason());
      date.setValue(changereq.getDateCreated());
      storyPoints.setValue(changereq.getStoryPoints());
      sprintIdText.setText(Integer.toString(changereq.getOpenInSprintId()));
      
      setEditable(!(changereq.getState().equals(UserStory.STATE_CLOSED) || 
      		changereq.getState().equals(UserStory.STATE_ASSIGNED) )); 
    } 
  }

  public void updateChangeRequestDetails(ChangeRequest changereq) {
    if (changereq != null) {
      changereq.setTitle(titleText.getText());
      changereq.setChangeRequest(ChangeReqText.getText());
      changereq.setPriority(priority.getValue());
      changereq.setReason(reason.getValue());
      changereq.setDateCreated(date.getValue());
      changereq.setState(state.getValue());
      changereq.setStoryPoints(storyPoints.getValue());
      changereq.setOpenInSprintId(Integer.parseInt(sprintIdText.getText()));
    }
  }

  private void clearChangeRequestDetails() {
    iDText.setText("");
    titleText.setText(""); 
    ChangeReqText.setText("");  
    date.setPromptText("");
  }  
  
  public boolean anyChanges(ChangeRequest changeRequest) {
  	boolean changed = true;
  	if ((changeRequest.getTitle().equals(titleText.getText())) &&
    	 (changeRequest.getChangeRequest().equals(ChangeReqText.getText())) &&
    	 (changeRequest.getPriority() == (priority.getValue())) &&
    	 (changeRequest.getReason().equals(reason.getValue())) &&
    	 (changeRequest.getDateCreated().equals(date.getValue())) &&
    	 (changeRequest.getState().equals(state.getValue())) &&
    	 (changeRequest.getStoryPoints() == storyPoints.getValue()) &&
    	 (changeRequest.getOpenInSprintId().equals(sprintIdText.getText()))) {
  		changed = false;
  	}
  	return changed;
  }
}

