package softwaremanagementtool.agile.ui;

import java.io.IOException;

import javafx.scene.layout.AnchorPane;
import softwaremanagementtool.agile.AgileProject;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.sprintview.SprintBacklogViewController;
import softwaremanagementtool.agile.sprintview.SprintInfoViewController;
import softwaremanagementtool.agile.sprintview.SprintRetrospectViewController;
import softwaremanagementtool.agile.sprintview.SprintReviewViewController;
import softwaremanagementtool.agile.sprintview.SprintTaskViewController;
import softwaremanagementtool.agile.sprintview.SprintViewController;
import softwaremanagementtool.agile.userstoryview.UserStoryViewController;

public class SprintUi extends BaseUi<SprintViewController> {
	
	private AnchorPane sprintLayout;
	private SprintInfoViewController infoViewController;
	private SprintBacklogViewController backlogViewController;
	private UserStoryViewController userStoryController;
	private SprintTaskViewController taskViewController;
	private SprintReviewViewController reviewViewController;
	private SprintRetrospectViewController retrospectViewController;
	
	private final String FXML_SPRINT_VIEW = "agile/sprintview/SprintView.fxml";
	private final String FXML_SPRINT_INFO_VIEW = "agile/sprintview/SprintInfoView.fxml";
	private final String FXML_SPRINT_BACKLOG_VIEW = "agile/sprintview/SprintBacklogView.fxml";
	private final String FXML_USER_STORY_VIEW = "agile/userstoryview/UserStoryView.fxml";
	private final String FXML_SPRINT_TASK_VIEW = "agile/sprintview/SprintTasksView.fxml";
	private final String FXML_SPRINT_REVIEW_VIEW = "agile/sprintview/SprintReviewView.fxml";
	private final String FXML_SPRINT_RETROSPECT_VIEW = "agile/sprintview/SprintRetrospectView.fxml";
	
	
	public  SprintUi(AgileProject parent) throws IOException {
		loadView(parent, FXML_SPRINT_VIEW);
  	classController.setAgilePrj(agilePrj);
    
  	infoViewController = (SprintInfoViewController) loadSubView(classController.getSprintInfoPane(), FXML_SPRINT_INFO_VIEW);
  	backlogViewController = (SprintBacklogViewController) loadSubView(classController.getSprintBacklogPane(), FXML_SPRINT_BACKLOG_VIEW);
  	userStoryController = (UserStoryViewController) loadSubView(backlogViewController.getBacklogEntryPane(), FXML_USER_STORY_VIEW); 
  	//userstoryPane.setVisible(false); ???
  	taskViewController = (SprintTaskViewController) loadSubView(classController.getSprintTaskPane(), FXML_SPRINT_TASK_VIEW);
  	reviewViewController = (SprintReviewViewController) loadSubView(classController.getSprintReviewPane(), FXML_SPRINT_REVIEW_VIEW);
  	retrospectViewController = (SprintRetrospectViewController) loadSubView(classController.getSprintRetrospctPane(), FXML_SPRINT_RETROSPECT_VIEW);
  	     
	}
	
	public void showSprint(Sprint sprint) {
	  infoViewController.showSprint(sprint);
	}
	
	public void addSprint(Sprint sprint)  {
    showSprint(sprint);
    //backlogViewController.setLast();
    
  }
}
