package softwaremanagementtool.agile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BacklogEntry {

	public static final int[] PRIORITIES = {1,2,3,4,5};
	public static final int[] STORY_POINTS = {1,2,3,5,8,13,20,40,100};
	
	private final IntegerProperty id;
	private final StringProperty title;
	private final IntegerProperty priority;
	private final IntegerProperty storyPoints;
	
	public BacklogEntry() {
  	//ID, title and owner data will be displayed in the user story view
  	this.id = new SimpleIntegerProperty(0);
    this.title = new SimpleStringProperty("New");
    this.priority = new SimpleIntegerProperty(5);
    this.storyPoints = new SimpleIntegerProperty(STORY_POINTS[0]);
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
	
	 //title setter and getter method
  public String getTitle() {
    return title.get();
  }
  public void setTitle(String Title) {
    this.title.set(Title);
  }
  public StringProperty titleProperty() {
    return title;
  }
  
  public int getPriority() {
    return priority.get();
  }
  
  public void setPriority(int priority) {
    this.priority.set(priority);
  }
  
  public IntegerProperty priorityProperty() {
    return priority;
  }
  
  public int getStoryPoints() {
    return storyPoints.get();
  }
  
  public void setStoryPoints(int inStoryPoints) {
    this.storyPoints.set(inStoryPoints);
  }
  
  public IntegerProperty storyPointsProperty() {
    return storyPoints;
  }
  
  public String getType() {
  	return "None";
  }
}
