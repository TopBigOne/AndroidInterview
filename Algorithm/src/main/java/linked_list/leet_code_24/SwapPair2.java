package linked_list.leet_code_24;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/17/21 1:55 PM
 * @Desc : 两两交换链表中的节点，使用非递归的方式，便于理解
 * （https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/）
 * <p>
 * 视频讲解：
 * https://www.bilibili.com/video/BV13J411V7hG?from=search&seid=6008195535902271070
 * <p>
 * 图画的不错
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-65/
 */
public class SwapPair2 {
    /**
     * 1->2->3->4->5;
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode future = pre.next.next;

            pre.next = future;
            cur.next = future.next;
            future.next = cur;

            pre = pre.next.next;
        }

        return dummy.next;
    }

    /**
     * @param head 假设链表是：1->2->3->4->5
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        // 新建一个 dummy 节点，起到穿针引线的作用
        ListNode dummy = new ListNode(0);
        // pre 节点等于当前的 dummy 节点
        ListNode pre = dummy;
        // pre 的下一个节点等于 head，
        // 到此：节点的形式可以看做 ：dummy->1->2->3->4->5
        pre.next = head;

        // 这个判断，保证，要处理的节点，至少是 3 个节点，为啥呢？
        // PS:两个节点，不是也能做两两交换吗？这样想，一点都没错...但是，不要忘记有一个 dummy 节点哦！
        // 假设，ListNode 是：dummy->1 ,这种场景，节点数，一共就是 2 个，但是 dummy 是虚拟的，
        // 不能将交换结果变成：1->dummy ,这样显然不对。
        // 总之：dummy 节点，是一个虚拟节点，所以至少要有 2 个真实的节点存在，
        // 否则，只有一个或者一个真实节点都没有的话，那就无法做两两交换，对吧？
        while (pre.next != null && pre.next.next != null) {
            // dummy->1->2->3->4->5
            // cur = 1;
            ListNode cur = pre.next;
            // future = 2;
            ListNode future = pre.next.next;

            // 开始做交换处理；
            // pre(dummy) 节点 指向 2;
            pre.next = future;
            // 当先节点的下一个节点指向 3;
            cur.next = future.next;
            // 3 个下一个节点，指向 1；
            future.next = cur;
            pre = pre.next.next;

        }
        // 返回 dummy 的下一个节点；
        return dummy.next;
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        // dummy->1->2->3->4->5;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode future = pre.next.next;

            pre.next = future;
            cur.next = future.next;
            future.next = cur;

            pre = pre.next.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs4(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode future = pre.next.next;

            pre.next = future;
            cur.next = future.next;
            future.next = cur;
            pre = pre.next.next;

        }

        return dummy.next;
    }

    /**
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/tu-jie-24-liang-liang-jiao-huan-lian-bia-63fj/
     *
     * @param head
     * @return
     */
    public ListNode swapPairs5(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {

            ListNode node1 = pre.next;
            ListNode node2 = node1.next;

            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return dummy.next;
    }


    /**
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/tu-jie-24-liang-liang-jiao-huan-lian-bia-63fj/
     *
     * @param head
     * @return
     */
    public ListNode swapPairs6(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;
            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }
        return dummy.next;
    }

    public ListNode swapPais7(ListNode head) {
        // dummy 大法
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            // 重新获取 mark1 和mark2
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;
            // 做交换：三步走；
            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            // pre 指针和curr 变量后移，ps: 因为是两两交换，指针肯定是往后移动两位
            pre = curr;
            curr = mark2;
        }
        return dummy.next;
    }

    public ListNode swapPairs8(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;
            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }
        return dummy.next;
    }


    public ListNode swapPairs9(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            // swap
            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }

        return dummy.next;
    }

    public ListNode swapPairs11(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            // 平移
            pre = curr;
            curr = mark2;

        }

        return dummy.next;
    }

    public ListNode swapPairs13(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr!=null&&curr.next!=null){
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }

        return dummy.next;
    }



}
