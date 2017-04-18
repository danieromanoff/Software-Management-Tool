package softwaremanagementtool.agile.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintList;
import softwaremanagementtool.agile.SprintTask;

public class SprintData {

	private AgileProject agilePrj;
	private SprintList sprintList;
	
	public SprintData(AgileProject inPrj) {
		agilePrj = inPrj;
		sprintList = agilePrj.sprintList();
  }
	
	private int estTime(ObservableList<SprintTask> tasks) {
		int time = 0;
		for (int i = 0; i < tasks.size(); i++) {
			time += tasks.get(i).getEstTime();
		}
		return time;
	}
	
	private int actTime(ObservableList<SprintTask> tasks) {
		int time = 0;
		for (int i = 0; i < tasks.size(); i++) {
			time += tasks.get(i).getActTime();
		}
		return time;
	}
	
	private int estTime(ObservableList<SprintTask> tasks, int backlog) {
		int time = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getBacklogRef() == backlog) {
			   time += tasks.get(i).getEstTime();
			}
		}
		return time;
	}
	
	private int actTime(ObservableList<SprintTask> tasks, int backlog) {
		int time = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getBacklogRef() == backlog) {
			   time += tasks.get(i).getActTime();
			}
		}
		return time;
	}
	
	public ChartData<String, Integer> getTaskBarData() {
		
		ChartData<String, Integer> data = new ChartData<String, Integer>();
		int estSeries, actSeries;
		ObservableList<SprintTask> tasks;

		estSeries = data.addLineSeries("Estimate Time (m)");
		actSeries = data.addLineSeries("Actual Time (m)");  
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
				tasks = agilePrj.getTaskList(sprintList.get().get(sprint));
				data.addPoint(estSeries, Integer.toString(sprintList.get().get(sprint).getID()), estTime(tasks));
				data.addPoint(actSeries, Integer.toString(sprintList.get().get(sprint).getID()), actTime(tasks));
		}
		
		data.xAxisLabel = "Sprints";
		data.yAxisLabel = "Total Task Times (m)";
		data.title = "Task Estimation";

	  return data;
		
	}
	
	public ChartData<String, Integer> getStoryPointBarData() {
		
		ChartData<String, Integer> data = new ChartData<String, Integer>();
		int estSeries, actSeries;
		ObservableList<SprintTask> tasks;
		ObservableList<BacklogEntry> backlog = agilePrj.getBacklogList();

		estSeries = data.addLineSeries("Estimate Time (m)");
		actSeries = data.addLineSeries("Actual Time (m)");  
		
		tasks = agilePrj.getTaskList().get();
		
		
		for (int item = 0; item < backlog.size(); item++) {
			if (backlog.get(item).getState().equals(BacklogEntry.STATE_CLOSED)) {
				String xPnt = Integer.toString(backlog.get(item).getID()) + "[" + Integer.toString(backlog.get(item).getStoryPoints()) + "]";
			  data.addPoint(estSeries, xPnt, estTime(tasks, backlog.get(item).getID())/backlog.get(item).getStoryPoints());
			  data.addPoint(actSeries, xPnt, actTime(tasks, backlog.get(item).getID())/backlog.get(item).getStoryPoints());
			}
		}
		
		data.xAxisLabel = "Backlog ID [sp]";
		data.yAxisLabel = "Story Points (m/sp)";
		data.title = "Story Point Estimation";

	  return data;
		
	}
	
public ChartData<String, Integer> getTestBarData() {
		
		ChartData<String, Integer> data = new ChartData<String, Integer>();
		int numSeries, attemptSeries, passSeries;

		numSeries = data.addLineSeries("Number of Tests");
		attemptSeries = data.addLineSeries("Tests Attempted");  
		passSeries = data.addLineSeries("Tests Passed");  
				
		
		for (int sprint = 0; sprint < sprintList.size(); sprint++) {
			if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
				
				data.addPoint(numSeries, Integer.toString(sprintList.get().get(sprint).getID()), sprintList.get().get(sprint).getNumTests());
				data.addPoint(attemptSeries, Integer.toString(sprintList.get().get(sprint).getID()), sprintList.get().get(sprint).getTestsAttempted());
				data.addPoint(passSeries, Integer.toString(sprintList.get().get(sprint).getID()), sprintList.get().get(sprint).getTestsPassed());
			}
		}
		
		data.xAxisLabel = "Sprint";
		data.yAxisLabel = "Tests";
		data.title = "Testing Status";

	  return data;
		
	}

  public ChartData<String, Integer> getSlocData() {
	
	  ChartData<String, Integer> data = new ChartData<String, Integer>();

	  int slocSeries = data.addLineSeries("SLOC");
	
	  for (int sprint = 0; sprint < sprintList.size(); sprint++) {
		  if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  data.addPoint(slocSeries, Integer.toString(sprintList.get().get(sprint).getID()), sprintList.get().get(sprint).getEndSloc());
		  }
	  }
	
	  data.xAxisLabel = "Sprint";
	  data.yAxisLabel = "SLOC";
	  data.title = "SLOC Tracking";

    return data;
	
  }
  
  public ChartData<String, Integer> getNumFilesData() {
  	
	  ChartData<String, Integer> data = new ChartData<String, Integer>();

	  int filesSeries = data.addLineSeries("Number of Files");

	  for (int sprint = 0; sprint < sprintList.size(); sprint++) {
		  if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_CLOSED)) {
			  data.addPoint(filesSeries, Integer.toString(sprintList.get().get(sprint).getID()), sprintList.get().get(sprint).getEndNumFiles());
		  }
	  }
	
	  data.xAxisLabel = "Sprint";
	  data.yAxisLabel = "Num Files";
	  data.title = "File Tracking";

    return data;
	
  }

 public ObservableList<PieChart.Data>  getCurrentSprintTaskData() {
  	
	 ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(); //TODO create a task
	 ObservableList<SprintTask> tasks;
	 int complete = 0, draft = 0, progress = 0;

	  for (int sprint = 0; sprint < sprintList.size(); sprint++) {
		  if (sprintList.get().get(sprint).getState().equals(Sprint.STATE_PROGRESS)) {
		  	tasks = agilePrj.getTaskList(sprintList.get().get(sprint));
		  	for (int i = 0; i < tasks.size(); i++) {
					if (tasks.get(i).getStatus().equals(SprintTask.STATUS_COMPLETE)){
						complete += tasks.get(i).getActTime();
					} else if (tasks.get(i).getStatus().equals(SprintTask.STATUS_DRAFT)){
						draft += tasks.get(i).getEstTime();
					} else if (tasks.get(i).getStatus().equals(SprintTask.STATUS_PROGRESS)){
						progress += tasks.get(i).getEstTime();
					}
				}
		  }
	  }
	  pieChartData.add(new PieChart.Data("Complete", complete));
	  pieChartData.add(new PieChart.Data("Draft", draft));
	  pieChartData.add(new PieChart.Data("InProgress", progress));

	  // setTitle("Current Sprint Task Status");

    return pieChartData;
	
  }
  
}
