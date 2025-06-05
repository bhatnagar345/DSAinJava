package String;

import java.util.Arrays;
import java.util.Scanner;


public class Permutation {

    private static void permute(String s, int l, int r) {
        if(l == r)
        {
            System.out.println(s);
        }
        for(int i = l;i<r;i++)
        {
            s = swap(s,l,i);
            permute(s,l+1,r);
            s = swap(s,l,i);
        }
    }

    private static String swap(String s, int i, int j)
    {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write down the string to permute: ");
        String s = scanner.nextLine();

        int l = 0;
        int r = s.length();

        System.out.println("After the permutation:");
        permute(s, l, r);

        scanner.close();
    }


}

