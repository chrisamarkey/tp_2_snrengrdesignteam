package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamBuilderTest
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testTeamBuilder()
	{
		LinkedList<Student> stuList = new LinkedList<>();

		stuList.add(new Student("EE00", 100, 3.0, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE01", 101, 3.1, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE02", 102, 3.2, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE03", 103, 3.3, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE04", 104, 2.4, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE05", 105, 3.5, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE06", 106, 3.6, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE07", 107, 3.7, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE08", 108, 3.8, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE09", 109, 2.9, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE10", 110, 3.0, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE11", 111, 3.1, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE12", 112, 3.2, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE13", 113, 3.3, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE14", 114, 2.4, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE15", 115, 3.5, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE16", 116, 3.6, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE17", 117, 3.7, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE18", 118, 3.8, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE19", 119, 2.9, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE20", 120, 3.0, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE21", 121, 3.1, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE22", 122, 3.2, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE23", 123, 3.3, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE24", 124, 2.4, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE25", 125, 3.5, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE26", 126, 3.6, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("EE27", 127, 3.7, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE28", 128, 3.8, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("EE29", 129, 2.9, "Electrical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));

		stuList.add(new Student("ME00", 200, 2.0, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME01", 201, 3.1, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME02", 202, 3.2, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME03", 203, 3.3, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME04", 204, 2.4, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME05", 205, 3.5, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME06", 206, 3.6, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME07", 207, 3.7, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME08", 208, 2.8, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME09", 209, 3.9, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("ME10", 210, 3.0, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME11", 211, 3.1, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME12", 212, 2.2, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME13", 213, 3.3, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME14", 214, 3.4, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME15", 215, 3.5, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME16", 216, 2.6, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME17", 217, 3.7, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME18", 218, 3.8, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME19", 219, 3.9, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("ME20", 220, 2.0, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME21", 221, 3.1, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME22", 222, 3.2, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME23", 223, 3.3, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME24", 224, 2.4, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME25", 225, 3.5, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME26", 226, 3.6, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME27", 227, 3.7, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME28", 228, 2.8, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("ME29", 229, 3.9, "Mechanical Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		
		stuList.add(new Student("KE00", 300, 2.0, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE01", 301, 3.1, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE02", 302, 3.2, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE03", 303, 3.3, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE04", 304, 3.4, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE05", 305, 3.5, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE06", 306, 2.6, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE07", 307, 3.7, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE08", 308, 3.8, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE09", 309, 3.9, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("KE10", 310, 3.0, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE11", 311, 3.1, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE12", 312, 2.2, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE13", 313, 3.3, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE14", 314, 3.4, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE15", 315, 3.5, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE16", 316, 3.6, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE17", 317, 3.7, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE18", 318, 2.8, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE19", 319, 3.9, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("KE20", 320, 3.0, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE21", 321, 3.1, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE22", 322, 3.2, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE23", 323, 3.3, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE24", 324, 2.4, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE25", 325, 3.5, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE26", 326, 3.6, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE27", 327, 3.7, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE28", 328, 3.8, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("KE29", 329, 3.9, "Computer Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		
		stuList.add(new Student("CE00", 400, 2.0, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE01", 401, 3.1, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE02", 402, 3.2, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE03", 403, 3.3, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE04", 404, 3.4, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE05", 405, 3.5, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE06", 406, 2.6, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE07", 407, 3.7, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE08", 408, 3.8, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE09", 409, 3.9, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("CE10", 410, 3.0, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE11", 411, 3.1, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE12", 412, 2.2, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE13", 413, 3.3, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE14", 414, 3.4, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE15", 415, 3.5, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE16", 416, 3.6, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE17", 417, 3.7, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE18", 418, 2.8, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE19", 419, 3.9, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		stuList.add(new Student("CE20", 420, 3.0, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE21", 421, 3.1, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE22", 422, 3.2, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE23", 423, 3.3, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE24", 424, 2.4, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE25", 425, 3.5, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE26", 426, 3.6, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE27", 427, 3.7, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE28", 428, 3.8, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));	
		stuList.add(new Student("CE29", 429, 3.9, "Civil Engineer", "", 0, "", new LinkedList<String>(), new LinkedList<String>()));
		
		stuList.get(0).addEnemyNames(stuList.get(1).getName()); // ee0 doesn't like ee1
		stuList.get(1).addEnemyNames(stuList.get(0).getName()); // ee1 doesn't like ee0
		stuList.get(30).addEnemyNames(stuList.get(31).getName()); // me0 doesn't like me1
		stuList.get(31).addEnemyNames(stuList.get(30).getName()); // me1 doesn't like me0
		stuList.get(60).addEnemyNames(stuList.get(61).getName()); // ce0 doesn't like ce1
		stuList.get(61).addEnemyNames(stuList.get(60).getName()); // ce1 doesn't like ce0
		
		stuList.get(29).addPreferredProjects("project9");
		stuList.get(59).addPreferredProjects("project9");
		stuList.get(89).addPreferredProjects("project9");
		
		stuList.get(70).addPreferredProjects("project2");
		stuList.get(71).addPreferredProjects("project3");
		stuList.get(72).addPreferredProjects("project4");
		stuList.get(73).addPreferredProjects("project5");
		stuList.get(74).addPreferredProjects("project6");
		stuList.get(75).addPreferredProjects("project6");
		stuList.get(76).addPreferredProjects("project7");
		stuList.get(77).addPreferredProjects("project7");
		stuList.get(78).addPreferredProjects("project8");
		stuList.get(79).addPreferredProjects("project8");
		
		LinkedList<Project> projList = new LinkedList<>();
		
		projList.add(new Project("project0", 0, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project1", 1, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project2", 2, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project3", 3, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project4", 4, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project5", 5, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project6", 6, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project7", 7, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project8", 8, 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project9", 9, 0, 0, new HashMap<>(), new LinkedList<Student>()));

		projList.get(0).addRequiredMembers("Electrical Engineer", 2);
		projList.get(0).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(0).addRequiredMembers("Computer Engineer", 3);
		projList.get(0).addRequiredMembers("Civil Engineer", 4);

		projList.get(1).addRequiredMembers("Electrical Engineer", 3);
		projList.get(1).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(1).addRequiredMembers("Computer Engineer", 4);
		projList.get(1).addRequiredMembers("Civil Engineer", 2);

		projList.get(2).addRequiredMembers("Electrical Engineer", 4);
		projList.get(2).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(2).addRequiredMembers("Computer Engineer", 2);
		projList.get(2).addRequiredMembers("Civil Engineer", 3);

		projList.get(3).addRequiredMembers("Electrical Engineer", 2);
		projList.get(3).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(3).addRequiredMembers("Computer Engineer", 3);
		projList.get(3).addRequiredMembers("Civil Engineer", 4);

		projList.get(4).addRequiredMembers("Electrical Engineer", 3);
		projList.get(4).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(4).addRequiredMembers("Computer Engineer", 4);
		projList.get(4).addRequiredMembers("Civil Engineer", 2);

		projList.get(5).addRequiredMembers("Electrical Engineer", 4);
		projList.get(5).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(5).addRequiredMembers("Computer Engineer", 2);
		projList.get(5).addRequiredMembers("Civil Engineer", 3);

		projList.get(6).addRequiredMembers("Electrical Engineer", 2);
		projList.get(6).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(6).addRequiredMembers("Computer Engineer", 3);
		projList.get(6).addRequiredMembers("Civil Engineer", 4);

		projList.get(7).addRequiredMembers("Electrical Engineer", 3);
		projList.get(7).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(7).addRequiredMembers("Computer Engineer", 4);
		projList.get(7).addRequiredMembers("Civil Engineer", 2);

		projList.get(8).addRequiredMembers("Electrical Engineer", 4);
		projList.get(8).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(8).addRequiredMembers("Computer Engineer", 2);
		projList.get(8).addRequiredMembers("Civil Engineer", 3);

		projList.get(9).addRequiredMembers("Electrical Engineer", 3);
		projList.get(9).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(9).addRequiredMembers("Computer Engineer", 3);
		projList.get(9).addRequiredMembers("Civil Engineer", 3);
		
		double studentBodyGPA = 0;
		double gpaRange = 0.2;
		
		for (Student student : stuList)
		{
			studentBodyGPA += student.getGPA();
		}
		
		studentBodyGPA /= stuList.size();
		
		TeamBuilder teamBuilder = new TeamBuilder(projList, stuList, studentBodyGPA - gpaRange, studentBodyGPA + gpaRange, true, true);
		
		teamBuilder.buildTeams();

		assertNotNull(teamBuilder.getStudents());
		assertNotNull(teamBuilder.getProjects());
		
		teamBuilder = new TeamBuilder(projList, stuList, studentBodyGPA - gpaRange, studentBodyGPA + gpaRange, false, false);
		
		teamBuilder.buildTeams();

		assertNotNull(teamBuilder.getStudents());
		assertNotNull(teamBuilder.getProjects());
	}
}
