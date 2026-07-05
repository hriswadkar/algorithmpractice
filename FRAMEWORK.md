# The 5-Step Problem-Solving Framework

Solving DSA problems is a *skill*, not trivia. The goal is not to memorize answers but to build a
repeatable process you can apply to any problem — including ones you've never seen. Use these 5 steps
every single time.

## 1. Restate the problem
Write, in plain language:
- **Inputs**: types, sizes, ranges. (e.g. "an array of up to 10^5 integers, values may be negative")
- **Output**: exactly what to return.
- **Constraints**: sorted? distinct? can it be empty? null?
- **Edge cases**: empty input, single element, all-same, negatives, overflow.

> The constraints often tell you the intended complexity. If n can be 10^5, an O(n^2) solution
> (~10^10 ops) is too slow — you probably need O(n) or O(n log n).

## 2. Trace an example by hand
Take a small input and walk through it on paper. This forces you to actually understand the problem
before you write code, and gives you a test case for free.

## 3. Brute force first
Get *a* working solution, even if it's slow. Correct-but-slow beats clever-but-broken. State its
Big-O. This is your baseline and often reveals the structure of the problem.

## 4. Find the bottleneck
Ask: which step makes it slow? Common culprits:
- A nested loop re-scanning data → O(n^2).
- Repeated searches in a list → each is O(n).
- Recomputing the same subproblem over and over.

## 5. Optimize by removing the bottleneck
Match the bottleneck to a technique:
- Repeated lookups → **HashMap / HashSet** for O(1).
- Sorted data / pairs from both ends → **Two Pointers**.
- "Most recent / matching" → **Stack**.
- Level-by-level / shortest path → **BFS (Queue)**.
- Overlapping subproblems → **Dynamic Programming (memoization / tabulation)**.

---

## Big-O cheat sheet

| Notation | Name | Example |
|----------|------|---------|
| O(1) | constant | HashMap get/put, array index |
| O(log n) | logarithmic | binary search |
| O(n) | linear | single loop over input |
| O(n log n) | linearithmic | good sorting |
| O(n^2) | quadratic | nested loop over input |
| O(2^n) | exponential | naive recursion over subsets |

Rule of thumb for the input size `n`:
- n ≤ 20 → O(2^n) may be fine
- n ≤ 5,000 → O(n^2) ok
- n ≤ 10^6 → need O(n) or O(n log n)
