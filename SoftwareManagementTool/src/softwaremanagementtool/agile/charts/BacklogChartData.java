package softwaremanagementtool.agile.charts;

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
		int burndownSeries, projectionSeries;
		
		// currently assuming sprints are in order
		burndownSeries = lineData.addSeries("Burndown");
    projectionSeries = lineData.addSeries("Projection");
		
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
		  // Project start
      lineData.addPoint(burndownSeries, sprintList.Sprint(0).startDateStr(), 
		      sprintList.Sprint(0).getBacklogStats().getTotalBacklogCount());
    }
    
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				
				lineData.addPoint(burndownSeries, sprintList.get().get(sprint).endDateStr(), 
				    sprintList.Sprint(sprint).getBacklogStats().getBacklogCount());
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompleteCount())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogCount();
			  lastSprint = sprintList.get().get(sprint).getEndDate().toString();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		lineData.addPoint(projectionSeries, lastSprint, (int)openBacklog);
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.addPoint(projectionSeries, projectedSprints.toString(), (int)openBacklog);	
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
		int burndownSeries, projectionSeries;
		
		// currently assuming sprints are in order
		
    burndownSeries = lineData.addSeries("Burndown");
    projectionSeries = lineData.addSeries("Projection");
    
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted      
		  // Project start
      lineData.addPoint(burndownSeries, sprintList.Sprint(0).startDateStr(), 
		      sprintList.Sprint(0).getBacklogStats().getTotalBacklogPoints());
    }
	
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.Sprint(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				lineData.addPoint(burndownSeries, sprintList.get().get(sprint).endDateStr(), 
				    sprintList.Sprint(sprint).getBacklogStats().getBacklogPoints());
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.Sprint(sprint).getBacklogStats().getBacklogCompletePoints())/(double)sprintsComplete;	
			  openBacklog = sprintList.Sprint(sprint).getBacklogStats().getBacklogPoints();
			  lastSprint = sprintList.Sprint(sprint).endDateStr();
			  // TODO add dates for future sprints
			}
		}
		// Start projection at end of burndown
		lineData.addPoint(projectionSeries, lastSprint, (int)openBacklog);
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.addPoint(projectionSeries, projectedSprints.toString(), (int)openBacklog);
				
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Backlog Items";
	  lineData.title = "Backlog Burndown by Story Points";

		return lineData;
	}
	
	
}
