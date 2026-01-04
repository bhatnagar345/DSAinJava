package String;

//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//A shift on s consists of moving the leftmost character of s to the rightmost position.
//For example, if s = "abcde", then it will be "bcdea" after one shift.

//Example 1:
//Input: s = "abcde", goal = "cdeab"
//Output: true
//
//Example 2:
//Input: s = "abcde", goal = "abced"
//Output: false

public class RotateString {
    public static int[] buildLps(String goal){
        int[] lps = new int[goal.length()];
        int i =1;
        int j =0;
        while(i < goal.length())
        {
            if(goal.charAt(i) == goal.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public  static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())return false;
        String text = s + s;
        int[] lps = buildLps(goal);
        int i = 0;
        int j =0;
        while(i < text.length()){
            if(text.charAt(i) == goal.charAt(j)){
                i++;
                j++;
            }
            if(j == goal.length()){
                return true;
            }else if( i < text.length() && text.charAt(i) != goal.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
          String s = "abcde";
          String goal = "cdeab";
          if(rotateString(s,goal)){
              System.out.println("Yes string is a rotation of another string");
          }else{
              System.out.println("No string is not a rotation of another string");
          }
    }
}
