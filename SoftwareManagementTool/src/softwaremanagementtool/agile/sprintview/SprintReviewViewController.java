package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.Sprint;


public class SprintReviewViewController {

	private AgileProject agilePrj;
  @FXML
  private TextField numFiles;
	@FXML
  private TextField TotalSloc;
  @FXML
  private TextArea notes;
  @FXML
  private TextField numTests;
  @FXML
  private TextField testsAttempted;
  @FXML
  private TextField testsPassed;

	@FXML
	private TableView<BacklogEntry> issuesTable;
	@FXML
	private TableColumn<BacklogEntry, Integer> idColumn;
	@FXML
	private TableColumn<BacklogEntry, String> titleColumn;
	
	@FXML
  private void initialize() {
    // Initialize the person table with the two columns.
   	idColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());     
	}
	
	public void setAgilePrj(AgileProject agileProject ) {
	  agilePrj = agileProject;
	}
	
	public void showSprint(Sprint sprint) {
    numFiles.setText(Integer.toString(sprint.getEndNumFiles()));
    notes.setText(sprint.getReviewNotes());      
    numTests.setText(Integer.toString(sprint.getNumTests()));
    testsAttempted.setText(Integer.toString(sprint.getTestsAttempted()));
    testsPassed.setText(Integer.toString(sprint.getTestsPassed()));
	  TotalSloc.setText(Integer.toString(sprint.getEndSloc()));
	  issuesTable.setItems(agilePrj.getSprintIssuesList(sprint));
	  
	  setEditable(sprint.getState().equals(Sprint.STATE_REVIEW));
	}
	
	private void setEditable(boolean edit) {
		numFiles.setEditable(edit);
		notes.setEditable(edit);
		numTests.setEditable(edit);
		testsAttempted.setEditable(edit);
		testsPassed.setEditable(edit);
		TotalSloc.setEditable(edit);
	}
	
	public void saveSprint(Sprint sprint) {
    sprint.setEndNumFiles(Integer.parseInt(numFiles.getText()));
    sprint.setReviewNotes(notes.getText());
    sprint.setTestsAttempted(Integer.parseInt(testsAttempted.getText()));
    sprint.setTestsPassed(Integer.parseInt(testsPassed.getText()));
    sprint.setNumTests(Integer.parseInt(numTests.getText()));
	  sprint.setEndSloc(Integer.parseInt(TotalSloc.getText()));
	}

}
