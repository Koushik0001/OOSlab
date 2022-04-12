/*19) Write a program to create two threads. Print “In main thread” in main thread and “In 
child thread” in child thread. */
class ChildThread implements Runnable
{
    Thread t;
    ChildThread()
    {
        t = new Thread(this,"child thread");
        t.start();
    }
    public void run()
    {
        System.out.println("In child thread");
    }
}
class assignment19
{
    public static void main(String []args)
    {
        ChildThread ct = new ChildThread();
        try
        {
            ct.t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("In Main thread");
    }
}