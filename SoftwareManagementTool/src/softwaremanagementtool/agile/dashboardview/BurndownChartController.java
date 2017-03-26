package softwaremanagementtool.agile.dashboardview;
 

import java.net.URL;
import java.util.Iterator;
import java.util.TreeMap;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class BurndownChartController {

  @FXML
  private Pane areachartPane;

  @FXML
  void initialize() {
    assert areachartPane != null : "fx:id=\"areachartPane\" was not injected: check your FXML file 'BurndownChart.fxml'.";

    XYChart.Series<Number, Number> projected = new XYChart.Series<>();
    XYChart.Series<Number, Number> actual = new XYChart.Series<>();
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    AreaChart<Number, Number> areachart = new AreaChart<Number, Number>(xAxis, yAxis);

    areachart.prefWidthProperty().bind(areachartPane.widthProperty());
    areachart.prefHeightProperty().bind(areachartPane.heightProperty());
    areachartPane.getChildren().add(areachart);

    areachart.setTitle("Burndown Chart");
    xAxis.setLabel("Sprint and Date");
    yAxis.setLabel("User Stories");
    

    projected.setName("Projected");
    {
      // need url for this: URL url = this.getClass().getResource("");
     // ProjectedCoor coordinates = new ProjectedData(url);

      TreeMap<Integer, String[]> map = coordinates.getNumberSortedCsv(0);
      Iterator<Integer> it = map.keySet().iterator();
      while (it.hasNext()) {
        int no = it.next();
        String[] words = map.get(no);
        Double dataX = Double.parseDouble(words[0]);
        Double dataY = Double.parseDouble(words[1]);

        projected.getData().add(new XYChart.Data<Number, Number>(dataX, dataY));
      }
    }
    areachart.getData().add(projected);

    actual.setName("Actual");
    {
     // URL url = this.getClass().getResource("");
     // ActualCoor coordinates = new ActualCoor(url);

      TreeMap<Integer, String[]> map = coordinates.getNumberSortedCsv(0);
      Iterator<Integer> it = map.keySet().iterator();
      while (it.hasNext()) {
        int no = it.next();
        String[] words = map.get(no);
        Double dataX = Double.parseDouble(words[0]);
        Double dataY = Double.parseDouble(words[1]);

        actual.getData().add(new XYChart.Data<Number, Number>(dataX, dataY));
      }
    }
    areachart.getData().add(actual);
  }


}
