import java.util.ArrayDeque;
import java.util.Deque;

/*
 * CHALLENGE: Valid Parentheses  (Stack)
 * -------------------------------------
 * Given a string s containing only the characters '(', ')', '{', '}', '[' and ']',
 * return true if the brackets are balanced and correctly nested, false otherwise.
 *
 * Rules for "valid":
 *   1. Every opening bracket is closed by the SAME type of bracket.
 *   2. Brackets are closed in the correct ORDER (proper nesting).
 *   3. Every closing bracket has a matching opening bracket.
 *
 * Examples:
 *   "()"        -> true
 *   "()[]{}"    -> true
 *   "(]"        -> false   (wrong type)
 *   "([)]"      -> false   (wrong order / bad nesting)
 *   "{[]}"      -> true
 *   ""          -> true    (nothing to mismatch)
 *   "("         -> false   (never closed)
 *   ")"         -> false   (nothing to close)
 *
 * GOAL: O(n) time, O(n) space, using a STACK (ArrayDeque).
 *
 * HINTS (peek only if stuck):
 *   - Deque<Character> stack = new ArrayDeque<>();
 *   - Loop over each char c:
 *       - if c is an opener '(', '{', '[' -> stack.push(c)
 *       - else (c is a closer):
 *           - if the stack is empty -> return false (nothing to match)
 *           - pop the top; if it isn't the MATCHING opener for c -> return false
 *   - After the loop, the string is valid ONLY IF the stack is empty
 *     (a leftover opener means it was never closed).
 *
 * Tip: a switch or a few if/else on the closer to find its expected opener works fine.
 *      (Advanced: map each closer to its opener, e.g. ')'->'(' , but not required.)
 */
public class ValidParentheses {

    static boolean isValid(String s) {
        // TODO: use a stack. Push openers; on a closer, check it matches the top.
        throw new UnsupportedOperationException("implement isValid");
    }

    // ---------------------------------------------------------------------
    // Test harness — you don't need to edit below this line.
    // Run:  javac ValidParentheses.java && java ValidParentheses
    // ---------------------------------------------------------------------
    private static int passed = 0, failed = 0;

    private static void check(String input, boolean expected) {
        boolean actual;
        try {
            actual = isValid(input);
        } catch (UnsupportedOperationException e) {
            System.out.printf("TODO   isValid(%-10s)  not implemented yet%n", quote(input));
            failed++;
            return;
        }
        if (actual == expected) {
            passed++;
            System.out.printf("PASS   isValid(%-10s) = %s%n", quote(input), actual);
        } else {
            failed++;
            System.out.printf("FAIL   isValid(%-10s) = %s  (expected %s)%n", quote(input), actual, expected);
        }
    }

    private static String quote(String s) {
        return '"' + s + '"';
    }

    public static void main(String[] args) {
        check("()", true);
        check("()[]{}", true);
        check("(]", false);
        check("([)]", false);
        check("{[]}", true);
        check("", true);
        check("(", false);
        check(")", false);
        check("((()))", true);
        check("([{}])", true);
        check("[({})](]", false);

        System.out.println("--------------------------------------------------");
        System.out.printf("Result: %d passed, %d failed%n", passed, failed);
        if (failed == 0) {
            System.out.println("All tests passed. Nice — ping me for a review!");
        }
    }
}
