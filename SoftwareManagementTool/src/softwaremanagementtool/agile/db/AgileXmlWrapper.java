package softwaremanagementtool.agile.db;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.UserStory;

/*
 *class  to wrap a list of US( user story ). This is used for saving the list of US( user story ) to XML.
 */

@XmlRootElement(name = "agileproject")
public class AgileXmlWrapper 
{
    private List<UserStory> userStories;
    private List<ChangeRequest> changeReqs;

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
    
}
