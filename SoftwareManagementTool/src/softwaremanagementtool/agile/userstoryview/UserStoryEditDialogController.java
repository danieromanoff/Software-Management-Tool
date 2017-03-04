package softwaremanagementtool.agile.userstoryview;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import softwaremanagementtool.agile.DateUtil;
import softwaremanagementtool.agile.UserStory;

public class UserStoryEditDialogController 
{
	// setting fields 
	@FXML
	private TextField IDField;
    @FXML
    private TextField TitleField;
    @FXML
    private TextField OwnerField;
    @FXML
    private TextField As_a_user_i_wantField;
    @FXML
    private TextField priorityField;
    @FXML
    private TextField Acceptance_CriteriaField;
    @FXML
    private TextField calanderdayField;
    private Stage dialogStage;
    private UserStory userstory;
    private boolean okClicked = false;


    // starts the controller class
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUserStory(UserStory userstory) {
        this.userstory = userstory;
        IDField.setText(Integer.toString(userstory.getID()));
        TitleField.setText(userstory.getTitle());
       // OwnerField.setText(userstory.getOwner());
        As_a_user_i_wantField.setText(userstory.getAs_a_user_i_want());
        priorityField.setText(Integer.toString(userstory.getpriority()));
        Acceptance_CriteriaField.setText(userstory.getAcceptance_Criteria());
        calanderdayField.setText(DateUtil.format(userstory.getcalanderday()));
        calanderdayField.setPromptText("mm/dd/yyyy");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    // Called when the user clicks ok.

    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	userstory.setID(Integer.parseInt(IDField.getText()));
        	userstory.setTitle(TitleField.getText());
  
        	userstory.setAs_a_user_i_want(As_a_user_i_wantField.getText());
        	userstory.setpriority(Integer.parseInt(priorityField.getText()));
        	userstory.setAcceptance_Criteria(Acceptance_CriteriaField.getText());
        	userstory.setcalanderday(DateUtil.parse(calanderdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    // Called when the user clicks cancel.
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    // user story input validation
    private boolean isInputValid() {
        String errorMessage = "";

        if (IDField.getText() == null || IDField.getText().length() == 0) {
            errorMessage += "No valid Priority!\n"; 
        }
        else {
            try {
                Integer.parseInt(IDField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }
        if (TitleField.getText() == null || TitleField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (OwnerField.getText() == null ||OwnerField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (As_a_user_i_wantField.getText() == null || As_a_user_i_wantField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (priorityField.getText() == null || priorityField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(priorityField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (Acceptance_CriteriaField.getText() == null || Acceptance_CriteriaField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (calanderdayField.getText() == null || calanderdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(calanderdayField.getText())) {
                errorMessage += "No valid birthday. Use the format mm/dd/yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}