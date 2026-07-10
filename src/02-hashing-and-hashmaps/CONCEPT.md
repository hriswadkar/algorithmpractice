# Topic 2 — Hashing / HashMaps

## The one-sentence idea
A hash-based structure lets you **check "have I seen this?" or "what's mapped to this key?" in O(1)**
average time — by trading some extra memory for speed. This is the single most useful trick for
turning slow O(n²) nested-loop solutions into fast O(n) ones.

## How hashing works (just enough)
A **hash function** turns a key (a number, a string, an object) into an array index. The structure
stores the value at that index, so lookups don't scan — they jump straight to the slot. Collisions
(two keys landing in the same slot) are handled internally. You don't implement any of this — Java's
library does it. You just need to know: **get / put / contains are ~O(1) on average.**

## The two structures you'll use constantly

### `HashSet<T>` — "have I seen this?"
A collection of **unique** values. No duplicates, no ordering.

```java
Set<Integer> seen = new HashSet<>();
seen.add(5);
seen.add(5);              // ignored — already present
boolean has = seen.contains(5);   // true, O(1)
int size = seen.size();           // 1
```

### `HashMap<K,V>` — "what value is associated with this key?"
Key → value pairs. Each key is unique.

```java
Map<String,Integer> counts = new HashMap<>();
counts.put("apple", 1);
counts.put("apple", counts.get("apple") + 1);   // now 2
int c = counts.get("apple");                     // 2
boolean has = counts.containsKey("apple");       // true
int safe = counts.getOrDefault("banana", 0);     // 0 — no exception when key absent

// Frequency-counting idiom you'll reuse a LOT:
counts.merge("apple", 1, Integer::sum);          // add 1, defaulting to 0 first
```

> Gotcha: `map.get(missingKey)` returns `null` for object types, which can NPE if you auto-unbox to
> `int`. Prefer `getOrDefault(key, 0)` or `containsKey` checks.

## The classic pattern: "seen so far" in a single pass
Instead of comparing every element to every other element (nested loop, O(n²)), you walk the array
**once**, and for each element you ask a hash structure about the elements you've *already* passed.

```
for each x in nums:
    if the structure already tells me what I need  -> answer found
    else                                           -> record x and move on
```

## Worked example: "does this array contain any duplicate?" — the naive vs. hashed way

Naive, O(n²): compare every pair.
```java
for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++)
        if (nums[i] == nums[j]) return true;
return false;
```

Hashed, O(n): remember what you've seen.
```java
Set<Integer> seen = new HashSet<>();
for (int x : nums) {
    if (seen.contains(x)) return true;   // seen before -> duplicate
    seen.add(x);
}
return false;
```
The nested loop re-scans the array n times (the **bottleneck**); the HashSet answers "seen it?" in
O(1), so one pass is enough.

## When to reach for hashing
- You catch yourself writing a nested loop just to *find* or *match* something.
- You need to count occurrences (frequencies).
- You need to dedupe, or test membership repeatedly.
- You need to look something up by a key (id → user, char → count, value → index).

Trade-off: hashing uses **O(n) extra memory** and the O(1) is *average* (rare worst cases are slower).
Almost always worth it.

---

## Your challenge: `ContainsDuplicate.java`
Open the file, read the problem, implement the `// TODO` with a `HashSet`, and run it.
This is the gateway pattern — the next challenge (Two Sum) uses the same "seen so far" idea with a
`HashMap` instead of a `HashSet`.
