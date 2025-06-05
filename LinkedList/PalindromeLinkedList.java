package LinkedList;

import java.util.Scanner;
import java.util.Stack;

// Check if string is a palindrome through Linked List
class Node {
    char data;
    LinkedNode next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {

    // Function to create linked list from a string
    public static LinkedNode createLinkedList(String str) {
        if (str.isEmpty()) return null;

        // Create the head node with the first character
        LinkedNode head = new LinkedNode(str.charAt(0));
        LinkedNode last = head;

        // Add the rest of the characters as nodes
        for (int i = 1; i < str.length(); i++) {
            LinkedNode temp = new LinkedNode(str.charAt(i));
            last.next = temp;
            last = temp;
        }

        return head;
    }

    // Function to display the linked list
    public static void display(LinkedNode head) {
        LinkedNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to check if the linked list is a palindrome
    public static void isPalindrome(LinkedNode head) {
        Stack<Character> stack = new Stack<>();
        LinkedNode temp = head;

        // Push all characters to stack
        while (temp != null) {
            stack.push((char) temp.data);
            temp = temp.next;
        }

        // Reset pointer to head
        temp = head;

        // Compare elements from start and stack (which has reverse)
        while (temp != null) {
            if (stack.pop() != temp.data) {
                System.out.println("This is NOT a palindrome.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("This is a palindrome.");
    }

    public static void main(String[] args) {
        // 🔹 Hardcoded Test Case
        String s1 = "abcdedcba";
        System.out.println("Hardcoded Input: " + s1);
        LinkedNode head1 = createLinkedList(s1);
        System.out.print("Linked List: ");
        display(head1);
        isPalindrome(head1);

        // 🔹 Another Test Case
        String s2 = "hello";
        System.out.println("\nTest Input: " + s2);
        LinkedNode head2 = createLinkedList(s2);
        System.out.print("Linked List: ");
        display(head2);
        isPalindrome(head2);

        // 🔹 User Input Test Case
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a string to check for palindrome:");
        String userInput = sc.nextLine();
        LinkedNode userHead = createLinkedList(userInput);
        System.out.print("Linked List: ");
        display(userHead);
        isPalindrome(userHead);

        sc.close();
    }
}

