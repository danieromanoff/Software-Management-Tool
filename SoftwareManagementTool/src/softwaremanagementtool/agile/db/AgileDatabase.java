package softwaremanagementtool.agile.db;

import java.io.File;

import javax.xml.bind.JAXBException;

import softwaremanagementtool.agile.AgileProject;

public class AgileDatabase {

	private AgileXmlDatabase db;
	
	public AgileDatabase(File file, AgileProject agilePrj) {
		try {
			db = new AgileXmlDatabase(file, agilePrj);
		} catch (JAXBException e) {
			// TODO Handle
			e.printStackTrace();
		}
	}
	
	public void save() {
		xmlSave(); // currently only XML supported
	}
	
	public void load() {
		xmlLoad(); // currently only XML supported
	}
	
	private void xmlSave() {
	  try {
			db.saveDataToFile();
		} catch (JAXBException e) {
			// TODO Handle
			e.printStackTrace();
		}
	}
	
	private void xmlLoad() {
	  try {
			db.loadDataFromFile();
		} catch (JAXBException e) {
			// TODO Handle
			e.printStackTrace();
		}
	}
	
}
