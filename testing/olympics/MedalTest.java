/**
 * 
 */
package olympics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Colm McEvoy
 * 40154091
 *
 */
class MedalTest {
	
	//test data
	
	 int year;
	 String medal, city, sport, discipline, athlete, country, gender, event;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		year = 2019; 
		
		city = "validCity"; 
		sport = "validSport";
		discipline = "validDiscipline";
		athlete = "validAthlete";
		country = "validCountry"; 
		gender = "validGender"; 
		event = "validEvent";
		medal = "1";
	}

	/**
	 * Test method for {@link olympics.Medal#Medal()}.
	 */
	@Test
	void testMedal() {
		Medal Medal = new Medal();
		assertNotNull(Medal);
	}

	/**
	 * Test method for {@link olympics.Medal#Medal(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testMedalIntStringStringStringStringStringStringStringString() throws Exception {
		Medal Medal = new Medal(year, city,sport, discipline, athlete, country, gender, event, medal);
		assertNotNull(Medal);
		
		//testing valid
		assertEquals(year, Medal.getYear());
		
		assertEquals(city, Medal.getCity());
		assertEquals(sport, Medal.getSport());
		assertEquals(athlete, Medal.getAthlete());
		assertEquals(country, Medal.getCountry());
		assertEquals(gender, Medal.getGender());
		assertEquals(event, Medal.getEvent());
		assertEquals(medal, Medal.getMedal());
		}

	/**
	 * Test method for {@link olympics.Medal#getSetYear()}.
	 */
	@Test
	void testGetYear()  throws Exception {
		Medal Medal = new Medal ();
		Medal.setYear(2016);
		
		assertEquals(2016, Medal.getYear());
		
	}
	/*
	 * Test if exception is working 
	 */
	@Test
	void testSetYearInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setYear(0);
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("invalid year", Exception.getMessage() );
	}

	/**
	 * Test method for {@link olympics.Medal#setgetCity(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testSetGetCity() throws Exception {
		Medal Medal = new Medal ();
		Medal.setCity("Dublin");
		
		assertEquals("Dublin", Medal.getCity());
		
	}
	/*
	 * Test if exception is working 
	 */
	@Test
	void testSetCityInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setCity(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("city not found", Exception.getMessage() );
	}


	/**
	 * Test method for {@link olympics.Medal#setGetSport(java.lang.String)}.
	 */
	@Test
	void testSetSport() throws Exception {
				Medal Medal = new Medal ();
				Medal.setSport("football");
				
				assertEquals("football", Medal.getSport());
				
			}
	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetSportInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setSport(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("sport not found", Exception.getMessage() );
	}

	/**
	 * Test method for {@link olympics.Medal#getSetDiscipline()}.
	 */
	@Test
	void testGetDiscipline() throws Exception {
		Medal Medal = new Medal ();
		Medal.setDiscipline("swimming");
		
		assertEquals("swimming", Medal.getDiscipline());
	
	}

	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetDisciplineInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setDiscipline(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("discipline can be a max of 79 chars", Exception.getMessage() );
	}
	
	/**
	 * Test method for {@link olympics.Medal#getSetAthlete()}.
	 */
	@Test
	void testGetAthlete() throws Exception {
		Medal Medal = new Medal ();
		Medal.setAthlete("CONLAN Michael");
		
		assertEquals("CONLAN Michael", Medal.getAthlete());
	
	}

	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetAthleteInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setAthlete(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("athlete should be a max of 79 chars", Exception.getMessage() );
	}

	/**
	 * Test method for {@link olympics.Medal#getSetCountry()}.
	 */
	@Test
	void testGetCountry() throws Exception {
		Medal Medal = new Medal ();
		Medal.setCountry("IRE");
		
		assertEquals("IRE", Medal.getCountry());
	
	}

	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetCountryInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setCountry(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("country should be 3 chars in lenght", Exception.getMessage() );
	}

	/**
	 * Test method for {@link olympics.Medal#getSetGender(java.lang.String)}.
	 */
	@Test
	void testSetGender() throws Exception {
		Medal Medal = new Medal ();
		Medal.setGender("Male");
		
		assertEquals("Male", Medal.getGender());
	
	}
	
	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetGenderInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setGender(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("invalid gender", Exception.getMessage() );
	}
	
	/**
	 * Test method for {@link olympics.Medal#getSetEvent()}.
	 */
	@Test
	void testGetEvent() throws Exception {
		Medal Medal = new Medal ();
		Medal.setEvent("100M");
		
		assertEquals("100M", Medal.getEvent());
	
	}
	
	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetEventInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setEvent(" ");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("event char to long (1-49)", Exception.getMessage() );
	}
	

	/**
	 * Test method for {@link olympics.Medal#getSetMedal()}.
	 */
	@Test
	void testGetMedal() throws Exception {
		Medal Medal = new Medal ();
		Medal.setMedal("1");
		
		assertEquals("Gold", Medal.getMedal());
	}
	
	/*
	 * Test if the exception is working 
	 */
	@Test
	void testSetMedalInvalid() {
		Medal Medal = new Medal();
		
		Exception Exception = assertThrows(Exception.class, () -> {
			Medal.setMedal("asdfg");
		});
			
		System.out.println(Exception.getMessage());
		
		assertEquals("invalid medal", Exception.getMessage() );
	}
	

	/**
	 * Test method for {@link olympics.Medal#toString()}.
	 */
	@Test
	void testToString() {
		Medal Medal = new Medal(); 
		String expected = " [Year=" + year + ", City=" + city + ", Sport=" + sport + ", Discipline=" + discipline + ", Athlete=" + athlete + ", Country=" + country + ", Gender=" + gender + ", Event=" + event + ", medal=" + medal+ "]"; 
		    }
	}


