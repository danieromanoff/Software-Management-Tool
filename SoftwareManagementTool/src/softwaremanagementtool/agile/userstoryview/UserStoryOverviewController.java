package softwaremanagementtool.agile.userstoryview;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.DateUtil;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.UserStory;

public class UserStoryOverviewController {
	
	//setting table field
    @FXML
    private TableView<UserStory> userstoryTable;
    @FXML
    private TableColumn<UserStory, Integer> IDColumn;
    @FXML
    private TableColumn<UserStory, String> TitleColumn;
    @FXML
    private TableColumn<UserStory, String> OwnerColumn;

    @FXML
    private Label IDLabel;
    @FXML
    private Label TitleLabel;
    @FXML
    private Label OwnerLabel;
    @FXML
    private Label As_a_user_i_wantLabel;
    @FXML
    private Label priorityLabel;
    @FXML
    private Label Acceptance_CriteriaLabel;
    @FXML
    private Label calanderdayLabel;

    // Reference to the main application.
    private AgileProject mainApp;

    //The constructor.
  
    public UserStoryOverviewController() {
    }

    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        OwnerColumn.setCellValueFactory(cellData -> cellData.getValue().OwnerProperty());
        
        // Clear user story details.
        showUserStoryDetails(null);
        
        // Listen for selection changes and show the user story details when changed.
        userstoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showUserStoryDetails(newValue));
    }

    public void setMainApp(AgileProject mainApp) {
        this.mainApp = mainApp;

        userstoryTable.setItems(mainApp.getUserStoryData());
    }
    

    // showing user story 
    private void showUserStoryDetails(UserStory userstory) {
        if (userstory != null) {
        	IDLabel.setText(Integer.toString(userstory.getID()));
            TitleLabel.setText(userstory.getTitle());
            OwnerLabel.setText(userstory.getOwner());
            As_a_user_i_wantLabel.setText(userstory.getAs_a_user_i_want());
            priorityLabel.setText(Integer.toString(userstory.getpriority()));
            Acceptance_CriteriaLabel.setText(userstory.getAcceptance_Criteria());
            calanderdayLabel.setText(DateUtil.format(userstory.getcalanderday()));
        } 
        else 
        {

        	IDLabel.setText("");
            TitleLabel.setText("");
            OwnerLabel.setText("");
            As_a_user_i_wantLabel.setText("");
            priorityLabel.setText("");
            Acceptance_CriteriaLabel.setText("");
            calanderdayLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteUserStory() {
        int selectedIndex = userstoryTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	userstoryTable.getItems().remove(selectedIndex);
        } 
        else 
        {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No user story Selected");
            alert.setContentText("Please select a user story from the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewUserStory() {
    	UserStory tempUserStory = new UserStory();
        boolean okClicked = mainApp.showUserStoryEditDialog(tempUserStory);
        if (okClicked) {
            mainApp.getUserStoryData().add(tempUserStory);
        }
    }

    @FXML
    private void handleEditUserStory() {
    	UserStory selectedUserStory = userstoryTable.getSelectionModel().getSelectedItem();
        if (selectedUserStory != null) {
            boolean okClicked = mainApp.showUserStoryEditDialog(selectedUserStory);
            if (okClicked) {
                showUserStoryDetails(selectedUserStory);
            }

        } 
        else 
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No user story Selected");
            alert.setContentText("Please select a user story from the table.");
            
            alert.showAndWait();
        }
    }
}