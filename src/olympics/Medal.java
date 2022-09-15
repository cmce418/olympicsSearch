/**
 * Colm McEvoy
 * 40154092
 */
package olympics;

import java.util.Scanner;

/**
 * @author cmcev
 *
 */
public class Medal {

	private int year;
	private String medal;
	private String city;
	private String sport;
	private String discipline;
	private String athlete;
	private String country;
	private String gender;
	private String event;

	public Scanner getYear;
	
	/*
	 * default constructor
	 */
	public Medal() {
		
	}
	
	/**
	 * constructor with args
	 * 
	 * @param year
	 * @param medal
	 * @param city
	 * @param sport
	 * @param discipline
	 * @param athlete
	 * @param country
	 * @param gender
	 *
	 * @throws Exception - based on validation rules ..
	 */
	public Medal(int year, String medal,String city, String sport, String discipline, String athlete, String country, String gender, String event) throws Exception {
		this.setYear(year);
		this.setMedal(medal);
		this.setCity(city);
		this.setSport(sport);
		this.setDiscipline(discipline);
		this.setAthlete(athlete);
		this.setCountry(country);
		this.setGender(gender);
		this.setEvent(event);
		
	}
	

	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		if (year >= 1896) {
			this.year = year;
		}
		else {
			this.year = 2021;
			System.out.println("invalid year for" +this.athlete+" "+this.event+ " Medal, year deaulted to 2021");
			}
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		if (city.length() > 0 && city.length() <= 29) {
			this.city = city;
		}
		else {
			this.city = "null";
			System.out.println("invalid city for " +this.athlete+ " " +this.event+ " (characters should be 0-29) defaulted to null");
			}
	}
	
	public String getSport() {
		return sport;
	}

	public void setSport(String sport)  {
		if (sport.length() > 0 && sport.length() <= 49) {
			this.sport = sport;
		}
		else {
			this.sport = "null";
			System.out.println("sport not found for " +this.athlete+ " " +this.event+ " (should be less than 50 characters) defaulted to null");
			}
	}
	

	public String getDiscipline() {
		return discipline;
	}
	
	public void setDiscipline(String discipline) {
		if (discipline.length() > 0 && discipline.length() <= 79) {
			this.discipline = discipline;
		}
		else {
			this.discipline = "null";
			System.out.println("discipline not found for " +this.athlete+ " " +this.event+ " (should be less than 80 characters) defaulted to null");
			}
	}
	

	public String getAthlete() {
		return athlete;
	}

	public void setAthlete(String athlete) {
		if (athlete.length() > 0 && athlete.length() <= 79) {
			this.athlete = athlete;
		}
		else {
			this.athlete = "null";
			System.out.println("Athlete invlaid " +this.country+ " " +this.year+ " (should be less than 80 characters) defaulted to null");

			}
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country)  {
	if (country.length() > 0 && country.length() <= 3) {
		this.country = country;
	}
	else {
		this.country = "nul";
		System.out.println("country invlaid for =  " +this.athlete+ " " +this.year+ " (should be less than 4 characters) defaulted to nul");
		}
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender)  {
		if (gender.length() > 0 && gender.length() <= 9) {
			this.gender = gender;
		}
		else {
			this.gender = "null";
			System.out.println("Gender not found for " +this.athlete+ " " +this.event+ " (should be less than 10 characters) defaulted to null");
			}
	}
	
	
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		if (event.length() > 0 && event.length() <= 50) {
			this.event = event;
		}
		else {
			this.event = "null";
			System.out.println("Event not found for " +this.athlete+ " " +this.sport+ " (should be less than 50 characters) defaulted to null");
			}
	}

	public String getMedal() {
		return medal;
	}

	public void setMedal(String medal){
		if (medal.equalsIgnoreCase("3")) {
			this.medal = "Bronze";
		}
		else if (medal.equalsIgnoreCase("2")) {
			this.medal = "Silver";;
		}
		else if (medal.equalsIgnoreCase("1")) {
			this.medal = "Gold";;
		}
		else {			
			this.medal = "null";
			System.out.println("Medal not found for " +this.athlete+ " " +this.event+ " (defaulted to null)");
		}
	}
	
	public String toString() {
		return " [Year=" + year + ", City=" + city + ", Sport=" + sport + ", Discipline=" + discipline + ", Athlete=" + athlete + ", Country=" + country + ", Gender=" + gender + ", Event=" + event + ", medal=" + medal+ "]\n";
	} 
	

	public String display() {
		return " [Year=" + year + ", City=" + city.toUpperCase() + ", Sport=" + sport + ", Discipline=" + discipline + ", Athlete=" + athlete + ", Country=" + country + ", Gender=" + gender + ", Event=" + event + ", medal=" + medal+ "]\n";
	}  


}
