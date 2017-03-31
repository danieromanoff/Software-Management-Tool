package softwaremanagementtool_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import softwaremanagementtool.agile_test.SprintList_Test;
import softwaremanagementtool.agile_test.SprintTask_Test;
import softwaremanagementtool.agile_test.Sprint_Test;
import softwaremanagementtool.agile_test.UserStory_Test;

@RunWith(Suite.class)
@SuiteClasses({
	UserStory_Test.class,
	Sprint_Test.class,
	SprintTask_Test.class,
	SprintList_Test.class
})
public class AllTests {

}
