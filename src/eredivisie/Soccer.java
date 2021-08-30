package eredivisie;

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
		
	// An arbitrary excitement rating for two teams
		
		double excitementTeamOne = 0;
		double excitementTeamTwo = 0;
		
		System.out.println("The teams in the Eredivisie are:");
		for (int i = 0; i <teamsArray.length; i++)
			System.out.println(i+1 + " " + teamsArray[i]);

		System.out.print("Select the first team by number: ");

		byte teamSelectionOne = scanner.nextByte();

	// Matches the first team selected with their ranking
		System.out.println("You selected: " + teamsArray[teamSelectionOne -1]);
		System.out.println(teamsArray[teamSelectionOne -1] + " was ranked " + rankingArray[teamSelectionOne -1]);

		System.out.println("Select the second team by number: ");

		byte teamSelectionTwo = scanner.nextByte();

	// Matches the second team selected with their ranking
		System.out.println("You selected: " + teamsArray[teamSelectionTwo -1]);
		System.out.println(teamsArray[teamSelectionTwo -1] + " was ranked " + rankingArray[teamSelectionTwo -1]);

	// Assigns an excitement rating to each team
		excitementTeamOne = (double)rankingArray[teamSelectionOne -1] + ((double)goalsRankingArray[teamSelectionOne -1] / 2);
		excitementTeamTwo = (double)rankingArray[teamSelectionTwo -1] + ((double)goalsRankingArray[teamSelectionTwo -1] / 2);
		

	// Compares the two teams
		if (rankingArray[teamSelectionOne -1] > rankingArray[teamSelectionTwo -1])
			System.out.println(teamsArray[teamSelectionTwo -1] +" was ranked better.");
			else if (rankingArray[teamSelectionOne -1] < rankingArray[teamSelectionTwo -1])
				System.out.println(teamsArray[teamSelectionOne - 1] +" was ranked better");
			else
				System.out.println("Error in selection");

		System.out.println(teamsArray[teamSelectionOne -1] + " has an exitement rating of " + excitementTeamOne);
		System.out.println(teamsArray[teamSelectionTwo -1] + " has an exitement rating of " + excitementTeamTwo);
		System.out.println((double)rankingArray[teamSelectionOne -1] + " + " + ((double)goalsRankingArray[teamSelectionOne -1] / 2));


	}
}

