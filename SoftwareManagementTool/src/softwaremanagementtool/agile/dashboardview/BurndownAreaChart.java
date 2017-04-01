package softwaremanagementtool.agile.dashboardview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintList;

public class BurndownAreaChart {
  
	private SprintList sprintList;
	
	public BurndownAreaChart(SprintList inList) {
  	sprintList = inList;
  }
	
	public AreaChartData getSprntBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		String lastSprint = "";
		AreaChartData AreaData = new AreaChartData();
		// currently assuming sprints are in order
		AreaData.data = FXCollections.observableArrayList(
        new AreaChart.Series<String,Integer>("Burndown", FXCollections.observableArrayList(
        )),
        new AreaChart.Series<String,Integer>("Projection", FXCollections.observableArrayList(
        ))
    );
		// Project start
		AreaData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(0).getStartDate().toString(), 
		    sprintList.get().get(0).getBacklogStats().getTotalBacklogCount()));
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  AreaData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(sprint).getEndDate().toString(), 
				    sprintList.get().get(sprint).getBacklogStats().getBacklogCount()));
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompleteCount())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogCount();
			  lastSprint = sprintList.get().get(sprint).getEndDate().toString();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		AreaData.data.get(1).getData().add(new XYChart.Data(lastSprint, (int)openBacklog));
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			AreaData.data.get(1).getData().add(new XYChart.Data(projectedSprints.toString(), (int)openBacklog));
				
		}
		
	  AreaData.xAxisLabel = "Sprints";
	  AreaData.yAxisLabel = "Backlog Items";
	  AreaData.title = "Backlog Burndown Count";

		return AreaData;
	}
	
	public AreaChartData getPointsBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		String lastSprint = "";
		AreaChartData AreaData = new AreaChartData();
		// currently assuming sprints are in order
		AreaData.data = FXCollections.observableArrayList(
        new AreaChart.Series<Integer,Integer>("Burndown", FXCollections.observableArrayList(
        )),
        new AreaChart.Series<Integer,Integer>("Projection", FXCollections.observableArrayList(
        ))
    );
		// Project start
		AreaData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(0).getStartDate().toString(), 
		    sprintList.get().get(0).getBacklogStats().getTotalBacklogPoints()));
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  AreaData.data.get(0).getData().add(new XYChart.Data(sprintList.get().get(sprint).getEndDate().toString(), 
				    sprintList.get().get(sprint).getBacklogStats().getBacklogPoints()));
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompletePoints())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogPoints();
			  lastSprint = sprintList.get().get(sprint).getEndDate().toString();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		AreaData.data.get(1).getData().add(new XYChart.Data(lastSprint, (int)openBacklog));
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			AreaData.data.get(1).getData().add(new XYChart.Data(projectedSprints.toString(), (int)openBacklog));
				
		}
		
	  AreaData.xAxisLabel = "Sprints";
	  AreaData.yAxisLabel = "Backlog Items";
	  AreaData.title = "Backlog Burndown by User Stories";

		return AreaData;
	}
	
}
