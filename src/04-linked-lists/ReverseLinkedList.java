import java.util.Arrays;

/*
 * CHALLENGE: Reverse a Linked List  (Linked Lists — three-pointer technique)
 * --------------------------------------------------------------------------
 * Given the head of a singly linked list, reverse it and return the new head.
 *
 * Example:
 *   input:  1 -> 2 -> 3 -> 4 -> 5 -> null
 *   output: 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * Edge cases:
 *   []      (empty list, head == null)  -> []      (return null)
 *   [1]     (single node)               -> [1]
 *
 * GOAL: O(n) time, O(1) extra space, by re-pointing the .next links as you walk.
 *
 * THE TECHNIQUE (three pointers):
 *   prev = null;           // the reversed part built so far (behind you)
 *   cur  = head;           // the node you're currently flipping
 *   while (cur != null):
 *       next = cur.next;   // 1. SAVE the rest of the list before you overwrite
 *       cur.next = prev;   // 2. flip this node's link to point backward
 *       prev = cur;        // 3. slide prev forward to cur
 *       cur  = next;       // 4. slide cur forward to the saved next
 *   return prev;           // prev is the new head when cur runs off the end
 *
 * Why `next` matters: once you do `cur.next = prev`, the original forward link is gone.
 * If you didn't save it first, you'd lose the entire rest of the list.
 */
public class ReverseLinkedList {

    // A node in a singly linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static ListNode reverseList(ListNode head) {
        // TODO: implement the three-pointer reversal described above.
        throw new UnsupportedOperationException("implement reverseList");
    }

    // ---------------------------------------------------------------------
    // Test harness — you don't need to edit below this line.
    // Run:  javac ReverseLinkedList.java && java ReverseLinkedList
    // ---------------------------------------------------------------------
    private static int passed = 0, failed = 0;

    // Build a linked list from an int array; returns the head (or null if empty).
    private static ListNode build(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    // Convert a linked list back into an int array so we can compare easily.
    private static int[] toArray(ListNode head) {
        int n = 0;
        for (ListNode c = head; c != null; c = c.next) n++;
        int[] out = new int[n];
        int i = 0;
        for (ListNode c = head; c != null; c = c.next) out[i++] = c.val;
        return out;
    }

    private static void check(int[] input, int[] expected) {
        int[] actual;
        try {
            actual = toArray(reverseList(build(input)));
        } catch (UnsupportedOperationException e) {
            System.out.printf("TODO   reverse(%-18s)  not implemented yet%n", Arrays.toString(input));
            failed++;
            return;
        }
        if (Arrays.equals(actual, expected)) {
            passed++;
            System.out.printf("PASS   reverse(%-18s) = %s%n", Arrays.toString(input), Arrays.toString(actual));
        } else {
            failed++;
            System.out.printf("FAIL   reverse(%-18s) = %s  (expected %s)%n",
                    Arrays.toString(input), Arrays.toString(actual), Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        check(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        check(new int[]{1, 2}, new int[]{2, 1});
        check(new int[]{1}, new int[]{1});
        check(new int[]{}, new int[]{});
        check(new int[]{7, 7, 8}, new int[]{8, 7, 7});
        check(new int[]{-1, 0, 1}, new int[]{1, 0, -1});

        System.out.println("--------------------------------------------------");
        System.out.printf("Result: %d passed, %d failed%n", passed, failed);
        if (failed == 0) {
            System.out.println("All tests passed. Nice — ping me for a review!");
        }
    }
}
