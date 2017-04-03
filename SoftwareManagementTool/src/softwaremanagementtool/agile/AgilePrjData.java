package softwaremanagementtool.agile;

import javax.xml.bind.annotation.XmlElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AgilePrjData {

	@XmlElement
	private ObservableList<String> prjUsers = FXCollections.observableArrayList();
	private String name;
	private String description;
	
	public int numUsers() {
		return prjUsers.size();
	}
	public String getUser(int index) {
		return prjUsers.get(index);
	}
	public void addUser(String user) {
		prjUsers.add(user);
	}
	public ObservableList<String> getUserList() {
		return prjUsers;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String inName) {
		name = inName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String inDesc) {
		description = inDesc;
	}

}
