package softwaremanagementtool.agile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SprintList {
  
  // List of Sprints
  private ObservableList<Sprint> sprintList = FXCollections.observableArrayList();

  public ObservableList<Sprint> get() {
    return sprintList;
  }
  
  public Sprint Sprint(int indx) {
    return sprintList.get(indx);
  }
  
  
  public Integer nextId() {
  
    Integer biggest = 0;
    for (int i=0; i < sprintList.size(); i++)
    {
      if (sprintList.get(i).getID() > biggest ) {
        biggest = sprintList.get(i).getID();
      }
    }
    return biggest + 1;
  }
  
  public void add(Sprint sprint) {
    sprintList.add(sprint);
  }
  
  public Boolean isSprintInProgress() {
  	for (int i=0; i < sprintList.size(); i++)
    {
      if (sprintList.get(i).getState().equals(Sprint.STATE_PROGRESS)) {
      	return true;
      }
    }
    return false;
  }
  
  public int size() {
  	return sprintList.size();
  }
}