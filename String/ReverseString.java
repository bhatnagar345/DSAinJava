package String;

public class ReverseString {

    public static void main(String[] args) {
        String s = "Harsh Bhatnagar";
        char[] a = s.toCharArray();
        System.out.println(a);
        int i =0;
        int j = a.length - 1;
        while(i < j)
        {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        for(int k =0; k < a.length;k++)
        {
            System.out.print(a[k]);
        }
    }
}
