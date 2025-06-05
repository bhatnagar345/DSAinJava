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

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
//leaving only distinct numbers from the original list. Return the linked list sorted as well.
//        Input: head = [1,2,3,3,4,4,5]
//        Output: [1,2,5]

public class DeleteAllDuplicates {

    // Function to remove all nodes with duplicate numbers
    public static ListNode deleteDuplicates(ListNode head) {
        // Dummy node to simplify edge cases like duplicates at the head
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(head != null)
        {
            if(head.next != null && (head.val == head.next.val))
            {
                while(head.next != null && (head.val == head.next.val))
                {
                    head = head.next;
                }
                if(head.next != null)
                {
                    head = head.next;
                }
                else
                {
                    dummy.next = null;
                    return prev.next;
                }
            }
            else
            {
                dummy.next = head;
                dummy = head;
                head = head.next;
            }
        }
        return prev.next;

    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create input list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        // Remove duplicates
        ListNode result = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(result);  // Expected: 1 -> 2 -> 5 -> null
    }
}
