package softwaremanagementtool.agile;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChangeRequest extends BacklogEntry {
   
  public static final String[] STATE = {"Draft","Open","Closed","Deleted"};
  
  private final StringProperty ChangeReq;
  private final StringProperty Justification;
  private final ObjectProperty<LocalDate> dateCreated;
  private final StringProperty state;
   
  /**
   *  History - Initials, Date, Description
   * 
   */
  public ChangeRequest() {
    //setting default data to some attributes
    this.ChangeReq= new SimpleStringProperty("Change Request Description");
    this.Justification = new SimpleStringProperty("some acceptance test");
    this.dateCreated = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    this.state = new SimpleStringProperty(STATE[0]);
  }
  
  public String getType() {
    return "ChangeRequest";
  }
  
  public String getChangeRequest() {
    return ChangeReq.get();
  }
  
  public void setChangeRequest(String inChangeRequest) {
    this.ChangeReq.set(inChangeRequest);
  }
  
  public StringProperty userStoryProperty() {
    return ChangeReq;
  }

  //Acceptance criteria setter and getter method
  public String getJustification() {
    return Justification.get();
  }
  
  public void setJustification(String inAcceptanceCriteria) {
    this.Justification.set(inAcceptanceCriteria);
  }
    
  public StringProperty acceptanceCriteriaProperty() {
    return Justification;
  }

  //date setter and getter method
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
