package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;

public class ReportsUi {

	private AgileProject agilePrj;
	private DashboardViewController controller;
	AnchorPane reportsLayout ;
	
	public ReportsUi(AgileProject parent) throws IOException {
		agilePrj = parent;
	  FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource("agile/reportsview/ReportsView.fxml"));
    reportsLayout = (AnchorPane) loader.load();
    controller = loader.getController();
	}
	
  
  public void show() {
		agilePrj.getMainLayout().setCenter(reportsLayout);
	}
}
