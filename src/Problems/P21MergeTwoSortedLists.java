package Problems;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class P21MergeTwoSortedLists {

    public ListNode getTestL1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(4);
        n1.next = n2;
        return n1;
    }

    public ListNode getTestL2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        n2.next = new ListNode(4);
        n1.next = n2;
        return n1;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode start, last;

        // set start node
        if (l1.val < l2.val) {
            last = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            last = new ListNode(l2.val);
            l2 = l2.next;
        }
        start = last;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                last.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            last = last.next;
        }

        if (l1 != null) {
            last.next = l1;
        }
        if (l2 != null) {
            last.next = l2;
        }

        return start;
    }
}