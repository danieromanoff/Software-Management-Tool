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
      if (taskList.get(i).getID() > biggest ) {
        biggest = taskList.get(i).getID();
      }
    }
    return biggest + 1;
  }
  
  public void add(SprintTask task) {
  	taskList.add(task);
  }
}
