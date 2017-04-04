package softwaremanagementtool.agile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import softwaremanagementtool.agile.ui.BacklogUi;
import softwaremanagementtool.agile.ui.BaseUi;
import softwaremanagementtool.agile.ui.DashboardUi;
import softwaremanagementtool.agile.ui.ReportsUi;
import softwaremanagementtool.agile.ui.SprintUi;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.db.AgileDatabase;

public class AgileProject {
  
   /**
   *  Class Attributes
   */
  
  private BorderPane mainLayout;
  private Stage primaryStage;
  private File file;
  private AgilePrjData prjData;
  private ProductBacklog productBacklog;
  private SprintList sprintList;
  private TaskList taskList;
  
  private BacklogList openProdBacklogList;
  private BacklogList sprintBacklogList;
  private TaskList sprintTaskList;
  
	private SprintUi sprintUi;
	private DashboardUi dashboardUi;
	private BacklogUi backlogUi;
	private ReportsUi reportsUi;

  /**
   *  Constructor
   */
  public AgileProject(
  		String mode, 
  		File inFile,
  		AgilePrjData agilePrjData, 
  		Stage inStage, 
  		BorderPane inLayout) 
  				throws IOException {
    
  	productBacklog = new ProductBacklog();
    sprintList = new SprintList();
    taskList = new TaskList();
    openProdBacklogList = new BacklogList();
    sprintBacklogList = new BacklogList();
    sprintTaskList = new TaskList();
    file = inFile;
  	
    // Open existing project
    if (mode.equals("OPEN")) {
    	load();
    } else {
    	prjData = agilePrjData;
    }
  	
    primaryStage = inStage;
    mainLayout = inLayout;

    // Create views
    sprintUi = new SprintUi(this);
    dashboardUi = new DashboardUi(this);
    backlogUi = new BacklogUi(this);
    reportsUi = new ReportsUi(this);
    
    showDashboard();
  }

  /**
   *  Scene methods
   *  
   */
  public void showDashboard() throws IOException {
    dashboardUi.show();
   // dashboardUi.showBurndownSprintCount();
    dashboardUi.showBurndownSprintPoints();
  }

  public  void showBacklog() throws IOException {
  	backlogUi.show();
  }
  
  public  void showSprintView() throws IOException {
  	sprintUi.show();
  }
  
  public  void showReportsView() throws IOException {
    reportsUi.show();
  }
  
  /**
   *  Get Stage and Layout methods 
   *  
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }
  
  public BorderPane getMainLayout() {
    return mainLayout;
  }
  
  public ObservableList<String> getUsers() {
  	return prjData.getUserList();
  }
  
  /**
   *  Load and Save methods 
   *  
   */
  public void save() {
  	// TODO get file from input
  	//File file = new File(prjData.xmlFileName());
  	//File file = new File("C:\\Users\\Stephen\\Desktop\\School\\SSW-695\\SMT\\test.xml");
  	
  	AgileDatabase db = new AgileDatabase(file, this);
	  db.save();
  }
  
  public void load() {
    // TODO get file from input
    //File file = new File(prjData.xmlFileName());
  	//File file = new File("test.xml");
  	
  	AgileDatabase db = new AgileDatabase(file, this);
		db.load();  	
  } 
  
  public AgilePrjData getPrjData() {
  	return prjData;
  }
  
  public void loadPrjData(AgilePrjData data) {
  	prjData = data;
  }
  
  public List<UserStory> getUserStories() {
  	ObservableList<UserStory> list = FXCollections.observableArrayList();
  	for (int i = 0; i < getBacklogList().size(); i++) {
  		if (getBacklogList().get(i).getType() == UserStory.type) {
  			list.add((UserStory) getBacklogList().get(i));
  		}
  	}
  	return list;
  }
  
  public void loadUserStories(List<UserStory> list) {
  	if (list == null) return;
  	for (int i = 0; i < list.size(); i++) {
  		getBacklogList().add(list.get(i));
  	}
  }
  
  public List<ChangeRequest> getChangeReqs() {
  	ObservableList<ChangeRequest> list = FXCollections.observableArrayList();
  	for (int i = 0; i < getBacklogList().size(); i++) {
  		if (getBacklogList().get(i).getType() == ChangeRequest.type) {
  			list.add((ChangeRequest) getBacklogList().get(i));
  		}
  	}
  	
  	return list;
  }
  
  public void loadChangeReqs(List<ChangeRequest> list) {
  	if (list == null) return;
  	for (int i = 0; i < list.size(); i++) {
  		getBacklogList().add(list.get(i));
  	}
  }
  
  public List<Sprint> getSprints() {
  	return sprintList.get();
  }
  
  public void loadSprints(List<Sprint> list) {
  	if (list == null) return;
  	for (int i = 0; i < list.size(); i++) {
  		sprintList.add(list.get(i));
  	}
  }
  
  public List<SprintTask> getTasks() {
  	return taskList.get();
  }
  
  public void loadTasks(List<SprintTask> list) {
  	if (list == null) return;
  	for (int i = 0; i < list.size(); i++) {
  		taskList.add(list.get(i));
  	}
  }
  
  /**
   *  Back log methods 
   *  
   */
  @SuppressWarnings("rawtypes")
	public void showBacklogEntry(BacklogEntry blEntry, BaseUi uiToShow) throws IOException {
  	uiToShow.showBacklogEntry(blEntry);
  }
  
  public void updateBacklogItem() {
  	backlogUi.updateBacklogItem();
  }
  
  @SuppressWarnings("rawtypes")
  public void leavingBacklogEntry(BacklogEntry blEntry, BaseUi blUi) {
  	blUi.leavingBacklogEntry(blEntry);
  }
  
  public void newUserStory() throws IOException {
    UserStory newUserStory = new UserStory();
    newUserStory.setID(productBacklog.nextId());
    getBacklogList().add(newUserStory);
    backlogUi.showNewEntry();
  } 
  
  public void newChangeRequest() throws IOException {
    ChangeRequest newChangeRequest = new ChangeRequest();
    newChangeRequest.setID(productBacklog.nextId());
    getBacklogList().add(newChangeRequest);
    backlogUi.showNewEntry();
  } 

  public ObservableList<BacklogEntry> getBacklogList() {
    return productBacklog.get();
  }
  

  /**
   *  Sprint Methods
   *  
   */
  public void newSprint() throws IOException {
    Sprint newSprint = new Sprint();
    newSprint.setID(sprintList.nextId());
    sprintList.get().add(newSprint);
    sprintUi.showNewSprint(newSprint);  	
  }
  
  public void saveSprintUpdates() throws IOException {
  	sprintUi.saveSprint(); 
  }
  
  public void sprintStateChangeReq(Sprint sprint, String newState) {
  	if (sprint.getState().equals(newState)) {
  		return;
  	}
  	if (newState.equals(Sprint.STATE_PROGRESS)) {
  		if (sprintList.isSprintInProgress()) {
  			// dont change another sprint in progress
  		}
  	}
  	if (newState.equals(Sprint.STATE_REVIEW)) {
  		sprint.setBacklogStats(productBacklog.getStats());
  	}
  	sprint.setState(newState);
  }
  
  public void showSprintDetails(Sprint sprint) {
  	sprintUi.showSprint(sprint); 
  }
  
  public ObservableList<Sprint> getSprintList() {
    return sprintList.get();
  }
  public SprintList sprintList() {
    return sprintList;
  }
  
  /**
   *  Sprint Backlog 
   *  
   */
  public ObservableList<BacklogEntry> getSprintBacklogList() {
  	sprintBacklogList.clear();
    for (int i = 0; i < productBacklog.get().size(); i++) {
    	if ( productBacklog.get().get(i).getSprintId() == sprintUi.currentSprint().getID()) {
    		sprintBacklogList.add(productBacklog.get().get(i));
    	}
    }
  	return sprintBacklogList.get();
  }
  
  public ObservableList<String> getSprintBacklogListStr() {
  	ObservableList<String> backlogList = FXCollections.observableArrayList();
    
    for (int i = 0; i < sprintBacklogList.size(); i++) {
    	backlogList.add(Integer.toString(sprintBacklogList.get().get(i).getID()));
    }
  	return backlogList;
  }
  
  public ObservableList<BacklogEntry> getOpenProdBacklogList() {
  	openProdBacklogList.clear();
  	for (int i=0; i< productBacklog.get().size(); i++ ) {
  		if (productBacklog.get().get(i).getState().equals(BacklogEntry.STATE_OPEN)) {
  			openProdBacklogList.add(productBacklog.get().get(i));
  		}
  	}
    return openProdBacklogList.get();
  }
  
  private void addBaacklogItemToSprint(BacklogEntry entry) {
  	openProdBacklogList.remove(entry);
  	sprintBacklogList.add(entry);
  	entry.setSprintId(sprintUi.currentSprint().getID());
  	entry.setState(BacklogEntry.STATE_ASSIGNED);
  }
  
  private void removeBaacklogItemToSprint(BacklogEntry entry) {
  	sprintBacklogList.remove(entry);
  	openProdBacklogList.add(entry);
  	entry.setSprintId(0);
  	entry.setState(BacklogEntry.STATE_OPEN);
  }
  
  public void moveSprintBacklogItem() {
  	if (sprintUi.getBacklogSlection().getState().equals(BacklogEntry.STATE_OPEN)) {
  		addBaacklogItemToSprint(sprintUi.getBacklogSlection());
  	} else {
  		removeBaacklogItemToSprint(sprintUi.getBacklogSlection());
  	}
  }
  
  
  /**
   *  Sprint Tasks 
   *  
   */
  public void newTask() {
  	SprintTask newTask = new SprintTask(); 
  	newTask.setSprintId(sprintUi.currentSprint().getID()); 
  	newTask.setId(taskList.nextId());
    taskList.add(newTask);
    sprintTaskList.add(newTask);
    sprintUi.showNewTask(newTask);
  }
  
  public ObservableList<SprintTask> getTaskList(Sprint sprint) {
    sprintTaskList.clear();
    for (int i=0; i<taskList.get().size(); i++) {
    	if (taskList.get().get(i).getSprintId() == sprintUi.currentSprint().getID()) {
    		sprintTaskList.add(taskList.get().get(i));
    	}
    }
  	return sprintTaskList.get();
  }
  

}  