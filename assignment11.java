/*11) Create an abstract class Publication, with data members noOfPages, price, publisherName etc. with their accessor/modifier functions. Now create two sub-classes Book and Journal Create a class Library that contains a list of Publications. Write a main() function
and create three Books and two Journals, add them to library and print the details of all publications.
*/
class Date
{
    int year,month,day;
    Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    void printDate()
    {
        System.out.printf(day + "." + month + "." + year);
    }
}
abstract class Publication
{
    int noOfPages;
    float price;
    String publisherName;
    Publication(int noP,float pri, String pname)
    {
        noOfPages = noP;
        price = pri;
        publisherName = pname;
    }
    int getNoofPages()
    {
        return noOfPages;
    }
    float getprice()
    {
        return price;
    }
    String getPublisher()
    {
        return publisherName;
    }
    void setnoOfPages(int n)
    {
        noOfPages = n;
    }
    void setprice(float p)
    {
        price = p;
    }
    void setPublisher(String publisher)
    {
        publisherName = publisher;
    }
    abstract void printPublication();
}
class Book extends Publication
{
    String title;
    String author;
    Book(String title, String author,int noP,float pri, String pname)
    {
        super(noP, pri, pname);
        this.title = title;
        this.author = author;
    }
    void printPublication() 
    {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Publisher : " + publisherName);
        System.out.println("No of Pages : " + noOfPages);
        System.out.println("Price : " + price);
    }
}
class Journal extends Publication
{
    Date issueDate;
    String subject;
    int volumes;
    Journal(String Sub,Date issueD,int vol,int noP,float pri, String pname)
    {
        super(noP, pri, pname);
        volumes = vol;
        subject = Sub;
        issueDate = issueD;
    }
    void printPublication() 
    {
        System.out.println("Subject : " + subject);
        System.out.printf("Issue Date : ");
	issueDate.printDate();
	System.out.println();
        System.out.println("Volumes :" + volumes);
        System.out.println("Publisher : " + publisherName);
        System.out.println("No of Pages : " + noOfPages);
        System.out.println("Price : " + price);
    }
}
class Library
{
    class node
    {
        Publication p;
        node next;
        node(Publication p)
        {
            this.p = p;
            next = null;
        }
    }
    node head;
    Library()
    {
   	head = null;
    }
    void add(Publication p)
    {
        node temp = head;
        if(head != null)
        {
            while(temp.next != null)
                temp = temp.next;
            temp.next = new node(p);
        }
        else
        {
            head = new node(p);
        }
    }
   /* void remove()
    {
        node temp = head;
        node tracer = head;
        while(temp != null)
        {
            if(temp.e.id == id && temp.e.name.equals(name) && temp != head)
            {
                tracer.next = temp.next;
                break;
            }
            else if(temp.e.id == id && temp.e.name.equals(name) && temp == head)
            {
                head = temp.next;
                break;
            }
            tracer = temp;
            temp = temp.next;
        }
    }*/

     void showLibrary()
    {
        node temp = head;
        while(temp != null)
        {
	    temp.p.printPublication();
     	    System.out.println();
            System.out.println();
            temp = temp.next;
        }
    }
}
class PublicationDemo 
{
	public static void main(String []args)
	{
		Publication b1 = new Book("History of Time","Stephen Howking",1000,2500,"MIT Press");
		Publication b2 = new Book("ABC of Computer","Sayan Maji",2000,5000,"Klkata Press");
		Publication b3 = new Book("Dreams Does Come True","William Black",500,1500,"Sun shine Pubication");

		Publication j1 = new Journal("Switching Algorithm",new Date(9,03,2021),2,4000,2000,"US Press");
		Publication j2 = new Journal("Mental Health",new Date(4,4,2020),3,3500,4500,"Colobia Press");
		
		Library l1 = new Library();
		l1.add(b1);
		l1.add(b2);
		l1.add(b3);
		l1.add(j1);
		l1.add(j2);

		l1.showLibrary();
	}
}

