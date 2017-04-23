package softwaremanagementtool.agile.dashboardview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.ChartData;

public class DashboardViewController {
  
  private AgileProject agilePrj;
  
 
 @FXML
 private AnchorPane ChartUpperLeft;
 
 @FXML
 private AnchorPane ChartUpperRight;
 
 @FXML
 private AnchorPane ChartLowerLeft;

 @FXML
 private AnchorPane ChartLowerRight;
 
  public void setAgileProject(AgileProject inPrj) {
    agilePrj = inPrj;
  }
  
  public void setPrjName(String inName) {
    // TBD set Name
  }
  
  public AnchorPane getChartUpperLeft() {
  	return ChartUpperLeft;
  }
  public AnchorPane getChartUpperRight() {
  	return ChartUpperRight;
  }
  public AnchorPane getChartLowerLeft() {
  	return ChartLowerLeft;
  }
  public AnchorPane getChartLowerRight() {
  	return ChartLowerRight;
  }
  
  
  
}
