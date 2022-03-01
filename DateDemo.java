/*
    7) Implement a class for “Date”. Write member functions for (i) getting 
the previous day, (iv) getting the next day, (iii) printing a day
There should be four constructors: (i) day, month and year are initialized to 
01, 01, 1970; (ii) day is initialized to user specified value but month and 
year are initialized to 01, 1970; (iii) day, month are initialized to user 
specified value but year is initialized to 1970; (iv) day, month and year are 
initialized to user defined values.
Also, write a main() function to (i) create a date object; (ii) print the next 
and the previous day.
*/

class Date
{
    int day, month, year;
    Date(int d, int m, int y)
    {
        if(d > lastDayofMonth(m, y) || m>12 || m<1)
        {
            System.out.println("Illegal initialisation of Date object...");
            System.out.println("Day (" + d + " : " + m + " : " + y  + ") does not exist...");
            System.out.println("Process terminated...");
            System.exit(1);
        }
        day = d;
        month = m;
        year = y;
    }
    Date(int d,int m)
    {
        if(d > lastDayofMonth(m, 1970) || m>12 || m<1)
        {
            System.out.println("Day" + d + " : " + m + " : " + 1970 + "does not exist...");
            System.exit(1);
        }
        day = d;
        month = m;
        year = 1970;
    }
    Date(int d)
    {
        if(d > lastDayofMonth(1, 1970))
        {
            System.out.println("Day" + d + " : " + 1 + " : " + 1970  + "does not exist...");
            System.exit(1);
        }
        day = d;
        month = 01;
        year = 1970;
    }
    Date()
    {
        day = 01;
        month = 01;
        year = 1970;
    }
    private static int lastDayofMonth(int month, int ... year)
    {
        if(month != 2)
        {
            switch(month)
            {
                case 1:
                    return 31;
                case 3:
                    return 31;
                case 4:
                    return 30;
                case 5:
                    return 31;
                case 6:
                    return 30;
                case 7:
                    return 31;
                case 8:
                    return 31;
                case 9:
                    return 30;
                case 10:
                    return 31;
                case 11:
                    return 30;
                case 12:
                    return 31;
            }
        }
        else if(month == 2 && year.length == 0)
            return 28;
        else
        {
            // leap year if perfectly divisible by 400
            if (year[0] % 400 == 0) 
                return 29;
            // not a leap year if divisible by 100
            // but not divisible by 400
            else if (year[0] % 100 == 0) 
                return 28;
            // leap year if not divisible by 100
            // but divisible by 4
            else if (year[0] % 4 == 0)
                return 29;
            // all other years are not leap years
            else
                return 28;
        }
        return 0;
    }
    Date previousDay()
    {
        if(day ==1)
        {
            if(month == 1)
                return new Date(31,12,year-1);
            else   
                return new Date(lastDayofMonth(month-1, year),month-1,year);
        }
        else
            return new Date(day-1,month,year);
    }
    Date nextDay()
    {
        if(day+1 <= lastDayofMonth(month, year))
            return new Date(day+1,month,year);
        else
        {
            if(month != 12)
                return new Date(01,month+1,year);
            else
                return new Date(01,01,year+1);
        }
    }
    void printDate()
    {
        System.out.printf(day + " : " + month + " : " + year);
    }

}
class DateDemo
{
    public static void main(String []args)
    {
        Date dt = new Date(31,12,2001);
        Date dt2 = new Date(29,2,2000);
        dt.previousDay().printDate();
        System.out.println();
        dt2.nextDay().printDate();
        System.out.println();
    }
}