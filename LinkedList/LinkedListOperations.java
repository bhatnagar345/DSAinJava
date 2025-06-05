package LinkedList;

import java.util.*;

class LinkedNode {
    int data;
    LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations {
    static LinkedNode root = null;

    // Create linked list from array
    public static void create(int[] a) {
        root = new LinkedNode(a[0]);
        LinkedNode last = root;
        for (int i = 1; i < a.length; i++) {
            LinkedNode temp = new LinkedNode(a[i]);
            last.next = temp;
            last = temp;
        }
    }

    // Display the linked list
    public static void display(LinkedNode p) {
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // Count the number of nodes
    public static int count(LinkedNode p) {
        int total = 0;
        while (p != null) {
            total++;
            p = p.next;
        }
        return total;
    }

    // Recursive count
    public static int recursiveCount(LinkedNode p) {
        if (p == null) return 0;
        return 1 + recursiveCount(p.next);
    }

    // Sum of all nodes
    public static int sum(LinkedNode p) {
        int sum = 0;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }
        return sum;
    }

    // Recursive sum
    public static int recursiveSum(LinkedNode p) {
        if (p == null) return 0;
        return p.data + recursiveSum(p.next);
    }

    // Insert at given index
    public static void insert(int index, int key) {
        if (index < 0 || index > count(root)) {
            System.out.println("Invalid index");
            return;
        }
        LinkedNode temp = new LinkedNode(key);
        if (index == 0) {
            temp.next = root;
            root = temp;
            return;
        }
        LinkedNode p = root;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        temp.next = p.next;
        p.next = temp;
    }

    // Insert at tail
    public static void insertAtTail(int key) {
        LinkedNode temp = new LinkedNode(key);
        if (root == null) {
            root = temp;
            return;
        }
        LinkedNode p = root;
        while (p.next != null) {
            p = p.next;
        }
        p.next = temp;
    }

    // Delete at index
    public static void deleteAt(int index) {
        if (index < 0 || index >= count(root)) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            root = root.next;
            return;
        }
        LinkedNode p = root;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    // Reverse the list
    public static void reverse() {
        LinkedNode prev = null, current = root, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
    }

    // Insert into sorted list
    public static void sortedInsert(int key) {
        LinkedNode temp = new LinkedNode(key);
        if (root == null || root.data > key) {
            temp.next = root;
            root = temp;
            return;
        }
        LinkedNode p = root;
        while (p.next != null && p.next.data < key) {
            p = p.next;
        }
        temp.next = p.next;
        p.next = temp;
    }

    // Remove duplicates from unsorted list
    public static void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        LinkedNode current = root;
        LinkedNode prev = null;
        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = prev.next;
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        create(a);
        System.out.println("Initial List:");
        display(root);

        System.out.println("Sum (recursive): " + recursiveSum(root));
        System.out.println("Count (recursive): " + recursiveCount(root));

        deleteAt(0);
        System.out.println("After deleting index 0:");
        display(root);

        insert(7, 1);
        insert(0, 1);
        System.out.println("After inserting 1 at index 7 and 0:");
        display(root);

        insertAtTail(10);
        insertAtTail(10);
        insertAtTail(11);
        System.out.println("After inserting at tail:");
        display(root);

        sortedInsert(6);
        System.out.println("After sorted insert 6:");
        display(root);

        reverse();
        System.out.println("After reversing:");
        display(root);

        removeDuplicates();
        System.out.println("After removing duplicates:");
        display(root);

        // Optional user input test
        System.out.print("\nEnter number of elements for new list: ");
        int n = sc.nextInt();
        int[] userInput = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            userInput[i] = sc.nextInt();
        }
        create(userInput);
        System.out.println("List from user input:");
        display(root);

        sc.close();
    }
}

