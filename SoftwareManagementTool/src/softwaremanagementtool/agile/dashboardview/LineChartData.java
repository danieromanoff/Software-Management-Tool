package softwaremanagementtool.agile.dashboardview;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class LineChartData {
	public ObservableList<XYChart.Series> data;
	public String xAxisLabel;
	public String yAxisLabel;
	public String title;
}

public class AreaChartData {
	public ObservableList<XYChart.Series> data;
	public String xAxisLabel;
	public String yAxisLabel;
	public String title;
}