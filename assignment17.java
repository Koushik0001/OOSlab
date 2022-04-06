/*17) Imagine a toll booth and a bridge. Cars passing by the booth are expected to pay an amount of Rs. 50/- as toll tax. Mostly they do but sometimes a car goes by without paying. The toll booth keeps track of the number of the cars that have passed without paying, total number of cars passed by, and the total amount of money collected. Execute this with a class called “Tollbooth” and print out the result as follows:
The total number of cars passed by without paying.
Total number of cars passed by.
Total cash collected.*/
import java.util.Random;
class Tollbooth
{
    String tollBoothNumber;
    int []ragistrationNumberOfCars;
    int totalNoOfCarsPassed; //total number of cars passed
    int passedNotPaied;//total number of cars passed without paying
    int totalCashCollected;

    Tollbooth(String tBN)
    {
        tollBoothNumber = tBN;
        totalCashCollected = 0;
        totalNoOfCarsPassed = 0;//total number of cars passed
        passedNotPaied = 0;//total number of cars passed without paying
        ragistrationNumberOfCars = new int[50];
    }
    void pass(int registrationNumber,boolean paymentStatus)
    {
        totalNoOfCarsPassed++;
        if(paymentStatus != true)
        {
            ragistrationNumberOfCars[passedNotPaied] = registrationNumber;
            passedNotPaied++;
        }
        else
            totalCashCollected += 50;
    }
    static boolean pay(int x)//ifr x==0 that means toll is paied
    {
        if(x==0)
            return true;//payment done
        else
            return false;//not paied
    }
    int getNumberOfCarsPassedUnpaied(){return passedNotPaied;}
    int getTotalCarsPassed(){return totalNoOfCarsPassed;}
    int getCashCollected(){return totalCashCollected;}
    void printRegNoOfcarsPassedUnpaid()
    {
        System.out.println("Ragistration Numbers of cars thst Passed Unpaid are:");
        for(int i =0; i<passedNotPaied; i++)
            System.out.println(ragistrationNumberOfCars[i]);
    }

}
public class assignment17
{
    public static void main(String []args)
    {
        Random registrationNumber = new Random();

        Tollbooth t1 = new Tollbooth("WB36421");

        for(int i=0; i<10; i++)
        {
            int carNumber = registrationNumber.nextInt(1000,5000);
            t1.pass(carNumber, Tollbooth.pay(carNumber%2));
        }
        System.out.println("Total number of cars passed : " + t1.getTotalCarsPassed());
        System.out.println("Total number of cars passed by without paying : " + t1.getNumberOfCarsPassedUnpaied());
        System.out.println("Total cash collected : " + t1.getCashCollected());
        t1.printRegNoOfcarsPassedUnpaid();

    }
}
