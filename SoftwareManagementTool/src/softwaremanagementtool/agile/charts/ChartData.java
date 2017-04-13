package softwaremanagementtool.agile.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ChartData <X, Y> {
	public ObservableList<XYChart.Series<X,Y>> data = FXCollections.observableArrayList();
	public String xAxisLabel;
	public String yAxisLabel;
	public String title;
	
	public int addLineSeries(String name){
		data.add(new LineChart.Series<X,Y>(name, FXCollections.observableArrayList()));
    return seriesIndx(name);
	}
	
	public int addAreaSeries(String name){
		data.add(new AreaChart.Series<X,Y>(name, FXCollections.observableArrayList()));
    return seriesIndx(name);
	}

	public void addPoint(int indx, X x, Y y){
		data.get(indx).getData().add(new XYChart.Data<X,Y>(x, y));
	}
	
	private int seriesIndx(String name) {
		for  (int i=0; i<data.size(); i++) {
			if (data.get(i).getName().equals(name)) {
				return i;
			}
		}
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
}

