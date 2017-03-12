package softwaremanagementtool.agile.db;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import softwaremanagementtool.agile.AgileProject;

public class AgileXmlDatabase {
	
	private File file;
	private AgileProject agilePrj;
	private Marshaller writer;
	AgileXmlWrapper writeWrapper;
	private Unmarshaller reader;
	AgileXmlWrapper readWrapper;
	
	public AgileXmlDatabase(File inFile, AgileProject inAgilePrj) throws JAXBException {
		file = inFile;
		agilePrj = inAgilePrj;
		JAXBContext context = JAXBContext.newInstance(  AgileXmlWrapper.class);
	  writer = context.createMarshaller();
	  writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	  writeWrapper = new AgileXmlWrapper();
		
	  reader = context.createUnmarshaller();
		
	}

  //saving data to xml file
  public void saveDataToFile() throws JAXBException { 
  	
  	writeWrapper.setUserStories(agilePrj.getUserStories());
  	writeWrapper.setChangeReqs(agilePrj.getChangeReqs());

  	
  	writer.marshal(writeWrapper, file);
         
  }
	
  public void loadDataFromFile() throws JAXBException {
  	
  	readWrapper = (AgileXmlWrapper) reader.unmarshal(file);
  	agilePrj.loadUserStories(readWrapper.getUserStories());
  	agilePrj.loadChangeReqs(readWrapper.getChangeReqs());
  	    
  }
	
}
