package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintTask;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.backlogview.BacklogViewController;
import softwaremanagementtool.agile.changereqview.ChangeReqViewController;
import softwaremanagementtool.agile.sprintview.SprintBacklogViewController;
import softwaremanagementtool.agile.sprintview.SprintInfoViewController;
import softwaremanagementtool.agile.sprintview.SprintRetrospectViewController;
import softwaremanagementtool.agile.sprintview.SprintReviewViewController;
import softwaremanagementtool.agile.sprintview.SprintTaskViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

public class SprintUi extends BaseUi<SprintViewController> {
	
	//private AnchorPane sprintLayout;
	private SprintInfoViewController infoViewController;
	private SprintBacklogViewController backlogViewController;
	private UserStoryViewController userStoryController;
	private ChangeReqViewController changeReqController;
	private SprintTaskViewController taskViewController;
	private SprintReviewViewController reviewViewController;
	private SprintRetrospectViewController retrospectViewController;
	private BacklogViewController sprintBlViewController;
	private BacklogViewController prodOpenBlViewController;
	
	private final String FXML_SPRINT_VIEW = "agile/sprintview/SprintView.fxml";
	private final String FXML_SPRINT_INFO_VIEW = "agile/sprintview/SprintInfoView.fxml";
	private final String FXML_SPRINT_BACKLOG_VIEW = "agile/sprintview/SprintBacklogView.fxml";
	private final String FXML_BACKLOG_VIEW = "agile/backlogview/BacklogView.fxml";
	private final String FXML_USER_STORY_VIEW = "agile/userstoryview/UserStoryView.fxml";
	private final String FXML_CHANGE_REQ_VIEW = "agile/changereqview/ChangeReqView.fxml";
	private final String FXML_SPRINT_TASK_VIEW = "agile/sprintview/SprintTasksView.fxml";
	private final String FXML_SPRINT_REVIEW_VIEW = "agile/sprintview/SprintReviewView.fxml";
	private final String FXML_SPRINT_RETROSPECT_VIEW = "agile/sprintview/SprintRetrospectView.fxml";
	
	
	public  SprintUi(AgileProject parent) throws IOException {
		loadView(parent, FXML_SPRINT_VIEW);
  	classController.setAgilePrj(agilePrj);
    
  	infoViewController = (SprintInfoViewController) loadSubView(classController.getSprintInfoPane(), FXML_SPRINT_INFO_VIEW);
  	backlogViewController = (SprintBacklogViewController) loadSubView(classController.getSprintBacklogPane(), FXML_SPRINT_BACKLOG_VIEW);
  	backlogViewController.setAgilePrj(agilePrj);
  	sprintBlViewController = (BacklogViewController) loadSubView(backlogViewController.getSprintBacklogPane(), FXML_BACKLOG_VIEW);
  	sprintBlViewController.setDisplayUi(this);
  	prodOpenBlViewController = (BacklogViewController) loadSubView(backlogViewController.getProductBacklogPane(), FXML_BACKLOG_VIEW);
  	prodOpenBlViewController.setDisplayUi(this);
  	
  	userStoryController = (UserStoryViewController) loadSubView(backlogViewController.getBacklogEntryPane(), FXML_USER_STORY_VIEW);
    userStoryController.setPane( (AnchorPane) backlogViewController.getBacklogEntryPane().getChildren().get(0));
    userStoryController.setAgilePrj(agilePrj);
    userStoryController.setVisable(false);
    changeReqController = (ChangeReqViewController) loadSubView(backlogViewController.getBacklogEntryPane(), FXML_CHANGE_REQ_VIEW);
    changeReqController.setPane( (AnchorPane) backlogViewController.getBacklogEntryPane().getChildren().get(1));
    changeReqController.setAgilePrj(agilePrj);
    changeReqController.setVisable(false);
  
  	taskViewController = (SprintTaskViewController) loadSubView(classController.getSprintTaskPane(), FXML_SPRINT_TASK_VIEW);
  	taskViewController.setAgilePrj(agilePrj);
  	reviewViewController = (SprintReviewViewController) loadSubView(classController.getSprintReviewPane(), FXML_SPRINT_REVIEW_VIEW);
  	retrospectViewController = (SprintRetrospectViewController) loadSubView(classController.getSprintRetrospctPane(), FXML_SPRINT_RETROSPECT_VIEW);
  	     
	}
	
	public void showSprint(Sprint sprint) {
		if (sprint != null) {
	    infoViewController.showSprint(sprint);
	    sprintBlViewController.setAgilePrj(agilePrj, agilePrj.getSprintBacklogList(sprint));
	    prodOpenBlViewController.setAgilePrj(agilePrj, agilePrj.getOpenProdBacklogList());
	    backlogViewController.showSprint(sprint);
	    taskViewController.showSprint(sprint);
	    reviewViewController.showSprint(sprint);
	    retrospectViewController.showSprint(sprint);
		}
	}
	
	public void showNewSprint(Sprint sprint)  {
    showSprint(sprint);
    classController.setLast();
  }
	
	public void saveSprint() {
	  Sprint sprint = currentSprint();
    if (sprint != null) {
    	infoViewController.saveSprint(sprint);
    	backlogViewController.saveSprint(sprint);
  	  taskViewController.saveSprint(sprint);
  	  reviewViewController.saveSprint(sprint);
  	  retrospectViewController.saveSprint(sprint);
    }
  }
	
	public Sprint currentSprint() {
		return classController.getSelectedItem();
	}
	
	public void showBacklogEntry(BacklogEntry blEntry) throws IOException {
		boolean prodBl = false;
		if (blEntry != null) {
      if (blEntry.getType().equals("UserStory")) {
        userStoryController.showUserStoryDetails((UserStory) blEntry);
        userStoryController.setVisable(true);
        changeReqController.setVisable(false);
        prodBl = blEntry.getState().equals(BacklogEntry.STATE_OPEN);
      }
      else if (blEntry.getType().equals("ChangeRequest")) {
      	changeReqController.showChangeRequestDetails((ChangeRequest) blEntry);
      	userStoryController.setVisable(false);
      	changeReqController.setVisable(true);
      	prodBl = ((ChangeRequest)blEntry).getState().equals("Open");
      }
      if (prodBl) {
      	sprintBlViewController.setNoSelection();
      	backlogViewController.setButtonAdd();
      }
      else {
      	prodOpenBlViewController.setNoSelection();
      	backlogViewController.setButtonRemove();
      }
    } 
  }
	
	public BacklogEntry getBacklogSlection() {
		BacklogEntry entry;
		entry = sprintBlViewController.getSelectedItem();
		if (entry == null) {
			entry = prodOpenBlViewController.getSelectedItem();
		}
		return entry;
	}
	
	
	public void showNewTask(SprintTask task) {
		taskViewController.showSprint(currentSprint());
		taskViewController.showSprintTaskDetails(task);
		taskViewController.setLast();
	}
	
	public void show() {
  	super.show();
  	classController.setFirst();
  	showSprint(classController.getSelectedItem());
	}
}
