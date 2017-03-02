package softwaremanagementtool.agile;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserStory extends BacklogEntry {
   
  private final StringProperty As_a_user_i_want;
  private final IntegerProperty priority;
  private final StringProperty Acceptance_Criteria;
  private final ObjectProperty<LocalDate> calanderday;
   
  /**
   *  History - Initials, Date, Description
   * 
   */
  public UserStory() {
    //setting default data to some attributes
    this.As_a_user_i_want= new SimpleStringProperty("user requirment");
    this.priority = new SimpleIntegerProperty(5);
    this.Acceptance_Criteria = new SimpleStringProperty("some acceptance test");
    this.calanderday = new SimpleObjectProperty<LocalDate>(LocalDate.now());
  }
  
  public String getType() {
  	return "UserStory";
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public String getAs_a_user_i_want() {
    return As_a_user_i_want.get();
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public void setAs_a_user_i_want(String As_a_user_i_want) {
    this.As_a_user_i_want.set(As_a_user_i_want);
  }
  
  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public StringProperty As_a_user_i_wantProperty() {
    return As_a_user_i_want;
  }

  /**
   *  History - Initials, Date, Description
   *  
   *
   */
  public int getpriority() {
    return priority.get();
  }
  
  public void setpriority(int priority) {
    this.priority.set(priority);
  }
  
  public IntegerProperty priorityProperty() {
    return priority;
  }

  //Acceptance criteria setter and getter method
  public String getAcceptance_Criteria() {
    return Acceptance_Criteria.get();
  }
  
  public void setAcceptance_Criteria(String Acceptance_Criteria) {
    this.Acceptance_Criteria.set(Acceptance_Criteria);
  }
    
  public StringProperty Acceptance_CriteriaProperty() {
    return Acceptance_Criteria;
  }

  //date setter and getter method
  public LocalDate getcalanderday() {
    return calanderday.get();
  }
  
  public void setcalanderday(LocalDate calanderday) {
    this.calanderday.set(calanderday);
  }
    
  public ObjectProperty<LocalDate> calanderdayProperty() {
    return calanderday;
  }
}