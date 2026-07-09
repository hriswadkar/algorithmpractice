# algorithmpractice

A hands-on course to build real confidence in **Data Structures & Algorithms**, written in **Java**.

Built for an experienced software engineer who never formally studied DSA. Each topic gives you a
short concept explanation, a worked example, and a **challenge you code yourself** — with runnable
tests so you get instant feedback. No build tools, no frameworks. Just a JDK.

---

## How to use this repo

1. Read the topic's `CONCEPT.md` (5 minutes).
2. Open the challenge file (e.g. `ValidPalindrome.java`). Read the problem description at the top.
3. Implement the method marked `// TODO`.
4. Run the file. The tests print `PASS`/`FAIL` and a summary. Iterate until all green.
5. Ping me — I'll review your solution, explain the optimal approach, and give the Big-O.

### Running a challenge

Each challenge is a **single self-contained file** with its own tests in `main`. From the repo root:

```bash
# compile + run (Windows PowerShell or bash — same commands)
javac 01-arrays-and-two-pointers/ValidPalindrome.java
java  -cp 01-arrays-and-two-pointers ValidPalindrome
```

Or `cd` into the folder first:

```bash
cd 01-arrays-and-two-pointers
javac ValidPalindrome.java && java ValidPalindrome
```

You need a JDK (11+). Check with `java -version`.

---

## The roadmap

We go roughly easy → hard. Each topic builds on the previous one.

| # | Topic | Core idea | Status |
|---|-------|-----------|--------|
| 1 | **Arrays & Two Pointers** | Walk an array with one or two indices; in-place work | Done |
| 2 | **Hashing / HashMaps** | Trade memory for O(1) lookups; frequency counting | In progress |
| 3 | **Stacks & Queues** | LIFO / FIFO; monotonic stacks | Planned |
| 4 | **Linked Lists** | Node-by-node pointers; reversal, cycle detection | Planned |
| 5 | **Trees (Binary Trees / BST)** | Recursion + traversals (in/pre/post-order) | Planned |
| 6 | **Graphs: BFS / DFS** | Explore grids/graphs; shortest path, connectivity | Planned |
| 7 | **Dynamic Programming** | Break a problem into overlapping subproblems | Planned |

### How each round works
- I explain the concept briefly and *when to reach for it*.
- You get a challenge with a Java starter file + tests you can run.
- You attempt it; I review, show the optimal solution, and note the time/space complexity.

---

## The problem-solving framework

For every problem, use this 5-step habit (it matters more than memorizing solutions):

1. **Restate** — inputs, outputs, constraints, edge cases, in your own words.
2. **Trace** — hand-run a small example on paper before coding.
3. **Brute force** — get *a* correct solution, even if slow. Note its Big-O.
4. **Bottleneck** — find the exact step that makes it slow.
5. **Optimize** — pick a data structure / technique that removes the bottleneck.

See `FRAMEWORK.md` for details.

---

## Progress log

| Date | Topic | Challenge | Result |
|------|-------|-----------|--------|
| 2026-07-05 | Arrays & Two Pointers | Valid Palindrome | solved (O(n) two pointers) |
| 2026-07-05 | Hashing / HashMaps | Contains Duplicate | solved (O(n) HashSet) |
| _pending_ | Hashing / HashMaps | Two Sum | not started |
