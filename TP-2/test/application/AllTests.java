package application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProjectTest.class, StudentTest.class, TeamBuilder.class})
public class AllTests
{

}
