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

//To remove the Nth node from the end of a singly linked list,
//we can solve this optimally using the two-pointer (fast and slow) technique.

public class RemoveNthFromEnd {

    // Function to remove the Nth node from the end of the list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize both slow and fast pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast ahead by n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is just before the node to be removed
        if(slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }

        // Return the new head (might be different if head was removed)
        return dummy.next;
    }

    // Helper function to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int n = 2; // Remove 2nd node from end (i.e., 4)
        head = removeNthFromEnd(head, n);

        System.out.print("After Removing " + n + "th node from end: ");
        printList(head);  // Expected: 1 -> 2 -> 3 -> 5 -> null
    }
}

