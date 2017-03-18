package softwaremanagementtool.agile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class SprintTask {
  
  public static final String[] STATUS = {"Draft","InProgress","Complete","Deleted"};
  
  private final IntegerProperty id;
  private final IntegerProperty sprintRef;
  private final StringProperty assignee;
  private final StringProperty theTask;
  private final IntegerProperty estTime;
  private final IntegerProperty actTime;
  private final IntegerProperty backlogRef;
  private final StringProperty status;

  public SprintTask() {
  	this.id = new SimpleIntegerProperty(0);
  	this.sprintRef = new SimpleIntegerProperty(0);
  	this.status = new SimpleStringProperty("");
    this.assignee = new SimpleStringProperty("");
    this.theTask = new SimpleStringProperty("");
    this.estTime = new SimpleIntegerProperty(0);
    this.actTime = new SimpleIntegerProperty(0);
    this.backlogRef = new SimpleIntegerProperty(0);

  } 
  
  public int getId() {
    return id.get();
  }
  public void setId(int ID) {
    this.id.set(ID);
  }
  public IntegerProperty IDProperty() {
    return id;
  }
  
  public int getSprintId() {
    return sprintRef.get();
  }
  public void setSprintId(int sprintID) {
    this.sprintRef.set(sprintID);
  }
  public IntegerProperty sprintIdProperty() {
    return sprintRef;
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
  public void setEstTime(int etime) {
    this.estTime.set(etime);
  }
  public IntegerProperty EstTimeProperty() {
    return estTime;
  }
  
  public int getActTime() {
    return actTime.get();
  }
  public void setActTime(int atime) {
    this.actTime.set(atime);
  }
  public IntegerProperty ActTimeProperty() {
    return actTime;
  }
  
  public int getBacklogRef() {
    return backlogRef.get();
  }
  public void setBacklogRef(int backlog) {
    this.backlogRef.set(backlog);
  }
  public IntegerProperty BacklogRefProperty() {
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