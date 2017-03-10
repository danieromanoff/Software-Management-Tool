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
  private final IntegerProperty estTime;
  private final IntegerProperty actTime;
  private final IntegerProperty backlogRef;
  private final StringProperty status;

  
  public SprintTask() {
    
    this.id = new SimpleIntegerProperty(0);
    this.assignee = new SimpleStringProperty("");
    this.theTask = new SimpleStringProperty("");
    this.estTime = new SimpleIntegerProperty(0);
    this.actTime = new SimpleIntegerProperty(0);
    this.backlogRef = new SimpleIntegerProperty(0);
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
  
  public int getEstTime() {
    return estTime.get();
  }
  public void setEstTime(int time) {
    this.estTime.set(time);
  }
  public IntegerProperty estTimeProperty() {
    return estTime;
  }
  
  public int getActTime() {
    return actTime.get();
  }
  public void setActTime(int time) {
    this.actTime.set(time);
  }
  public IntegerProperty actTimeProperty() {
    return actTime;
  }
  
  public int getBacklogRef() {
    return backlogRef.get();
  }
  public void setBacklogRef(int inBacklogRef) {
    this.backlogRef.set(inBacklogRef);
  }
  public IntegerProperty backlogRefProperty() {
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