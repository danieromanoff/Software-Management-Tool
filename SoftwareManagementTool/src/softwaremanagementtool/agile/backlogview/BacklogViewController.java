/**
 * 
 */
package softwaremanagementtool.agile.backlogview;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ui.BaseUi;


public class BacklogViewController {

	private AgileProject agilePrj;
	@SuppressWarnings("rawtypes")
	private BaseUi displayUi;
	@FXML
	private TableView<BacklogEntry> backlogTable;
	@FXML
	private TableColumn<BacklogEntry, Integer> IDColumn;
	@FXML
	private TableColumn<BacklogEntry, String> TitleColumn;
 
	
	@FXML
  private void initialize() {
    // Initialize the person table with the two columns.
   	IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
    TitleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
       
    // Listen for selection changes and show the user story details when changed.
    backlogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showEntryDetails(newValue));
    
	}
    
	// selected user story or change request
  private void showEntryDetails(BacklogEntry blEntry) {
  	try {
			agilePrj.showBacklogEntry(blEntry, displayUi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setLast () {
  	backlogTable.getSelectionModel().selectLast(); 
  }
  
  public BacklogEntry getSelectedItem() {
  	return backlogTable.getSelectionModel().getSelectedItem();
  }
  
  public void setAgilePrj(AgileProject agileProject) {
    this.agilePrj = agileProject;
    backlogTable.setItems(agilePrj.getBacklogList());
  }

  public void setDisplayUi(@SuppressWarnings("rawtypes") BaseUi parentUi) {
  	displayUi = parentUi;
	}
}
