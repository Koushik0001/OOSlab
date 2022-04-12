/*20) Create two threads and call them EvenThread and OddThread. EvenThread will print number as 2 4 6 8 10... and OddThread will print number as 1 3 5.... Now synchronize these two thread to get the output as 1 2 3 4 5 6 7 8. */
class numbers
{
    private int currentValue = 0;
    int turn;
    numbers(int turn)
    {
        this.turn = turn;
    }
    synchronized int getCurrentValue(int callingfunctionNumber)
    {
        if(turn != callingfunctionNumber)
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
        return currentValue;
    }
    synchronized void incrementCurrentValue()
    {
        currentValue++;
        notify();
    }
}
class EvenThread implements Runnable
{
    Thread t;
    numbers n;
    int max_number;
    EvenThread(numbers n, int max_number)
    {
        this.max_number = max_number;
        this.n = n;
        t = new Thread(this,"EvenThread");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            int i = n.getCurrentValue(2);
            if(i>max_number)
            {
                n.turn  = 1;//telling the gerCurrentValue function that now its Evevthred's turn
                n.incrementCurrentValue();
                break;
            }
            if(i%2 == 0)
                System.out.println(i);
            else
            {
                System.out.println(n.getCurrentValue(2));
            }
            n.turn = 1;//telling the gerCurrentValue function that now its Oddthred's turn
            n.incrementCurrentValue();
        }
    }
}

class OddThread implements Runnable
{
    Thread t;
    numbers n;
    int max_number;
    OddThread(numbers n, int max_number)
    {
        this.max_number = max_number;
        this.n = n;
        t = new Thread(this,"OddThread");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            int i = n.getCurrentValue(1);
            if(i>max_number)
            {
                n.turn  = 2;//telling the gerCurrentValue function that now its Evevthred's turn
                n.incrementCurrentValue();
                break;
            }
            if(i%2 != 0)
                System.out.println(i);
            else
            {
                System.out.println(n.getCurrentValue(1));
            }
            n.turn  = 2;//telling the gerCurrentValue function that now its Evevthred's turn
            n.incrementCurrentValue();
        }
    }
}

public class assignment20 
{
    public static void main(String []args)
    {
        numbers n = new numbers(2);
        new EvenThread(n,20);
        new OddThread(n, 20);
    }
}
