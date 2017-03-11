package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;

public class DashboardUi {

	private AgileProject agilePrj;
	private DashboardViewController controller;
	AnchorPane dashboardLayout ;
	
  public DashboardUi(AgileProject parent) throws IOException {
  	agilePrj = parent;
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/dashboardview/DashboardView.fxml"));
    dashboardLayout = loader.load();    
    controller = (DashboardViewController)loader.getController();
    controller.setAgileProject(agilePrj); 
   // controller.setPrjName(projectName); 
    AnchorPane.setTopAnchor(dashboardLayout, 0.0);
    AnchorPane.setLeftAnchor(dashboardLayout, 0.0);
    AnchorPane.setRightAnchor(dashboardLayout, 0.0);
    AnchorPane.setBottomAnchor(dashboardLayout, 0.0);
  }
  
  public void show() {
		agilePrj.getMainLayout().setCenter(dashboardLayout);
	}
  
}
