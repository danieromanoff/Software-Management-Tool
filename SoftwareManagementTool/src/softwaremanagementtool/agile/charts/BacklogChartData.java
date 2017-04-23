package softwaremanagementtool.agile.charts;

import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintList;

public class BacklogChartData {
  
	private SprintList sprintList;
	
	public BacklogChartData(SprintList inList) {
  	sprintList = inList;
  }
	
	/*
	 *  Sprint Burn-down chart data 
	 */
	public ChartData<String, Integer> getSprntBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		ChartData<String, Integer> lineData = new ChartData<String, Integer>();
		int burndownSeries, projectionSeries;
		
		// currently assuming sprints are in order
	  // Actual burn-down
		burndownSeries = lineData.addLineSeries("Burndown");
	  // At the current rate, project how many more sprints are needed to finish
    projectionSeries = lineData.addLineSeries("Projection");  
		
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
		  // First point, Sprint 0 total number of backlog entries at the beginning of first sprint
      lineData.addPoint(burndownSeries, Integer.toString(0), 
		      sprintList.Sprint(0).getBacklogStats().getTotalBacklogCount());
    }
    
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				// next closed sprint, get the backlog count for next point 
				lineData.addPoint(burndownSeries, Integer.toString(sprintList.get().get(sprint).getID()), 
				    sprintList.Sprint(sprint).getBacklogStats().getBacklogCount());
				// calculate burndown rate
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompleteCount())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogCount();
			  projectedSprints = sprintList.get().get(sprint).getID();
			}
		}
		// Start projection at end of burndown
		lineData.addPoint(projectionSeries, Integer.toString(projectedSprints), (int)openBacklog);
		
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.addPoint(projectionSeries, Integer.toString(projectedSprints), (int)openBacklog);	
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Backlog Items";
	  lineData.title = "Backlog Burndown Count";

		return lineData;
	}
	
	
	public ChartData<String, Integer> getPointsBurndownData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		ChartData<String, Integer> lineData = new ChartData<String, Integer>();
		int burndownSeries, projectionSeries;
		
		// currently assuming sprints are in order
		
    burndownSeries = lineData.addLineSeries("Burndown");
    projectionSeries = lineData.addLineSeries("Projection");
    
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted      
		  // Project start
      lineData.addPoint(burndownSeries, Integer.toString(0), 
		      sprintList.Sprint(0).getBacklogStats().getTotalBacklogPoints());
    }
	
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.Sprint(sprint).getState().equals(Sprint.STATE_CLOSED)) {
		
				lineData.addPoint(burndownSeries, Integer.toString(sprintList.get().get(sprint).getID()), 
				    sprintList.Sprint(sprint).getBacklogStats().getBacklogPoints());
				
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.Sprint(sprint).getBacklogStats().getBacklogCompletePoints())/(double)sprintsComplete;	
			  openBacklog = sprintList.Sprint(sprint).getBacklogStats().getBacklogPoints();
			  projectedSprints = sprintList.Sprint(sprint).getID();
			}
		}
		// Start projection at end of burndown
		lineData.addPoint(projectionSeries, Integer.toString(projectedSprints), (int)openBacklog);
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.addPoint(projectionSeries, Integer.toString(projectedSprints), (int)openBacklog);
				
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Story Points";
	  lineData.title = "Backlog Burndown by Story Points";

		return lineData;
	}
	
	
	public ChartData<Integer, Integer> getSprntBurndownAreaData() {
		Integer sprintsComplete = 0;
		double openBacklog = 0;
		double burndownRate = 0.0;
		Integer projectedSprints = 0;
		ChartData<Integer, Integer> lineData = new ChartData<Integer, Integer>();
		int burndownSeries, projectionSeries;
		
		// currently assuming sprints are in order
	  // Actual burn-down
		burndownSeries = lineData.addLineSeries("Burndown");
	  // At the current rate, project how many more sprints are needed to finish
    projectionSeries = lineData.addLineSeries("Projection");  
		
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
		  // First point, Sprint 0 total number of backlog entries at the beginning of first sprint
      lineData.addPoint(burndownSeries, 0, 
		      sprintList.Sprint(0).getBacklogStats().getTotalBacklogCount());
    }
    
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				// next closed sprint, get the backlog count for next point 
				lineData.addPoint(burndownSeries, sprintList.get().get(sprint).getID(), 
				    sprintList.Sprint(sprint).getBacklogStats().getBacklogCount());
				// calculate burndown rate
			  sprintsComplete++;
			  burndownRate = ((double) sprintList.get().get(sprint).getBacklogStats().getBacklogCompleteCount())/(double)sprintsComplete;	
			  openBacklog = sprintList.get().get(sprint).getBacklogStats().getBacklogCount();
			  projectedSprints = sprintList.get().get(sprint).getID();
			}
		}
		// Start projection at end of burndown
		lineData.addPoint(projectionSeries, projectedSprints, (int)openBacklog);
		
		
		while (openBacklog > 0) {
			openBacklog -= burndownRate;
			if (openBacklog < 0) {
				openBacklog = 0;
			}
			projectedSprints++;
			lineData.addPoint(projectionSeries, projectedSprints, (int)openBacklog);	
		}
		
	  lineData.xAxisLabel = "Sprints";
	  lineData.yAxisLabel = "Backlog Items";
	  lineData.title = "Backlog Burndown Count";

		return lineData;
	}
	

	public ChartData<Integer, Integer> getSprintBurndownAreaStateData() {
		ChartData<Integer, Integer> data = new ChartData<Integer, Integer>();
		int series[] = new int[BacklogEntry.STATE.length]; 
		
		// Create a series for each State
		int i = 0;
		for (String state : BacklogEntry.STATE) {
			series[i] = data.addAreaSeries(state);
			data.addPoint(series[i++], 0, 0);
		}

		if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
		  // First point, Sprint 0 total number of backlog entries at the beginning of first sprint
	  	  data.addPoint(series[BacklogEntry.indexOf(BacklogEntry.STATE_OPEN)], 0, 
		        sprintList.Sprint(0).getBacklogStats().getTotalBacklogCount());
    }
		
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
		  i = 0;
		  if (sprintList.Sprint(sprint).getState().equals(Sprint.STATE_CLOSED)) {
		    for (String state : BacklogEntry.STATE) {
		  	  data.addPoint(series[i++], sprintList.Sprint(sprint).getID(), 
			        sprintList.Sprint(sprint).getBacklogStats().getUserStoryCount(state) + 
		  	          sprintList.Sprint(sprint).getBacklogStats().getChangeReqCount(state));

		    }
		  }
		}
		
	  data.xAxisLabel = "Sprints";
	  data.yAxisLabel = "Backlog Items";
	  data.title = "Backlog Items by State";

		return data;
	}
	

	public ChartData<Integer, Integer> getSprintBurndownAreaStatePoints() {
		ChartData<Integer, Integer> data = new ChartData<Integer, Integer>();
		int series[] = new int[BacklogEntry.STATE.length]; 
		
		// Create a series for each State
		int i = 0;
		for (String state : BacklogEntry.STATE) {
			series[i] = data.addAreaSeries(state);
			data.addPoint(series[i++], 0, 0);
		}

		if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
		  // First point, Sprint 0 total number of backlog entries at the beginning of first sprint
	  	  data.addPoint(series[BacklogEntry.indexOf(BacklogEntry.STATE_OPEN)], 0, 
		        sprintList.Sprint(0).getBacklogStats().getTotalBacklogPoints());
    }
		
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
		  i = 0;
		  if (sprintList.Sprint(sprint).getState().equals(Sprint.STATE_CLOSED)) {
		    for (String state : BacklogEntry.STATE) {
		  	  data.addPoint(series[i++], sprintList.Sprint(sprint).getID(), 
			        sprintList.Sprint(sprint).getBacklogStats().getUserStoryPoints(state) + 
		  	          sprintList.Sprint(sprint).getBacklogStats().getChangeReqPoints(state));

		    }
		  }
		}
		
	  data.xAxisLabel = "Sprints";
	  data.yAxisLabel = "Backlog Items";
	  data.title = "Backlog Points by State";

		return data;
	}
	

	public ChartData<Integer, Integer> getSprintBurndownAreaUsCr() {

		ChartData<Integer, Integer> data = new ChartData<Integer, Integer>();
		int usSeries, crSeries;
		
		// currently assuming sprints are in order
		usSeries = data.addAreaSeries("User Stories");
	  // At the current rate, project how many more sprints are needed to finish
    crSeries = data.addAreaSeries("Change Requests");  
		
    if ((sprintList.size() > 0) && (sprintList.Sprint(0).getState().equals(Sprint.STATE_CLOSED))) {
    	// TODO this assumes the first sprint is not deferred or deleted   
    	data.addPoint(usSeries, 0, sprintList.Sprint(0).getBacklogStats().getTotalUserStoryCount());
    	data.addPoint(crSeries, 0, sprintList.Sprint(0).getBacklogStats().getTotalChangeReqCount());
    }
    
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				// next closed sprint, get the backlog count for next point 
				data.addPoint(usSeries, sprintList.get().get(sprint).getID(), 
				    sprintList.Sprint(sprint).getBacklogStats().getUserStoryCount());
				data.addPoint(crSeries, sprintList.get().get(sprint).getID(), 
				    sprintList.Sprint(sprint).getBacklogStats().getChangeReqCount());
			}
		}
		
		data.xAxisLabel = "Sprints";
		data.yAxisLabel = "Backlog Items";
		data.title = "Backlog US-CR Count";

		return data;
	}
	
	
	
}
