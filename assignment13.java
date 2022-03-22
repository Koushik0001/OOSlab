/*13) Implement a class for a “Person”. Person has data members ‘age’, ’weight’, ‘height’, ‘dateOfBirth’, ‘address’ with proper reader/write methods etc. Now create two subclasses “Employee” and “Student”. Employee will have additional data member ‘salary’, ‘dateOfJoining’, ‘experience’ etc. Student has data members ‘roll’, ‘listOfSubjects’, their marks and methods ‘calculateGrade’. Again create two sub-classes “Technician” and “Professor” from Employee. Professor has data members ‘courses’, ‘listOfAdvisee’ and their add/remove methods. Write a main() function to demonstrate the creation of objects of different classes and their method calls.*/
class Date
{
    int year,month,day;
    Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    Date(Date d)
    {
        this.year = d.year;
        this.month = d.month;
        this.year = d.year;
    }
    void printDate()
    {
        System.out.printf("%d : %d : %d",day,month,year);
    }
}
class Person
{
    int age,weight;
    float height;
    Date dateOfBirth;
    String address;
    
    Person()
    {
        age = 0;
        weight = 0;
        height = 0;
        dateOfBirth = null;
        address = null;
    }
    void setPersonDetails(int age, int weight, float height, Date dateOgBirth, String address)
    {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOgBirth;
        this.address = address;
    }
    void showPersonDetails()
    {
        System.out.println("Age : " + age);
        System.out.println("Weignt : " + weight);
        System.out.printf("Height : %.1f feet%n",height);
        System.out.printf("Date of Birth : ");
        dateOfBirth.printDate();
        System.out.printf("%nAddress : %s%n",address);
    }
    //READER WRITER FUNCTIONS
}
abstract class Employee extends Person
{
    float salary;
    Date dateOfJoining;
    int experience ;//experience in years

    Employee(){}
    Employee(float salary, Date dateOfJoining, int experience)
    {
        this.salary = salary;
        this.dateOfBirth = dateOfJoining;
        this.experience = experience;
    }
    void setSalary(float salary)
    {
        this.salary = salary;
    }
    void setDateOfJoining(Date dj)
    {
        this.dateOfJoining = dj;
    }
    void setExperience(int y)
    {
        this.experience = y;
    }
    abstract void showEmployeeDetails();
}
class Student extends Person
{
    int roll;
    String []subjects;
    int []marks;

    Student()
    {
        roll = 0;
    }
    Student(int roll, String sub1, String sub2, String sub3, String sub4, String sub5)
    {
        this.roll = roll;
        subjects = new String[5];
        subjects[0] = sub1;
        subjects[1] = sub2;
        subjects[2] = sub3;
        subjects[3] = sub4;
        subjects[4] = sub5;
    }
    void setRoll(int r)
    {
        roll = r;
    }
    void setSubjects(String ...subs)
    {
        subjects = subs;
    }
    void setMarks(int ...m)
    {
        if(m.length >5)
        {      
            System.out.println("Marks provided for more than 5 subjects...%nProgram Tarminated...");
            System.exit(1);
        }
        marks = m;
    }
    char calculateGrade()
    {
        float total = 0;
        for(int m:marks)
            total += m;
        
        total /= 500;
        total *= 100;
        if(total >= 91)
            return 'S';
        else if(total >= 81)
            return 'A';
        else if(total >= 71)
            return 'B';
        else if(total >= 61)
            return 'C';
        else if(total >= 51)
            return 'D';
        else 
            return 'F';   
    }
    void showStudentDetails()
    {
        System.out.println("*****************************************");
        System.out.println("           STUDENT");
        showPersonDetails();
        System.out.println("Roll : " + roll);
        int i = 0;
        for(String s:subjects)
        {
            System.out.println(s + " : " + marks[i]);
            i++;
        }
        System.out.println("Grade : " + calculateGrade());
        System.out.println("*****************************************");
        System.out.println();
        System.out.println();
    }
}
class Technician extends Employee
{
    String field;//technician of what
    Technician(){}
    Technician(float salary, Date dateOfJoining, int experience, String field)
    {
        super(salary, dateOfJoining, experience);
        this.field = field;     
    }
    void setField(String field)
    {
        this.field = field;
    }
    void showEmployeeDetails()
    {
        System.out.println("*****************************************");
        System.out.println("           " + field + " Technician");
        showPersonDetails();
        System.out.println("Salary : " + salary);
        System.out.printf("Date of Joining : ");
        dateOfJoining.printDate();
        System.out.println();
        System.out.println("*****************************************");
        System.out.println();
        System.out.println();
    }   
}
class Professor extends Employee
{
    class Course
    {
        String course;
        Course next;

        Course(String course)
        {
            this.course = course;
            next = null;
        }
    }
    Course courses;
    class Advicee
    {
        String advicee;
        Advicee next;

        Advicee(String advicee)
        {
            this.advicee = advicee;
            next = null;
        }
    }
    Advicee advicees;
    {
        courses = null;
        advicees = null;
    }
    Professor(){}
    Professor(float salary, Date dateOfJoining, int experience)
    {
        super(salary,dateOfJoining,experience);
    }
    void addCourses(String ...course)
    {
        if(course.length == 0)
            return;
        
        if(courses == null)
        {
            courses = new Course(course[0]);
            for(int i=1; i<course.length; i++)
            {
                addCourses(course[i]);
            }
        }
        else
        {
            Course temp = courses;
            while(temp.next != null)
                temp = temp.next ;
            
            for(int i=0; i<course.length; i++)
            {
                temp.next = new Course(course[i]);
                temp = temp.next;
            }
        }
    }
    void removeCourse(String ... course)
    {
        if(courses == null)
            return;
        Course tracer = courses , temp = courses;
        for(int i=0; i<course.length; i++)
        {
            while(temp != null && !temp.course.equals(course[i]))
            {
                tracer = temp;
                temp = temp.next;
            }
            if(temp.course.equals(course[i]) && tracer != courses)
            {
                tracer.next = temp.next;
            }
            else if(temp.course.equals(course[i]) && tracer == courses)
            {
                courses = temp.next;
            }
        }
    }

    void addAdvicee(String ...advicee)
    {
        if(advicee.length == 0)
            return;
        
        if(advicees == null)
        {
            advicees = new Advicee(advicee[0]);
            for(int i=1; i<advicee.length; i++)
            {
                addAdvicee(advicee[i]);
            }
        }
        else
        {
            Advicee temp = advicees;
            while(temp.next != null)
                temp = temp.next ;
            
            for(int i=0; i<advicee.length; i++)
            {
                temp.next = new Advicee(advicee[i]);
                temp = temp.next;
            }
        }
    }
    void removeAdvicee(String ... advicee)
    {
        if(advicees == null)
            return;
        Advicee tracer = advicees , temp = advicees;
        for(int i=0; i<advicee.length; i++)
        {
            while(temp != null && !temp.advicee.equals(advicee[i]))
            {
                tracer = temp;
                temp = temp.next;
            }
            if(temp.advicee.equals(advicee[i]) && tracer != advicees)
            {
                tracer.next = temp.next;
            }
            else if(temp.advicee.equals(advicee[i]) && tracer == advicees)
            {
                advicees = temp.next;
            }
        }
    }

    void showEmployeeDetails()
    {
        System.out.println("*****************************************");
        System.out.println("           PROFESSOR ");
        showPersonDetails();
        System.out.println("Salary : " + salary);
        System.out.printf("Date of Joining : ");
        dateOfJoining.printDate();
        System.out.printf("%nCourses : %n");
        Course temp = courses;
        while(temp != null)
        {
            System.out.printf("     " + temp.course + "%n");
            temp = temp.next;
        }
        System.out.println("Advicee : ");
        Advicee temp2 = advicees;
        while(temp2 != null)
        {
            System.out.printf("     " + temp2.advicee + "%n");
            temp2 = temp2.next;
        }
        System.out.println("*****************************************");
        System.out.println();
        System.out.println();
    }
    //add remove methods
}
class assignment13
{
    public static void main(String []args)
    {
        Professor SB = new Professor();
        SB.setPersonDetails(30, 80, 6, new Date(13,11,1998),"Kolkata 700106, Saltlake");
        SB.setSalary(80000);
        SB.addCourses("Math","COA","Statistics");
        SB.removeCourse("Statistics");
        SB.addCourses("CN");
        SB.addAdvicee("Samir Debnath","Dipak Sarkar","Mrinal Basu");
        SB.setDateOfJoining(new Date(5,10,2012));
        SB.setExperience(9);
        SB.showEmployeeDetails();

        Technician PD = new Technician();
        PD.setPersonDetails(25, 85, 5, new Date(25,02,1998), "Saltlake, Kolkata 700106");
        PD.setDateOfJoining(new Date(12,02,2015));
        PD.setExperience(7);
        PD.setSalary(35000);
        PD.setField("LAB");
        PD.showEmployeeDetails();

        Student SL = new Student();
        SL.setPersonDetails(21, 80, 6, new Date(14,01,2005), "Saltlake, Kolkata 700106");
        SL.setRoll(1154);
        SL.setSubjects("Math","COA","CN","DBMS","OOS");
        SL.setMarks(97,86,89,91,96);
        SL.showStudentDetails();
    }
}