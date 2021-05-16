package linked_list.leet_code_23;

import java.util.PriorityQueue;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/16/21 3:32 PM
 * @Desc : 字节：23  leetcode 23 : 合并K个升序链表 ；https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
 * 题解：https://www.bilibili.com/video/BV1u54y1U7gv?from=search&seid=2939987306071276907
 */
public class MergeKList {
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (minHeap.size() != 0) {
            ListNode node = minHeap.remove();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }

        }
        return dummy.next;

    }


    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            minHeap.add(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (minHeap.size() != 0) {
            ListNode node = minHeap.remove();
            cur.next = node;
            cur = cur.next;
            if (cur.next != null) {
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }

    /**
     * 一姐的思路，我的注释
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 优先级队列， 用 ListNode[] 数组中，每个链表的头结点的 val 做比较；
        // 小的放前面，大的放后面 （是不是有点像冒泡排序？）
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 将 数组参数lists 中的几点，全部放入优先级队列中 PriorityQueue
        for (ListNode list : lists) {
            // 当心测试 case 里面，放一个null 链表，
            // 编程经验：不要相信别人传过来的参数，一定要做非法校验，
            // 人家调一些非法参数，你的函数蹦了，那就你的问题；
            // 而不是别人的问题。没办法，行走江湖，就是这么的残酷
            if (list == null) {
                continue;
            }
            // 放.....
            minHeap.add(list);
        }

        // dummy 大法（不解释...我也不会解释...没空，，我要刷题，，，）
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        //
        while (minHeap.size() != 0) {
            // 1： 获取最小节点，不用怀疑，PripoQueue 队列 第 0 的位置已近是最小的节点了；
            ListNode minNode = minHeap.remove();
            // 2：将最小节点连接到 curr 的下一节点上（心里默念：穿针引线...）
            curr.next = minNode;
            // 3：当前节点后移一位（ps: 就是往前走一步）
            curr = curr.next;
            // 想一下，为啥可能为空的？ 回头看第2步，curr 的 next 节点，是不是连接了 minNode 节点啊？
            // minNode 是不是 会有下一个节点啊？为啥？我操？
            // think again :minNode节点元素，最原始的数据，是不是 通过 for 循环遍历lists 数组放进去的啊？
            // 这下，明白了吧
            if (curr.next != null) {
                //  minNode 当点节点已经被 curr 的 next 节点连接上了，
                // minHeap后面的节点还没有被使用，所有要将minHeap的下一个节点放到优先级队列中，
                // 优先级队列会在内部对他们进行排列的（小泡泡放已经被放在队列的第 0 个位置了...不行自己 debug）
                minHeap.add(minNode.next);
            }
        }
        // 用 dummy 大法返回结果；
        return dummy.next;

    }



}
