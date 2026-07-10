# Topic 3 — Stacks & Queues

Two simple structures that unlock a surprising number of problems. Both are about the **order** in
which you take things out.

## Stack — LIFO (Last In, First Out)
Think of a stack of plates: you add to the top and remove from the top. The **last** thing you pushed
is the **first** thing you pop.

```
push 1   push 2   push 3        pop -> 3    pop -> 2
[1]      [1,2]    [1,2,3]        [1,2]       [1]
                    ^ top          ^ top       ^ top
```

In Java, use `ArrayDeque` as a stack (it's faster than the legacy `Stack` class):

```java
Deque<Character> stack = new ArrayDeque<>();
stack.push('a');          // add to top
char top = stack.peek();  // look at top WITHOUT removing  -> 'a'
char x   = stack.pop();   // remove and return top          -> 'a'
boolean empty = stack.isEmpty();
```

> Avoid `java.util.Stack` — it's synchronized/legacy. `ArrayDeque` is the modern choice for both
> stacks and queues.

### When to reach for a stack
- **Matching / nesting**: parentheses, HTML tags, undo history — anything where the most recent
  unmatched thing must be closed first.
- **"Most recent" logic**: next-greater-element, evaluating expressions, backtracking.
- **Reversing** order, or converting recursion into iteration.

## Queue — FIFO (First In, First Out)
Think of a line at a checkout: the **first** person in is the **first** served.

```
offer 1   offer 2   offer 3        poll -> 1    poll -> 2
[1]       [1,2]     [1,2,3]         [2,3]        [3]
 ^ front                             ^ front      ^ front
```

Also an `ArrayDeque`, but you add at one end and remove from the other:

```java
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(1);            // add to back
int front = queue.peek();  // look at front           -> 1
int y     = queue.poll();  // remove and return front -> 1
```

### When to reach for a queue
- **Breadth-first search (BFS)** — process things level by level (you'll see this in Topic 6).
- **Scheduling / streaming** — handle items in arrival order.
- **Sliding-window** problems (often a *deque* — double-ended queue).

## Deque = both
`ArrayDeque` is a **double-ended queue**: you can add/remove at *either* end. That's why it can act as
a stack (`push`/`pop` on one end) or a queue (`offer`/`poll` on opposite ends). One class, both jobs.

| Operation | Stack (LIFO) | Queue (FIFO) |
|-----------|--------------|--------------|
| add       | `push(x)`    | `offer(x)`   |
| remove    | `pop()`      | `poll()`     |
| look      | `peek()`     | `peek()`     |

## The classic stack pattern: matching pairs
Scan left to right. When you see an "opener", **push** it. When you see a "closer", the thing it must
match is whatever is on **top** of the stack (the most recent unmatched opener). Pop and check.

```
input: ( [ ] )
'(' -> push        stack: (
'[' -> push        stack: ( [
']' -> top is '['? yes, pop   stack: (
')' -> top is '('? yes, pop   stack: (empty)
end -> stack empty? yes -> balanced
```

If at any point the closer doesn't match the top (or the stack is empty when you need something to
match), it's invalid. At the end, a **non-empty** stack means unclosed openers → also invalid.

---

## Your challenge: `ValidParentheses.java`
Given a string of brackets, decide if they're balanced and correctly nested. Use a stack.
This exact pattern (push openers, match closers against the top) is one you'll reuse constantly.
