import java.util.zip.Deflater;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (55.71%)
 * Likes:    2342
 * Dislikes: 3585
 * Total Accepted:    729.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */

// @lc code=start
class Solution {
    public static int checkNext(char thisC, char nextC){
        switch(thisC){
            case 'I':
                if (nextC == 'V')
                    return 4;
                else if (nextC == 'X')
                    return 9;
                else 
                    return 1;
            case 'X':
                if (nextC == 'L')
                    return 40;
                else if (nextC == 'C')
                    return 90;
                else 
                    return 10;
            case 'C':
                if(nextC == 'D')
                    return 400;
                else if (nextC == 'M')
                    return 900;
                else 
                    return 100;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int index = 0, length = s.length();
        int res = 0, pairValue;
        char c;
        while(index < length){
            c = s.charAt(index);
            switch(c){
                case 'I':
                    if((index + 1) < length){
                        pairValue = checkNext(c, s.charAt(index+1));
                        if(pairValue != 1)
                            index++;
                        res += pairValue;
                    }
                    else
                        res += 1;
                    index++;
                    break;
                case 'V':
                    res += 5;
                    index++;
                    break;
                case 'X':
                    if((index + 1) < length){
                        pairValue = checkNext(c, s.charAt(index+1));
                        if(pairValue != 10)
                            index++;
                        res += pairValue;
                    }
                    else
                        res += 10;
                    index++;
                    break;
                case 'L':
                    res += 50;
                    index++;
                    break;
                case 'C':
                    if((index + 1) < length){
                        pairValue = checkNext(c, s.charAt(index+1));
                        if(pairValue != 100)
                            index++;
                        res += pairValue;
                    }
                    else
                        res += 100;
                    index++;
                    break;
                case 'D':
                    res += 500;
                    index++;
                    break;
                case 'M':
                    res += 1000;
                    index++;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
// @lc code=end

