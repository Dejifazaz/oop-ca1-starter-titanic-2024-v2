package org.example;
//ca1
public class Passenger implements Comparable<Passenger>{
    private String passengerId;    // passenger number
    private int survived;           // 0=false, 1=true
    private PassengerClass passengerClass;  // passenger class, 1=1st, 2=2nd or 3rd class
    private String name;
    private String gender;
    private int age;
    private int siblingsAndSpouses ;    // number of
    private int parentsAndChildren;     // number of
    private String ticketNumber;
    private double fare;                // cost of ticket
    private String cabin;           // cabin, list of cabins or NoCabin
    private String embarkedAt;      // port where passenger boarded ship

    public Passenger(){

    }

    public Passenger(String passengerId, int survived, int passengerClassAsNumber, String name,
                     String gender, int age, int siblingsAndSpouses, int parentsAndChildren,
                     String ticketNumber, double fare, String cabin, String embarkedAt) {
        this.passengerId = passengerId;
        this.survived = survived;

        if(passengerClassAsNumber==1)
            passengerClass=PassengerClass.FIRST;
        else if(passengerClassAsNumber==2)
            passengerClass=PassengerClass.SECOND;
        else if(passengerClassAsNumber==3)
            passengerClass=PassengerClass.THIRD;
        else if(passengerClassAsNumber==4)
            passengerClass=PassengerClass.UNKNOWN;

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.siblingsAndSpouses = siblingsAndSpouses;
        this.parentsAndChildren = parentsAndChildren;
        this.ticketNumber = ticketNumber;
        this.fare = fare;
        this.cabin = cabin;
        this.embarkedAt = embarkedAt;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId='" + passengerId + '\'' +
                ", survived=" + survived +
                ", passengerClass=" + passengerClass +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", siblingsAndSpouses=" + siblingsAndSpouses +
                ", parentsAndChildren=" + parentsAndChildren +
                ", ticketNumber=" + ticketNumber +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarkedAt='" + embarkedAt + '\'' +
                '}';
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public PassengerClass getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(PassengerClass passengerClass) {
        this.passengerClass = passengerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSiblingsAndSpouses() {
        return siblingsAndSpouses;
    }

    public void setSiblingsAndSpouses(int siblingsAndSpouses) {
        this.siblingsAndSpouses = siblingsAndSpouses;
    }

    public int getParentsAndChildren() {
        return parentsAndChildren;
    }

    public void setParentsAndChildren(int parentsAndChildren) {
        this.parentsAndChildren = parentsAndChildren;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getHasCabin() {
        return cabin;
    }

    public void setHasCabin(String hasCabin) {
        this.cabin = hasCabin;
    }

    public String getEmbarkedAt() {
        return embarkedAt;
    }

    public void setEmbarkedAt(String embarkedAt) {
        this.embarkedAt = embarkedAt;
    }

    @Override
    public int compareTo(Passenger other){
        int otherId = Integer.parseInt(other.passengerId);
        int thisId = Integer.parseInt(this.passengerId);
        return Integer.compare(thisId, otherId);
    }
}
