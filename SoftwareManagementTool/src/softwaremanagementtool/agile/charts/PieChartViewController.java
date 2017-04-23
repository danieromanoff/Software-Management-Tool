package softwaremanagementtool.agile.charts;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartViewController {

	@FXML
	private PieChart pieChart;
	
	public void setData(ObservableList<PieChart.Data> data) {
		 
		pieChart.setData(data);
  	
  
    
		pieChart.setTitle("Current Sprint Task Status"); // TODO
    
  }
}
