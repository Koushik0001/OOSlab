/*23) Consider the series 1+2+3+...+100. This can be considered as (1+3+5+...+99)+(2+4+6+... +100). Create two threads to compute two series in parallel (do not use simplified equation). Finally print the final sum. */
class EvenThread implements Runnable
{
    Thread t;
    int evenSum = 0;
    EvenThread()
    {
        t = new Thread(this,"EvenThread");
        t.start();
    }
    public void run()
    {
        int currentValue = 2;
        while(currentValue <= 100)
        {
            evenSum += currentValue;
            currentValue += 2;
        }
        System.out.println("Sum of the Even series = " + evenSum);
    }
}

class OddThread implements Runnable
{
    Thread t;
    int oddSum = 0;
    OddThread()
    {
        t = new Thread(this,"OddThread");
        t.start();
    }
    public void run()
    {
        int currentValue = 1;
        while(currentValue <= 100)
        {
           oddSum += currentValue;
           currentValue += 2;
        }
        System.out.println("Sum of the Odd series = " + oddSum);
    }
}

public class assignment23
{
    public static void main(String []args)
    {
        EvenThread et =  new EvenThread();
        OddThread ot = new OddThread();

        try
        {
            et.t.join();
            ot.t.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted Exception caught in main thread...");
        }
        int sum = et.evenSum + ot.oddSum;
        System.out.println("Summation of the whole series = " + sum);
    }
}
