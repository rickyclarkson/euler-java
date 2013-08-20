/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

import java.util.Arrays;

class Nineteen {
  public static void main(String[] args) {
    int totalDays = 0;
    for (int a = 1901; a <= 2000; a++)
      totalDays += daysInYear(a);

    int[] monthLengths = monthLengths(totalDays);
    int year = 1901;
    int month = 0;
    int dayOfWeek = 1;
    int sundays = 0;
    int dayOfMonth = 0;
    for (int a = 0; a < totalDays; a++) {
      dayOfWeek++;
      dayOfWeek %= 7;
      dayOfMonth++;
      if (dayOfMonth == monthLengths[(year - 1901) * 12 + month]) {
        dayOfMonth = 0;
	month++;
	if (month == 12) {
	  year++;
	  month = 0;
	}
      }
      if (dayOfMonth == 0 && dayOfWeek == 6) {
        sundays++;
	System.out.println(year + ", " + (month + 1) + ", " + (dayOfMonth + 1));
      }
    }
    System.out.println(sundays);
  }

  static int daysInYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 366 : 365;
  }

  static int[] monthLengths(int totalDays) {
    int[] monthLengths = new int[1200];
    int year = 1901;
    for (int a = 0; a < 1200; a++)
      switch (a % 12) {
        case 0: monthLengths[a] = 31; break;
	case 1: monthLengths[a] = daysInYear(year) == 366 ? 29 : 28; break;
	case 2: monthLengths[a] = 31; break;
	case 3: monthLengths[a] = 30; break;
	case 4: monthLengths[a] = 31; break;
	case 5: monthLengths[a] = 30; break;
	case 6: monthLengths[a] = 31; break;
	case 7: monthLengths[a] = 31; break;
	case 8: monthLengths[a] = 30; break;
	case 9: monthLengths[a] = 31; break;
	case 10: monthLengths[a] = 30; break;
	case 11: monthLengths[a] = 31; year++; break;
      }
    return monthLengths;
  }
}
