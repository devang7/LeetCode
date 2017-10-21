class SortList {
    public static void main(String args[]) {
        int test1[] = new int[]{4,6,1,3,7};
        int test2[] = new int[]{4,2,1,7};
        ListNode list1 = createList(test1);
        ListNode list2 = createList(test2);
        printList(list2);
        ListNode sortedHead = new Solution().sortList(list2);
        printList(sortedHead);
    }
    private static ListNode createList(int arr[]) {
        ListNode head = null;
        ListNode tail = null;
        for(int i = 0; i < arr.length; i++) {
            if(head == null) {
                head = new ListNode(arr[i]);
                tail = head;
                continue;
            }
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode split = splitList(head);
        ListNode temp = split.next;
        split.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode x = merge(left, right);
        return x;
    }

    private ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast == null) return prev;
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            head = list1;
            head.next = merge(list1.next, list2);
        } else {
            head = list2;
            head.next = merge(list1, list2.next);
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
/*
4,6,1,3,7
4,2,1,7
*/
