package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import softwaremanagementtool.agile.UserStory;

public class UserStory_Test {

	@Test
	public void test_type() {
		UserStory us = new UserStory();
		assertEquals(us.getType(),"UserStory");
	}
	
	@Test
	public void test_userStory() {
		UserStory us = new UserStory();
		us.setUserStory("This is a user story test");
		assertEquals(us.getUserStory(),"This is a user story test");
		assertEquals(us.userStoryProperty().get(),"This is a user story test");
	}
	
	@Test
	public void test_priority() {
		UserStory us = new UserStory();
		us.setPriority(5);
		assertEquals(us.getPriority(), 5);
		assertEquals(us.priorityProperty().get(), 5);
	}

	@Test
	public void test_acceptanceTest() {
		UserStory us = new UserStory();
		us.setAcceptanceCriteria("Test This User Story");;
		assertEquals(us.getAcceptanceCriteria(), "Test This User Story");
		assertEquals(us.acceptanceCriteriaProperty().get(), "Test This User Story");
	}
	
	@Test
	public void test_dateCreated() {
		UserStory us = new UserStory();
		LocalDate today = LocalDate.now();
		us.setDateCreated(today); 
		assertEquals(us.getDateCreated(), today);
		assertEquals(us.dateCreatedProperty().get(), today);
	}
	
	@Test
	public void test_id() {
		UserStory us = new UserStory();
		us.setID(123);
		assertEquals(us.getID(), 123);
		assertEquals(us.IDProperty().get(), 123);
	}
	
	@Test
	public void test_title() {
		UserStory us = new UserStory();
		us.setTitle("This is a User Story");;
		assertEquals(us.getTitle(), "This is a User Story");
		assertEquals(us.titleProperty().get(), "This is a User Story");
	}
	
	@Test
	public void test_state() {
		UserStory us = new UserStory();
		us.setState(UserStory.STATE[0]);;
		assertEquals(us.getState(), UserStory.STATE[0]);
		assertEquals(us.stateProperty().get(), UserStory.STATE[0]);
	}
	
	@Test
	public void test_storyPoints() {
		UserStory us = new UserStory();
		us.setStoryPoints(UserStory.STORY_POINTS[0]);;
		assertEquals(us.getStoryPoints(), UserStory.STORY_POINTS[0]);
		assertEquals(us.storyPointsProperty().get(), UserStory.STORY_POINTS[0]);
	}
	
}
