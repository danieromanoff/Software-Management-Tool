package softwaremanagementtool.agile.ui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class OkMsg {
	public static boolean send(String header, String context) {
	  Alert alert = new Alert(AlertType.CONFIRMATION);
	  alert.setTitle("Select");
	  alert.setHeaderText(header);
	  alert.setContentText(context);

	  Optional<ButtonType> result = alert.showAndWait();
	  return (result.get() == ButtonType.OK);
	}
}
