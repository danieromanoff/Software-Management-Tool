package softwaremanagementtool.agile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class SprintTask {
  
  public static final String[] STATUS = {"Draft","InProgress","Complete","Deleted"};
  
  private final IntegerProperty id;
  private final StringProperty assignee;
  private final StringProperty theTask;
  private final StringProperty estTime;
  private final StringProperty actTime;
  private final StringProperty backlogRef;
  private final StringProperty status;

  
  public SprintTask() {
    
    this.id = new SimpleIntegerProperty(0);
    this.assignee = new SimpleStringProperty("");
    this.theTask = new SimpleStringProperty("");
    this.estTime = new SimpleStringProperty("");
    this.actTime = new SimpleStringProperty("");
    this.backlogRef = new SimpleStringProperty("");
    this.status = new SimpleStringProperty("");
  }
  
  public int getID() {
    return id.get();
  }
  public void setID(int ID) {
    this.id.set(ID);
  }
  public IntegerProperty IDProperty() {
    return id;
  }
  
  public String getAssignee() {
    return assignee.get();
  }
  public void setAssignee(String inAssignee) {
    this.assignee.set(inAssignee);
  }
  public StringProperty assigneeProperty() {
    return assignee;
  }
  
  public String getTheTask() {
    return theTask.get();
  }
  public void setTheTask(String inTheTask) {
    this.theTask.set(inTheTask);
  }
  public StringProperty theTaskProperty() {
    return theTask;
  }
  
  public String getEstTime() {
    return estTime.get();
  }
  public void setEstTime(String etime) {
    this.estTime.set(etime);
  }
  public StringProperty EstTimeProperty() {
    return estTime;
  }
  
  public String getActTime() {
    return actTime.get();
  }
  public void setActTime(String atime) {
    this.actTime.set(atime);
  }
  public StringProperty ActTimeProperty() {
    return actTime;
  }
  
  public String getBacklogRef() {
    return backlogRef.get();
  }
  public void setBacklogRef(String backlog) {
    this.backlogRef.set(backlog);
  }
  public StringProperty BacklogRefProperty() {
    return backlogRef;
  }
  
  public String getStatus() {
    return status.get();
  }
  public void setStatus(String inStatus) {
    this.status.set(inStatus);
  }
  public StringProperty statusProperty() {
    return status;
  }


}