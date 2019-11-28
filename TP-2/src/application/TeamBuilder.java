package application;

//this class is just to get you started.  feel free to change it however you see fit

public class TeamBuilder
{
	enum TeamBuildingState
	{
		eInit,
		eHighPriorityDecisions,
		eFillInTheRest,
		eFixProblems
	}
	
	TeamBuildingState teamBuildingState;
	
	public TeamBuilder()
	{
		teamBuildingState = TeamBuildingState.eInit;
	}
	
	public void buildTeams()
	{
		while (true)
		{
			switch (teamBuildingState)
			{
				default:
				case eInit:
				{
					// initialize things
					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eHighPriorityDecisions;
					break;
				}
				
				case eHighPriorityDecisions:
				{
					// do the important things
					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eFillInTheRest;
					break;
				}
				
				case eFillInTheRest:
				{
					// deal with the normal people
					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eFixProblems;
					break;
				}
				
				case eFixProblems:
				{
					// try and fix teams that aren't following the rules
					System.out.println(teamBuildingState);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		TeamBuilder teamBuilder = new TeamBuilder();
		
		teamBuilder.buildTeams();
	}
}
