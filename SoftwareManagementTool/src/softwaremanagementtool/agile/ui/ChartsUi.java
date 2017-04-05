package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.BacklogChartData;
import softwaremanagementtool.agile.charts.ChartViewController;
import softwaremanagementtool.agile.charts.LineChartViewController;
import softwaremanagementtool.agile.dashboardview.DashboardViewController;
import softwaremanagementtool.agile.sprintview.SprintInfoViewController;

public class ChartsUi extends BaseUi<ChartViewController> {

	private final String FXML_CHART_VIEW = "agile/charts/ChartView.fxml";
	private final String FXML_LINECHART_VIEW = "agile/charts/LineChartView.fxml";
	
	private LineChartViewController lineChartController;
	
	private AnchorPane lineChart;

  public ChartsUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_CHART_VIEW);
  	//classController.setAgileProject(agilePrj);

    FXMLLoader lineLoader = new FXMLLoader();
    lineLoader.setLocation(SoftwareManagementToolMain.class.getResource(FXML_LINECHART_VIEW));
    lineChart = lineLoader.load();    
    // Allow re-size
    classController.getPane().getChildren().add(lineChart);
    AnchorPane.setTopAnchor(lineChart, 0.0);
    AnchorPane.setLeftAnchor(lineChart, 0.0);
    AnchorPane.setRightAnchor(lineChart, 0.0);
    AnchorPane.setBottomAnchor(lineChart, 0.0);
    lineChartController = (LineChartViewController)lineLoader.getController();
  }
  
  
  
  public void showBurndownSprintCount() {
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  //	lineChartController.setLineData(chartData.getSprntBurndownData());
  	
  }
  
  public void showBurndownSprintPoints() {
  	super.show();
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	lineChartController.setLineData(chartData.getPointsBurndownData());
  	
  }
}
