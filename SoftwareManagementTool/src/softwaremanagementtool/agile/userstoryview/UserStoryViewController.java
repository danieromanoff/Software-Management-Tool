/**
 * 
 */
package softwaremanagementtool.agile.userstoryview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.UserStory;

/**
 * @author Stephen
 *
 */
public class UserStoryViewController {


	//setting table field
    @FXML
    private TextField iDText;
    @FXML
    private TextField titleText;
    @FXML
    private TextArea userStoryText;
    @FXML
    private TextField acceptanceCriteriaText;
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

  
  public UserStoryViewController() {
  }

    
  @FXML
  private void initialize() {
    // Clear user story details.
  	clearUserStoryDetails();    
  	for (Integer prior : BacklogEntry.PRIORITIES) {
  		priority.getItems().add(prior);
  	}
  	for (Integer points : BacklogEntry.STORY_POINTS) {
  		storyPoints.getItems().add(points);
  	}
  	for (String usState : UserStory.STATE) {
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

  public void showUserStoryDetails(UserStory userstory) {
    if (userstory != null) {
      iDText.setText(Integer.toString(userstory.getID()));
      titleText.setText(userstory.getTitle());      
      userStoryText.setText(userstory.getUserStory());
      priority.setValue(userstory.getPriority());
      state.setValue(userstory.getState());
      acceptanceCriteriaText.setText(userstory.getAcceptanceCriteria());
      date.setValue(userstory.getDateCreated());
      storyPoints.setValue(userstory.getStoryPoints());
    } 
  }
  
  public void updateUserStoryDetails(UserStory userstory) {
    if (userstory != null) {
    	userstory.setTitle(titleText.getText());
    	userstory.setUserStory(userStoryText.getText());
    	userstory.setPriority(priority.getValue());
    	userstory.setAcceptanceCriteria(acceptanceCriteriaText.getText());
    	userstory.setDateCreated(date.getValue());
    	userstory.setState(state.getValue());
    	userstory.setStoryPoints(storyPoints.getValue());
    }
  }
  
  private void clearUserStoryDetails() {
    iDText.setText("");
    titleText.setText(""); 
    userStoryText.setText("");  
    acceptanceCriteriaText.setText("");
    date.setPromptText("");
  }  
}

