/**
 *  Tests the LinkedList class by creating multiple objects of type Node<T>.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *  Then adds countries to a singly linked list.
 *
 * @author Foothill College, [Swati Gupta]
 */

import java.util.Random;

import java.util.Scanner;

public class TestGenericList 
{
	// Sets the Scanner object to the beginning of the input stream
	// Since we will be reading user input in more than one place.
	// To avoid incorrectly closing/reopening closing the stream,
	// the reference to the stream is set as a class attribute.
	public static Scanner input = new Scanner(System.in);

	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TODO: The purpose is to help you debug
		// Note: The implementation of method is optional.
	    
       System.out.println("How many countries do you want to add to the list?");
        
        int requestedSize = Integer.parseInt( input.nextLine() );
        
        LinkedList<Country> selectedCountries = new LinkedList<Country>();
        
        for (int i = 0; i < requestedSize; i++)
        {
            selectedCountries.add(allCountries[i]);
        }
        
        String countryNames = "";
        java.util.Iterator<Country> iterator = selectedCountries.iterator();
        int counter = 0;
        while(iterator.hasNext())
        {
            countryNames += iterator.next().getName();

//            // uses a ternary operator to prettify the output
            countryNames += counter++ % 10 == 0 ? "\n" : ", ";
        }

        System.out.println("\nCountry Names: " + countryNames);
	}


	/**
	 * Creates a generic linked list. Then based on the user's input,
	 * adds a random number of countries to the list.
	 * @param allCountries      An array of Country objects
	 */
	private LinkedList<Country> createRandomListOfCountries(Country [] allCountries)
	{	
//		input = new Scanner(System.in);
		System.out.println("How many countries do you want to add to the list?");
		int requestedSize = Integer.parseInt(input.nextLine());


		// Build the list out of a random selection of countries.
		Random random = new Random();
		LinkedList<Country> selectedCountries = new LinkedList<Country>();
		for (int i = 0; i < requestedSize; i++)
		{
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}

		// Use an iterator to go through your country list and collect country names
		String countryNames = "";
		java.util.Iterator<Country> iterator = selectedCountries.iterator();
		int counter = 0;
		while(iterator.hasNext())
		{
			countryNames += iterator.next().getName();

			// uses a ternary operator to prettify the output
			countryNames += counter++ % 10 == 0 ? "\n" : ", ";
		}

		System.out.println("\nCountry Names: " + countryNames);

		return selectedCountries;
	}

	private void testSearchInList(LinkedList<Country> selectedCountryList) 
	{		
		// Tests that the iterator of the LinkedList class by calling its toString() method.
		// Note: To debug your list, comment this line in
		System.out.println("Size of list: " + selectedCountryList.size());
		System.out.println("List of countries: " + selectedCountryList);

		// Check if the name of a country is in the list.
		// If the country is found, print the details.
		// Otherwise output not found.
		System.out.println("\nWhat country do you want to search for?");
		
		String countryNameToFind = input.nextLine();

		// NOTE: The generic linked list should be able to check whether
		//       the list has an element that equals the generic type
		//       passed as an argument to the contains() method.
		Country tmpCountry = new Country(countryNameToFind);        
		Country foundCountry = selectedCountryList.contains(tmpCountry);
		
		if (foundCountry != null)		
			System.out.println("Country " + countryNameToFind + " found with details:\n" + foundCountry);       
		
		else
			System.out.println("Country " + countryNameToFind + " not found.");	
	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a generic LinkedList object.
	 */
	public static void main(String[] args) 
	{		
		// Create and set objects of type Country 
		//
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)
		final int NUM_COUNTRIES_TO_TEST = 3;			// Note: Include test cases in addition to 3


		// Parse the CSV data file
		//
		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		


		// Create and set objects of type Country 
		//
		Country [] countries;
//		countries = new Country[NUM_COUNTRIES_TO_TEST];

		Country current;
		countries = new Country[countryNames.length];

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   

			// Note: Initially convert your CountryList to a generic LinkedList and make sure that list builds 
			// 		 correctly using the original Country constructor which takes the numberOfYears to setup
			// 		 the array of subscriptions.
			// Note: Make sure to comment this out before submitting.
			//current = new Country(countryNames[countryIndex], numberOfYears);

			// Note: Once you are successful in creating a generic LinkedList of countries, create a
			// 		 LinkedList of SubscriptionYear in the Country class.
			// 	     So, your Country class should no longer have an array of SubscriptionYear objects.
			current = new Country(countryNames[countryIndex]);	


			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}

		TestGenericList application = new TestGenericList();

		// Note: Initially, to test your output you may hard code the number of 
		//       countries added, and the array positions selected.
		//		 However, make sure to comment this out before submitting your work.
//		application.debugListOfCountries(countries);
		
		System.out.println("Part 1: " + "\n") ;

		// review it
		LinkedList<Country> selectedCountryList = application.createRandomListOfCountries(countries);

		application.testSearchInList(selectedCountryList);	
		
		System.out.println("Part 2: " + "\n") ;

		
		// additional test case for searching country in list
		application.testSearchInList(selectedCountryList);    
		
		 System.out.print("\n");
		 System.out.println("Part 2: " + "\n") ;
		 
		 System.out.println("Now printing the Total subscription data of selected countries: ");
		 
		// test case for checking the getNumSubscriptionsForPeriod() 
         
         System.out.printf(countries[0].getName() + " (1960 to 2012): %.2f \n \n", 
                 countries[0].getNumSubscriptionsForPeriod(1960, 2012));

         System.out.printf(countries[155].getName() + " (1959 to 1989): %.2f \n \n", 
                 countries[155].getNumSubscriptionsForPeriod(1959, 1989));

         System.out.printf(countries[10].getName() + " (1960 to 2000): %.2f \n \n", 
                 countries[10].getNumSubscriptionsForPeriod(1960, 2000));

         System.out.printf(countries[251].getName() + " (1988 to 2012): %.2f \n \n", 
                 countries[251].getNumSubscriptionsForPeriod(1988, 2012));

         System.out.printf(countries[111].getName() + " (1961 to 2014): %.2f \n \n", 
                 countries[111].getNumSubscriptionsForPeriod(1961, 2014));
         

        // flush the error stream
        System.err.flush();

		System.out.println("\nDone with TestGenericList.");
		
		input.close();
	}
}