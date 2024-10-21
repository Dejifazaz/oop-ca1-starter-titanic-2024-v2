package org.example;
// CA1
import java.io. * ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "titanic-data-100.csv"; // file should be in the project folder (below pom.xml)

        ArrayList<Passenger> passengerList= new ArrayList<>();

        loadPassengerDataFromFile( passengerList, fileName);

        displayAllPassengers( passengerList );


        // Assignment: Implement and test the following methods.
        // See the description of each method in the CA1 Specification PDF file from Moodle
        //Q1
        String[] names = getPassengerNames(passengerList);
        for( String name : names)
        {
            System.out.println(name);
        }

        //Q2
       getPassengersContainingNames(passengerList,"William");

        //Q3
       getPassengersOlderThan(passengerList,18);

       //Q4
      int count = countPassengersByGender(passengerList,"male");

       //Q5
       double total = sumFares(passengerList);

       //Q6
      String [] survivors = maleSurvivors(passengerList);
        for( String s : survivors)
        {
            System.out.println(s);
        }

        //Q7
       Passenger owner = ticketOwner(passengerList,"3101282");

        //Q8
       Double avgAge = averageAge(passengerList);

        //Q9
        ArrayList<Passenger> p =  getPassengersByTicketClass(passengerList,PassengerClass.FIRST);

       //Q10
        ArrayList<Passenger> sorted1 = sortPassengersByPassengerId(passengerList);
        //Q11
       ArrayList<Passenger> sorted2 = sortPassengersByName(passengerList);

//        sortPassengersByAgeThenName();
//        sortPassengersByGenderThenPassengerNumber()
//        sortPassengersByFareThenSurvival();
//        sortPassengersByTicketClass()
//        sortPassengersByAge();
//        sortPassengersByTicketNumberLambda();
//        sortPassengersByTicketNumberStatic();
//        findPassengerByTicketNumber();
//        findPassengerByPassengerId();

        System.out.println("Finished, Goodbye!");
    }

    /**
     * Populate an ArrayList of Passenger objects with data from a text file
     * @param passengerList - an ArrayList to be filled with Passenger objects
     * @param fileName - name of CSV text file containing passenger details
     */
    public static void loadPassengerDataFromFile( ArrayList<Passenger> passengerList, String fileName) {

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // John Malone,20,1.78,3.55   for example

        // Use a Regular Expression to set both comma and newline as delimiters.
        //  sc.useDelimiter("[,\\r\\n]+");
        // Text files in windows have lines ending with "CR-LF" or "\r\n" sequences.
        // or may have only a newline - "\n"
        // Windows uses CRLF (\r\n, 0D 0A) line endings while Unix just uses LF (\n, 0A).
        //
        try (Scanner sc = new Scanner(new File(fileName))
                .useDelimiter("[,\\r\\n]+"))
        {

            // skip past the first line, as it has field names (not data)
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // while there is a next token to read....
            System.out.println("Go...");

            while (sc.hasNext())
            {
                String passengerId = sc.next();    // read passenger ID
                int survived = sc.nextInt();     // 0=false, 1=true
                int passengerClass = sc.nextInt();  // passenger class, 1=1st, 2=2nd or 3rd
                String name = sc.next();
                String gender = sc.next();
                int age = sc.nextInt();
                int siblingsAndSpouses = sc.nextInt();
                int parentsAndChildren = sc.nextInt();
                String ticketNumber = sc.next();
                double fare = sc.nextDouble();
                String cabin = sc.next();
                String embarkedAt = sc.next();

                System.out.println(passengerId +", " + name);

                passengerList.add(
                        new Passenger( passengerId, survived, passengerClass,
                                name, gender, age, siblingsAndSpouses,parentsAndChildren,ticketNumber,
                                fare, cabin, embarkedAt)
                );
            }
        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }

    public static void displayAllPassengers( ArrayList<Passenger> passengerList ) {
        System.out.println("Displaying all passengers:");
        for( Passenger passenger : passengerList)
        {
            System.out.println(passenger);
        }
    }

   //Q1
    public static String[] getPassengerNames(ArrayList<Passenger> passengerList) {
        int size = passengerList.size();
        String[] names = new String[100];
        for(int i = 0; i < size;i++ )
        {
            String name = passengerList.get(i).getName();
            names[i] = name;
        }

        return names;
    }

    //Q2
    public static ArrayList<Passenger> getPassengersContainingNames(ArrayList<Passenger> passengerList,String name){

        int size = passengerList.size();
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < size; i++ ) {
            String passengerName = passengerList.get(i).getName();
            if (passengerName.contains(name)) {
                passengers.add(passengerList.get(i));
            }
        }

        return passengers;
    }

    //Q3
   public static ArrayList<Passenger> getPassengersOlderThan(ArrayList<Passenger> passengerList,int age){
       int size = passengerList.size();
       ArrayList<Passenger> passengers = new ArrayList<>();
       for(int i = 0; i < size; i++ ) {
           int passengerAge = passengerList.get(i).getAge();
           if (passengerAge > age) {
               passengers.add(passengerList.get(i));
           }
       }

       return passengers;
    }

    //Q4
    public static int countPassengersByGender(ArrayList<Passenger> passengerList,String gender){
        int size = passengerList.size();
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < size; i++ ) {
            String passengerGender = passengerList.get(i).getGender();
            if (passengerGender == gender) {
                passengers.add(passengerList.get(i));
            }
        }

        return passengers.size();
    }

    //Q5
    public static double sumFares(ArrayList<Passenger> passengerList){
        int size = passengerList.size();
       double totalFare = 0;
        for(int i = 0; i < size; i++ ) {
            double fare = passengerList.get(i).getFare();
            totalFare += fare;
        }

        return totalFare;
    }

    //Q6
    public static String[] maleSurvivors(ArrayList<Passenger> passengerList){
        int size = passengerList.size();
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < size; i++ ) {
            String passengerGender = passengerList.get(i).getGender();
            int survived = passengerList.get(i).getSurvived();
            if (passengerGender == "male" && survived == 1) {
                passengers.add(passengerList.get(i));
            }
        }

        int msize = passengers.size();
        String[] maleSurvivors = new String[msize];
        for(int i = 0; i < msize; i++ )
        {
            maleSurvivors[i] = passengers.get(i).getName();
        }

        return maleSurvivors;

    }

    //07
    public static  Passenger  ticketOwner(ArrayList<Passenger> passengerList,String ticketNumber){
        int size = passengerList.size();
        Passenger  ticketOwner = new Passenger();
        for(int i = 0; i < size; i++ ) {
           if (passengerList.get(i).getTicketNumber().equals(ticketNumber)) {
               ticketOwner = passengerList.get(i);
           }

    }

        return ticketOwner;
    }

    //Q8
    public static Double averageAge(ArrayList<Passenger> passengerList){
        int size = passengerList.size();
        int totalAge = 0;
        for(int i = 0; i < size; i++ ) {
           totalAge += passengerList.get(i).getAge();
            }

        return  (double)totalAge / size;
    }
    //Q9
    public static ArrayList<Passenger> getPassengersByTicketClass(ArrayList<Passenger> passengerList,PassengerClass ticketClass){
        int size = passengerList.size();
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < size; i++ ) {
            if (passengerList.get(i).getPassengerClass().equals(ticketClass)){
                passengers.add(passengerList.get(i));
            }
        }

        return passengers;
    }

    public  static ArrayList<Passenger>sortPassengersByPassengerId(ArrayList<Passenger> passengerList){
        ArrayList<Passenger> passengers = new ArrayList<>(passengerList);
        Collections.sort(passengers);
        return passengers;
    }
    public static ArrayList<Passenger> sortPassengersByName(ArrayList<Passenger> passengerList){
        SortByName s = new SortByName();

        return Collections.sort(passengerList, s);
    }

}