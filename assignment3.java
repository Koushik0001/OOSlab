/* 3) Write a class “Box” that with three member-variables “height”, “width” and “breadth”. 
Write suitable constructors to initialize them. Add functions like “getVolume” and “getArea” 
that will return volume and surface area respectively. Instantiate two arbitrary boxes and then 
print their volume and surface area.*/
class Box 
{
    float height,width, breadth;
    Box(float height, float width, float breadth)
    {
        this.height = height;
        this.breadth = breadth;
        this.width = width;
    }
    float getVolume(){return height*breadth*width;}
    float getArea(){return breadth*width;}
}


public class assignment3 
{
    public static void main(String []args)
    {
        Box b1 = new Box(1,2,3);
        Box b2 = new Box(4, 4, 4);

        System.out.println("Volume of box1 : " + b1.getVolume());
        System.out.println("Surface Area of box1 : " + b1.getArea());

        System.out.println("Volume of box2 : " + b2.getVolume());
        System.out.println("Surface Area of box2 : " + b2.getArea());
    }
}
