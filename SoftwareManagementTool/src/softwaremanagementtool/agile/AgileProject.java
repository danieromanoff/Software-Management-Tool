package softwaremanagementtool.agile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import softwaremanagementtool.agile.ui.BacklogUi;
import softwaremanagementtool.agile.ui.DashboardUi;
import softwaremanagementtool.agile.ui.ReportsUi;
import softwaremanagementtool.agile.ui.SprintUi;
import softwaremanagementtool.agile.UserStory;
import softwaremanagementtool.agile.db.AgileXmlDatabase;

public class AgileProject {
  
   /**
   *  Class Attributes
   */
  
  private BorderPane mainLayout;
  private Stage primaryStage;
  private ProductBacklog productBacklog;
  private SprintList sprintList;
	private SprintUi sprintUi;
	private DashboardUi dashboardUi;
	private BacklogUi backlogUi;
	private ReportsUi reportsUi;

  /**
   *  Constructor
   */
  public AgileProject(String mode, Stage inStage, BorderPane inLayout) throws IOException {
    
    primaryStage = inStage;
    mainLayout = inLayout;
    productBacklog = new ProductBacklog();
    sprintList = new SprintList();
    // Create views
    sprintUi = new SprintUi(this);
    dashboardUi = new DashboardUi(this);
    backlogUi = new BacklogUi(this);
    reportsUi = new ReportsUi(this);
    if (mode.equals("OPEN")) {
    	load();
    }
    showDashboard();
  }

  /**
   *  Scene methods
   *  
   */
  public void showDashboard() throws IOException {
    dashboardUi.show();
  }

  public  void showBacklog() throws IOException {
    // Frame to hold backlog view
  	backlogUi.show();
  }
  
  public  void showSprintView() throws IOException {
  	sprintUi.show();
  }
  
  public  void showReportsView() throws IOException {
    reportsUi.show();
  }
  
  /**
   *  Back log methods 
   *  
   */
  public void showBacklogEntry(BacklogEntry blEntry) throws IOException {
  	backlogUi.showBacklogEntry(blEntry);
  }
  
  public void updateBacklogItem() {
  	backlogUi.updateBacklogItem();
  }
  
  public void newUserStory() throws IOException {
    UserStory newUserStory = new UserStory();
    newUserStory.setID(productBacklog.nextId());
    getBacklogList().add(newUserStory);
    backlogUi.addUserStory(newUserStory);
    
  } 
  
  public void newChangeRequest() throws IOException {
    ChangeRequest newChangeRequest = new ChangeRequest();
    newChangeRequest.setID(productBacklog.nextId());
    getBacklogList().add(newChangeRequest);
    backlogUi.addChangeRequest(newChangeRequest);

  } 

  public ObservableList<BacklogEntry> getBacklogList() {
    return productBacklog.backlogList();
  }
  
  /**
   *  
   *  
   *
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }
  
  public BorderPane getMainLayout() {
    return mainLayout;
  }

  /**
   *  Sprint Methods
   *  
   *
   */
  public void newSprint() throws IOException {
    Sprint newSprint = new Sprint();
    newSprint.setID(sprintList.nextId());
    sprintList.get().add(newSprint);
    //sprintViewController.showUserSprint(newSprint); TODO
    //sprintViewController.setLastListItem();
  	
    
  }
  
  public void save() {

  	
  	File file = new File("test.xml");
  	
  	AgileXmlDatabase db;
		try {
			db = new AgileXmlDatabase(file, this);
			db.saveDataToFile();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void load() {
  	
    File file = new File("test.xml");
  	
  	AgileXmlDatabase db;
		try {
			db = new AgileXmlDatabase(file, this);
			db.loadDataFromFile();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
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
  	
  	for (int i = 0; i < list.size(); i++) {
  		getBacklogList().add(list.get(i));
  	}
  }
  
  public List<Sprint> getSprints() {
  	return sprintList.get();
  }
  
  public void loadSprints(List<Sprint> list) {
  	
  	for (int i = 0; i < list.size(); i++) {
  		sprintList.add(list.get(i));
  	}
  }
}  