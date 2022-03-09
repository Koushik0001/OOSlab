/*9) Write a Java class Employee containing information name, id, address, salary etc. Write necessary constructor and read/write methods.
 * Create a class Dept that has a name, location etc. The Dept contains a number of Employee. Write methods add and remove to add and remove an employee to/from this department.
 * Write a main() function and create Information Technology department. Add five employees and print yearly expenditure for this department.*/
class Employee
{
    String name, address;
    int id;
    float salary;
    Employee(String name, int id, float salary, String address)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.address = address;
    }
}
class Dept 
{
    String dept_name, location;
    class node
    {
        Employee e;
        node next;
        node(String name, int id, float salary, String address)
        {
            e = new Employee(name, id, salary, address);
            next = null;
        }
    }
    node head;
    Dept(String dept_name, String location)
    {
        this.dept_name = dept_name;
        this.location = location;
        head = null;
    }
    void add(String name, int id, float salary, String address)
    {
        node temp = head;
        if(head != null)
        {
            while(temp.next != null)
                temp = temp.next;
            temp.next = new node(name, id, salary, address);
        }
        else
        {
            head = new node(name, id, salary, address);
            head.next = null;
        }
    }
    void remove(String name, int id)
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
    }
    float Yearly_expenditure()
    {
        float expenditure = 0;
        node temp = head;
        while(temp != null)
        {
            expenditure += temp.e.salary;
            temp = temp.next;
        } 

        expenditure *= 12;
        return expenditure;
    }
    void show_employees()
    {
        node temp = head;
        while(temp != null)
        {
            System.out.println("Name : " + temp.e.name);
            System.out.println("ID :" + temp.e.id);
            System.out.println("Salary : " + temp.e.salary);
            System.out.println("Address : " + temp.e.address);
            System.out.println();
            System.out.println();
            temp = temp.next;
        }
    }
}
class DeptDemo
{
    public static void main(String []args)
    {
        Dept IT = new Dept("Information Technology","JU, Salt Lake Campus");
        IT.add("abc",123,70000,"Saltlake");
        IT.add("kiy",456,75000,"Hoogly");
        IT.add("Pjk",758,80000,"Behala");
        IT.add("mnp",476,60000,"Howrah");
        IT.add("joi",154,50000,"Saltlake");
        
        System.out.println("Yearly Expenditure of IT department is : " + IT.Yearly_expenditure());
    }
}
