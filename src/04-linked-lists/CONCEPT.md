# Topic 4 — Linked Lists

## What is a linked list?
A linked list stores a sequence as a chain of **nodes**. Each node holds a **value** and a
**reference (pointer) to the next node**. The list itself is just a reference to the first node
(the **head**). The last node points to `null`.

```
head
 |
 v
[1|.] -> [2|.] -> [3|.] -> null
 val next
```

A singly linked node in Java:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

## Array vs. Linked List — the trade-off
| | Array | Linked List |
|---|---|---|
| Access i-th element | **O(1)** (direct index) | O(n) (walk from head) |
| Insert/remove at front | O(n) (shift everything) | **O(1)** (repoint head) |
| Insert/remove given the node | O(n) | **O(1)** (repoint neighbors) |
| Memory layout | contiguous (cache-friendly) | scattered (a pointer per node) |

So: arrays win for random access; linked lists win for cheap insert/remove once you're *at* the spot.
In interviews the value is learning to **manipulate pointers** carefully.

## The mental model: you only ever hold references
You can't "jump" to the middle — you **walk** the chain with a pointer:

```java
ListNode cur = head;
while (cur != null) {
    // do something with cur.val
    cur = cur.next;      // step forward
}
```

The whole game is updating `.next` links without losing track of nodes. **The #1 bug** is
overwriting a `.next` before you've saved where it pointed — so you lose the rest of the list.
The fix is almost always: **save the next node in a temp variable first.**

## The core technique: three pointers to reverse links
To reverse a list you walk through it flipping each `.next` to point backward. You need three
references so you never lose your place:
- `prev` — the node behind you (starts as `null`)
- `cur`  — the node you're processing
- `next` — a temp holding `cur.next` **before** you overwrite it

```
step: save next, point cur back to prev, then slide prev and cur forward
```

## Worked example: print a list (safe walking)
```java
static void print(ListNode head) {
    ListNode cur = head;
    StringBuilder sb = new StringBuilder();
    while (cur != null) {
        sb.append(cur.val);
        if (cur.next != null) sb.append(" -> ");
        cur = cur.next;
    }
    System.out.println(sb);   // e.g. "1 -> 2 -> 3"
}
```

## Two habits that prevent most linked-list bugs
1. **Save `next` before you rewire.** `ListNode next = cur.next;` then change `cur.next`.
2. **Dummy head node** (for problems that build/delete from the front): create a throwaway
   `dummy` node whose `.next` is the head, do your work, then `return dummy.next;`. This avoids
   special-casing the first element. (You won't need it for this first challenge, but remember it.)

## When you'll see linked lists
- Reversal (this challenge), merging two sorted lists, removing the N-th node.
- **Cycle detection** with fast/slow pointers (Floyd's algorithm) — a two-pointer classic.
- As the backing structure for stacks/queues, LRU caches, adjacency lists.

---

## Your challenge: `ReverseLinkedList.java`
Reverse a singly linked list and return the new head. Use the **three-pointer** technique
(`prev`, `cur`, `next`). O(n) time, O(1) space. The file includes helpers to build a list from an
array and convert it back, so the tests read naturally.
