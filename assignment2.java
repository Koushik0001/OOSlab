/*2) Write a program to implement a class “student” with the following members. Name of the student.
Marks of the student obtained in three subjects.
Function to assign initial values.
Function to compute total average.
Function to display the student’s name and the total marks.
Write an appropriate main() function to demonstrate the functioning of the above. */
class Student
{
    int []marks;
    String name;
    Student(){}
    Student(String name, int...marks)
    {
        this.name = name;
        this.marks = marks;
    }
    void setName(String name){this.name = name;}
    void setMarks(int ...marks){this.marks = marks;}

    String getName(){return name;}

    float totalAverage(){return (marks[0]+marks[1]+marks[2])/3 ;}
    float total(){return (marks[0]+marks[1]+marks[2]);}
}
public class assignment2 
{
    public static void main(String []args)
    {
        Student s1 = new Student();
        s1.setName("Koushik Mahanta");
        s1.setMarks(97,97,97);
        
        System.out.println("Name : " + s1.getName());
        System.out.println("Total Marks = " + s1.total());
    }
}
