import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * CHALLENGE: Two Sum  (Hashing / HashMap)  -- THE classic hashing problem
 * -----------------------------------------------------------------------
 * Given an integer array nums and an integer target, return the indices of the
 * two numbers that add up to target.
 *
 * Rules:
 *   - Exactly one valid answer exists for every test case.
 *   - You may NOT use the same element twice (the two indices must be different).
 *   - Return the indices in ascending order: {smallerIndex, largerIndex}.
 *
 * Examples:
 *   nums = [2, 7, 11, 15], target = 9   -> {0, 1}   (2 + 7 = 9)
 *   nums = [3, 2, 4],       target = 6   -> {1, 2}   (2 + 4 = 6)
 *   nums = [3, 3],          target = 6   -> {0, 1}   (3 + 3 = 6)
 *   nums = [-1, -2, -3, -4],target = -6  -> {1, 3}   (-2 + -4 = -6)
 *
 * GOAL: O(n) time using a HashMap. This is the "seen so far" pattern again, but
 *       instead of a Set of values you keep a Map of  value -> index.
 *
 * THE KEY INSIGHT:
 *   As you walk the array, for the current number x the number you NEED is
 *   its complement:  need = target - x.
 *   If you've already seen `need`, you have your pair. The map remembers WHERE
 *   you saw each value, so you can return both indices.
 *
 * HINTS (peek only if stuck):
 *   - Map<Integer,Integer> seen = new HashMap<>();   // value -> index
 *   - Loop with an index i from 0..n-1:
 *       - int need = target - nums[i];
 *       - if (seen.containsKey(need)) return new int[]{ seen.get(need), i };
 *       - else seen.put(nums[i], i);
 *   - Checking BEFORE you put nums[i] is what prevents reusing the same element.
 *   - The problem guarantees a solution, so the loop will always find one; a final
 *     "not found" return is just to satisfy the compiler (use new int[]{-1, -1}).
 */
public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        // TODO: use a HashMap<value, index> and the complement (target - nums[i]).
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // ---------------------------------------------------------------------
    // Test harness — you don't need to edit below this line.
    // Run:  javac TwoSum.java && java TwoSum
    // ---------------------------------------------------------------------
    private static int passed = 0, failed = 0;

    private static void check(int[] nums, int target, int[] expected) {
        int[] actual;
        try {
            actual = twoSum(nums, target);
        } catch (UnsupportedOperationException e) {
            System.out.printf("TODO   twoSum(%-16s, %3d)  not implemented yet%n", Arrays.toString(nums), target);
            failed++;
            return;
        }
        if (Arrays.equals(actual, expected)) {
            passed++;
            System.out.printf("PASS   twoSum(%-16s, %3d) = %s%n", Arrays.toString(nums), target, Arrays.toString(actual));
        } else {
            failed++;
            System.out.printf("FAIL   twoSum(%-16s, %3d) = %s  (expected %s)%n",
                    Arrays.toString(nums), target, Arrays.toString(actual), Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        check(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        check(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        check(new int[]{3, 3}, 6, new int[]{0, 1});
        check(new int[]{-1, -2, -3, -4}, -6, new int[]{1, 3});
        check(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3});
        check(new int[]{5, 75, 25}, 100, new int[]{1, 2});
        check(new int[]{1, 2, 3, 4, 5}, 9, new int[]{3, 4});

        System.out.println("--------------------------------------------------");
        System.out.printf("Result: %d passed, %d failed%n", passed, failed);
        if (failed == 0) {
            System.out.println("All tests passed. Nice — ping me for a review!");
        }
    }
}
