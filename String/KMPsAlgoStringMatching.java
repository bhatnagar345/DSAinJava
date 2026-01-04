package String;

//Given two strings txt and pat, return the 0-based index of the first occurrence of the substring
//pat in txt. If pat is not found, return -1.
//Input: text = "GeeksForGeeks", pattern = "For"
//Output: 5
//Explanation: "For" is present as substring in "GeeksForGeeks" from index 5 (0 based indexing).

public class KMPsAlgoStringMatching {

    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private static void kmpSearch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        int[] lps = buildLPS(pattern);
        int i =0;
        int j =0;
        while(i < m)
        {
            if(text.charAt(i) == pattern.charAt(j))
            {
                j++;
                i++;
            } 
            if (j == n) {
                System.out.println("Index found at : " + (i-j));
                j = lps[j-1];
            } else if (i< m && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        kmpSearch(text, pattern);
    }


}
