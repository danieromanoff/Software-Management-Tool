package softwaremanagementtool.agile.ui;

import java.io.IOException;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.reportsview.ReportsViewController;

public class ReportsUi extends BaseUi<ReportsViewController> {
	
	private final String FXML_REPORTS_VIEW = "agile/reportsview/ReportsView.fxml";

	public ReportsUi(AgileProject parent) throws IOException {
		loadView(parent, FXML_REPORTS_VIEW);
  	classController.setAgileProject(agilePrj);
	}
}
