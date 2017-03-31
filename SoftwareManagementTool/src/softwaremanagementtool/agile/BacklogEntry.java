package softwaremanagementtool.agile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BacklogEntry {

	public static final int[] PRIORITIES = {1,2,3,4,5};
	public static final int[] STORY_POINTS = {1,2,3,5,8,13,20,40,100};
	public static final String STATE_DRAFT = "Draft";
	public static final String STATE_DEFERRED = "Deferred";
	public static final String STATE_OPEN = "Open";
	public static final String STATE_ASSIGNED ="Assigned";
	public static final String STATE_CLOSED ="Closed";
	public static final String STATE_DELETED ="Deleted";
	public static final String[] STATE = {
			BacklogEntry.STATE_DRAFT,
			BacklogEntry.STATE_DEFERRED,
			BacklogEntry.STATE_OPEN,
			BacklogEntry.STATE_ASSIGNED,
			BacklogEntry.STATE_CLOSED,
			BacklogEntry.STATE_DELETED};
	
	private final IntegerProperty id;
	private final StringProperty title;
	private final IntegerProperty priority;
	private final IntegerProperty storyPoints;
	private final IntegerProperty sprintId;
  private final StringProperty state;
	
	public BacklogEntry() {
  	//ID, title and owner data will be displayed in the user story view
  	this.id = new SimpleIntegerProperty(0);
    this.title = new SimpleStringProperty("New");
    this.priority = new SimpleIntegerProperty(5);
    this.storyPoints = new SimpleIntegerProperty(STORY_POINTS[0]);
    this.sprintId = new SimpleIntegerProperty(0);
    this.state = new SimpleStringProperty(STATE_DRAFT);
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
	
	public int getSprintId() {
    return sprintId.get();
  }
  public void setSprintId(int sprintId) {
    this.sprintId.set(sprintId);
  }
	public IntegerProperty sprintIdProperty() {
    return sprintId;
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
  
  public String getState() {
    return state.get();
  }
  
  public void setState(String inState) {
    this.state.set(inState);
  }
  
  public StringProperty stateProperty() {
    return state;
  }
  
}
