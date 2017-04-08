package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.BacklogChartData;
import softwaremanagementtool.agile.charts.LineChartViewController;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;

public class DashboardUi extends BaseUi<DashboardViewController> {
	
	private final String FXML_DASHBOARD_VIEW = "agile/dashboardview/DashboardView.fxml";
	private final String FXML_LINECHART_VIEW = "agile/charts/LineChartView.fxml";
	
	private LineChartViewController view1Controller;
	private LineChartViewController view2Controller;
	private LineChartViewController view3Controller;
	private LineChartViewController view4Controller;
	
	private Object loadChart(String fxml, AnchorPane whichCorner ) throws IOException {
	  FXMLLoader loader = new FXMLLoader();
	  loader.setLocation(SoftwareManagementToolMain.class.getResource(fxml));
	  AnchorPane chart = loader.load();    
	  whichCorner.getChildren().add(chart);
	  AnchorPane.setTopAnchor(chart, 0.0);
	  AnchorPane.setLeftAnchor(chart, 0.0);
	  AnchorPane.setRightAnchor(chart, 0.0);
	  AnchorPane.setBottomAnchor(chart, 0.0);
	  return loader.getController();
	}
	
  public DashboardUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_DASHBOARD_VIEW);
  	classController.setAgileProject(agilePrj);
  	
    // TOP Left
    view1Controller = (LineChartViewController)loadChart(FXML_LINECHART_VIEW, classController.getChartUpperLeft());
    // TOP Right
    view2Controller = (LineChartViewController)loadChart(FXML_LINECHART_VIEW, classController.getChartUpperRight());
    // Lower Left
    view3Controller = (LineChartViewController)loadChart(FXML_LINECHART_VIEW, classController.getChartLowerLeft());
    // Lower Right
    view4Controller = (LineChartViewController)loadChart(FXML_LINECHART_VIEW, classController.getChartLowerRight());

  }  
  
  public void show() {
  	super.show();
  	// Top Left
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	view1Controller.setLineData(chartData.getPointsBurndownData());
  	
  	// Top Right
  	view2Controller.setLineData(chartData.getPointsBurndownData());
  	
    // Lower Left
   	view3Controller.setLineData(chartData.getPointsBurndownData());
   	
    // Lower Right
   	view4Controller.setLineData(chartData.getPointsBurndownData());
  	
  }
}
