package softwaremanagementtool.agile.dashboardview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.charts.LineChartData;

public class DashboardViewController {
  
  private AgileProject agilePrj;
  
  @FXML
  private LineChart lineChart;
  
  @FXML
 CategoryAxis xAxis = new CategoryAxis();
  
 @FXML
 NumberAxis yAxis = new NumberAxis("Backlog", 0, 100, 10);


  public void setAgileProject(AgileProject inPrj) {
    agilePrj = inPrj;
  }
  
  public void setPrjName(String inName) {
    // TBD set Name
  }
  
  public void setData(){
  	  	
  	
  	ObservableList<XYChart.Series> lineChartData = FXCollections.observableArrayList(
        new LineChart.Series<Integer,Integer>("Series 1", FXCollections.observableArrayList(
            new XYChart.Data("1 2/24/17", 10),
            new XYChart.Data("2", 9),
            new XYChart.Data("3", 8),
            new XYChart.Data("4", 7),
            new XYChart.Data("5", 6)
        )),
        new LineChart.Series<Integer,Integer>("Series 2", FXCollections.observableArrayList(
            new XYChart.Data("4", 8),
            new XYChart.Data("5", 7),
            new XYChart.Data("6", 6),
            new XYChart.Data("7", 5)
        ))
  
    );
  	lineChart.setData(lineChartData);
  	
   yAxis.setLabel("Backlog");
   yAxis.setUpperBound(15);
  	
  	
  }
  
  public void setLineData(LineChartData data) {
  	lineChart.setData(data.data);
  	
    yAxis.setLabel(data.yAxisLabel);
    xAxis.setLabel(data.xAxisLabel);
    
    lineChart.setTitle(data.title);
    
  }
  
  
}
