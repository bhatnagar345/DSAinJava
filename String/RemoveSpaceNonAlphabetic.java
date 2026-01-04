package String;

import org.w3c.dom.ls.LSOutput;

public class RemoveSpaceNonAlphabetic {
    public static void main(String[] args) {

        String str = "A man, a plan,      a canal: Panama";

        String result = str.replaceAll("[^a-zA-Z]", "");
        System.out.println("Removing All spaces and Non alphabetic characters : " + result);
        str = str.replaceAll("[^a-zA-Z ]", "")    // keep only letters & space
                        .replaceAll("\\s+", " ")     // convert multiple spaces to one
                        .trim();    // remove leading & trailing spaces
        System.out.println(str);
    }

}
