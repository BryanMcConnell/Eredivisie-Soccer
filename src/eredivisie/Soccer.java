package eredivisie;

import java.util.Arrays;
import java.util.Scanner;



public class Soccer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	// Teams in the Eredivisie
		final String[] teamsArray = {
				"Ajax","AZ","Cambuur","Feyenoord","Fortuna Sittard","Go Ahead Eagles",
				"FC Groningen","SC Heerenveen","Heracles Almelo","NEC","PSV",
				"RKC Waalwik","Sparta Rotterdam","FC Twente","FC Utrecht","Vitesse",
				"Willem II","PEC Zwolle"};

	// Team ranking in 2020-2021 season based on array position
		byte[] rankingArray = {1,3,16,5,11,17,7,12,9,18,2,15,8,10,6,4,14,13};

	// Team ranking by goals scored in current season based on array position
		byte[] goalsRankingArray = {1,8,4,2,4,6,4,4,7,5,1,3,7,6,2,7,4,8};

	// An arbitrary excitement rating for two teams & overall
		double excitementTeamOne = 0;
		double excitementTeamTwo = 0;
		double totalExcitement = 0;
		double[] teamExcitement = new double[18];
		double max = Double.MIN_VALUE;
		double secondMax = Double.MAX_VALUE;
		String result = "";
		System.out.println("The teams in the Eredivisie are:");
		for (int i = 0; i < teamsArray.length; i++)
			System.out.println(i + 1 + " " + teamsArray[i]);
		System.out.print("Select the first team by number: ");
		byte teamSelectionOne = scanner.nextByte();

	// Matches the first team selected with their ranking
		System.out.println("You selected: " + teamsArray[teamSelectionOne - 1]);
		System.out.println(teamsArray[teamSelectionOne - 1] + " was ranked " + 		rankingArray[teamSelectionOne - 1]);
		System.out.println("Select the second team by number: ");
		byte teamSelectionTwo = scanner.nextByte();
		scanner.close();
		
	// Matches the second team selected with their ranking
		System.out.println("You selected: " + teamsArray[teamSelectionTwo - 1]);
		System.out.println(teamsArray[teamSelectionTwo - 1] + " was ranked " + 		rankingArray[teamSelectionTwo - 1]);

	// Assigns an excitement rating to each team & overall (want to get rid of total)
		excitementTeamOne = rankingArray[teamSelectionOne - 1] + 		((double)goalsRankingArray[teamSelectionOne - 1] / 2);
		excitementTeamTwo = rankingArray[teamSelectionTwo - 1] + 		((double)goalsRankingArray[teamSelectionTwo - 1] / 2);
		totalExcitement = excitementTeamOne + excitementTeamTwo;

	// Compares the two teams
		if (rankingArray[teamSelectionOne - 1] > rankingArray[teamSelectionTwo - 1])
			System.out.println(teamsArray[teamSelectionTwo - 1] +" was ranked better.");
		else if (rankingArray[teamSelectionOne - 1] < rankingArray[teamSelectionTwo - 1])
			System.out.println(teamsArray[teamSelectionOne - 1] +" was ranked better");
		else
			System.out.println("Error in selection");

	// Moving the excitement level of each time into an array
		for (int i = 0; i < teamsArray.length; i++)
			teamExcitement[i] = rankingArray[i] + ((double)goalsRankingArray[i] / 2);
			System.out.println("The result:");
		for (int i = 0; i < teamExcitement.length; i++)	
			System.out.println(i + 1 + " " + teamsArray[i] + " " + teamExcitement[i]);

	// Display value level of a game between two teams 
		if (totalExcitement < 5)
			System.out.println("This will be a very exciting game!");
		else if (totalExcitement < 11)
			System.out.println("This will be an exciting game!");
		else if (totalExcitement < 21)
			System.out.println("This will be an interesting game.");
		else
			System.out.println("This might be a dull one.");
		
		double low = 1000;
		double high = 0;
		int teamLowOne = 0, teamLowTwo = 0;
		int teamHighOne = 0, teamHighTwo = 0;
	// Display the value level of all possible games
		for (int i = 0; i < (teamExcitement.length - 1); i++) {
			for (int m = (i + 1); m < (teamExcitement.length); m++) {
				System.out.println(teamExcitement[i] + teamExcitement[m] + " " + teamsArray[i] + 
				" vs " + teamsArray[m]);
				System.out.println("\n");
	
	// Find the highest and lowest
				
				double currentHigh = teamExcitement[i] + teamExcitement[m];
				if (currentHigh > high) {
					teamHighOne = i + 1;
					teamHighTwo = m + 1;
					high = currentHigh;
				}
				if (currentHigh < low ) {
					teamLowOne = i + 1;
					teamLowTwo = m + 1;
					low = currentHigh;
				}
				
				System.out.println("The most exciting game is " + teamsArray[teamLowOne - 1] + 
				" and " + teamsArray[teamLowTwo - 1] + " " + low);
				System.out.println("The least exciting game i s" + teamsArray[teamHighOne - 1] + 
				" and " + teamsArray[teamHighTwo - 1] + " " + high);
			}
		}
	}
}

