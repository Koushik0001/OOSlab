import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*22) Consider a file that contains a number of integers. Create two threads. Call them ‘producer’ and ‘consumer’ thread. Producer thread will be reading the integers from the file continuously while consumer thread will add them up. Use proper synchronization mechanism if needed.*/
class MyFile
{
    int sum = 0;
    FileInputStream fn;
    int currentInteger;
    boolean EOF = false;

    boolean readingDone = false;
    MyFile(String file)
    {
        try
        {
            fn = new FileInputStream(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found...");
        }
    }
    synchronized int getNumber() throws IOException
    {
        if(readingDone)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted Exception caught");
            }
        }
        String num = "0";
        int i = 0;
        do
        {
            i = fn.read();
            if((char)i != ' ' &&  i != -1)
                num = num + (char)i;
        }while((char)i != ' ' && i != -1);
        if(i == -1)
        {
            fn.close();
            try
            {
                currentInteger =  Integer.parseInt(num);
            }
            catch(NumberFormatException nfe){}
            EOF = true;
            readingDone = true;
            //System.out.println("Producer" + currentInteger);
            notify();
            return 0;
        }
        currentInteger =  Integer.parseInt(num);
        readingDone = true;
        //System.out.println("Producer" + currentInteger);
        notify();
        return 1;
    }

    synchronized void addNumbr()
    {
        if(!readingDone)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted Exception caught");
            }
        }
        sum += currentInteger;
        readingDone = false;
        //System.out.println("Consumerr" + currentInteger);
        notify();
    }
}
class Producer implements Runnable
{
    MyFile file;
    Thread t;
    Producer(MyFile file)
    {
        this.file = file;
        t = new Thread(this,"Producer");
        t.start();
    }
    public void run()
    {
        int i = 1;
        while(i!=0)
        {
            try
            {
                i = file.getNumber();
            }
            catch(IOException e)
            {
                System.out.println("IO Exception caught...");
            }
        }
    }
}
class Consumer implements Runnable
{
    MyFile file;
    Thread t;
    Consumer(MyFile file)
    {
        this.file = file;
        t = new Thread(this,"Producer");
        t.start();
    }
    public void run()
    {
        while(file.EOF != true)
        {
            file.addNumbr();
        }
    }
}

public class assignment22
{
    public static void main(String []args)
    {
        MyFile file = new MyFile(args[0]);
        Producer pr = new Producer(file);
        Consumer con = new Consumer(file);

        try
        {
            pr.t.join();
            con.t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted exception in the main thread...");
        }

        System.out.println("Sum = " + file.sum);

    }
}
