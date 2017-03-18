package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintTask;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.ui.SaveAlert;

public class SprintTaskViewController {

//setting table field
  @FXML
  private TextField id;
  @FXML
  private TextField assignee;
  @FXML
  private TextArea theTask;
  @FXML
  private TextField estTime;
  @FXML
  private TextField actTime;
  @FXML
  private TextField backlogRef;
  @FXML
  private ComboBox<String> status;

  @FXML
	private TableView<SprintTask> taskTable;
	@FXML
	private TableColumn<SprintTask, Integer> IDColumn;
	@FXML
	private TableColumn<SprintTask, String> TaskColumn;
  
  // Reference to the main application.
  private AgileProject agilePrj;
  private AnchorPane thisPane;

  public SprintTaskViewController() {
  }
  
  @FXML
  private void initialize() {
    // Clear user story details.
    clearSprintTaskDetails();    
    for (String usStatus : SprintTask.STATUS) {
      status.getItems().add(usStatus);
    }
    
    IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    TaskColumn.setCellValueFactory(cellData -> cellData.getValue().theTaskProperty());
       
    // Listen for selection changes and show the user story details when changed.
    taskTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> newSelection(oldValue, newValue));
    
  }
  
  private void newSelection(SprintTask oldEntry, SprintTask newEntry) {
		if (oldEntry != null) {
			if (anyChanges(oldEntry) && SaveAlert.save()) {
				updateSprintTaskDetails(oldEntry);
			}
		}
		showSprintTaskDetails(newEntry);
	}
  
  
  
  @FXML
  private void goNewTask() {
  	agilePrj.newTask();
  }
  
  @FXML
  private void goSaveTask() {
  	updateSprintTaskDetails(getSelectedItem());
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
  }
  
  public void setPane(AnchorPane inPane) {
    this.thisPane = inPane;
  }
  
  public void setVisable(boolean visable) {
    thisPane.setVisible(visable);
  }
  
  public void showSprintTaskDetails(SprintTask sprinttask) {
    if (sprinttask != null) {
      id.setText(Integer.toString(sprinttask.getId()));
      assignee.setText(sprinttask.getAssignee());      
      theTask.setText(sprinttask.getTheTask());
      estTime.setText(Integer.toString(sprinttask.getEstTime()));
      actTime.setText(Integer.toString(sprinttask.getActTime()));
      backlogRef.setText(Integer.toString(sprinttask.getBacklogRef()));
      status.setValue(sprinttask.getStatus());
      
    }
  }
    
    public void updateSprintTaskDetails(SprintTask sprinttask) {
      if (sprinttask != null) {
        sprinttask.setAssignee(assignee.getText());
        sprinttask.setTheTask(theTask.getText());
        sprinttask.setEstTime(Integer.parseInt(estTime.getText()));
        sprinttask.setActTime(Integer.parseInt(actTime.getText()));
        sprinttask.setBacklogRef(Integer.parseInt(backlogRef.getText()));
        sprinttask.setStatus(status.getValue());
      }
    }
    
    private void clearSprintTaskDetails() {
      id.setText("");
      assignee.setText(""); 
      theTask.setText("");  
      backlogRef.setText("");
      status.setPromptText("");
    }
    
    public boolean anyChanges(SprintTask task) {
    	boolean changed = true;
    	if ((task.getAssignee().equals(assignee.getText())) &&
      	 (task.getTheTask().equals(theTask.getText())) &&
      	 (task.getEstTime() == Integer.parseInt(estTime.getText())) &&
      	 (task.getActTime() == Integer.parseInt(actTime.getText())) &&
      	 (task.getBacklogRef() == Integer.parseInt(backlogRef.getText())) &&
      	 (task.getStatus() == status.getValue())) {
    		changed = false;
    	}
    	return changed;
    }

    public void setLast () {
    	taskTable.getSelectionModel().selectLast(); 
    }
    
    public SprintTask getSelectedItem() {
      return taskTable.getSelectionModel().getSelectedItem();
    }

    public void showSprint(Sprint sprint) {
    	taskTable.setItems(agilePrj.getTaskList(sprint));
    	clearSprintTaskDetails();
    	taskTable.getSelectionModel().selectFirst(); 
  	}
  	
    public void updateTask() {
    	updateSprintTaskDetails(getSelectedItem());
  	}
    
  	public void saveSprint(Sprint sprint) {
  		// TODO
  	}
}
