# 3. Remove Linked List Elements

## 1. Problem
Given the head of a linked list and an integer `val`, remove all nodes from the linked list that have `Node.val == val`, and return the updated head.

## 2. Approach
Deleting nodes in a singly linked list requires modifying the `next` reference of the preceding node. To handle edge cases easily (e.g., when deleting the head node or when all nodes match `val`), we introduce a **dummy node**:

1. Create `dummy` where `dummy.next = head`.
2. Initialize `current = dummy`.
3. Traverse while `current.next != null`.
4. If `current.next.val == val`, remove the target node by executing `current.next = current.next.next`.
5. Otherwise, advance `current = current.next`.
6. Return `dummy.next` as the new head.

### Written Tracing Example
Input: `1 -> 2 -> 6 -> 3 -> 6`, `val = 6`

* **Setup:** `dummy(0) -> 1 -> 2 -> 6 -> 3 -> 6`, `current = dummy`
* `current.next.val` is 1 ($\neq 6$) $\rightarrow$ move `current` to `1`.
* `current.next.val` is 2 ($\neq 6$) $\rightarrow$ move `current` to `2`.
* `current.next.val` is 6 ($== 6$) $\rightarrow$ bypass node: `2.next = 3`.
* `current.next.val` is 3 ($\neq 6$) $\rightarrow$ move `current` to `3`.
* `current.next.val` is 6 ($== 6$) $\rightarrow$ bypass node: `3.next = null`.
* **End:** Return `dummy.next` (`1 -> 2 -> 3`).

### Challenges Faced & Failed Attempts
* **Handling Head Deletions Without Dummy Node:** My first attempt used separate `while` loops to handle cases where `head.val == val`. This led to verbose code and null pointer errors when the list consisted entirely of target values (e.g., `head = [7,7,7,7], val = 7`). Using a dummy node unified the deletion logic across all positions.

## 3. Complexity Analysis
* **Time Complexity:** O(n)
  * **Why:** We traverse the entire linked list in a single pass, performing O(1) work per node.
* **Space Complexity:** O(1)
  * **Why:** We only create a single dummy node and a pointer reference regardless of list length.

## 4. Reflection / Improvement
* **Is there a more efficient approach?** No, O(n) time and O(1) space is optimal.
* **Alternative Approaches:** A recursive solution is possible, but it requires O(n) space on the system call stack due to recursion frames.
