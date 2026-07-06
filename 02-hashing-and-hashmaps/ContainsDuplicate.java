import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * CHALLENGE: Contains Duplicate  (Hashing / HashSet)
 * --------------------------------------------------
 * Given an integer array nums, return true if ANY value appears at least twice,
 * and false if every element is distinct.
 *
 * Examples:
 *   [1, 2, 3, 1]        -> true   (1 appears twice)
 *   [1, 2, 3, 4]        -> false  (all distinct)
 *   [1, 1, 1, 3, 3]     -> true
 *   []                  -> false  (nothing to duplicate)
 *   [7]                 -> false
 *   [-1, -2, -1]        -> true   (negatives count too)
 *
 * GOAL: solve it in O(n) time using a HashSet ("have I seen this value before?").
 *
 * HINTS (peek only if stuck):
 *   - Create a Set<Integer> seen = new HashSet<>();
 *   - Walk the array once. For each value x:
 *       - if seen.contains(x) -> you found a duplicate, return true
 *       - otherwise seen.add(x) and keep going
 *   - If you finish the loop with no repeat, return false.
 *
 * (A sort-then-scan-neighbors approach also works in O(n log n) — but try the O(n) hashing version.)
 */
public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        // TODO: use a HashSet to detect a repeated value in a single pass.
        throw new UnsupportedOperationException("implement containsDuplicate");
    }

    // ---------------------------------------------------------------------
    // Test harness — you don't need to edit below this line.
    // Run:  javac ContainsDuplicate.java && java ContainsDuplicate
    // ---------------------------------------------------------------------
    private static int passed = 0, failed = 0;

    private static void check(int[] input, boolean expected) {
        boolean actual;
        try {
            actual = containsDuplicate(input);
        } catch (UnsupportedOperationException e) {
            System.out.printf("TODO   containsDuplicate(%-18s)  not implemented yet%n", Arrays.toString(input));
            failed++;
            return;
        }
        if (actual == expected) {
            passed++;
            System.out.printf("PASS   containsDuplicate(%-18s) = %s%n", Arrays.toString(input), actual);
        } else {
            failed++;
            System.out.printf("FAIL   containsDuplicate(%-18s) = %s  (expected %s)%n",
                    Arrays.toString(input), actual, expected);
        }
    }

    public static void main(String[] args) {
        check(new int[]{1, 2, 3, 1}, true);
        check(new int[]{1, 2, 3, 4}, false);
        check(new int[]{1, 1, 1, 3, 3}, true);
        check(new int[]{}, false);
        check(new int[]{7}, false);
        check(new int[]{-1, -2, -1}, true);
        check(new int[]{0, 0}, true);
        check(new int[]{10, 20, 30, 40, 50}, false);

        System.out.println("--------------------------------------------------");
        System.out.printf("Result: %d passed, %d failed%n", passed, failed);
        if (failed == 0) {
            System.out.println("All tests passed. Nice — ping me for a review!");
        }
    }
}
