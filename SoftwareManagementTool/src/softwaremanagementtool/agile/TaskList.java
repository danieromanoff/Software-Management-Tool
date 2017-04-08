package softwaremanagementtool.agile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskList {
	 // List of Sprints
  private ObservableList<SprintTask> taskList = FXCollections.observableArrayList();

  public ObservableList<SprintTask> get() {
    return taskList;
  }
  
  public Integer nextId() {
  
    Integer biggest = 0;
    for (int i=0; i < taskList.size(); i++)
    {
      if (taskList.get(i).getId() > biggest ) {
        biggest = taskList.get(i).getId();
      }
    }
    return biggest + 1;
  }
  
  public void add(SprintTask task) {
  	taskList.add(task);
  }
  
  public void clear() {
  	taskList.clear();
  }
  
  public boolean allTasksComplete(int sprint) {
  	boolean done = true;
  	for (int i=0; i < taskList.size(); i++)
  	{
  		if ((taskList.get(i).getSprintId() == sprint) &&
  				(!taskList.get(i).getStatus().equals(SprintTask.STATUS_COMPLETE)) &&
  				(!taskList.get(i).getStatus().equals(SprintTask.STATUS_INCOMPLETE))) {
  			done = false;
  		}
  	}
  	return done;
  }
  
}
