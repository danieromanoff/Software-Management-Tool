/**
 * 
 */
package softwaremanagementtool.agile.backlogview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.DateUtil;
import softwaremanagementtool.agile.UserStory;

/**
 * @author Stephen
 *
 */
public class BacklogViewController {

	private AgileProject agilePrj;
	@FXML
	private TableView<BacklogEntry> backlogTable;
	@FXML
	private TableColumn<BacklogEntry, Integer> IDColumn;
	@FXML
	private TableColumn<BacklogEntry, String> TitleColumn;
  @FXML
  private AnchorPane backlogEntryPane;

	
	@FXML
  private void initialize() {
    // Initialize the person table with the two columns.
   	IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
       
    // Clear user story details.
   // showUserStoryDetails(null);
       
    // Listen for selection changes and show the user story details when changed.
    backlogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showEntryDetails(newValue));
    
	}
    
	// showing user story 
  private void showEntryDetails(BacklogEntry blEntry) {
  	try {
			agilePrj.showBacklogEntry(blEntry);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
      
    backlogTable.setItems(agilePrj.getBacklogList());
  
  }

  public AnchorPane getBacklogEntryPane() {
		return backlogEntryPane;
	}
}
