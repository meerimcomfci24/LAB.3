# 4. Palindrome Linked List

## 1. Problem
Given the head of a singly linked list, determine whether the list is a palindrome (reads the same forward and backward).

## 2. Approach
To solve this problem in O(n) time and O(1) space, we divide the solution into three distinct steps:

1. **Find Midpoint:** Use fast and slow pointers (`slow` moves 1 step, `fast` moves 2 steps). When `fast` reaches the end, `slow` is at the midpoint.
2. **Reverse Second Half:** Reverse the sublist starting from `slow` in-place using standard iterative pointer manipulation.
3. **Compare Values:** Compare node values step-by-step using two pointers: one starting at `head` and the other at the head of the reversed second half.

### Written Tracing Example
Input: `1 -> 2 -> 2 -> 1`

* **Step 1 (Find Midpoint):**
  * `slow` arrives at the 3rd node (value `2`).
* **Step 2 (Reverse Second Half):**
  * Reversing sublist `2 -> 1 -> null` produces `1 -> 2 -> null`.
  * First half: `1 -> 2 -> ...`
  * Second half (reversed): `1 -> 2 -> null`
* **Step 3 (Compare):**
  * Step 1: `p1.val` (1) == `p2.val` (1) $\rightarrow$ Match!
  * Step 2: `p1.val` (2) == `p2.val` (2) $\rightarrow$ Match!
* **Result:** `true`

### Challenges Faced & Failed Attempts
* **Array List Copying Attempt:** My initial instinct was to copy all values into an `ArrayList<Integer>` and use a standard two-pointer check from both ends. While simple and running in O(n) time, it required O(n) auxiliary space, violating the follow-up constraint.

## 3. Complexity Analysis
* **Time Complexity:** O(n)
  * **Why:** Finding the middle takes $n/2$ steps, reversing the second half takes $n/2$ steps, and comparison takes at most $n/2$ steps. In total, operations equal $1.5n$, which simplifies to O(n).
* **Space Complexity:** O(1)
  * **Why:** Node pointers are updated in-place without allocating extra arrays or list containers.

## 4. Reflection / Improvement
* **Is there a more efficient approach?** No, O(n) time and O(1) space is optimal.
* **Good Practice:** In a real-world scenario, re-reversing the second half before returning to restore the original list structure is considered good practice.
