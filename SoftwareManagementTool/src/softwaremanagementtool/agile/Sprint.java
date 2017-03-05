package softwaremanagementtool.agile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sprint {

	private final IntegerProperty id;
	
	public Sprint() {
  	
  	this.id = new SimpleIntegerProperty(0);

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
}
