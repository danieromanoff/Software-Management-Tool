package softwaremanagementtool.agile;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import softwaremanagementtool.agile.db.LocalDateAdapter;

public class UserStory extends BacklogEntry {
   
	public static final String type = "UserStory";
	public static final String[] STATE = {"Draft","Deferred","Open","Closed","Deleted"};
	
  private final StringProperty userStory;
  private final StringProperty acceptanceCriteria;
  private final ObjectProperty<LocalDate> dateCreated;
  private final StringProperty state;
   
  /**
   *  History - Initials, Date, Description
   * 
   */
  public UserStory() {
    //setting default data to some attributes
    this.userStory= new SimpleStringProperty("");
    this.acceptanceCriteria = new SimpleStringProperty("");
    this.dateCreated = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    this.state = new SimpleStringProperty(STATE[0]);
  }
  
  public String getType() {
  	return type;
  }
  
  public String getUserStory() {
    return userStory.get();
  }
  
  public void setUserStory(String inUserStory) {
    this.userStory.set(inUserStory);
  }
  
  public StringProperty userStoryProperty() {
    return userStory;
  }

  //Acceptance criteria setter and getter method
  public String getAcceptanceCriteria() {
    return acceptanceCriteria.get();
  }
  
  public void setAcceptanceCriteria(String inAcceptanceCriteria) {
    this.acceptanceCriteria.set(inAcceptanceCriteria);
  }
    
  public StringProperty acceptanceCriteriaProperty() {
    return acceptanceCriteria;
  }

  //date setter and getter method
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  public LocalDate getDateCreated() {
    return dateCreated.get();
  }
  
  public void setDateCreated(LocalDate inDateCreated) {
    this.dateCreated.set(inDateCreated);
  }
    
  public ObjectProperty<LocalDate> dateCreatedProperty() {
    return dateCreated;
  }
  
  public String getState() {
    return state.get();
  }
  
  public void setState(String inState) {
    this.state.set(inState);
  }
  
  public StringProperty stateProperty() {
    return state;
  }
}