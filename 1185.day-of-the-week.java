import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;


/*
 * @lc app=leetcode id=1185 lang=java
 *
 * [1185] Day of the Week
 *
 * https://leetcode.com/problems/day-of-the-week/description/
 *
 * algorithms
 * Easy (64.01%)
 * Likes:    114
 * Dislikes: 1048
 * Total Accepted:    22.5K
 * Total Submissions: 35.2K
 * Testcase Example:  '31\n8\n2019'
 *
 * Given a date, return the corresponding day of the week for that date.
 * 
 * The input is given as three integers representing the day, month and year
 * respectively.
 * 
 * Return the answer as one of the following values {"Sunday", "Monday",
 * "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given dates are valid dates between the years 1971 and 2100.
 * 
 */

// @lc code=start

class Solution {
    public boolean isLeapYear(int year){
        if (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
            return true;
        else
            return false;
    }

    public int getMonthDay(int month, int year){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:{
                if(isLeapYear(year))
                    return 29;
                else 
                return 28;
            }
            default:
                return 0;
        }
    }
    
    public String dayOfTheWeek(int day, int month, int year) {
        int days = 0;
        boolean flag = true;
        if(year >= 1999){
            for(int i = 2000; i <= year; i++){
                if(isLeapYear(i))
                    days += 366;
                else
                    days += 365;
            }
            if (month > 7){
                for(int i = 8; i < month; i++)
                    days += getMonthDay(i, year);
                days += day + 31 -18;
            }
            else if (month < 7){
                for(int i = 6; i > month; i--)
                    days -= getMonthDay(i, year);
                days -= getMonthDay(month, year) - day + 18;
            }
            else {
                if (day >= 18){
                    days += day - 18;
                    flag = true;
                }
                else if (day < 18){
                    days -= 18 - day;
                    if (year == 1999){
                        days = 18 - day;
                        flag = false;
                    }
                }
            }

        }
        else if(year < 1999){
            flag = false;
            for (int i = 1998; i > year; i--){
                if(isLeapYear(i))
                    days += 366;
                else
                    days += 365;
            }
            for(int i = 12; i > month; i--)
                days += getMonthDay(i, year);
            days += getMonthDay(month, year) - day;
            for(int i = 1; i < 7; i++)
                days += getMonthDay(i, 1999);
            days += 18;
        }

       
        switch (days%7){
            case 1:
                if(flag)
                    return "Monday";
                else
                    return "Saturday";
            case 2:
                if(flag)
                    return "Tuesday";
                else
                    return "Friday"; 
            case 3:
                if(flag)
                    return "Wednesday";
                else
                    return "Thursday";
            case 4:
                if(flag)
                    return "Thursday";
                else
                    return "Wednesday";
            case 5:
                if(flag)
                    return "Friday";
                else
                    return "Tuesday";
            case 6:
                if(flag)
                    return "Saturday";
                else
                    return "Monday";
            case 0:
                return "Sunday";
            default:
                return null;
        }
     
    }
}
// @lc code=end

