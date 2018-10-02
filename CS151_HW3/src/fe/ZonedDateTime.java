package fe;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.ZonedDateTime;

public class ZonedDateTime {

	private int year;
	private int month;
	private int day;
	 private static final int[] DAYS_PER_MONTH 
     = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  private static final int GREGORIAN_START_YEAR = 1582;
  private static final int GREGORIAN_START_MONTH = 10;
  private static final int GREGORIAN_START_DAY = 15;
  private static final int JULIAN_END_DAY = 4;

  public static final int JANUARY = 1;
  public static final int FEBRUARY = 2;
  public static final int DECEMBER = 12;

	public ZonedDateTime(int theYear, int theMonth, int theDay)
	{
		year = theYear;
		month=theMonth;
		day=theDay;
	}
	
	public int getYear()
	{
		return year;
		
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	 private static int daysPerMonth(int y, int m)
	   {
	      int days = DAYS_PER_MONTH[m - 1];
	      if (m == FEBRUARY && isLeapYear(y)) 
	         days++;
	      return days;
	   }
	 private static boolean isLeapYear(int y)
	   {
	      if (y % 4 != 0) return false;
	      if (y < GREGORIAN_START_YEAR) return true;
	      return (y % 100 != 0) || (y % 400 == 0);
	   }
	 
	 public int daysFrom(ZonedDateTime other)
	   {
	      int n = 0;
	      ZonedDateTime d = this;
	      while (d.compareTo(other) > 0)
	      {
	         d = d.previousDay();
	         n++;
	      }
	      while (d.compareTo(other) < 0)
	      {
	         d = d.nextDay();
	         n--;
	      }
	      return n;
	   }
	private ZonedDateTime nextDay()
	{
		int y = year;
		int m = month;
		int d = day;
		
		if(y==GREGORIAN_START_YEAR
			&& m==GREGORIAN_START_MONTH
			&& d==GREGORIAN_START_DAY)
		{
			d=GREGORIAN_START_DAY;
		}
		else if(d< daysPerMonth(y,m))
		{
			d++;
		}
		else
		{
			d= 1;
			m++;
			if(m > DECEMBER)
			{
				m=JANUARY;
				y++;
				if(y==0) y++;
			}
		}
		
		return new ZonedDateTime(y, m, d);
	}
	
	private ZonedDateTime previousDay()
	{
		int y = year;
	      int m = month;
	      int d = day;

	      if (y == GREGORIAN_START_YEAR
	            && m == GREGORIAN_START_MONTH
	            && d == GREGORIAN_START_DAY)
	         d = JULIAN_END_DAY;
	      else if (d > 1)
	         d--;
	      else
	      {	
	         m--;
	         if (m < JANUARY) 
	         {             
	            m = DECEMBER; 
	            y--; 
	            if (y == 0) y--;
	         }
	         d = daysPerMonth(y, m);
	      }
	      return new ZonedDateTime(y, m, d);
	}
	public int compareTo(ZonedDateTime d)
	{
		if (year > d.year) return 1;
		else if (year < d.year) return -1;
		else if(month > d.month) return 1;
		else if (month < d.month) return 1;
		else return day - d.day;
	}
	public static void main(String[] args)
	{
		ZonedDateTime birthday = new ZonedDateTime(1998, 9, 13);
		LocalDateTime a = LocalDateTime.now();
		int x = a.getYear();
		int y = a.getMonthValue();
		int z = a.getDayOfMonth();
		ZonedDateTime current = new ZonedDateTime(x, y, z);
		 System.out.println(current.getYear() 
		            + "-" + current.getMonth() 
		            + "-" + current.getDay()); 
		      System.out.println(current.daysFrom(birthday));
	}
}
