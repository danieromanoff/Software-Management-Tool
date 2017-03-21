package softwaremanagementtool.agile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductBacklog {

  //user story data as an observable list of user stories.
  private ObservableList<BacklogEntry> productBacklog = FXCollections.observableArrayList();

  public ObservableList<BacklogEntry> get() {
  	return productBacklog;
  }
  
  public Integer nextId() {
  
  	Integer biggest = 0;
  	for (int i=0; i < productBacklog.size(); i++)
  	{
  		if (productBacklog.get(i).getID() > biggest ) {
  			biggest = productBacklog.get(i).getID();
  		}
  	}
  	return biggest + 1;
  }
  
  public BacklogStats getStats() {
  	BacklogStats stats = new BacklogStats();
  	
  	for (int st = 0; st < BacklogEntry.STATE.length; st++ ) {
  	 	for (int bl = 0; bl < productBacklog.size(); bl++) {
			  if (productBacklog.get(bl).getState().equals(BacklogEntry.STATE[st])) {
			  	
			  }
			}
		}
  	
  	// TODO gather
  	return stats;
  }
}
