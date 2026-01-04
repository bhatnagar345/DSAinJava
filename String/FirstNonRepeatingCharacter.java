package String;

//Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
// return -1.
//Example 1:
//
//Input: s = "leetcode"
//Output: 0
//Explanation:
//The character 'l' at index 0 is the first character that does not occur at any other index.
//
//Example 2:
//Input: s = "loveleetcode"
//Output: 2

//Example 3:
//Input: s = "aabb"
//Output: -1

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "Harsh Bhatnagar";
        int[] c = new int[26];

        for(int i =0;i< s.length(); i++)
        {
            c[s.charAt(i) - 'a']++;
        }
        for(int i =0;i< s.length();i++)
        {
            if(c[s.charAt(i) - 'a'] == 1) System.out.println(s.charAt(i));
        }
        System.out.println("-1");
    }
}
