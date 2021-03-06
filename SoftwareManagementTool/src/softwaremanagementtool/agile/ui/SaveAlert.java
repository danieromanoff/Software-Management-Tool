package softwaremanagementtool.agile.ui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class SaveAlert {

	public static boolean save() {
	  Alert alert = new Alert(AlertType.CONFIRMATION);
	  alert.setTitle("Apply Changes");
	  alert.setHeaderText("Changes Made, Do you want to apply?");
	  alert.setContentText("OK to Apply; Cancel to discard");

	  Optional<ButtonType> result = alert.showAndWait();
	  return (result.get() == ButtonType.OK);
	}
}
