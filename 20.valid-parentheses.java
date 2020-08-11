import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start


class Solution {
    ArrayList<Character> arrayList = new ArrayList<>();
    public boolean isValid(String s) {
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                arrayList.add(c);
            else {
                if (arrayList.isEmpty())
                    return false;
                switch(c){
                    case '}':
                    {
                        if(arrayList.get(arrayList.size() - 1) == '{'){
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        else 
                            return false;
                    }
                    case ']':
                    {
                        if(arrayList.get(arrayList.size() - 1) == '['){
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        else 
                            return false;
                    }
                    case ')':
                    {
                        if(arrayList.get(arrayList.size() - 1) == '('){
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        else 
                            return false;
                    }
                    default:
                        return false;
                }

            }

       }
        if(arrayList.isEmpty())
            return true;
        return false;
    }
}
// @lc code=end

