package LinkedList;

//class  ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}

public class MergeSortedLists {

    // Method to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node simplifies edge case handling
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists
        while (l1 != null && l2 != null) {
            // Compare values and attach the smaller one to current
            if (l1.val < l2.val) {
                current.next = l1; // Link l1 node
                l1 = l1.next; // Move l1 pointer
            } else {
                current.next = l2; // Link l2 node
                l2 = l2.next; // Move l2 pointer
            }
            current = current.next; // Move current pointer
        }

        // Attach remaining nodes of non-empty list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return head of merged list (after dummy)
        return dummy.next;
    }

    // Helper to create a linked list from an array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 7};
        int[] list2 = {2, 4, 6, 8};

        ListNode l1 = createList(list1);
        ListNode l2 = createList(list2);

        ListNode merged = mergeTwoLists(l1, l2);

        System.out.print("Merged Sorted List: ");
        printList(merged);  // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    }
}

