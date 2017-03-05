package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.collections.ObservableList;
import softwaremanagementtool.agile.Sprint;
import softwaremanagementtool.agile.SprintList;

public class SprintList_Test {

	@Test
	public void test_SprintList() {
		ObservableList<Sprint> sprintList;
		SprintList sl = new SprintList();
		Sprint sp1 = new Sprint();
		sp1.setID(sl.nextId());
		sl.add(sp1);
		Sprint sp2 = new Sprint();
		sp2.setID(sl.nextId());
		sl.add(sp2);
		sprintList = sl.sprintList();
		assertEquals(sprintList.get(0), sp1);
		assertEquals(sprintList.get(1), sp2);
	}

}
