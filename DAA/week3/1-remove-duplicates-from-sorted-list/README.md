# 1. Remove Duplicates from Sorted List

## 1. Problem
Given the head of a sorted singly linked list, remove all duplicate nodes so that each element appears only once. The resulting list must remain sorted in ascending order.

## 2. Approach
Since the list is already sorted, nodes with identical values are placed adjacent to each other. We iterate through the list with a single pointer:

1. Start with `current = head`.
2. Check if `current` and `current.next` exist.
3. If `current.val == current.next.val`, skip the duplicate node by pointing `current.next` to `current.next.next`.
4. Otherwise, advance `current` to `current.next`.
5. Continue until reaching the end of the list and return `head`.

### Written Tracing Example
Input: `1 -> 1 -> 2 -> 3 -> 3 -> null`

* **Start:** `current` at first node (`1`).
* **Iteration 1:** `current.val` (1) == `current.next.val` (1). 
  * Update `current.next` to `2`. 
  * List state: `1 -> 2 -> 3 -> 3 -> null`. `current` remains at first node (`1`).
* **Iteration 2:** `current.val` (1) != `current.next.val` (2). 
  * Move `current` to `2`.
* **Iteration 3:** `current.val` (2) != `current.next.val` (3). 
  * Move `current` to first `3`.
* **Iteration 4:** `current.val` (3) == `current.next.val` (3). 
  * Update `current.next` to `null`.
  * List state: `1 -> 2 -> 3 -> null`.
* **End:** `current.next` is `null`, loop terminates.
* **Output:** `1 -> 2 -> 3 -> null`

### Challenges Faced & Failed Attempts
* **Premature Pointer Advancement:** In my first draft, I moved `current = current.next` inside the `if` block right after deleting a duplicate node. This created a bug when handling three or more identical consecutive values (e.g., `1 -> 1 -> 1`), as it skipped comparing the newly linked node. I resolved this by advancing `current` strictly inside the `else` block.

## 3. Complexity Analysis
* **Time Complexity:** O(n)
  * **Why:** The algorithm visits each node in the list at most twice (once during value evaluation and once when skipping or advancing). Thus, the runtime grows linearly with $n$, the number of nodes.
* **Space Complexity:** O(1)
  * **Why:** The algorithm operates in-place using a single pointer reference without allocating additional data structures.

## 4. Reflection / Improvement
* **Is there a more efficient approach?** No, O(n) time and O(1) space is optimal because every node must be inspected at least once.
