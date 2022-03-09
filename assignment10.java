/*10) Implement a class for a Student. Information about a student includes name, roll no and an array of five subject names. The class should have suitable constructor and get/set methods. Implement a class TabulationSheet. A tabulation sheet contains roll numbers and marks of each student for a particular subject. This class should have a method for adding the marks and roll no of a student.
 * Implement a class MarkSheet. A mark sheet contains marks of all subjects for a particular student. This class should have a method to add name of a student and marks in each subject. Write a main() function to create three Student objects, Five Tabulationsheet objects for Five subjects and three Marksheet object for three students. Print the mark sheets.
 * */
class Student
{
    private String name;
    private int roll;
    private String []subjects;
    Student(String n,int r, String ... sub)
    {
            name = n;
            roll = r;
            subjects = sub;
    }
    void setname(String n){ name = n;}
    void setroll(int r){ roll = r;}
    void setsubs(String ... sub){ subjects = sub;}
    String getname(){ return name;}
    int getroll(){ return roll;}
    String[] getsubs(){return subjects;}
}
class Tabulationsheet
{
    String subjectname;
    class Studentmarks
    {
        int roll;
        float marks;
        Studentmarks nextstudent;
        Studentmarks(int roll,float marks)
        {
            this.roll = roll;
            this.marks = marks;
        }
    }
    Studentmarks head;
    Tabulationsheet(String subjectname,Classroom clr)
    {
        this.subjectname = subjectname;
        head = null;
        add_from_classroom(clr);
    }
    void addmarks(int roll,float marks)
    {
        Studentmarks temp = head;
        int found = 0;
        while(temp != null)
        {
            if(temp.roll == roll)
            {
                temp.marks = marks; 
                found = 1;
            }
            temp = temp.nextstudent;
        }
        if(found == 0)
            System.out.println("The roll"+ roll +" number does not exist for the subject" + subjectname);
    }
    private void add(int roll)
    {
        Studentmarks temp = head;
        if(head != null)
        {
            while(temp.nextstudent != null)
                temp = temp.nextstudent;
            temp.nextstudent = new Studentmarks(roll, -1);
        }
        else
        {
            head = new Studentmarks(roll, -1);
            head.nextstudent = null;
        }
    }
    void add_from_classroom(Classroom clr)
    {
        clr.temp = clr.students;
        while(clr.temp != null)
        {
            for(int i=0; i<5; i++)
            {
                if(clr.temp.s.getsubs()[i].equals(subjectname))
                    add(clr.temp.s.getroll());
            }
            clr.temp = clr.temp.next;
        }
    }
    float getmarks(int roll)
    {
        Studentmarks temp = head;
        while(temp != null)
        {
            if(temp.roll == roll)
                return temp.marks;  
            temp = temp.nextstudent;
        }
        return -1;
    }
    void remove(int roll)
    {
        Studentmarks temp = head;
        Studentmarks tracer = head;
        while(temp != null)
        {
            if(temp.roll == roll && temp != head)
            {
                tracer.nextstudent = temp.nextstudent;
                break;
            }
            else if(temp.roll == roll && temp == head)
            {
                head = temp.nextstudent;
                break;
            }
            tracer = temp;
            temp = temp.nextstudent;
        }
    }
}
class Marksheet
{
    class node
    {
        String name;
        String []subs;
        float []marks;
        int roll;
        node next;
        node(String name, int roll, float []marks, String []subs)
        {
            this.name = name;
            this.roll = roll;
            this.marks = marks;
            this.subs = subs; 
        }
    }
    node marksheets;
    Marksheet(Classroom clr,Tabulationsheet ... tsheets)
    {
        clr.temp = clr.students;
        /*float []marks = new float[5];
 *         String []subs = new String[5];*///giving wrong answer if memory allocation done here
        while(clr.temp != null)
        {
            float []marks = new float[5];
            String []subs = new String[5];
            for(int i=0,j=0; i<tsheets.length && j<5 ; i++)
            {
                if(tsheets[i].getmarks(clr.temp.s.getroll()) != -1)
                {
                    subs[j] = tsheets[i].subjectname;
                    marks[j] = tsheets[i].getmarks(clr.temp.s.getroll());
                    j++;
                }
            }
            add(clr.temp.s.getname(),clr.temp.s.getroll(),marks,subs);
            clr.temp = clr.temp.next;
        }
    }
    void add(String name, int roll, float []marks, String ... subs)
    {
        node temp = marksheets;
        if(marksheets != null)
        {
            while(temp.next != null)
                temp = temp.next;
            temp.next = new node(name, roll, marks, subs);
        }
        else
        {
            marksheets = new node(name, roll, marks, subs);
            marksheets.next = null;
        }
    }
    void printMarksheet()
    {
        node temp = marksheets;
        while(temp != null)
        {
            System.out.println("------------------MARKSHEET----------------------");
            System.out.println("            Name : " + temp.name);
            System.out.println("            Roll : " + temp.roll);
            for(int i=0; i<5; i++)
            {
                System.out.printf("%-4s : %6.2f%n",temp.subs[i],temp.marks[i]);
            }
            System.out.println("-------------------------------------------------");
            System.out.println();
            temp = temp.next;
        }
    }
}
class Classroom
{
    String class_year;
    int calender_year;
    class node
    {
        Student s;
        node next;
        node(String n,int r, String ... sub)
        {
            s = new Student(n,r,sub);
        }
    }
    node students;
    node temp;
    Classroom(int class_year,int calender_year)
    {
        this.class_year = class_year + "st/nd/th year";
        this.calender_year = calender_year;
        students = null;
    }
    void add(String n,int r, String ... sub)
    {
        node temp = students;
        if(students != null)
        {
            while(temp.next != null)
                temp = temp.next;
            temp.next = new node(n, r, sub);
        }
        else
        {
            students = new node(n, r, sub);
            students.next = null;
        }
    }
    void remove(String name, int roll)
    {
        node temp = students;
        node tracer = students;
        while(temp != null)
        {
            if(temp.s.getroll() == roll && temp.s.getname().equals(name) && temp != students)
            {
                tracer.next = temp.next;
                break;
            }
            else if(temp.s.getroll() == roll && temp.s.getname().equals(name) && temp == students)
            {
                students = temp.next;
                break;
            }
            tracer = temp;
            temp = temp.next;
        }
    }
}
class StudentMarksDemo
{
    public static void main(String []args)
    {
        Classroom IT_2nd_2024 = new Classroom(2, 2022);
        IT_2nd_2024.add("Abc",1,"OOS","CN","GGM","DBMS","Math");
        IT_2nd_2024.add("Xyz",2,"OOS","CN","GGM","DBMS","Math");
        IT_2nd_2024.add("Pqr",3,"OOS","CN","GGM","DBMS","Math");

        Tabulationsheet oos = new Tabulationsheet("OOS",IT_2nd_2024);
        Tabulationsheet cn = new Tabulationsheet("CN",IT_2nd_2024);
        Tabulationsheet ggm = new Tabulationsheet("GGM",IT_2nd_2024);
        Tabulationsheet dbms = new Tabulationsheet("DBMS",IT_2nd_2024);
        Tabulationsheet math = new Tabulationsheet("Math",IT_2nd_2024);

        oos.addmarks(1, 100);
        oos.addmarks(2, 98);
        oos.addmarks(3, 97);

        cn.addmarks(1, 99);
        cn.addmarks(2, 93);
        cn.addmarks(3, 92);
        
        ggm.addmarks(1, 95);
        ggm.addmarks(2, 99);
        ggm.addmarks(3, 99);

        dbms.addmarks(1, 91);
        dbms.addmarks(2, 92);
        dbms.addmarks(3, 95);

        math.addmarks(1, 96);
        math.addmarks(2, 97);
        math.addmarks(3, 96);

        Marksheet markshett_IT_2024_2nd = new Marksheet(IT_2nd_2024,oos,cn,ggm,dbms,math);
        markshett_IT_2024_2nd.printMarksheet();

    }
}
