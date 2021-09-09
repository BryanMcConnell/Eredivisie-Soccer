package eredivisie;

import java.util.Scanner;



public class Soccer {
	public static Scanner scanner = new Scanner(System.in);
	
	
	
// Teams in the Eredivisie
	public static String[] teamsArray = {
				"Ajax","AZ","Cambuur","Feyenoord","Fortuna Sittard","Go Ahead Eagles",
				"FC Groningen","SC Heerenveen","Heracles Almelo","NEC","PSV",
				"RKC Waalwik","Sparta Rotterdam","FC Twente","FC Utrecht","Vitesse",
				"Willem II","PEC Zwolle"};

// Team ranking in 2020-2021 season based on array position
	public static byte[] rankingArray = {1,3,16,5,11,17,7,12,9,18,2,15,8,10,6,4,14,13};

// Team ranking by goals scored in current season based on array position
	public static byte[] goalsRankingArray = {1,8,4,2,4,6,4,4,7,5,1,3,7,6,2,7,4,8};

// An arbitrary excitement rating for two teams & overall
	public static double excitementTeamOne = 0;
	public static double excitementTeamTwo = 0;
	public static double totalExcitement = 0;
	public static double[] teamExcitement = new double[18];
	public static byte teamSelectionOne;
	public static byte teamSelectionTwo;
	public static byte menuSelection;
	static final String INVALID = "Not a valid selection. Please try again.";

// Beginning
	public static void main(String[] args) {
		System.out.println("The teams in the Eredivisie are:");
		for (int i = 0; i < teamsArray.length; i++)
			System.out.println(i + 1 + " " + teamsArray[i]);
		
		System.out.println("Main Menu\n1: Select Teams for Excitement Ratings" +
				"\n2: Select Teams for Mock Game" +
				"\n3: Exit" +
				"\nSelect a number: ");
		while (!scanner.hasNextByte()) {
			System.out.println(INVALID);
			scanner.next();
		} 
		menuSelection = scanner.nextByte();
		if (menuSelection == 1) {
			entrySelectOne();
		}
		else if (menuSelection == 2) {
			mockGame();
		}
		else if (menuSelection == 3) {
			System.exit(0);
		}
		else
			System.out.println(INVALID);
	}
	
	public static void mockGame() {
		System.out.println("Pending");
		System.exit(0);
	}
	
	public static void entrySelectOne() {
		System.out.print("Select the first team by number: ");
		while (!scanner.hasNextByte()) {
			System.out.println(INVALID);
			scanner.next();
		}
		teamSelectionOne = scanner.nextByte();
		if (teamSelectionOne < 1 || teamSelectionOne > 18) {
			System.out.println(INVALID);
			entrySelectOne();
		}
		else
			entrySelectTwo();
	}
	
	public static void entrySelectTwo() {
		
// Matches the first team selected with their ranking
		System.out.println("You selected: " + teamsArray[teamSelectionOne - 1]);
		System.out.println(teamsArray[teamSelectionOne - 1] + " was ranked " + 		rankingArray[teamSelectionOne - 1]);
		System.out.println("Select the second team by number: ");
		while (!scanner.hasNextByte()) {
			System.out.println(INVALID);
			scanner.next();
		}
			teamSelectionTwo = scanner.nextByte();
			if (teamSelectionTwo < 1 || teamSelectionTwo > 18 || teamSelectionTwo == teamSelectionOne) {
				System.out.println(INVALID);
				entrySelectTwo();
			}
			else
				headToHead();
	}
	
	public static void headToHead() {
	
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
			System.out.println(INVALID);

// Moving the excitement level of each time into an array
		for (int i = 0; i < teamsArray.length; i++) {
			teamExcitement[i] = rankingArray[i] + ((double)goalsRankingArray[i] / 2);
			//System.out.println("The result:");
		}
		for (int i = 0; i < teamExcitement.length; i++)	{
			//System.out.println(i + 1 + " " + teamsArray[i] + " " + teamExcitement[i]);
		}
		
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
/*				System.out.println(teamExcitement[i] + teamExcitement[m] + " " + teamsArray[i] + 
				" vs " + teamsArray[m]);
				System.out.println("\n");
*/	
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
			}	
		}
			System.out.println("The most exciting game is " + teamsArray[teamLowOne - 1] + 
			" and " + teamsArray[teamLowTwo - 1] + " " + low);
			System.out.println("The least exciting game is " + teamsArray[teamHighOne - 1] + 
			" and " + teamsArray[teamHighTwo - 1] + " " + high);
	}
}

