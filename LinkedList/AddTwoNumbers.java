package LinkedList;

public class AddTwoNumbers {

    // Method to add two numbers represented as linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to make it easy to return result
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead; // Pointer to build the result list
        int carry = 0; // Initialize carry to 0

        // Loop through both lists until both are null and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of current nodes or 0 if null
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Compute sum and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10; // Update carry
            int digit = sum % 10; // Digit to store in the current node

            // Create new node with digit and add it to the result list
            current.next = new ListNode(digit);
            current = current.next; // Move to next node

            // Move input pointers if not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the result list starting from the next of dummy node
        return dummyHead.next;
    }

    // Helper method to create a linked list from array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create test data
        int[] num1 = {2, 4, 3}; // Represents 342
        int[] num2 = {5, 6, 4}; // Represents 465

        // Convert arrays to linked lists
        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        // Call addTwoNumbers and print result
        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printList(result); // Expected: 7 -> 0 -> 8 (807)
    }
}

