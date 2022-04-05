/*14) Create a base class “Automobile”. An Automobile contains data members ‘make’, ‘type’, ‘maxSpeed’, ‘price’, ‘mileage’, ‘registrationNumber’ etc. with their reader/writer methods. Now create two sub-classes “Track” and “Car”. Track has data members ‘capacity’, ‘hoodType’, ‘noOfWheels’ etc. Car has data members ‘noOfDoors’, ‘seatingCapacity’ and their reader/writer methods. Create a main() function to demonstrate this.
*/
class Automobile
{
    String make;
    String type;
    int maxspeed;
    double price;
    double mileage;
    String registrationNumber;

    void setAutomobileDetails(String make, String type, int maxspeed, double price, double mileage,String registrationNumber)
    {
        this.make = make;
        this.type = type;
        this.maxspeed = maxspeed;
        this.price = price;
        this.mileage = mileage;
        this.registrationNumber = registrationNumber;
    }

    void setMake(String make){this.make = make;}
    void setType(String type){this.type = type;}
    void setMaxspeed(int maxspeed){this.maxspeed = maxspeed;}
    void setPrice(double price){this.price = price;}
    void setMileage(double mileage){this.mileage = mileage;}
    void setRegistrationNumber(String registrationNumber){this.registrationNumber = registrationNumber;}

    void showAutomobileDatails()
    {
        System.out.println("Make : " + make);
        System.out.println("Type : " + type);
        System.out.println("Maximum Speed : " + maxspeed + " km/h");
        if(price>=1000000)
            System.out.println("Price : " + " Rs." +price/1000000 + " Million" );
        else    
            System.out.println("Price : " + " Rs." +price/1000000 + " Million" );
        System.out.println("Mileage : " + mileage + " kmpl");
        System.out.println("Registration Number : " + registrationNumber);
    }

}
class Truck extends Automobile
{
    int capacity;
    String hoodType;
    int noOfWheels;

    void setCapacity(int capacity){this.capacity = capacity;}
    void setHoodType(String hoodType){this.hoodType = hoodType;}
    void setNoOfWheels(int noOfWheels){this.noOfWheels = noOfWheels;}

    void showTruckDetails()
    {
        showAutomobileDatails();
        System.out.println("Capacity : " + capacity + " kg");
        System.out.println("Hood Type : " + hoodType);
        System.out.println("Number of Wheels : " + noOfWheels);
        System.out.println();
        System.out.println();
    }
}
class Car extends Automobile
{
    int noOfDoors;
    int seatingCapacity;

    void setNoOfDoors(int noOfDoors){this.noOfDoors = noOfDoors;}
    void setSeatingCapacity(int seatingCapacity){this.seatingCapacity = seatingCapacity;}

    void showCarDetails()
    {
        showAutomobileDatails();
        System.out.println("Number of Doors : " + noOfDoors);
        System.out.println("Seating Capacity : " + seatingCapacity);
        System.out.println();
        System.out.println();
    }
}
public class assignment14 
{
    public static void main(String []args)
    {
        Car c1 = new Car();
        Truck t1 = new Truck();

        c1.setAutomobileDetails("Lamborghini", "Sports Car ", 355, 71813280.0, 7.7, "WB63L95");
        c1.setNoOfDoors(2);
        c1.setSeatingCapacity(2);
        c1.showCarDetails();

        System.out.println();
        System.out.println();

        t1.setAutomobileDetails("Tata", "Semitrailer", 180, 2000000, 1.8, "WB58T76");
        t1.setHoodType("Long Hood");
        t1.setCapacity(4000);
        t1.setNoOfWheels(8);
        t1.showTruckDetails();
    }   
}
