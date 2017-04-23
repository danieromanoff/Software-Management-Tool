package softwaremanagementtool.agile.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class LineChartViewController {
	
	@FXML
	private LineChart<String, Integer> lineChart;
	  
	@FXML
	CategoryAxis xAxis = new CategoryAxis();
	  
	@FXML
	NumberAxis yAxis = new NumberAxis(" ", 0, 100, 10);

	public void setLineData(ChartData<String, Integer> data) {
	 
  	lineChart.setData(data.data);
  	
    yAxis.setLabel(data.yAxisLabel);
    xAxis.setLabel(data.xAxisLabel);
    
    lineChart.setTitle(data.title);
    
  }
}
