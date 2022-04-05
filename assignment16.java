import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*16) A bookshop maintains the inventory of books that are being sold at the shop. The list 
includes details such as author, title, publisher, cost and stock position. Whenever a customer 
wants a book, the sales person inputs the title and author and the system searches the list and 
displays whether it is available or not. If it is not, an appropriate message is displayed. If 
it is, then the system displays the book details and details and requests for the number of 
copies required. If the required copies are available, the total cost of the requested copies 
is displayed, otherwise the message “requires copies not in stock” is displayed. Design a 
system using a class called “Book” with suitable member methods and constructors. */

class Book 
{
    String author;
    String title;
    String publisher;
    float cost;

    Book(String author, String title, String publisher, float cost)
    {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.cost = cost;
    }
    void setAuthor(String author){this.author = author;}
    void setTitle(String title){this.title = title;}
    void setPublisher(String publisher){this.publisher = publisher;}
    void setCost(float cost){this.cost = cost;}

    String getAuthor(){return author;}
    String getTitle(){return title;}
    String getPublisher(){return publisher;}
    float getCost(){return cost;}

    void printDetails()
    {
        PrintWriter pw = new PrintWriter(System.out,true);
        pw.println("Author : " + author);
        pw.println("Title : " + title);
        pw.println("Publisher : " + publisher);
        pw.println("Cost : " + cost);
    }
}
class Inventory
{
    class ListElement
    {
        Book book;
        ListElement next;
        
        ListElement(Book book)
        {
            this.book = book;
            this.next = null;
        }
    }
    ListElement books = null;
    void addBook(Book book)
    {
        if(books == null)
            books = new ListElement(book);
        else
        {
            ListElement temp = books;
            while(temp.next != null)
                temp = temp.next;

            temp.next = new ListElement(book);
        }
    }
    void findBook(String title, String author)
    {
        ListElement temp = books;
        Book searchedBook = null;
        int numberOfCopiesAvailable = 0;

        while(temp.next != null)
        {
            if(title.toLowerCase().equals(temp.book.title.toLowerCase()) && author.toLowerCase().equals(temp.book.author.toLowerCase()))
            {
                searchedBook = temp.book;
                numberOfCopiesAvailable++;
            }
            temp = temp.next;
        }
        PrintWriter pw = new PrintWriter(System.out,true);
        if(numberOfCopiesAvailable > 0)
        {
            pw.println();
            pw.println("The book is available.");
            pw.println("Details : ");
            searchedBook.printDetails();
            pw.println("How many copies do you need : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                int copiesNeeded = Integer.parseInt(br.readLine());
                if(copiesNeeded <= numberOfCopiesAvailable)
                {
                    pw.println("Total Cost = " + copiesNeeded*searchedBook.cost);
                }
                else
                {
                    pw.println("Required copies not available");
                }
            }
            catch (IOException io)
            {
                pw.println("An IO exceotion Occured...");
                pw.print(io);
            }
        }
        else
            pw.println("The book is not available.");
    }
}
class assignment16
{
    public static void main(String []args)
    {
        Inventory In1 = new Inventory();
        In1.addBook(new Book("S.Hoking","History Of Time","Pearson",1000));
        In1.addBook(new Book("Robert Arnold","Forgotten Victiry","Pearson",1500));
        In1.addBook(new Book("Albert Maxwell","Down the Memory Lane","Skyline Press",4000));
        In1.addBook(new Book("S.Hoking","History Of Time","Pearson",1000));
        In1.addBook(new Book("Robert Arnold","I was there","Pearson",1500));
        In1.addBook((new Book("Joker","History that Finds Itself","MIT Press",2500)));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Title of the Book : ");
        try
        {
            String title = br.readLine();
            System.out.print("Enter Name of the Author : ");
            String author = br.readLine();
            In1.findBook(title, author);
        }
        catch(IOException io)
        {
            System.out.println("IO Exception Occured.");
            System.out.print(io);
        }
    }
}