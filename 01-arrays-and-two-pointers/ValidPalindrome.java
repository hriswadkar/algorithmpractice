/*
 * CHALLENGE: Valid Palindrome  (Arrays & Two Pointers — Shape A)
 * ---------------------------------------------------------------
 * A phrase is a palindrome if, after converting all uppercase letters to lowercase
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 *
 * Given a String s, return true if it is a palindrome, false otherwise.
 *
 * Examples:
 *   "A man, a plan, a canal: Panama"  ->  true   (becomes "amanaplanacanalpanama")
 *   "race a car"                      ->  false  (becomes "raceacar")
 *   ""                                ->  true   (empty reads the same both ways)
 *   ".,"                              ->  true   (no alphanumeric chars -> empty)
 *   "0P"                              ->  false  ('0' vs 'p')
 *
 * GOAL: solve it in O(n) time and O(1) extra space using TWO POINTERS
 *       (one from the start, one from the end, walking inward).
 *
 * HINTS (peek only if stuck):
 *   - Character.isLetterOrDigit(c) tells you if a char counts.
 *   - Character.toLowerCase(c) normalizes case.
 *   - When the left char isn't alphanumeric, advance left and continue (don't compare yet).
 *     Same idea for the right pointer.
 *
 * Do NOT build a cleaned-up copy of the string first — that would be O(n) extra space.
 * The whole point is to skip junk characters in place with the two pointers.
 */
public class ValidPalindrome {

    static boolean isPalindrome(String s) {
        // TODO: implement using two pointers (left = 0, right = s.length() - 1).
        //   1. While left < right:
        //   2.   skip non-alphanumeric chars on the left, then on the right
        //   3.   compare the lowercased chars; if they differ, return false
        //   4.   move both pointers inward
        //   5. If you get through the whole string, return true.
        throw new UnsupportedOperationException("implement isPalindrome");
    }

    // ---------------------------------------------------------------------
    // Test harness — you don't need to edit below this line.
    // Run:  javac ValidPalindrome.java && java ValidPalindrome
    // ---------------------------------------------------------------------
    private static int passed = 0, failed = 0;

    private static void check(String input, boolean expected) {
        boolean actual;
        try {
            actual = isPalindrome(input);
        } catch (UnsupportedOperationException e) {
            System.out.printf("TODO   isPalindrome(%-34s)  not implemented yet%n", quote(input));
            failed++;
            return;
        }
        if (actual == expected) {
            passed++;
            System.out.printf("PASS   isPalindrome(%-34s) = %s%n", quote(input), actual);
        } else {
            failed++;
            System.out.printf("FAIL   isPalindrome(%-34s) = %s  (expected %s)%n",
                    quote(input), actual, expected);
        }
    }

    private static String quote(String s) {
        return '"' + s + '"';
    }

    public static void main(String[] args) {
        check("A man, a plan, a canal: Panama", true);
        check("race a car", false);
        check("", true);
        check(".,", true);
        check("0P", false);
        check("a", true);
        check("Was it a car or a cat I saw?", true);
        check("ab_a", true);
        check("Madam", true);
        check("hello", false);

        System.out.println("--------------------------------------------------");
        System.out.printf("Result: %d passed, %d failed%n", passed, failed);
        if (failed == 0) {
            System.out.println("All tests passed. Nice — ping me for a review!");
        }
    }
}
