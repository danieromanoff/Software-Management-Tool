package softwaremanagementtool.agile_test;

import static org.junit.Assert.*;

import org.junit.Test;

import softwaremanagementtool.agile.BacklogEntry;
import softwaremanagementtool.agile.BacklogList;

public class BacklogList_Test {

	@Test
	public void test_BacklogList() {
		BacklogList bll = new BacklogList();
		BacklogEntry be1 = new BacklogEntry();
		BacklogEntry be2 = new BacklogEntry();
		bll.add(be1);
		bll.add(be2);
		assertEquals(bll.size(), 2);
		bll.remove(be1);
		assertEquals(bll.size(), 1);
		bll.clear();
		assertEquals(bll.size(), 0);
	}

}
