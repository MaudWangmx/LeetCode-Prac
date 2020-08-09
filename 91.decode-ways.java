import java.util.ArrayList;
import java.util.PrimitiveIterator.OfInt;

/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {

    ArrayList<Integer> array = new ArrayList<>();
    
    //@param n: Ln
    public int countNArray(int n){
        if (n == 0)
            return 1;
        if (n == 1){
            if(array.get(0) == 0)
                return 0;
            else 
                return 1;
        }
        else {
            if ((array.get(n-2) == 1 && array.get(n-1) != 0) || (array.get(n-2) == 2 && array.get(n-1) >=1 && array.get(n-1) <= 6))
                return countNArray(n-1) + countNArray(n-2);
            if (((array.get(n-2) > 2 || array.get(n-2) == 0) && array.get(n-1) != 0) || (array.get(n-2) == 2 && array.get(n-1) > 6))
                return countNArray(n-1);
            if (array.get(n-2) <= 2 && array.get(n-2) >= 1 && array.get(n-1) == 0)
                return countNArray(n-2);
            else 
                return 0;              
        }
    }
    public int numDecodings(String s) {

        for(int i = 0; i < s.length(); i++){
            array.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return countNArray(s.length());
    }
}
// @lc code=end

