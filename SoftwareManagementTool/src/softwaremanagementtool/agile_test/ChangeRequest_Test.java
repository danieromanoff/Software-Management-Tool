package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import softwaremanagementtool.agile.ChangeRequest;

public class ChangeRequest_Test {

	@Test
	public void test_type() {
		ChangeRequest cr = new ChangeRequest();
		assertEquals(cr.getType(),ChangeRequest.type);
	}
	
	@Test
	public void test_changeReq() {
		ChangeRequest cr = new ChangeRequest();
		cr.setChangeRequest("This is a change req test");
		assertEquals(cr.getChangeRequest(),"This is a change req test");
		assertEquals(cr.changeReqProperty().get(),"This is a change req test");
	}
	
	@Test
	public void test_priority() {
		ChangeRequest cr = new ChangeRequest();
		cr.setPriority(5);
		assertEquals(cr.getPriority(), 5);
		assertEquals(cr.priorityProperty().get(), 5);
	}

	@Test
	public void test_acceptanceTest() {
		ChangeRequest cr = new ChangeRequest();
		cr.setJustification("issue");;
		assertEquals(cr.getJustification(), "issue");
		assertEquals(cr.justificationProperty().get(), "issue");
	}
	
	@Test
	public void test_dateCreated() {
		ChangeRequest cr = new ChangeRequest();
		LocalDate today = LocalDate.now();
		cr.setDateCreated(today); 
		assertEquals(cr.getDateCreated(), today);
		assertEquals(cr.dateCreatedProperty().get(), today);
	}
	
	@Test
	public void test_id() {
		ChangeRequest cr = new ChangeRequest();
		cr.setID(123);
		assertEquals(cr.getID(), 123);
		assertEquals(cr.IDProperty().get(), 123);
	}
	
	@Test
	public void test_title() {
		ChangeRequest cr = new ChangeRequest();
		cr.setTitle("This is a Change Req");;
		assertEquals(cr.getTitle(), "This is a Change Req");
		assertEquals(cr.titleProperty().get(), "This is a Change Req");
	}
	
	@Test
	public void test_state() {
		ChangeRequest cr = new ChangeRequest();
		cr.setState(ChangeRequest.STATE[0]);;
		assertEquals(cr.getState(), ChangeRequest.STATE[0]);
		assertEquals(cr.stateProperty().get(), ChangeRequest.STATE[0]);
	}
	
	@Test
	public void test_storyPoints() {
		ChangeRequest cr = new ChangeRequest();
		cr.setStoryPoints(ChangeRequest.STORY_POINTS[0]);;
		assertEquals(cr.getStoryPoints(), ChangeRequest.STORY_POINTS[0]);
		assertEquals(cr.storyPointsProperty().get(), ChangeRequest.STORY_POINTS[0]);
	}

}
