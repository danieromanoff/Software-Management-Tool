package softwaremanagementtool.agile.db;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import softwaremanagementtool.agile.AgilePrjData;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintTask;
import softwaremanagementtool.agile.UserStory;

/*
 *class  to wrap a list of US( user story ). This is used for saving the list of US( user story ) to XML.
 */

@XmlRootElement(name = "agileproject")
public class AgileXmlWrapper 
{
	private AgilePrjData prjData;
  private List<UserStory> userStories;
  private List<ChangeRequest> changeReqs;
  private List<Sprint> sprints;
  private List<SprintTask> tasks;

  @XmlElement(name = "prjdata")
  public AgilePrjData getPrjData() 
  {
    return prjData;
  }
  public void setPrjData(AgilePrjData inData) 
  {
    this.prjData = inData;
  }
  
  @XmlElement(name = "userstory")
  public List<UserStory> getUserStories() 
  {
    return userStories;
  }
  public void setUserStories(List<UserStory> inUserStories) 
  {
    this.userStories = inUserStories;
  }
    
  @XmlElement(name = "changereq")
  public List<ChangeRequest> getChangeReqs() 
  {
    return changeReqs;
  }
  public void setChangeReqs(List<ChangeRequest> changeReqs) 
  {
    this.changeReqs = changeReqs;
  }
    
  @XmlElement(name = "sprints")
  public List<Sprint> getSprints() 
  {
    return sprints;
  }
  public void setSprints(List<Sprint> sprints) 
  {
    this.sprints = sprints;
  }
    
  @XmlElement(name = "tasks")
  public List<SprintTask> getTasks() 
  {
    return tasks;
  }
  public void setTasks(List<SprintTask> tasks) 
  {
    this.tasks = tasks;
  }
    
}
