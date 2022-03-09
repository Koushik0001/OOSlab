class Date
{
	int day, month, year;
	Date(int d, int m, int y)
	{
		if(d>lastDayofMonth(m, y)||m>12 || m<1)
		{
			System.out.println("Illegal initialisation of Date object...");
			System.out.println("Day (" + d + " : " + m + " : " + y + " ) does not exist...");
			System.out.println("Process terminated...");
			System.exit(1);
		}
		day = d;
		month = m;
		year = y;
	}
	Date(int d, int m)
	{
		if(d > lastDayofMonth(m, 1970) || m>12 || m<1)
		{
			System.out.println("Day" + d + ":" + m + ":"+1970+"does not exist...");
			System.exit(1);
		}
		day = d;
		month = m;
		year = 1970;
	}
	Date(int d)
	{
		if(d>lastDayofMonth(1,1970))
		{
			System.out.println("Day" + d + ":" + 1 + " : " + 1970 + "does not exist...");
			System.exit(1);
		}
		day = d;
		month = 1;
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
			if(year[0] % 400 == 0)
				return 29;
			else if(year[0]%100 == 0)
				return 28;
			else if(year[0] % 4 == 0)
				return 29;
			else
				return 28;
		}
		return 0;
	}
	Date previousDay()
	{
		if(day == 1)
		{
			if(month ==1)
				return new Date(31,12,year-1);
			else
				return new Date(lastDayofMonth(month-1,year),month-1,year);
		}
		else
			return new Date(day-1,month,year);
	}
	Date nextDay()
	{
		if(day+1 <= lastDayofMonth(month,year))
			return new Date(day+1,month,year);
		else
		{
			if(month != 12)
				return new Date(1,month+1,year);
			else
				return new Date(1,1,year+1);
		}
	}
	void printDate()
	{
		System.out.println(day + ":" + month + ":" + year);
	}
}
class DateDemo
{
	public static void main(String []args)
	{
		Date dt = new Date(1,1,2000);
		Date dt2 = new Date(31,12,2000);
		
		dt.nextDay().printDate();
		dt.previousDay().printDate();
	}
}

