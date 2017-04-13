package softwaremanagementtool.agile.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;

public class StackedAreaChartViewController {
	
	@FXML
	private StackedAreaChart chart;
	  
	@FXML
	NumberAxis xAxis = new NumberAxis(0,5,1);
	  
	@FXML
	NumberAxis yAxis = new NumberAxis();

	public void setData(ChartData data) {
	 
		chart.setData(data.data);
  	//chart.getData().addAll(data.data);
  	
    yAxis.setLabel(data.yAxisLabel);
    xAxis.setLabel(data.xAxisLabel);
    xAxis.setMinorTickCount(0);
    
    chart.setTitle(data.title);
    
    
  }
}
