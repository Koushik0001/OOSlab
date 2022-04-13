//import java.io.FileInputStream;
//import java.io.IOError;
import java.io.IOException;

/*24) Consider the following parallel binary search algorithm for series a1, a2...an sorted in increasing order such that n mod 10 = 0. Element to be searched is e.

a) Create n/10 threads t1, t2,..,tn/10.
b) Distribute the numbers among threads such that ti will have numbers ai, ai+1, ....a2i-1. 
c) Distribute the element e to all threads.
d) Each thread searches the element e in its sub-array using binary search algorithm.

25) Write a Java program using threading technology and print the thread index and location where the element has been found.*/

class ChildThread implements Runnable
{
    int threadIndex;
    int elementIndex;
    int element; 

    int []array;
    int startIndex;
    int endIndex;

    Thread t;
    ChildThread(int threadIndex, int []array,int startIndex, int endIndex,int element)
    {
        this.threadIndex = threadIndex;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
        this.element = element;
        t = new Thread(this,"Thread "+threadIndex);
        t.start();
    }

    public void run()
    {
        int left = startIndex;
        int right = endIndex;
        
        int mid;

        while(left<= right)
        {
            mid = (left+right)/2;
            if(element == array[mid])
            {
                elementIndex = mid;
                break;
            }
            else if(element < array[mid])
                right = mid-1;

            else if(element > array[mid])
                left = mid+1;
        }

        if(left > right)
            elementIndex = -1;
    }
}



public class assignment24
{
    public static void main(String []args) throws IOException
    {
        int []array = new int[]{0,1,3,4,5,6,10,12,14,17,19,21,23,25,27,29,31,34,35,38};

        //for reading the numbers from a file
        //FileInputStream fn = new FileInputStream(args[0]);
        //int index = 0;
        //String num = "0";
        //int i = 0;
        //while(i!= -1)
        //{
        //    do
        //    {
        //        i = fn.read();
        //        if((char)i != ' ' &&  i != -1)
        //            num = num + (char)i;
        //    }while((char)i != ' ' && i != -1);
        //    if(i == -1)
        //    {
        //        fn.close();
        //        try
        //        {
        //            array[index] =  Integer.parseInt(num);
        //        }
        //        catch(NumberFormatException nfe){}
        //    }
        //    System.out.println(array[index]);
        //    index++;
        //}
        ChildThread ch1 = new ChildThread(1, array, 0, 9, 12);
        ChildThread ch2 = new ChildThread(2, array, 10, 19, 35);

        try
        {
            ch1.t.join();
            ch2.t.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted exception caught in main thred...");
        }
        System.out.println("Index of searched element in thred 1 : " + ch1.elementIndex);
        System.out.println("Index of searched element in thred 2 : " + ch2.elementIndex);
    }
}
