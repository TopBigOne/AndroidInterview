package linked_list.leet_code_234;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/20 15:50
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        boolean result = palindrome.isPalindrome(head);
        System.out.println("result: "+result);

    }
}
