package Problems;

class P21ListNode {
    int val;
    P21ListNode next;
    P21ListNode(int x) {
        val = x;
    }
}

public class P21MergeTwoSortedLists {

    public P21ListNode getTestL1() {
        P21ListNode n1 = new P21ListNode(1);
        P21ListNode n2 = new P21ListNode(2);
        n2.next = new P21ListNode(4);
        n1.next = n2;
        return n1;
    }

    public P21ListNode getTestL2() {
        P21ListNode n1 = new P21ListNode(1);
        P21ListNode n2 = new P21ListNode(3);
        n2.next = new P21ListNode(4);
        n1.next = n2;
        return n1;
    }

    public void print(P21ListNode node) {
        System.out.print("P21 : ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public P21ListNode mergeTwoLists(P21ListNode l1, P21ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        P21ListNode start, last;

        // set start node
        if (l1.val < l2.val) {
            last = new P21ListNode(l1.val);
            l1 = l1.next;
        } else {
            last = new P21ListNode(l2.val);
            l2 = l2.next;
        }
        start = last;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = new P21ListNode(l1.val);
                l1 = l1.next;
            } else {
                last.next = new P21ListNode(l2.val);
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