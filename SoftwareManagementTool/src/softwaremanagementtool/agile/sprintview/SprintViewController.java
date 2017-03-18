package softwaremanagementtool.agile.sprintview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;


public class SprintViewController {

  private AgileProject agilePrj;
  @FXML
  private TableView<Sprint> sprintTable;
  @FXML
  private TableColumn<Sprint, Integer> idColumn;
  @FXML
  private TableColumn<Sprint, String> stateColumn;
  @FXML
  private TableColumn<Sprint, String> startDateColumn;
  @FXML
  private TableColumn<Sprint, String> endDateColumn;
  @FXML
  private AnchorPane sprintInfoPane;
  @FXML
  private AnchorPane sprintBacklogPane;
  @FXML
  private AnchorPane sprintTaskPane;
  @FXML
  private AnchorPane sprintReviewPane;
  @FXML
  private AnchorPane sprintRetrospectPane;
  
  @FXML
  private void initialize() {
    // Initialize the person table with the two columns.
    idColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
    startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateStringProperty());
    endDateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateStringProperty());
    
    
    // Listen for selection changes and show the user story details when changed.
    sprintTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSprintDetails(newValue));
    
  }
  
  private void showSprintDetails(Sprint sprint) {
    agilePrj.showSprintDetails(sprint);
  }
  
  public Sprint getSelectedItem() {
  	return sprintTable.getSelectionModel().getSelectedItem();
  }
  
  @FXML
  private void goNewSprint() throws IOException {
     agilePrj.newSprint();
  }
  
  @FXML
  private void goSave() throws IOException {
     agilePrj.saveSprintUpdates();
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
    sprintTable.setItems(agilePrj.getSprintList());
  }
  
  public void setLast () {
  	sprintTable.getSelectionModel().selectLast(); 
  	showSprintDetails(getSelectedItem());
  }
  
  public void setFirst () {
    sprintTable.getSelectionModel().selectFirst();
  }
  
	public AnchorPane getSprintInfoPane() {
		return sprintInfoPane;
	}
	public AnchorPane getSprintBacklogPane() {
		return sprintBacklogPane;
	}
	public AnchorPane getSprintTaskPane() {
		return sprintTaskPane;
	}
	public AnchorPane getSprintReviewPane() {
		return sprintReviewPane;
	}
	public AnchorPane getSprintRetrospctPane() {
		return sprintRetrospectPane;
	}

	
}