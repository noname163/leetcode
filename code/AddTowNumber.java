package code;

public class AddTowNumber {

    public static void main(String[] argv) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        convertStringToListNode("9999999", listNode1);
        convertStringToListNode("9999", listNode2);
        ListNode result = addTwoNumbers(listNode1, listNode2);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
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
        value1 = revertNumber(value1);
        value2 = revertNumber(value2);
        int total = value1+value2;
        revertNumberResult(total, result);
        return result;
    }

    private static int revertNumber(int num){
        int result = 0;
        while (num!=0) {
            int remain = num%10;
            result = result*10 +remain;
            num = num/10;
        }
        return result;
    }
    private static void revertNumberResult(int num, ListNode listNode){
        boolean isFirstNode = true;
        while (num!=0) {
            int remain = num%10;
            if(isFirstNode){
                listNode.val = remain;
                isFirstNode = false;
            }
            else{
                listNode.next = new ListNode(remain);
                listNode = listNode.next;
            }
            num = num/10;
        }
    }

    private static void convertStringToListNode(String value,ListNode result){

        boolean isFirstNode = true;
        for (char c : value.toCharArray()) {
            if(isFirstNode){
                result.val = Integer.parseInt(String.valueOf(c));
                isFirstNode = false;
            }
            else{
                result.next = new ListNode(Integer.parseInt(String.valueOf(c)));
                result = result.next;
            }
        }
    }

}