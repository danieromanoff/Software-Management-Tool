package softwaremanagementtool.agile.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;

	public class BurndownAreaChartViewController {
		
		@FXML
		private AreaChart areaChart;
		  
		@FXML
		CategoryAxis xAxis = new CategoryAxis();
		  
		@FXML
		NumberAxis yAxis = new NumberAxis("Backlog", 0, 100, 10);

		public void setLineData(ChartData data) {
	  	areaChart.setData(data.data);
	  	
	    yAxis.setLabel(data.yAxisLabel);
	    xAxis.setLabel(data.xAxisLabel);
	    
	    areaChart.setTitle(data.title);
	    
	  }
	}