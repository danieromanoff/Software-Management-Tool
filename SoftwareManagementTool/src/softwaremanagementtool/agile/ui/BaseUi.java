package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;

public class BaseUi<T> {

	protected AgileProject agilePrj;
	protected T classController;
	protected AnchorPane classLayout ;
		
	protected void loadView(AgileProject parent, String fxmlFile) throws IOException {
  	agilePrj = parent;
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource(fxmlFile));
    classLayout = loader.load();    
    classController = loader.getController();
  
    AnchorPane.setTopAnchor(classLayout, 0.0);
    AnchorPane.setLeftAnchor(classLayout, 0.0);
    AnchorPane.setRightAnchor(classLayout, 0.0);
    AnchorPane.setBottomAnchor(classLayout, 0.0);
  }
  
  public void show() {
		agilePrj.getMainLayout().setCenter(classLayout);
	}
  
  protected Object loadSubView(AnchorPane parent, String fxmlFile) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource(fxmlFile));
    AnchorPane pane = loader.load();    
    // Allow re-size
    parent.getChildren().add(pane);
    AnchorPane.setTopAnchor(pane, 0.0);
    AnchorPane.setLeftAnchor(pane, 0.0);
    AnchorPane.setRightAnchor(pane, 0.0);
    AnchorPane.setBottomAnchor(pane, 0.0);
    return (loader.getController());
  }
}
