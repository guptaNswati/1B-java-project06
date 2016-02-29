project folder:
project06_swatig/


Brief description of submitted files:

src/Node.java
    - Node Class with two private fields, one is a generic object and second one is an object of parameterized Node type.
    - First constructor that takes in one parameter, a generic object.
    - Second constructor that takes in two parameters, a generic object and an object of parameterized Node type.
    - Include setter () for the attribute next.
    - Include getter () for all attributes.
    - Include toString () that returns the string representation of "data". 

src/LinkedList.java
    - LinkedList class that contains collection of generic Node objects and its size.
    - Implements the generic Iterable interface
    - A constructor that creates an empty LinkedList object. 
    - Include isEmpty() that checks if head is pointing to any node.
    - Include add() that takes a generic object as parameter and adds that new object to the end of the list.
    - Include contains() that takes a generic object as parameter and checks if the object can be found in the linked list.
    - Include toString() which uses an iterator to print the contents of the list.
    - Include getNodeAtIndex() that gets a node at a specific index.
    - Include size() that returns the size of the list.
    - Include iterator() that returns object of type ListIterator.
    - Have an inner class called ListIterator to traverse the collection of objects in the list.
    - ListIterator class includes
        - A generic field called current that keeps track of the current location being traversed.
        - Implements generic Iterator interface
        - A constructor that initializes current to the beginning of the list.
        - method next() that returns the next object in the list.
           

src/CSVReader.java
    - CSVReader Class with three private fields.
    - constructor that takes in filename, reads the cellular.csv file and sets its members data. 
    - getters for members.   


src/SubscriptionYear.java
    - SubscriptionYear Class having two private instance variables, year of type int & subscriptions of type double 
    - A constructor that takes in the year and number of subscriptions. 
    - Include getter() and setter() for instance variable year.
    - Include getter() and setter() for instance variable subscriptions.
    - Include toString() which returns the number of subscriptions. 
    - Include equals() that 
 

src/Country.java
    - Country Class having three private instance variables, name of type String, subscriptions a linked list of SubscriptionYear objects, minYear and maxYear of type int.
    - A constructor that takes in an object of type String, which is the name of the country and creates a new list of SubscriptionYear, initializes min year to a large number and max year to a small number.
    - Added equals() that override Object.equlas() to check if two objects of type Country are equal, based on their name.
    - Include getter() and setter() for instance variable name.
    - Include getter() and setter() for instance variable subscriptions. 
    - Includes addSubscriptionYear() that create a new SubscriptionYear object and adds it in subscriptions list. Also, updates the minimum and maximum year.
    - Includes getNumSubscriptionsForPeriod() that returns total number of subscriptions for a specified period using an iterator  .
    - Includes toString() which overrides subscription.toString() and returns a representation of the country with its data.
    

src/TestGenericList.java
    - Includes TestGenericList Class which has debugListOfCountries() and testRandomListOfCountries().
    - testRandomListOfCountries() builds a random list of countries specified by user from array of Country objects called, allCountries.
    - Tests the LinkedList class by creating multiple objects of type Node<T>.
    - The implementation of debugListOfCountries() is similar to testRandomListOfCountries() that is to build a list of countries but not randomly.It is used for initial debugging and not to be called in main.
    - Includes main() for running the application.
    - Creates one object of type CSVReader class, which reads input from a CSV file. 
    - Uses the attributes stored in CSVReader object to create objects of type Country class and adds the newest country read into the list .       
    - Adds the data for each country to an array of Country objects.
    - Adds countries to a singly linked list. 
    - Includes testSearchInList() that check if the name of a country is in the list. If the country is found, print the details.
        
        
 
resources/cellular.csv
    - A CSV (Comma Separated Value) file containing cellular data of 252 countries from 1960-2012
    - Row contains the data of each country 
    - First Column contains the country name, followed by its data in a given year 
 
resources/cellular_short.csv 
    - A short CSV file containing cellular data of 3 countries from 1960-2012 
    - Row contains the data of each country 
    - First Column contains the country names, followed by its data in a given year
    
       
resources/RUN.txt
    - console output of CSVReader.java, SubscriptionYear.java, Country.java, CountryNode.java, CountryList.java, TestCountryList.java

README.txt
    - description of submitted files