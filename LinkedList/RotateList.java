package LinkedList;

// Definition for singly-linked list node
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}

//Given the head of a linked list, rotate the list to the right by k places.
//        Input: head = [1,2,3,4,5], k = 2
//        Output: [4,5,1,2,3]
public class RotateList {

    // Function to rotate list to the right by k places
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Compute length and reach last node
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Connect last node to head (circular list)
        current.next = head;

        // Step 3: Compute effective rotations needed
        k = k % length;

        // Step 4: Find new tail (length - k - 1) and new head (tail.next)
        int stepsToNewHead = length - k;
        while (stepsToNewHead-- > 0) {
            current = current.next;
        }

        // Step 5: Break the circle
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }

    // Helper function to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.print("Original List: ");
        printList(head);

        ListNode result = rotateRight(head, k);

        System.out.print("Rotated List (k = " + k + "): ");
        printList(result);  // Expected: 4 -> 5 -> 1 -> 2 -> 3
    }
}

