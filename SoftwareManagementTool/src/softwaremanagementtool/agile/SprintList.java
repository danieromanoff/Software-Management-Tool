package softwaremanagementtool.agile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SprintList {
	
	// List of Sprints
  private ObservableList<Sprint> sprintList = FXCollections.observableArrayList();

  public ObservableList<Sprint> sprintList() {
  	return sprintList;
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
}
