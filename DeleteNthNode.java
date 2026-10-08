public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode slow = dummy;
    ListNode fast = dummy;

    // Create a gap of n nodes
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }

    // Move together
    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }

    // Remove nth node from end
    slow.next = slow.next.next;

    return dummy.next;
}