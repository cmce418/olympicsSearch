/**
 * Colm McEvoy
 * 40154092
 * 
 */
package olympics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import olympics.Medal;


/**
 * Colm McEvoy
 * 40154091
 *
 */
public class StarterApp {

	// stores the data read and mapped for the csv file
	public static ArrayList<Medal> Medals = new ArrayList<Medal>();

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
				
				//Read in medal stats
				readInMedals();

				// show the menu
				showMenu();
				
			}
			
	/**
	 * Method to load the menu		
	 * @returns: Menu
	 */
	public static ArrayList<Medal> showMenu() {				
				System.out.println("In the Entries Above some values have been reset to Null, as they where outside of parameter");
				System.out.println();
				Scanner scanner = new Scanner(System.in);
				int option;
				System.out.println("Olympics stats ");
				do {
					System.out.println("1. Display all medals");
					System.out.println("2. Output to screen the details of all medals for a specified medal type won by a specified country");
					System.out.println("3. Output to screen the total of all medal types won by a specified country");
					System.out.println("4. Output to screen all medals won in a particular olympic year");
					System.out.println("5. Medals search by individual athlete");
					System.out.println("6. Last year that medals were presented for a particular sport");
					System.out.println("7. Medla won by Germany (East and West and Unified Germany");
					System.out.println("8. Gold Medals won by Gender in a specified country");
					System.out.println("9. The role of honour of Olympic champions (male and female) for a particular Event");
					System.out.println("10. Output to screen each country (sorted alphabetically) with the total gold medals each has won");
					System.out.println("11. Sorted by athlete name (in reverse alphabetical order) output to screen each medal won by a particular county in a particular year in a particular sport");
					System.out.println("12. Host cities in alphabetical order");
					System.out.println("13. Capitalise the Host City e.g. Beijing to BEIJING. Then export/write to a new file (summer_updated.csv) in the format: shown below. Note, include the header as shown. Example csv output ");
					System.out.println("14. Quit");
					System.out.println("Enter option ...");
					option = scanner.nextInt();

					switch (option) {
						
					case 1: 
							//show all medals
					for (Medal Medal : Medals) {
						System.out.println(Medal.toString());
						}
						break;
						
					case 2:
						 medalsByTypeByCountry();	
						break;
						
					case 3:
						allMedalsByCountry();
						break;
						
					case 4:
						medalsByYear();
						break;
						
					case 5:
						medalsByAthlete();
						break;
						
					case 6:
						System.out.println("Last year Rugby was played in the olympics : 1924 in Paris");
						break;	
						
					case 7:
						totalMedalsByGerman();
						break;
						
					case 8:
						goldMedalsByGenderByCountry();
						break;	
						
					case 9:
						goldMedalWinnersByEvent();
						break;	
						
					case 10:
						everyCountry();
						break;
						
					case 11:
						countryYearSportSearch();
						break;	
						
					case 12:
						hostCities();
						break;	
						
					case 13:
						reWriteFile();
						break;	
						
					case 14:
						System.out.println("Quitting");
						break;		
					default:
						System.out.println("Try options again...");
					}
										
					System.out.println("");
					System.out.println("Select another category");
					System.out.println("");


				} while (option != 14);
				scanner.close();
				return null;
			}
		
	/**
	* read in all medals 
	* year city sport discipline athlete country gender event medal 
	*/
	public static void readInMedals() {

				File file = new File("summer.csv");

				FileReader fileReader;
				BufferedReader bufferedReader;
				String medalInfo;
				String[] stats;

				try {
					fileReader = new FileReader(file);
					bufferedReader = new BufferedReader(fileReader);
					
					// parse each data point - by comma
					
					medalInfo = bufferedReader.readLine();
					// ditch the first line (header values) so read the next line
					medalInfo = bufferedReader.readLine();

					do {
						//creat a match and add stats
						Medal medal = new Medal();
						stats = medalInfo.split(",");

						// parse medal info

						medal.setYear(Integer.parseInt(stats[0]));
						medal.setCity(stats[1]);
						medal.setSport(stats[2]);
						medal.setDiscipline(stats[3]);
						medal.setAthlete(stats[4]);
						medal.setCountry(stats[5]);
						medal.setGender(stats[6]);
						medal.setEvent(stats[7]);
						medal.setMedal(stats[8]);
						
						// add to arraylist of olympicMedals
						Medals.add(medal);

						// read the next line
						medalInfo = bufferedReader.readLine();
					} while (medalInfo != null);
					

					// close all1
					fileReader.close();
					bufferedReader.close();

				} catch (FileNotFoundException e) {
					System.out.println("file not found");
				} catch (IOException e) {
					System.out.println("Invalid Entry");
				} catch (NumberFormatException e) {
				System.out.println("Invalid Entry");
				} catch (Exception e) {
					System.out.println("Invalid Entry");
				}
				
			}
	
	/**
	 * search medals by type (Gold/Silver/Bronze) for specific country
	 * @return : list of medal type won and total
	 */
	public static void medalsByTypeByCountry() {
	
			try
			{
				String userCountryInput;
				String userMedalInput;
				//Message to user
				System.out.println("enter country (formatted to 3 character ");
				
				//scanner
				Scanner scann1 = new Scanner(System.in);
				userCountryInput = scann1.nextLine();
				
				//scanner
				System.out.println("enter Medal type");
				Scanner scann2 = new Scanner(System.in);
				userMedalInput = scann2.nextLine();
				//show medal by year

				//capture and use userCountry
				ArrayList<Medal> countryMedals = new ArrayList<Medal>();
				for (Medal Medal : Medals) {
					if (Medal.getCountry().equalsIgnoreCase(userCountryInput) && Medal.getMedal().equalsIgnoreCase(userMedalInput)) {
						countryMedals.add(Medal);
						}
					}									
				System.out.print(countryMedals.toString());
				System.out.println("Total " +userMedalInput+ " Medals Won by " +userCountryInput+ " = " +countryMedals.size());
			}	
			catch (Exception e) {
				System.out.println("system error, contact admin");
			}
	}
	
	/**
 	* search for total of all medals won by a country
 	* @return : Gold =
 	* 			 Silver =
 	* 			 Bronze =
 	*/
	public static void allMedalsByCountry() {
		
	try
	{	
		String inputCountry;
		System.out.println("enter country (should be 3 characters long)");

		Scanner scann3 = new Scanner(System.in);
		inputCountry = scann3.nextLine();
		
		
		ArrayList<Medal> countryMedalGold = new ArrayList<Medal>();
		ArrayList<Medal> countryMedalSilver = new ArrayList<Medal>();
		ArrayList<Medal> countryMedalBronze = new ArrayList<Medal>();

		
		for (Medal Medal : Medals) {
			
			if (Medal.getCountry().equalsIgnoreCase(inputCountry) && Medal.getMedal().equalsIgnoreCase("Gold")) {	
				countryMedalGold.add(Medal);
			} 
			else if (Medal.getCountry().equalsIgnoreCase(inputCountry) && Medal.getMedal().equalsIgnoreCase("Silver")) {								
				countryMedalSilver.add(Medal);		
			}
			else if (Medal.getCountry().equalsIgnoreCase(inputCountry) && Medal.getMedal().equalsIgnoreCase("Bronze")) {								
				countryMedalBronze.add(Medal);		
			}
			
		}
		System.out.println("Medals won by " +inputCountry);
		System.out.println("Gold Medals won = " +countryMedalGold.size());
		System.out.println("Silver Medals won = " +countryMedalSilver.size());
		System.out.println("Bronze Medals won = " +countryMedalBronze.size());
	}
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
	
	}
	
	/**	
	 * search all medal won in a specific year
	 * @return : list of all medal won in set year
	 */
	public static void medalsByYear() {
	try 
	{
	
	int userYear;
	System.out.println("enter Year (an olympic year, Between 1896-2012 inclusive");
	
	Scanner scann = new Scanner(System.in);
	userYear = scann.nextInt();

	ArrayList<Medal> medalsByYear = new ArrayList<Medal>();
	
	for (Medal Medal : Medals) {
		if (Medal.getYear() == userYear){
			medalsByYear.add(Medal);		
		}
	}
	
	System.out.println(medalsByYear.toString());	
	System.out.println(" ");
	}
	
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
	
	}
	
	/**
	 * search athlete to find medals won
	 * @return list of medals won by athlete and total
	 */
	public static void medalsByAthlete() {
	
	try
	{
		//user input 
		System.out.println("enter Athelete name (Surname then FirstName)");
		String userInputAthleteName;
		//scanner
		Scanner scan3 = new Scanner(System.in);
		userInputAthleteName = scan3.nextLine();
		//show medal by year
		ArrayList<Medal> medalsByAthlete = new ArrayList<Medal>();
		
		for (Medal Medal : Medals) {
			if (Medal.getAthlete().equalsIgnoreCase(userInputAthleteName)) {	
			medalsByAthlete.add(Medal);
			}
		}							
	System.out.println(medalsByAthlete.toString());
	System.out.println("total medals won by " +userInputAthleteName+ " = " +medalsByAthlete.size());
	}
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
	
	}
	
	/**
	 * display all medals won by Germany (East+West and unified)
	 * @return total of medals won
	 */
	public static void totalMedalsByGerman() {
	try 
	{
		ArrayList<Medal> germanMedals = new ArrayList<Medal>();
		for (Medal Medal : Medals) {
			if (Medal.getCountry().contains("GDR") || Medal.getCountry().contains("FRG") || Medal.getCountry().contains("GER")) {		
				germanMedals.add(Medal);
			}
		}		
	System.out.println("Total medals won by german (East and West and unifed Germany = ");	
	System.out.println(germanMedals.size());
	}
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
}
	
	/**
	 * search by country and then by gender
	 * @return total medals by country and gender
	 */
	public static void goldMedalsByGenderByCountry() {
	try
	{
		String countryInput;
		String userGenderInput;
		//Message to user
		System.out.println("enter country");
		
		//scanner
		Scanner scan4 = new Scanner(System.in);
		countryInput = scan4.nextLine();
		
		//scanner
		System.out.println("enter Gender (Men/Women)");
		Scanner scan5 = new Scanner(System.in);
		userGenderInput = scan5.nextLine();
		//show medal by year
		
		
		//capture and use userCountry
		ArrayList<Medal> genderCountryMedals = new ArrayList<Medal>();
		
		for (Medal Medal : Medals) {
			if (Medal.getCountry().equalsIgnoreCase(countryInput) && Medal.getGender().equalsIgnoreCase(userGenderInput) && Medal.getMedal().equals("Gold")) {
			genderCountryMedals.add(Medal);
				}
		}
	System.out.println("Medals for " +countryInput + " by " +userGenderInput+ " : "  );
	System.out.println(genderCountryMedals.size());
	}
	
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
}
	
	/**
	 * search the winner of a particular event
	 * @return list of all winners of specified event
	 */
	public static void goldMedalWinnersByEvent() {
	try
	{
		String userEventInput;
		String genderInputByUser;
		//Message to user
		System.out.println("enter Event");
		
		//scanner
		Scanner scan4 = new Scanner(System.in);
		userEventInput = scan4.nextLine();
				
		//capture and use userCountry
		ArrayList<Medal> genderEventWinners = new ArrayList<Medal>();
		
		for (Medal Medal : Medals) {
			if (Medal.getEvent().equalsIgnoreCase(userEventInput) && Medal.getMedal().equals("Gold")) {
				genderEventWinners.add(Medal);
				}
		}
	System.out.println("Winners of :" +userEventInput );
	System.out.println(genderEventWinners.toString());
	}
	
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
	
}

/**
 * host cities in alphabetical order
 */
	public static void hostCities() {
		File summer = new File("summer.csv");

		String medalInfo;
		String[] stats;
		List<String> hostCities = new ArrayList<String>();

		try {
			//read in file
			FileReader fr = new FileReader(summer);
			BufferedReader br = new BufferedReader(fr);
			
			// parse each data point - by comma
			medalInfo = br.readLine();
			
			// ditch the first line (header values) so read the next line
			medalInfo = br.readLine();

			do {
				stats = medalInfo.split(",");
				hostCities.add(stats[1]);
				// read the next line
				medalInfo = br.readLine();
				} while (medalInfo != null);
			//remove duplicates 
			HashSet<String> hSetCities = new HashSet(hostCities);
			//sort in alphabetical order
			List<String> hostCity = new ArrayList<String>(hSetCities);
			Collections.sort(hostCity);
			//display to screen
			for (String strCities : hostCity) {
				System.out.println(strCities);
				}
			} 
			catch (FileNotFoundException e) {
			System.out.println("file not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}	

	/**
	 * every country in alphabetical order and total gold medals won
	 */
	public static void everyCountry() {
		File summer = new File("summer.csv");

		String medalInfo;
		String[] stats;
		List<String> countries = new ArrayList<String>();
		ArrayList<Medal> countriesGoldMedals = new ArrayList<Medal>();

		try {
			//read in file
			FileReader fr = new FileReader(summer);
			BufferedReader br = new BufferedReader(fr);
			
			// parse each data point - by comma
			medalInfo = br.readLine();
			
			// ditch the first line (header values) so read the next line
			medalInfo = br.readLine();

			do {
				stats = medalInfo.split(",");
				countries.add(stats[5]);

				// read the next line
				medalInfo = br.readLine();
				} while (medalInfo != null);				

			//remove duplicates 
			HashSet<String> hSetCountries = new HashSet(countries);
			//sort in alphabetical order
			List<String> alphaCountries = new ArrayList<String>(hSetCountries);
			Collections.sort(alphaCountries);		
			//display to screen
			for (String strCountries : alphaCountries) {
				for (Medal Medal : Medals) 
					if (Medal.getCountry().equalsIgnoreCase(strCountries) && Medal.getMedal().equalsIgnoreCase("Gold")) {	
					countriesGoldMedals.add(Medal);				

				} 
			System.out.println(strCountries + " gold Medals won = " +countriesGoldMedals.size());
	
			}

			} 
			catch (FileNotFoundException e) {
			System.out.println("file not found");
			} catch (IOException e) {
				System.out.println();
			}
	}

/**
 * @return search for country year and sport
 */
	public static void countryYearSportSearch () {
	try
	{		
		String countryInput;
		String userSportInput;
		int year;
		//Message to user
		System.out.println("enter country (3 characters long)");
		
		//scanner
		Scanner scan4 = new Scanner(System.in);
		countryInput = scan4.nextLine();
		
		//scanner
		System.out.println("enter Sport");
		Scanner scan5 = new Scanner(System.in);
		userSportInput = scan5.nextLine();
		
		System.out.println("enter Year");
		Scanner scan6 = new Scanner(System.in);
		year = scan6.nextInt();
		
		//capture and use userCountry
		List<Medal> sportCountryYearMedals = new ArrayList<Medal>();
		
		for (Medal Medal : Medals) {
			if (Medal.getCountry().equalsIgnoreCase(countryInput) && Medal.getSport().equalsIgnoreCase(userSportInput) && Medal.getYear() == year) {
			sportCountryYearMedals.add(Medal);
			}
		}
		System.out.println("Medals for :" +countryInput+ " in " +year+ " Sport : " +userSportInput);
		System.out.print(sportCountryYearMedals);
		
	}
	
	catch (Exception exception) {
		System.out.println("system error contact admin");
	}
	
	}

/**
 * re write the csv file with capitals for host city 
 */
	public static void reWriteFile() {
		try {
		File file = new File ("summer_update.csv");
				
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file,false);
		BufferedWriter bw = new BufferedWriter (fw);
		
		for (Medal Medal : Medals) {
			
			bw.write("year, City, Sport, Athlete, Country, Medal");
			bw.write(Medal.getYear()+ "," +Medal.getCity().toUpperCase()+"," +Medal.getAthlete()+ ","  +Medal.getCountry()+ "," +Medal.getMedal());
			
		}
		System.out.println("file updated");
		
		bw.close();
	
		
		}catch (Exception e) {
			System.out.println("file updated check file");
		}
		
	}
}	

	
	
	

	



		

	

