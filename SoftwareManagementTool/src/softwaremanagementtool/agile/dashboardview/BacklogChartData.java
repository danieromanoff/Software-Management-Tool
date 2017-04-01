package softwaremanagementtool.agile.dashboardview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintList;

public class BacklogChartData {
  
	private SprintList sprintList;
	
	public BacklogChartData(SprintList inList) {
  	sprintList = inList;
  }
	
	public LineChartData getSprntBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		String lastSprint = "";
		LineChartData lineData = new LineChartData();
		// currently assuming sprints are in order
		lineData.data = FXCollections.observableArrayList(
        new LineChart.Series<String,Integer>("Burndown", FXCollections.observableArrayList(
        )),
        new LineChart.Series<String,Integer>("Projection", FXCollections.observableArrayList(
        ))
    );
		// Project start
		lineData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(0).getStartDate().toString(), 
		    sprintList.get().get(0).getBacklogStats().getTotalBacklogCount()));
		System.out.println(sprintList.get().get(0).getBacklogStats().getTotalBacklogCount().toString());
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  lineData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(sprint).getEndDate().toString(), 
				    sprintList.get().get(sprint).getBacklogStats().getBacklogCount()));
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompleteCount())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogCount();
			  lastSprint = sprintList.get().get(sprint).getEndDate().toString();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		lineData.data.get(1).getData().add(new XYChart.Data(lastSprint, (int)openBacklog));
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.data.get(1).getData().add(new XYChart.Data(projectedSprints.toString(), (int)openBacklog));
				
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Backlog Items";
	  lineData.title = "Backlog Burndown Count";

		return lineData;
	}
	
	public LineChartData getPointsBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		String lastSprint = "";
		LineChartData lineData = new LineChartData();
		// currently assuming sprints are in order
		lineData.data = FXCollections.observableArrayList(
        new LineChart.Series<Integer,Integer>("Burndown", FXCollections.observableArrayList(
        )),
        new LineChart.Series<Integer,Integer>("Projection", FXCollections.observableArrayList(
        ))
    );
		// Project start
		lineData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(0).getStartDate().toString(), 
		    sprintList.get().get(0).getBacklogStats().getTotalBacklogPoints()));
		System.out.println(sprintList.get().get(0).getBacklogStats().getTotalBacklogPoints().toString());
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  lineData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(sprint).getEndDate().toString(), 
				    sprintList.get().get(sprint).getBacklogStats().getBacklogPoints()));
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompletePoints())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogPoints();
			  lastSprint = sprintList.get().get(sprint).getEndDate().toString();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		lineData.data.get(1).getData().add(new XYChart.Data(lastSprint, (int)openBacklog));
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.data.get(1).getData().add(new XYChart.Data(projectedSprints.toString(), (int)openBacklog));
				
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Backlog Items";
	  lineData.title = "Backlog Burndown by Story Points";

		return lineData;
	}
	
}
