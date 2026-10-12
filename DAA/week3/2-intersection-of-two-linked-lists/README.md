# 2. Intersection of Two Linked Lists

## 1. Problem
Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. If there is no intersection, return `null`. The original list structure must not be modified.

## 2. Approach
We use a two-pointer technique (`pA` and `pB`) to eliminate the difference in length between the two lists:

1. Initialize `pA = headA` and `pB = headB`.
2. Move both pointers forward one step at a time.
3. When `pA` reaches `null`, redirect it to `headB`.
4. When `pB` reaches `null`, redirect it to `headA`.
5. If the lists intersect, both pointers will travel a combined distance of `lenA + lenB` and meet at the intersection node. If they do not intersect, both pointers will reach `null` at the exact same time after completing two passes.

### Written Tracing Example
List A: `4 -> 1 -> 8 -> 4 -> 5` (length 5)  
List B: `5 -> 6 -> 1 -> 8 -> 4 -> 5` (length 6)  
Intersection at node `8`.

* **Pass 1:**
  * `pA` traverses List A (5 nodes), hits `null`, redirects to `headB`.
  * `pB` traverses List B (6 nodes), hits `null`, redirects to `headA`.
* **Pass 2:**
  * `pA` takes 3 steps in List B ($5 + 3 = 8$ total steps).
  * `pB` takes 2 steps in List A ($6 + 2 = 8$ total steps).
  * Both pointers point to node `8` simultaneously.
* **Output:** Node `8`.

### Challenges Faced & Failed Attempts
* **Hash Set Memory Overhead:** Initially, I considered storing all node references of List A in a `HashSet<ListNode>` and checking List B nodes against it. Although this ran in O(m + n) time, it required O(m) auxiliary space. Switching to the two-pointer redirection technique allowed us to achieve O(1) space complexity.

## 3. Complexity Analysis
* **Time Complexity:** O(m + n)
  * **Why:** $m$ and $n$ represent the lengths of `headA` and `headB`. In the worst-case scenario, each pointer visits every node in both lists at most twice ($2 \times (m + n)$ operations).
* **Space Complexity:** O(1)
  * **Why:** The solution uses only two reference variables (`pA` and `pB`), allocating constant memory.

## 4. Reflection / Improvement
* **Is there a more efficient approach?** No, O(m + n) time and O(1) space is the theoretical optimum.
