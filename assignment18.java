/*18) Write two interfaces “Fruit” and “Vegetable” containing methods ‘hasAPeel’ and ‘hasARoot’. Now write a class “Tomato” implementing Fruit and Vegetable. Instantiate an object of Tomato. Print the details of this object. */
interface Fruit{void hasAPeel();}
interface Vegetable{void hasARoot();}

class Tomato implements Fruit, Vegetable
{
    String name;
    Tomato(String name){this.name = name;}
    String getName(){return name;}
    public void hasAPeel()
    {
        System.out.println("This has a Peel but there is no need for Peeling.");
    }
    public void hasARoot()
    {
        System.out.println("This does not come with the root");
    }
}
public class assignment18
{
    public static void main(String []args)
    {
        Tomato t1 = new Tomato("CGN-89564-2");
        System.out.println("Name : "+t1.getName());
        t1.hasAPeel();
        t1.hasARoot();
    }
}
