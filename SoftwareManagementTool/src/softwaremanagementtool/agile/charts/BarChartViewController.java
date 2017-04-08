package softwaremanagementtool.agile.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;

public class BarChartViewController {

	@FXML
	private BarChart barChart;
	
	@FXML
	CategoryAxis xAxis = new CategoryAxis();
	  
	@FXML
	NumberAxis yAxis = new NumberAxis("Backlog", 0, 100, 10);
	

	public void setLineData(LineChartData data) {
  	barChart.setData(data.data);
  	
    yAxis.setLabel(data.yAxisLabel);
    xAxis.setLabel(data.xAxisLabel);
    
    barChart.setTitle(data.title);
    
  }
	
}
