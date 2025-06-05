package LinkedList;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int val) {
//        this.val = val;
//    }
//}

//Given the head of a singly linked list and two integers left and right where left <= right,
//reverse the nodes of the list from position left to position right, and return the reversed list.

public class ReverseSublist {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Move prev to the node before the 'left' position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Start reversing from current node
        ListNode current = prev.next;
        ListNode next = null;

        // Step 4: Reverse sublist using head-insertion method
        for (int i = 0; i < right - left; i++) {
            next = current.next; // Store the next node
            current.next = next.next; // Remove next from its current place
            next.next = prev.next; // Insert next at the beginning of sublist
            prev.next = next; // Update previous node to point to new head
        }

        // Step 5: Return the head of the new list
        return dummy.next;
    }

    // Helper to create a list from array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Test method
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = createList(nums);

        int left = 2, right = 4;

        System.out.print("Original List: ");
        printList(head);

        ListNode result = reverseBetween(head, left, right);

        System.out.print("Reversed List (from " + left + " to " + right + "): ");
        printList(result); // Expected: 1 -> 4 -> 3 -> 2 -> 5
    }
}

