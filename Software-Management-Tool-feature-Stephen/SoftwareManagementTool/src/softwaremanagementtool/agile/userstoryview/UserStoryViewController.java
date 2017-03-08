/**
 * 
 */
package softwaremanagementtool.agile.userstoryview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import softwaremanagementtool.agile.AgileProject;
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

    // Reference to the main application.
  private AgileProject agilePrj;

  
  public UserStoryViewController() {
  }

    
  @FXML
  private void initialize() {
    // Clear user story details.
  	clearUserStoryDetails();    
  	priority.getItems().addAll(1,2,3,4,5); //TODO
  }

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void showUserStoryDetails(UserStory userstory) {
    if (userstory != null) {
      iDText.setText(Integer.toString(userstory.getID()));
      titleText.setText(userstory.getTitle());      
      userStoryText.setText(userstory.getUserStory());
      priority.setValue(userstory.getPriority());
      acceptanceCriteriaText.setText(userstory.getAcceptanceCriteria());
      date.setValue(userstory.getDateCreated());
    } 
  }
  
  public void updateUserStoryDetails(UserStory userstory) {
    if (userstory != null) {
    	userstory.setTitle(titleText.getText());
    	userstory.setUserStory(userStoryText.getText());
    	userstory.setPriority(priority.getValue());
    	userstory.setAcceptanceCriteria(acceptanceCriteriaText.getText());
    	userstory.setDateCreated(date.getValue());
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

