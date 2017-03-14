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
  private TextField JustificationText;
  @FXML
  private DatePicker date;
  @FXML
  private ComboBox<Integer> priority;
  @FXML
  private ComboBox<Integer> storyPoints;
  @FXML
  private ComboBox<String> state;

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

  public void showChangeRequestDetails(ChangeRequest changereq) {
    if (changereq != null) {
      iDText.setText(Integer.toString(changereq.getID()));
      titleText.setText(changereq.getTitle());      
      ChangeReqText.setText(changereq.getChangeRequest());
      priority.setValue(changereq.getPriority());
      state.setValue(changereq.getState());
      JustificationText.setText(changereq.getJustification());
      date.setValue(changereq.getDateCreated());
      storyPoints.setValue(changereq.getStoryPoints());
    } 
  }

  public void updateChangeRequestDetails(ChangeRequest changereq) {
    if (changereq != null) {
      changereq.setTitle(titleText.getText());
      changereq.setChangeRequest(ChangeReqText.getText());
      changereq.setPriority(priority.getValue());
      changereq.setJustification(JustificationText.getText());
      changereq.setDateCreated(date.getValue());
      changereq.setState(state.getValue());
      changereq.setStoryPoints(storyPoints.getValue());
    }
  }

  private void clearChangeRequestDetails() {
    iDText.setText("");
    titleText.setText(""); 
    ChangeReqText.setText("");  
    JustificationText.setText("");
    date.setPromptText("");
  }  
  
  public boolean anyChanges(ChangeRequest changeRequest) {
  	boolean changed = true;
  	if ((changeRequest.getTitle().equals(titleText.getText())) &&
    	 (changeRequest.getChangeRequest().equals(ChangeReqText.getText())) &&
    	 (changeRequest.getPriority() == (priority.getValue())) &&
    	 (changeRequest.getJustification().equals(JustificationText.getText())) &&
    	 (changeRequest.getDateCreated().equals(date.getValue())) &&
    	 (changeRequest.getState() == state.getValue()) &&
    	 (changeRequest.getStoryPoints() == storyPoints.getValue())) {
  		changed = false;
  	}
  	return changed;
  }
}

