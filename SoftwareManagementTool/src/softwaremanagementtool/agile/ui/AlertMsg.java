package softwaremanagementtool.agile.ui;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertMsg {
	
	public static void send(String header, String context) {
	  Alert alert = new Alert(AlertType.WARNING);
	  alert.setTitle("WARNING");
	  alert.setHeaderText(header);
	  alert.setContentText(context);

	  alert.showAndWait();
	  return ;
	}
}
