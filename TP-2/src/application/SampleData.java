package application;

import java.util.HashMap;
import java.util.LinkedList;

public class SampleData
{
	public static LinkedList<Project> getProjects()
	{
		LinkedList<Project> projList = new LinkedList<>();
		
		projList.add(new Project("project0", 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project1", 1, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project2", 2, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project3", 3, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project4", 4, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project5", 5, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project6", 6, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project7", 7, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project8", 8, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project9", 9, 0, new HashMap<>(), new LinkedList<Student>()));

		projList.get(0).addRequiredMembers("Electrical Engineer", 2);
		projList.get(0).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(0).addRequiredMembers("Civil Engineer", 4);

		projList.get(1).addRequiredMembers("Electrical Engineer", 3);
		projList.get(1).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(1).addRequiredMembers("Civil Engineer", 2);

		projList.get(2).addRequiredMembers("Electrical Engineer", 4);
		projList.get(2).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(2).addRequiredMembers("Civil Engineer", 3);

		projList.get(3).addRequiredMembers("Electrical Engineer", 2);
		projList.get(3).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(3).addRequiredMembers("Civil Engineer", 4);

		projList.get(4).addRequiredMembers("Electrical Engineer", 3);
		projList.get(4).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(4).addRequiredMembers("Civil Engineer", 2);

		projList.get(5).addRequiredMembers("Electrical Engineer", 4);
		projList.get(5).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(5).addRequiredMembers("Civil Engineer", 3);

		projList.get(6).addRequiredMembers("Electrical Engineer", 2);
		projList.get(6).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(6).addRequiredMembers("Civil Engineer", 4);

		projList.get(7).addRequiredMembers("Electrical Engineer", 3);
		projList.get(7).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(7).addRequiredMembers("Civil Engineer", 2);

		projList.get(8).addRequiredMembers("Electrical Engineer", 4);
		projList.get(8).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(8).addRequiredMembers("Civil Engineer", 3);

		projList.get(9).addRequiredMembers("Electrical Engineer", 3);
		projList.get(9).addRequiredMembers("Mechanical Engineer", 3);
		projList.get(9).addRequiredMembers("Civil Engineer", 3);
		
		return projList;
	}
	
	public static LinkedList<Student> getStudents()
	{
		LinkedList<Student> stuList = new LinkedList<>();

		stuList.add(new Student("EE00", 100, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE01", 101, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE02", 102, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE03", 103, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE04", 104, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE05", 105, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE06", 106, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE07", 107, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE08", 108, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE09", 109, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE10", 110, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE11", 111, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE12", 112, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE13", 113, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE14", 114, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE15", 115, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE16", 116, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE17", 117, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE18", 118, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE19", 119, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE20", 120, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE21", 121, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE22", 122, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE23", 123, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE24", 124, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE25", 125, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE26", 126, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("EE27", 127, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE28", 128, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("EE29", 129, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));

		stuList.add(new Student("ME00", 200, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME01", 201, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME02", 202, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME03", 203, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME04", 204, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME05", 205, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME06", 206, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME07", 207, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME08", 208, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME09", 209, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("ME10", 210, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME11", 211, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME12", 212, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME13", 213, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME14", 214, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME15", 215, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME16", 216, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME17", 217, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME18", 218, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME19", 219, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("ME20", 220, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME21", 221, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME22", 222, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME23", 223, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME24", 224, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME25", 225, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME26", 226, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME27", 227, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME28", 228, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("ME29", 229, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));

		stuList.add(new Student("CE00", 300, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE01", 301, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE02", 302, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE03", 303, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE04", 304, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE05", 305, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE06", 306, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE07", 307, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE08", 308, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE09", 309, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("CE10", 310, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE11", 311, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE12", 312, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE13", 313, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE14", 314, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE15", 315, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE16", 316, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE17", 317, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE18", 318, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE19", 319, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		stuList.add(new Student("CE20", 320, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE21", 321, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE22", 322, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE23", 323, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE24", 324, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE25", 325, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE26", 326, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE27", 327, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE28", 328, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		stuList.add(new Student("CE29", 329, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));

//		stuList.get(0).addEnemyIDs(stuList.get(1).getID()); // ee0 doesn't like ee1
//		stuList.get(1).addEnemyIDs(stuList.get(0).getID()); // ee0 doesn't like ee1
//		stuList.get(59).addPreferredProjects("project0");
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
		
		
		
		return stuList;
	}
}
