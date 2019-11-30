package application;

import java.util.LinkedList;

// this class is just to get you started.  feel free to change it however you see fit

public class TBController
{
	// this enum probably can't be nested here
	// the code is currently designed to have some other class
	// change the ProgramState with the setProgramState method
	// which it can't do without having scope of this enum
	// ...or change the setProgramState to not use this enum
	enum ProgramState
	{
		eInit,
		eIdle,
		eReadData,
		eWriteData,
		eBuildTeams
	}
	
	ProgramState programState;
	LinkedList<Student> studentList;
	LinkedList<Project> projectList;
	
	// construtor
	public TBController()
	{
		programState = ProgramState.eInit;
	}
	
	// allows calling functions to direct program
	public void setProgramState(ProgramState input)
	{
		programState = input;
	}
	
	// each stage of program execution is represented here
	public void programManager()
	{
		switch (programState)
		{
			default:
			case eInit:
			{
				// initialize stuff, then go to idle state
				
				studentList = new LinkedList<>();
				projectList = new LinkedList<>();

				System.out.println(programState);
				programState = ProgramState.eIdle;
				break;
			}
			
			case eIdle:
			{
				// wait for instruction from GUI to move to somewhere else
				System.out.println(programState);
				break;
			}
			
			case eReadData:
			{
				// read excel files, then return to idle
				// names of excel files should be variables that can be set by other classes
				System.out.println(programState);
				programState = ProgramState.eIdle;
				break;
			}
			
			case eWriteData:
			{
				// write excel files, then return to idle
				// names of excel files should be variables that can be set by other classes
				System.out.println(programState);
				programState = ProgramState.eIdle;
				break;
			}
			
			case eBuildTeams:
			{
				// build teams, then return to idle
				System.out.println(programState);
				programState = ProgramState.eIdle;
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		TBController tbController = new TBController();

		tbController.programManager();
		tbController.programState = ProgramState.eIdle;
		tbController.programManager();
		tbController.programState = ProgramState.eReadData;
		tbController.programManager();
		tbController.programState = ProgramState.eWriteData;
		tbController.programManager();
		tbController.programState = ProgramState.eBuildTeams;
		tbController.programManager();
		
	}
}
