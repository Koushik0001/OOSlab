/*21) Consider the following series
x = 1+1/1! +1/2! + 1/3! + .........1/10!
Create two threads t1 & t2. t1 will generate the denominators and t2 will form the term and add 
them up. Finally print the result. */

class SumOfSeries
{
    float sumOfSeries = 0;

    int currentDenominator;
    private int currentValue = 0;
    boolean denomCounted = false;
    synchronized void countDenom()
    {
        if(denomCounted == true)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted Exception Caught\n");
            }
        }
        if(currentValue == 0)
        {
            currentDenominator = 1;
        }
        else
        {
            int factorial = 1;
            for(int i=currentValue; i>0; i--)
                factorial = factorial*i;

            currentDenominator = factorial;
        }
        //System.out.println(currentValue + "th denominator " + currentDenominator);
        currentValue++;
        denomCounted = true;
        notify();
    }

    synchronized void add()
    {
        if(denomCounted == false)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted Exception Caught\n");
            }
        }
        sumOfSeries += (1.0/currentDenominator);
        //System.out.println(1.0/currentDenominator);
        denomCounted = false;
        notify();
    }

}
class CountDenom implements Runnable
{
    Thread t;
    SumOfSeries s;
    CountDenom(SumOfSeries s)
    {
        this.s = s;
        t = new Thread(this,"EvenThread");
        t.start();
    }
    public void run()
    {
        for(int i=0; i<=10; i++)
        {
            s.countDenom();
        }
    }
}

class Add implements Runnable
{
    Thread t;
    SumOfSeries s;
    Add(SumOfSeries s)
    {
        this.s = s;
        t = new Thread(this,"OddThread");
        t.start();
    }
    public void run()
    {
        for(int i=0; i<=10; i++)
        {
            s.add();
        }
    }
}
public class assignment21 
{
    public static void main(String []args)
    {
        SumOfSeries s = new SumOfSeries();
        CountDenom cd = new CountDenom(s);
        Add ad = new Add(s);
        
        try
        {
            cd.t.join();
            ad.t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted Exception Caught\n");
        }
        System.out.printf("Sum Of the series is : %.5f\n",s.sumOfSeries);
    }
}
