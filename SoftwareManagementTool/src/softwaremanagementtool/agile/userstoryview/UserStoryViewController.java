/**
 * 
 */
package softwaremanagementtool.agile.userstoryview;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.DateUtil;
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
    private TextField userStoryText;
    @FXML
    private TextField priorityText;
    @FXML
    private TextField acceptanceCriteriaText;
    @FXML
    private TextField dateText;

    // Reference to the main application.
  private AgileProject agilePrj;

  
  public UserStoryViewController() {
  }

    
  @FXML
  private void initialize() {
    // Clear user story details.
    showUserStoryDetails(null);    
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
            
      userStoryText.setText(userstory.getAs_a_user_i_want());
      priorityText.setText(Integer.toString(userstory.getpriority()));
      acceptanceCriteriaText.setText(userstory.getAcceptance_Criteria());
      dateText.setText(DateUtil.format(userstory.getcalanderday()));
    } 
    else 
    {
    	iDText.setText("");
      titleText.setText("");
          //  
      userStoryText.setText("");
      priorityText.setText("");
      acceptanceCriteriaText.setText("");
      dateText.setText("");
    }
  }  
}

