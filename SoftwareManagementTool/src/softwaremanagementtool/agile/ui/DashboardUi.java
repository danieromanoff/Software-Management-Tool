package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.BacklogChartData;
import softwaremanagementtool.agile.charts.BarChartViewController;
import softwaremanagementtool.agile.charts.LineChartViewController;
import softwaremanagementtool.agile.charts.PieChartViewController;
import softwaremanagementtool.agile.charts.SprintData;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;

public class DashboardUi extends BaseUi<DashboardViewController> {
	
	private final String FXML_DASHBOARD_VIEW = "agile/dashboardview/DashboardView.fxml";
	private final String FXML_LINECHART_VIEW = "agile/charts/LineChartView.fxml";
	private final String FXML_PIECHART_VIEW = "agile/charts/PieChartView.fxml";
	private final String FXML_BARCHART_VIEW = "agile/charts/BarChartView.fxml";
	
	private LineChartViewController view1Controller;
	private PieChartViewController view2Controller;
	private BarChartViewController view3Controller;
	private LineChartViewController view4Controller;
	
	
  public DashboardUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_DASHBOARD_VIEW);
  	classController.setAgileProject(agilePrj);
  	
    // TOP Left
    view1Controller = (LineChartViewController)loadSubView( classController.getChartUpperLeft(), FXML_LINECHART_VIEW);
    // TOP Right
    view2Controller = (PieChartViewController)loadSubView( classController.getChartUpperRight(), FXML_PIECHART_VIEW);
    // Lower Left
    view3Controller = (BarChartViewController)loadSubView( classController.getChartLowerLeft(), FXML_BARCHART_VIEW);
    // Lower Right
    view4Controller = (LineChartViewController)loadSubView( classController.getChartLowerRight(), FXML_LINECHART_VIEW);

  }  
  
  public void show() {
  	super.show();
  	// Top Left
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	view1Controller.setLineData(chartData.getPointsBurndownData());
  	
  	// Top Right
  	SprintData chartData2 = new SprintData(agilePrj);
  	view2Controller.setData(chartData2.getCurrentSprintTaskData());
  	
    // Lower Left
   	SprintData chartData3 = new SprintData(agilePrj);
   	view3Controller.setData(chartData3.getTestBarData());
   	
    // Lower Right
   	SprintData chartData4 = new SprintData(agilePrj);
   	view4Controller.setLineData(chartData4.getSlocData());
  	
  }
}
