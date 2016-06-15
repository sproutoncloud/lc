/*
Create a new list
1st parenthesis
( // Accepted, append to the element in the list
) // NOT acceptable

Add 2nd parenthesis to the 1st, 
(( // Accepted, append to the element in the list
() // Accepted, append to the element in the list

Add 3rd parenthesis to the previous two.
(() // Accepted, append to the element in the list
((( // Accepted, append to the element in the list
()( // Accepted, append to the element in the list
()) // NOT acceptable

What's the rule to determine if adding a left or right parenthesis is acceptable? 
"(": It's always okay to add a left parenthesis because the input is in pairs.
")": Only if number of left parenthesis (leftCount) is greater than right parenthesis.
     In other words, add a ")" such that leftCount > rightCount

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        // only initiate one arraylist so we don't have to create multiple lists. 
        ArrayList<String> res = new ArrayList<String>();
        generateParenthese(res, n, 0, 0, "");
        return res;
    }
    
    public List<String> generateParenthese(ArrayList<String> res, int n, int leftCount, int rightCount, String s) {
        
        // termination condition. Left and right parenthesis have equal numbers, and all n pairs must be presented in the final string. 
        if (leftCount == rightCount && leftCount == n ) 
            res.add(s);

        // Recursively add "(" or ")", if condition determines the degree of recursive calls. depth is n.
        if (leftCount < n )
            // left parenthesis add anytime as it does not break the matching syntax.
            generateParenthese(res, n, leftCount+1, rightCount, s+"(");
      
        // acceptable criteria for adding ")"
        if (rightCount < leftCount) {
            generateParenthese(res, n, leftCount, rightCount+1, s+")");
        }
        return res;
    }
}