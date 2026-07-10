# Topic 1 — Arrays & Two Pointers

## What is an array?
An array is a fixed-size, contiguous block of memory holding elements of the same type. In Java:

```java
int[] nums = {5, 2, 9, 1};
int first = nums[0];   // 5   — indexing is O(1)
int n = nums.length;   // 4
```

Key properties:
- **Index access is O(1)** — the CPU computes the address directly.
- **Fixed size** — you can't grow a raw array (use `ArrayList` when you need to grow).
- **Cache-friendly** — contiguous memory means looping over an array is very fast in practice.

## The Two Pointers technique
Instead of nested loops (O(n²)), you keep **two indices** moving through the array and do work in a
**single pass (O(n))**. Two common shapes:

### Shape A — pointers starting at opposite ends, moving toward each other
Great for: reversing in place, palindromes, pair-sum in a **sorted** array.

```
[ a  b  c  d  e ]
  ^           ^
 left        right     -> move them toward the middle
```

### Shape B — both pointers moving forward (fast/slow, or read/write)
Great for: removing duplicates in place, sliding windows, partitioning.

```
[ a  b  c  d  e ]
  ^  ^
 slow fast              -> fast scans ahead, slow marks the write position
```

## Worked example: reverse an array in place (Shape A)
We swap the ends and walk inward. O(n) time, O(1) extra space.

```java
static void reverse(int[] a) {
    int left = 0, right = a.length - 1;
    while (left < right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
        left++;
        right--;
    }
}
```

Trace on `[1, 2, 3, 4]`:
- left=0,right=3 → swap → `[4, 2, 3, 1]`
- left=1,right=2 → swap → `[4, 3, 2, 1]`
- left=2,right=1 → loop ends. Done.

## When to reach for two pointers
- The array is **sorted** (or you can sort it) and you need pairs/targets.
- You need to do something **in place** (no extra array).
- You're tempted to write a nested loop comparing elements — ask "can one pass with two indices do it?"

---

## Your challenge: `ValidPalindrome.java`
Open the file, read the problem at the top, implement the `// TODO`, and run it. This uses **Shape A**.
