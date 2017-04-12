package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.SoftwareManagementToolMain;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.BacklogChartData;
import softwaremanagementtool.agile.charts.BarChartViewController;
import softwaremanagementtool.agile.charts.ChartViewController;
import softwaremanagementtool.agile.charts.LineChartViewController;
import softwaremanagementtool.agile.charts.PieChartViewController;
import softwaremanagementtool.agile.charts.StackedAreaChartViewController;
import softwaremanagementtool.agile.charts.SprintData;

public class ChartsUi extends BaseUi<ChartViewController> {

	private final String FXML_CHART_VIEW = "agile/charts/ChartView.fxml";
	private final String FXML_LINECHART_VIEW = "agile/charts/LineChartView.fxml";
	private final String FXML_STACKED_AREA_CHART = "agile/charts/StackedAreaChartView.fxml";
	private final String FXML_BAR_CHART = "agile/charts/BarChartView.fxml";
	private final String FXML_PIE_CHART = "agile/charts/PieChartView.fxml";
	
	private LineChartViewController lineChartController;
	private StackedAreaChartViewController stackedAreaChartController;
	private BarChartViewController barChartController;
	private PieChartViewController pieChartController;
	
	private AnchorPane newPane;
	private AnchorPane lineChartPane;
	private AnchorPane stackedAreaPane;
	private AnchorPane barChartPane;
	private AnchorPane pieChartPane;

	
	private Object loadChart(AnchorPane parent, String fxmlFile) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SoftwareManagementToolMain.class.getResource(fxmlFile));
    newPane = loader.load();    
    // Allow re-size
    parent.getChildren().add(newPane);
    AnchorPane.setTopAnchor(newPane, 0.0);
    AnchorPane.setLeftAnchor(newPane, 0.0);
    AnchorPane.setRightAnchor(newPane, 0.0);
    AnchorPane.setBottomAnchor(newPane, 0.0);
    return (loader.getController());
  }
	
  public ChartsUi(AgileProject parent) throws IOException {
  	loadView(parent, FXML_CHART_VIEW);
  	//classController.setAgileProject(agilePrj);

  	lineChartController = (LineChartViewController)loadChart(classController.getPane(), FXML_LINECHART_VIEW);
  	lineChartPane = newPane;
  	stackedAreaChartController = (StackedAreaChartViewController)loadChart(classController.getPane(), FXML_STACKED_AREA_CHART);
  	stackedAreaPane = newPane;
  	barChartController = (BarChartViewController)loadChart(classController.getPane(), FXML_BAR_CHART);
  	barChartPane = newPane;
  	pieChartController = (PieChartViewController)loadChart(classController.getPane(), FXML_PIE_CHART);
  	pieChartPane = newPane;
  	
  }
  
  private void turnChartsOff() {
  	lineChartPane.setVisible(false);
  	stackedAreaPane.setVisible(false);
  	barChartPane.setVisible(false);
  	pieChartPane.setVisible(false);
  }
  
  
  public void showBurndownSprintCount() {
  	super.show();
  	turnChartsOff();
  	lineChartPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	lineChartController.setLineData(chartData.getSprntBurndownData()); 
  }
  
  public void showBurndownSprintPoints() {
  	super.show();
  	turnChartsOff();
  	lineChartPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	lineChartController.setLineData(chartData.getPointsBurndownData());
  }
  
  public void showStackedAreaCount() { // this one is no good
  	super.show();
  	turnChartsOff();
  	stackedAreaPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	stackedAreaChartController.setData(chartData.getSprntBurndownAreaData());
  }
  
  public void showBurndownAreaStateCount() {
  	super.show();
  	turnChartsOff();
  	stackedAreaPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	stackedAreaChartController.setData(chartData.getSprintBurndownAreaStateData());
  }
  
  public void showBurndownAreaStatePoints() {
  	super.show();
  	turnChartsOff();
  	stackedAreaPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	stackedAreaChartController.setData(chartData.getSprintBurndownAreaStatePoints());
  }
  
  public void showBurndownAreaUsCr() {
  	super.show();
  	turnChartsOff();
  	stackedAreaPane.setVisible(true);
  	BacklogChartData chartData = new BacklogChartData(agilePrj.sprintList());
  	stackedAreaChartController.setData(chartData.getSprintBurndownAreaUsCr());
  }
  
  public void showSprintTasksBarChart() {
  	super.show();
  	turnChartsOff();
  	barChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	barChartController.setData(chartData.getTaskBarData());
  }
  
  public void showStoryPointBarChart() {
  	super.show();
  	turnChartsOff();
  	barChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	barChartController.setData(chartData.getStoryPointBarData());
  }
  
  public void showTestBarChart() {
  	super.show();
  	turnChartsOff();
  	barChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	barChartController.setData(chartData.getTestBarData());
  }
  
  public void showNumFilesLineChart() {
  	super.show();
  	turnChartsOff();
  	lineChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	lineChartController.setLineData(chartData.getNumFilesData());
  }

  public void showSlocLineChart() {
  	super.show();
  	turnChartsOff();
  	lineChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	lineChartController.setLineData(chartData.getSlocData());
  }

  public void showCurrentSprintTaskChart() {
  	super.show();
  	turnChartsOff();
  	pieChartPane.setVisible(true);
  	SprintData chartData = new SprintData(agilePrj);
  	pieChartController.setData(chartData.getCurrentSprintTaskData());
  }
  
}
