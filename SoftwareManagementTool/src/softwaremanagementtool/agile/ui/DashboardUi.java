package softwaremanagementtool.agile.ui;

import java.io.IOException;

import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;

public class DashboardUi extends BaseUi<DashboardViewController> {
	
	private final String FXML_DASHBOARD_VIEW = "agile/dashboardview/DashboardView.fxml";

  public DashboardUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_DASHBOARD_VIEW);
  	classController.setAgileProject(agilePrj);
  }  
}
