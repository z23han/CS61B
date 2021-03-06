/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
    private int month;
    private int day;
    private int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
      
      this.month = month;
      this.day = day;
      this.year = year;
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
      
      String delims = "/";
      String[] tokens = s.split(delims);

      if (tokens.length != 3) {
          throw new IllegalArgumentException("Format should be month/day/year");
      }

      if (tokens[0].length() > 2) {
          throw new IllegalArgumentException("month must be 1 or 2 digits");
      } else {
          int month = Integer.parseInt(tokens[0]);
          if (month > 12 || month < 1) {
              throw new IllegalArgumentException("month input illegal!");
          } else {
              this.month = month;
          }
      }
      
      if (tokens[1].length() > 2) {
          throw new IllegalArgumentException("day must be 1 or 2 digits!");
      } else {
          int day = Integer.parseInt(tokens[1]);
          if (day > 31 || day < 1) {
              throw new IllegalArgumentException("day input illegal!");
          } else {
              this.day = day;
          }
      }
      
      if (tokens[2].length() < 1 || tokens[2].length() > 4) {
          throw new IllegalArgumentException("year must be between 1 and 4 digits!");
      } else {
          int year = Integer.parseInt(tokens[2]);
          if (year < 1) {
              throw new IllegalArgumentException("year input illegal!");
          } else {
              this.year = year;
          }
      }
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
      
      if (year % 4 == 0) {
          if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
                
            } else {
                return false;
            }

          } else {
            return true;
          }
      }
      return false;                        // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
      
      if (isLeapYear(year)) {
      
          switch (month) {
              case 1: 
                  return 31;
              case 2:
                  return 29;
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
      } else {

          switch (month) {
              case 1:
                  return 31;
              case 2:
                  return 28;
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
      return 0;                           // replace this line with your solution
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {

      if (month > 12 || month < 1) {
          return false;
      }
      
      if (day > 31 || day < 1) {
          return false;
      }

      if (year < 1) {
          return false;
      }

      return true;
      
    //return true;                        // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
      
      return Integer.toString(this.month) + "/" + Integer.toString(this.day) + "/" + 
          Integer.toString(this.year); 
    //return "stuff";                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
      
      if (d.year > this.year) {
          return true;
      } else if (d.year < this.year) {
          return false;
      } else {
          if (d.month > this.month) {
              return true;
          } else if (d.month < this.month) {
              return false;
          } else {
              if (d.day > this.day) {
                  return true;
              } else {
                  return false;
              }
          }
      }
    //return true;                        // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
      
      if (d.year == this.year && d.month == this.month && d.day == this.day) {
          return false;
      } 
      if (isBefore(d)) {
          return false;
      } else {
          return true;
      }
    //return true;                        // replace this line with your solution
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
      switch (this.month) {
          case 1:
              return this.day;
          case 2:
              return 31 + this.day;
          case 3:
              if (isLeapYear(this.year)) {
                  return (60 + this.day);
              } else {
                  return (59 + this.day);
              }
          case 4:
              if (isLeapYear(this.year)) {
                  return (91 + this.day);
              } else {
                  return (90 + this.day);
              }
          case 5:
              if (isLeapYear(this.year)) {
                  return (121 + this.day);
              } else {
                  return (120 + this.day);
              }
          case 6:
              if (isLeapYear(this.year)) {
                  return (152 + this.day);
              } else {
                  return (151 + this.day);
              }
          case 7:
              if (isLeapYear(this.year)) {
                  return (182 + this.day);
              } else {
                  return (181 + this.day);
              }
          case 8:
              if (isLeapYear(this.year)) {
                  return (212 + this.day);
              } else {
                  return (211 + this.day);
              } 
          case 9:
              if (isLeapYear(this.year)) {
                  return (243 + this.day);
              } else {
                  return (242 + this.day);
              }
          case 10:
              if (isLeapYear(this.year)) {
                  return (274 + this.day);
              } else {
                  return (273 + this.day);
              }
          case 11:
              if (isLeapYear(this.year)) {
                  return (304 + this.day);
              } else {
                  return (303 + this.day);
              }
          case 12:
              if (isLeapYear(this.year)) {
                  return (335 + this.day);
              } else {
                  return (334 + this.day);
              }
      }
    return 0;                           // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
      
      int d_day = d.dayInYear(); 
      int this_day = dayInYear();
      int diff;
      
      if (d.year == this.year) {
          return (d_day - this_day);
      } else if (d.year > this.year) {
          if (isLeapYear(this.year)) {
              diff = 366 - this_day;
              for (int y = this.year+1; y < d.year; y++) {
                  if (isLeapYear(y)) {
                      diff += 366;
                  } else {
                      diff += 365;
                  }
              }
              diff += d_day;
          } else {
              diff = 365 - this_day;
              for (int y = this.year + 1; y < d.year; y++) {
                  if (isLeapYear(y)) {
                      diff += 366;
                  } else {
                      diff += 365;
                  }
              }
              diff += d_day;
          }
          diff = -diff;
          return diff;
      } else {
          if (isLeapYear(d.year)) {
              diff = 366 - d_day;
              for (int y = d.year + 1; y < this.year; y++) {
                  if (isLeapYear(y)) {
                      diff += 366;
                  } else {
                      diff += 365;
                  }
              }
              diff += this_day;
          } else {
              diff = 365 - d_day;
              for (int y = d.year + 1; y < this.year; y++) {
                  if (isLeapYear(y)) {
                      diff += 366;
                  } else {
                      diff += 365;
                  }
              }
              diff += this_day;
          }
          return diff;
      }
    //return 0;                           // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
