package softwaremanagementtool.agile;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserStory {
	private final IntegerProperty ID;
    private final StringProperty Title;
    private final StringProperty Owner;
    private final StringProperty As_a_user_i_want;
    private final IntegerProperty priority;
    private final StringProperty Acceptance_Criteria;
    private final ObjectProperty<LocalDate> calanderday;

    // default constructor to match the user story method from MainApp method 
    public UserStory() {
        this(0,null, null);
    }
    
    public UserStory(int ID,String Title, String Owner) {
    	//ID, title and owner data will be displayed in the user story view
    	this.ID = new SimpleIntegerProperty(ID);
        this.Title = new SimpleStringProperty(Title);
        this.Owner = new SimpleStringProperty(Owner);
        //setting default data to some attributes
        this.As_a_user_i_want= new SimpleStringProperty("user requirment");
        this.priority = new SimpleIntegerProperty(5);
        this.Acceptance_Criteria = new SimpleStringProperty("some acceptance test");
        this.calanderday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2017, 2, 21));
    }

    //Id setter and getter methods 
    public int getID() {
        return ID.get();
    }
    public void setID(int ID) {
        this.ID.set(ID);
    }
    public IntegerProperty IDProperty() {
        return ID;
    }

    //title setter and getter method
    public String getTitle() {
        return Title.get();
    }
    public void setTitle(String Title) {
        this.Title.set(Title);
    }
    public StringProperty TitleProperty() {
        return Title;
    }

    //Owner setter and getter method
    public String getOwner() {
        return Owner.get();
    }
    public void setOwner(String Owner) {
        this.Owner.set(Owner);
    }
    public StringProperty OwnerProperty() {
        return Owner;
    }

    //As_a_user_i_want setter and getter method
    public String getAs_a_user_i_want() {
        return As_a_user_i_want.get();
    }
    public void setAs_a_user_i_want(String As_a_user_i_want) {
        this.As_a_user_i_want.set(As_a_user_i_want);
    }
    public StringProperty As_a_user_i_wantProperty() {
        return As_a_user_i_want;
    }

    //priority setter and getter method
    public int getpriority() {
        return priority.get();
    }
    public void setpriority(int priority) {
        this.priority.set(priority);
    }
    public IntegerProperty priorityProperty() {
        return priority;
    }

    //Acceptance criteria setter and getter method
    public String getAcceptance_Criteria() {
        return Acceptance_Criteria.get();
    }
    public void setAcceptance_Criteria(String Acceptance_Criteria) {
        this.Acceptance_Criteria.set(Acceptance_Criteria);
    }
    public StringProperty Acceptance_CriteriaProperty() {
        return Acceptance_Criteria;
    }

    //date setter and getter method
    public LocalDate getcalanderday() {
        return calanderday.get();
    }
    public void setcalanderday(LocalDate calanderday) {
        this.calanderday.set(calanderday);
    }
    public ObjectProperty<LocalDate> calanderdayProperty() {
        return calanderday;
    }
}