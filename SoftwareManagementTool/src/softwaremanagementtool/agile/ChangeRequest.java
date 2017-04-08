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
  
	public static final String REASON_ISSUE = "Issue";
	public static final String REASON_REFACT = "Refactor";
	public static final String REASON_ENHANCE = "Enhancement";
	public static final String[] REASON = {
			REASON_ISSUE, REASON_REFACT, REASON_ENHANCE
	};
	
  private final StringProperty changeReq;
  private final StringProperty reason;
  private final ObjectProperty<LocalDate> dateCreated;
  private  Integer openInSprintId;
   
  /**
   *  History - Initials, Date, Description
   * 
   */
  public ChangeRequest() {
    //setting default data to some attributes
    this.changeReq= new SimpleStringProperty("");
    this.reason = new SimpleStringProperty("");
    this.dateCreated = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    openInSprintId = 0;
  }
  
  public String getType() {
    return type;
  }
  
  public String getChangeRequest() {
    return changeReq.get();
  }
  
  public void setChangeRequest(String inChangeRequest) {
    this.changeReq.set(inChangeRequest);
  }
  
  public StringProperty changeReqProperty() {
    return changeReq;
  }

  //Acceptance criteria setter and getter method
  public String getReason() {
    return reason.get();
  }
  
  public void setReason(String inReason) {
    this.reason.set(inReason);
  }
    
  public StringProperty justificationProperty() {
    return reason;
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
