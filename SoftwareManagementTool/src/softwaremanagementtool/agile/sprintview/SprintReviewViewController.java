package softwaremanagementtool.agile.sprintview;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.Sprint;

public class SprintReviewViewController {

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
  private TableColumn<Sprint, String> Issue;
	
	public void showSprint(Sprint sprint) {
    numFiles.setText(Integer.toString(sprint.getEndNumFiles()));
    notes.setText(sprint.getReviewNotes());      
    numTests.setText(Integer.toString(sprint.getNumTests()));
    testsAttempted.setText(Integer.toString(sprint.getTestsAttempted()));
    testsPassed.setText(Integer.toString(sprint.getTestsPassed()));
	  TotalSloc.setText(Integer.toString(sprint.getEndSloc()));
	}
	
	public void saveSprint(Sprint sprint) {
    sprint.setEndNumFiles(Integer.parseInt(numFiles.getText()));
    sprint.setReviewNotes(notes.getText());
    sprint.setTestsAttempted(Integer.parseInt(numTests.getText()));
    sprint.setTestsPassed(Integer.parseInt(numTests.getText()));
    sprint.setNumTests(Integer.parseInt(numTests.getText()));
	  sprint.setEndSloc(Integer.parseInt(TotalSloc.getText()));
	}

}
