package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

import javafx.collections.ObservableList;
import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.ChangeRequest;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.UserStory;

public class Sprint_Test {

	@Test
	public void test_id() {
		Sprint sprint = new Sprint();
		sprint.setID(123);
		assertEquals(sprint.getID(), 123);
		assertEquals(sprint.IDProperty().get(), 123);
	}
	
	@Test
	public void test_startDate() {
		Sprint sprint = new Sprint();
		LocalDate today = LocalDate.now();
		sprint.setStartDate(today); 
		assertEquals(sprint.getStartDate(), today);
		assertEquals(sprint.startDateProperty().get(), today);
	}
	
	@Test
	public void test_endDate() {
		Sprint sprint = new Sprint();
		LocalDate today = LocalDate.now();
		sprint.setEndDate(today); 
		assertEquals(sprint.getEndDate(), today);
		assertEquals(sprint.endDateProperty().get(), today);
	}
	
	@Test
	public void test_state() {
		Sprint sprint = new Sprint();
		sprint.setState(Sprint.STATE[1]); 
		assertEquals(sprint.getState(), Sprint.STATE[1]);
		assertEquals(sprint.stateProperty().get(), Sprint.STATE[1]);
	}
	
/*	@Test  TODO Remove???
 	public void test_sprintBacklog() {
		ObservableList<BacklogEntry> sprintBacklog;
		Sprint sprint = new Sprint();
		UserStory us = new UserStory();
		sprint.addToBacklog(us); 
		UserStory us2 = new UserStory();
		sprint.addToBacklog(us2);
		sprintBacklog = sprint.sprintBacklog();
		assertEquals(sprintBacklog.get(0).getID(), us.getID());
		assertEquals(sprintBacklog.get(1).getID(), us2.getID());
	} */
	
/*	@Test TODO Remove????
	public void test_issuesOpened() {
		ObservableList<Integer> issues;
		Sprint sprint = new Sprint();
		ChangeRequest cr = new ChangeRequest();
		sprint.addToIssues(cr); 
		ChangeRequest cr2 = new ChangeRequest();
		sprint.addToIssues(cr2);
		issues = sprint.issuesOpened();
		assertEquals(issues.get(0), (Integer) 7);//TODO cr.getID());
		assertEquals(issues.get(1), (Integer) 7);//TODO cr2.getID());
	} */
	
	@Test
	public void test_numFiles() {
		Sprint sprint = new Sprint();
		sprint.setEndNumFiles(25);
		assertEquals(sprint.getEndNumFiles(), 25);
		assertEquals(sprint.endNumFilesProperty().get(), 25);
	}
	
	@Test
	public void test_sloc() {
		Sprint sprint = new Sprint();
		sprint.setEndSloc(1234);
		assertEquals(sprint.getEndSloc(), 1234);
		assertEquals(sprint.endSlocProperty().get(), 1234);
	}
	
	@Test
	public void test_review() {
		Sprint sprint = new Sprint();
		sprint.setReviewNotes("This is the results of the Spint"); 
		assertEquals(sprint.getReviewNotes(), "This is the results of the Spint");
		assertEquals(sprint.reviewNotesProperty().get(), "This is the results of the Spint");
	}
	
	@Test
	public void test_retrospectiveWell() {
		Sprint sprint = new Sprint();
		sprint.setRetrospectiveWell("This was good"); 
		assertEquals(sprint.getRetrospectiveWell(), "This was good");
		assertEquals(sprint.retrospectiveWellProperty().get(), "This was good");
	}
	
	@Test
	public void test_retrospectiveNotSo() {
		Sprint sprint = new Sprint();
		sprint.setRetrospectiveNotSo("This was bad"); 
		assertEquals(sprint.getRetrospectiveNotSo(), "This was bad");
		assertEquals(sprint.retrospectiveNotSoProperty().get(), "This was bad");
	}
	
	@Test
	public void test_numTests() {
		Sprint sprint = new Sprint();
		sprint.setNumTests(52);
		assertEquals(sprint.getNumTests(), 52);
		assertEquals(sprint.numTestsProperty().get(), 52);
	}
	
	@Test
	public void test_testsAttempted() {
		Sprint sprint = new Sprint();
		sprint.setTestsAttempted(51);
		assertEquals(sprint.getTestsAttempted(), 51);
		assertEquals(sprint.testsAttemptedProperty().get(), 51);
	}
	
	@Test
	public void test_testsPassed() {
		Sprint sprint = new Sprint();
		sprint.setTestsPassed(49);
		assertEquals(sprint.getTestsPassed(), 49);
		assertEquals(sprint.testsPassedProperty().get(), 49);
	}
}
