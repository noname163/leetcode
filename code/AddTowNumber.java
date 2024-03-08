package code;

public class AddTowNumber {

    public static void main(String[] argv) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(5);
        ListNode listNode13 = new ListNode(6);
        ListNode listNode14 = new ListNode(7);
        ListNode listNode15 = new ListNode(8);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        addTwoNumbers(listNode1, listNode11);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode nextValue1 = l1.next;
        ListNode nextValue2 = l2.next;
        int value1 = l1.val;
        int value2 = l2.val;
        while (nextValue1.next != null || nextValue2.next != null) {
            if (nextValue1.next != null) {
                value1 = value1 * 10 + nextValue1.val;
                nextValue1 = nextValue1.next;
            }
            if (nextValue2.next != null) {
                value2 = value2 * 10 + nextValue2.val;
                nextValue2 = nextValue2.next;
            }
        }
        if (nextValue1.next == null) {
            value1 = value1 * 10 + nextValue1.val;
        }
        if (nextValue2.next == null) {
            value2 = value2 * 10 + nextValue2.val;
        }
        char[] charValue1 = String.valueOf(value1).toCharArray();
        char[] charValue2 = String.valueOf(value2).toCharArray();
        String revertValue1 = "";
        String revertValue2 = "";
        for (int i = charValue1.length - 1; i >= 0; i--) {
            revertValue1 += charValue1[i];
        }
        for (int i = charValue2.length - 1; i >= 0; i--) {
            revertValue2 += charValue2[i];
        }
        int total = Integer.valueOf(revertValue1) + Integer.valueOf(revertValue2);
        boolean flag = false;
        for (char c : String.valueOf(total).toCharArray()) {
            result.val = Integer.valueOf(String.valueOf(c));
            if (flag) {
                result.next = new ListNode(Integer.valueOf(c));
            }
            flag = true;
        }
        return result;
    }

}