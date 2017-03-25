package softwaremanagementtool.agile;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import softwaremanagementtool.agile.db.LocalDateAdapter;

public class ChangeRequest extends BacklogEntry {
   
	public static final String type = "ChangeRequest";
  
  private final StringProperty ChangeReq;
  private final StringProperty Justification;
  private final ObjectProperty<LocalDate> dateCreated;
  private  Integer openInSprintId;
   
  /**
   *  History - Initials, Date, Description
   * 
   */
  public ChangeRequest() {
    //setting default data to some attributes
    this.ChangeReq= new SimpleStringProperty("Change Request Description");
    this.Justification = new SimpleStringProperty(" ");
    this.dateCreated = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    openInSprintId = 0;
  }
  
  public String getType() {
    return type;
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

  public Integer getOpenInSprintId() {
    return openInSprintId;
  }
  
  public void setOpenInSprintId(Integer id) {
    this.openInSprintId = id;
  }
  
}
