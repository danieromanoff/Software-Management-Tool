/**
 * 
 */
package softwaremanagementtool.agile.backlogview;

import java.io.IOException;

import javafx.collections.ObservableList;
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
    backlogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> newSelection(oldValue, newValue));
    
	}
   
	private void newSelection(BacklogEntry oldEntry, BacklogEntry newEntry) {
		if (oldEntry != null) {
		  agilePrj.leavingBacklogEntry(oldEntry, displayUi);
		}
	  showEntryDetails(newEntry);
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
  
  public void setFirst () {
  	backlogTable.getSelectionModel().selectFirst(); 
  	showEntryDetails(getSelectedItem());
  }
  
  public void setLast () {
  	backlogTable.getSelectionModel().selectLast(); 
  	showEntryDetails(getSelectedItem());
  }
  
  public BacklogEntry getSelectedItem() {
  	return backlogTable.getSelectionModel().getSelectedItem();
  }
  
  public void setAgilePrj(AgileProject agileProject, ObservableList<BacklogEntry> list ) {
    this.agilePrj = agileProject;
    backlogTable.setItems(list);
  }

  public void setDisplayUi(@SuppressWarnings("rawtypes") BaseUi parentUi) {
  	displayUi = parentUi;
	}
}
