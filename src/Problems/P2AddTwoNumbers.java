package Problems;

import java.util.HashMap;

public class P2AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode makeTestNode(int input) {
        ListNode result, curr;
        curr = result = new ListNode(0);

        while(input != 0) {
            curr.next = new ListNode(input % 10);
            input = input / 10;
            curr = curr.next;
        }

        return result.next;
    }

    public void print(ListNode node) {
        System.out.print("P2 : ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result, curr;
        curr = result = new ListNode(0);

        boolean over = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (over) sum++;

            if (sum >= 10) {
                over = true;
                sum = sum % 10;
            } else {
                over = false;
            }
            curr.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        ListNode n = null;
        if (l1 != null) {
            n = l1;
        }
        if (l2 != null) {
            n = l2;
        }

        while (n != null) {
            if (over) n.val++;

            if (n.val >= 10) {
                over = true;
                n.val = n.val % 10;
            } else {
                over = false;
            }
            curr.next = new ListNode(n.val);
            n = n.next;
            curr = curr.next;
        }

        if (over) {
            curr.next = new ListNode(1);
        }

        if (result.next != null) {
            return result.next;
        } else {
            return result;
        }
    }
}