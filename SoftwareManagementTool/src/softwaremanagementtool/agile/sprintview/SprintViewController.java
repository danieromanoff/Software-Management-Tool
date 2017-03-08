package softwaremanagementtool.agile.sprintview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.Sprint;


public class SprintViewController {

  private AgileProject agilePrj;
  @FXML
  private TableView<Sprint> sprintTable;
  @FXML
  private TableColumn<Sprint, Integer> idColumn;
  @FXML
  private TableColumn<Sprint, String> titleColumn;
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
   // titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
       
    // Listen for selection changes and show the user story details when changed.
    sprintTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSprintDetails(newValue));
    
  }
  
  private void showSprintDetails(Sprint sprint) {
      // TODO agilePrj.showBacklogEntry(blEntry);

 }
  
  @FXML
  private void goNewSprint() throws IOException {
     agilePrj.newSprint();
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
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