package softwaremanagementtool.agile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BacklogList {

  private ObservableList<BacklogEntry> backlogList = FXCollections.observableArrayList();
  

  public ObservableList<BacklogEntry> get() {
    return backlogList;
  }
  
  public void clear() {
  	backlogList.clear();
  }
  
  
  public void add(BacklogEntry entry) {
  	backlogList.add(entry);
  }
  
  public void remove(BacklogEntry entry) {
  	for (int i = 0; i < backlogList.size(); i++) {
  		if (entry.getID() == backlogList.get(i).getID()) {
  			backlogList.remove(i);
  		}
  	}
  }
  
}
