/*8) Implement a class for a Book. Book contains a title (a String), a list of authors (array of authors), 
 * number of pages (an integer), price (floating point number), publisher (a String) etc. Write suitable constructor and accessor/modifier methods.
 * Implement a class for Library. A library contains a list of books (array of Book). Write add (to add a book) and remove (to delete a book) methods for library.
 * Write a main() function to create a Library and add five Book to library. Print the total price of all books.
 * */ 
class Book
{
        String title, publisher;
        String []authors;
        int pages;
        float price;
        Book(){}
        Book(String title,String publisher,int pages, float price, String ... authors)
        {
            this.title = title;
            this.publisher = publisher;
            this.pages = pages;
            this.price = price;
            this.authors = authors;
        }
}
class Library 
{
    Book []books;
    int books_count = 0;
    Library(int NumberOfBooks)
    {
        books = new Book[NumberOfBooks+1];
    }
    private static void replace(Library lib,int index1, int index2)
    {
        Book temp = lib.books[index1];
        lib.books[index1] = lib.books[index2];
        lib.books[index2] = temp;
    }
    
    int add(String title,String publisher,int pages, float price,String ... authors)
    {
        if(books_count == books.length)
        {
            System.out.println("Library is full...");
            System.out.println("No more books can be added to the library...");
            return 0;
        }
        else
        {
            books[books_count] = new Book(title, publisher, pages, price,authors);
            books_count++;
            return 1;
        }

    }
    void remove(String title, String publisher)
    {
        for(int i=0;i<books_count; i++)
        {
            if(books[i].title.equals(title))
            {
                if(books[i].publisher.equals(publisher))
                {
                    if(i != books_count)
                        replace(this,i,books_count-1);
                    books[books_count] = null;
                    books_count--;
                }
            }
        }
    }
    void ShowLibrary()
    {
        for(int i=0;i<books_count; i++)
        {
            if(books[i] != null)
            {
                System.out.println("BOOK " + i);
                System.out.println("Title  : "+ books[i].title);
                System.out.println("Publisher : " + books[i].publisher);
                System.out.println("Pages : " + books[i].pages);
                System.out.println("Price : " + books[i].price);
                System.out.printf("Authors : %s\n",books[i].authors[0]);
                if(books[i].authors.length >1)
                {
                    for(int j =1; j<books[i].authors.length; j++)
                        System.out.printf("          %s%n",books[i].authors[j]);
                }
                System.out.println();
                System.out.println();
            } 
        }
        System.out.println("#####################");
    }
}
class LibraryDemo
{
    public static void main(String []args)
    {
        Library l1 = new Library(5);
        l1.add("History of Time","Pearson",500,500,"S.Hoking","Robert Arnold");
        l1.add("History that Finds Itself","MIT Press",500,200,"Joker");
        l1.add("Forgotten Victiry","Pearson",1500,2200,"Robert Arnold");
        l1.add("Down the Memory Line","Skyline Press",200,900,"Albert Maxwell");
        l1.add("I was there","Pearson",500,100,"Robert Arnold");
        l1.ShowLibrary();

        l1.remove("History of Time","Pearson");
        l1.add("History of Time","Pearson",500,500,"S.Hoking","Robert Arnold");
        l1.ShowLibrary();

        l1.remove("Down the Memory Line","Skyline Press");
        l1.add("Glympses of future","MIT Press",500,500,"S.Hoking","Robert Arnold");
        l1.ShowLibrary();

    }
}
