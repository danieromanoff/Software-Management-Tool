package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;

import org.junit.Test;

import softwaremanagementtool.agile.SprintTask;

public class SprintTask_Test {
	
	@Test
	public void test_id() {
		SprintTask task = new SprintTask();
		task.setId(111);
		assertEquals(task.getId(), 111);
		assertEquals(task.IDProperty().get(), 111);
	}
	
	@Test
	public void test_assignee() {
		SprintTask task = new SprintTask();
		task.setAssignee("John Smith");
		assertEquals(task.getAssignee(), "John Smith");
		assertEquals(task.assigneeProperty().get(), "John Smith");
	}
	
	@Test
	public void test_theTask() {
		SprintTask task = new SprintTask();
		task.setTheTask("Refactor the SprintTask class");
		assertEquals(task.getTheTask(), "Refactor the SprintTask class");
		assertEquals(task.theTaskProperty().get(), "Refactor the SprintTask class");
	}

	@Test
	public void test_estTime() {
		SprintTask task = new SprintTask();
		task.setEstTime(120);
		assertEquals(task.getEstTime(), 120);
		assertEquals(task.EstTimeProperty().get(), 120);
	}
	
	@Test
	public void test_actTime() {
		SprintTask task = new SprintTask();
		task.setActTime(110);
		assertEquals(task.getActTime(), 110);
		assertEquals(task.ActTimeProperty().get(), 110);
	}
	
	@Test
	public void test_backlogRef() {
		SprintTask task = new SprintTask();
		task.setBacklogRef(9);
		assertEquals(task.getBacklogRef(), 9);
		assertEquals(task.BacklogRefProperty().get(), 9);
	}
	
}
