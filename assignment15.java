import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Shape 
{
    double area();
    void draw();
    void rotate()throws IOException;
    void move() throws IOException;
}

class Circle implements Shape 
{
    private double radius;
    private int x, y;

    Circle(double r) 
    {
        radius = r;
        x = 0;
        y = 0;
    }

    public double getRadius(){return radius;}
    public int getX() {return x;}
    public int getY(){return y;}

    public void setRadius(double radius) {this.radius = radius;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public double area() 
    {
        double area = Math.PI * radius * radius;

        System.out.println("The area of the circle is " + area + "sq. unit area.");
        return area;
    }

    public void draw() {
        System.out.println("    --   ");
        System.out.println(" -      -   ");
        System.out.println("-        -  ");
        System.out.println("-        - ");
        System.out.println(" -      -  ");
        System.out.println("    --   ");
    }

    public void move() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the units to be moved in X coordinates");
        int xMove = Integer.parseInt(br.readLine());
        System.out.println("Enter the units to be moved in Y coordinates");
        int yMove = Integer.parseInt(br.readLine());

        x += xMove;
        y += yMove;

        System.out.println("Moving the circle from the {0, 0}. The new coordinates of the center of the circle is {" + x
                + ", " + y + "}.");
        
    }

    public void rotate()
    {
        System.out.println("Rotating a circle about its centre doesn't change anything.");
    }
}

class Rectangle implements Shape 
{
    private double height, breadth;

    Rectangle(double h, double b)
    {
        height = h;
        breadth = b;
    }

    public double getBreadth() {return breadth;}
    public double getHeight() {return height;}
    public void setBreadth(double breadth) {this.breadth = breadth;}
    public void setHeight(double height) {this.height = height;}

    public void draw()
    {
        System.out.println(" ------------------ ");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println(" ------------------ ");
    }
    public double area() 
    {
        double area = breadth * height;

        System.out.println("The area of the rectangle is " + area + "sq. unit area.");
        return area;
    }

    public void move() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("The initial position of bottom left corner of {0,0}");

        System.out.println("Enter the units to be moved in X coordinates");
        double newX = Integer.parseInt(br.readLine());

        System.out.println("Enter the units to be moved in Y coordinates");
        double newY = Integer.parseInt(br.readLine());

        System.out.println("The bottom left corner of the rectangle is in {" + newX + "," + newY + "}");
        System.out.println("The top left corner of the rectangle is in {" + newX + "," + (double)(newY+height) + "}");
        System.out.println("The bottom right corner of the rectangle is in {" + (double)(newX+breadth) + "," + newY + "}");
        System.out.println("The top right corner of the rectangle is in {" + (double)(newX+breadth) + "," + (double)(newY+height) + "}");
        br.close();
    }

    public void rotate() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("The initial coordinates of top right corner of rectangle is {" + breadth + "," + height + "}");
        System.out.println("Enter 1 to rotate clockwise or 2 to rotate anti clockwise");

        int dcs = Integer.parseInt(br.readLine());

        if(dcs == 1){
            System.out.println("The new coordinates of top right corner of rectangle is {" + height + "," + breadth + "}");
        }
        else if(dcs == 2){
            System.out.println("The new coordinates of top right corner of rectangle is {" + 0 + "," + breadth + "}");
        }
        br.close();
    }

}

public class assignment15 {
    public static void main(String[] args) 
    {
        Circle c = new Circle(4);
        try
        {
            c.move();

            Rectangle r = new Rectangle(10, 20);
            r.move();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}