/* 1) Create a class “Room” which will hold the “height”, “width” and “breadth” of the room in 
three fields. This class also has a method “volume()” to calculate the volume of this room. 
Create another class “RoomDemo” which will use the earlier class, create instances of rooms, 
and display the volume of room.*/
class Room
{
    float height, width, breadth;
    Room(float height, float width, float breadth)
    {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }
    float volume()
    {
        return height*breadth*width;
    }
}
class assignment1
{
    public static void main(String[] args) 
    {
        Room room1 = new Room(12, 18, 16);
        System.out.println("Volume of the Room1 = "+room1.volume());
    }
}
