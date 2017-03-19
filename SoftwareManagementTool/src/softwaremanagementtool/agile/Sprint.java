package softwaremanagementtool.agile;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import softwaremanagementtool.agile.db.LocalDateAdapter;

public class Sprint {

  public static final String[] STATE = {"Draft","InProgress","Closed","Deleted"};
  
  private final IntegerProperty id;
  private final ObjectProperty<LocalDate> startDate;
  private final ObjectProperty<LocalDate> endDate;
  private final StringProperty state;
 // private ObservableList<BacklogEntry> sprintBacklog = FXCollections.observableArrayList();
 // private ObservableList<SprintTask> taskList = FXCollections.observableArrayList();
 // private ObservableList<Integer> issuesOpened = FXCollections.observableArrayList();
  private final IntegerProperty endNumFiles;
  private final IntegerProperty endSloc;
  private final StringProperty reviewNotes;
  private final StringProperty retrospectiveWell;
  private final StringProperty retrospectiveNotSo;
  private final IntegerProperty numTests;
  private final IntegerProperty testsAttempted;
  private final IntegerProperty testsPassed;
  
  public Sprint() {
    
    this.id = new SimpleIntegerProperty(0);
    this.startDate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    this.endDate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
    this.state = new SimpleStringProperty(STATE[0]);
    this.endNumFiles = new SimpleIntegerProperty(0);
    this.endSloc = new SimpleIntegerProperty(0);
    this.reviewNotes = new SimpleStringProperty("");
    this.retrospectiveWell = new SimpleStringProperty("");
    this.retrospectiveNotSo = new SimpleStringProperty("");
    this.numTests = new SimpleIntegerProperty(0);
    this.testsAttempted = new SimpleIntegerProperty(0);
    this.testsPassed = new SimpleIntegerProperty(0);
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
  
  public StringProperty dateToStringPoperty(LocalDate date) {
		return	new SimpleStringProperty(date.toString());
  }
  
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  public LocalDate getStartDate() {
    return startDate.get();
  }
  public void setStartDate(LocalDate inStartDate) {
    this.startDate.set(inStartDate);
  }  
  public ObjectProperty<LocalDate> startDateProperty() {
    return startDate;
  }
  public StringProperty startDateStringProperty() {
  	return dateToStringPoperty(startDate.get());
  }
  
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  public LocalDate getEndDate() {
    return endDate.get();
  }
  public void setEndDate(LocalDate inEndDate) {
    this.endDate.set(inEndDate);
  }
  public ObjectProperty<LocalDate> endDateProperty() {
    return endDate;
  }
  public StringProperty endDateStringProperty() {
  	return dateToStringPoperty(endDate.get());
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
  
  
//  public void addToBacklog(BacklogEntry item) {
  //  sprintBacklog.add(item);
 // }
 // public ObservableList<BacklogEntry> sprintBacklog( ) {
 //   return sprintBacklog;
 // }
  
  //public void addToIssues(ChangeRequest issue) {
    // TODOissuesOpened.add((Integer)issue.getID());
 // }
 // public ObservableList<Integer> issuesOpened( ) {
 //   return issuesOpened;
 // }
  
 // public void addToTaskList(SprintTask task) {
 //   taskList.add(task);
 // }
 // public ObservableList<SprintTask> taskList( ) {
//    return taskList;
 // }
  
  public int getEndNumFiles() {
    return endNumFiles.get();
  }
  public void setEndNumFiles(int numFiles) {
    this.endNumFiles.set(numFiles);
  }
  public IntegerProperty endNumFilesProperty() {
    return endNumFiles;
  }
  
  public int getEndSloc() {
    return endSloc.get();
  }
  public void setEndSloc(int sloc) {
    this.endSloc.set(sloc);
  }
  public IntegerProperty endSlocProperty() {
    return endSloc;
  }
  
  public String getReviewNotes() {
    return reviewNotes.get();
  }
  public void setReviewNotes(String notes) {
    this.reviewNotes.set(notes);
  } 
  public StringProperty reviewNotesProperty() {
    return reviewNotes;
  }
  
  public String getRetrospectiveWell() {
    return retrospectiveWell.get();
  }
  public void setRetrospectiveWell(String notes) {
    this.retrospectiveWell.set(notes);
  } 
  public StringProperty retrospectiveWellProperty() {
    return retrospectiveWell;
  }
  
  public String getRetrospectiveNotSo() {
    return retrospectiveNotSo.get();
  }
  public void setRetrospectiveNotSo(String notes) {
    this.retrospectiveNotSo.set(notes);
  } 
  public StringProperty retrospectiveNotSoProperty() {
    return retrospectiveNotSo;
  }
  
  public int getTestsAttempted() {
    return testsAttempted.get();
  }
  public void setTestsAttempted(int numTests) {
    this.testsAttempted.set(numTests);
  }
  public IntegerProperty testsAttemptedProperty() {
    return testsAttempted;
  }
  
  public int getTestsPassed() {
    return testsPassed.get();
  }
  public void setTestsPassed(int numTests) {
    this.testsPassed.set(numTests);
  }
  public IntegerProperty testsPassedProperty() {
    return testsPassed;
  }
  
  public int getNumTests() {
    return numTests.get();
  }
  public void setNumTests(int numTests) {
    this.numTests.set(numTests);
  }
  public IntegerProperty numTestsProperty() {
    return numTests;
  }
}