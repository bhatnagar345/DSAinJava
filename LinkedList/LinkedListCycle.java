package LinkedList;

// Node class for Linked List
//class ListNode {
//    int val;          // Value of the node
//    ListNode next;    // Reference to the next node
//
//    ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}

//To determine whether a linked list has a cycle, we use a well-known and optimized algorithm called
//Floyd's Cycle Detection Algorithm (also known as the Tortoise and Hare algorithm).

public class LinkedListCycle {

    // Function to detect if the linked list has a cycle
    public static boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, it can't have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers: slow moves 1 step, fast moves 2 steps
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer by 1
            fast = fast.next.next;      // Move fast pointer by 2

            // If both pointers meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, no cycle
        return false;
    }

    // Main method to test the cycle detection
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Connect nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2 (cycle)
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;  // Creates a cycle

        // Test the function
        System.out.println("Cycle exists: " + hasCycle(head));  // Expected: true

        // Break the cycle and test again
        fourth.next = null;
        System.out.println("Cycle exists: " + hasCycle(head));  // Expected: false
    }
}

