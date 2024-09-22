package class028;

/**
 * ClassName: f
 * Package: class028
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/21 11:29
 * @Version 1.0
 */
// 返回两个无环链表相交的第一个节点
// 测试链接 : https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class Code01_IntersectionOfTwoLinkedLists {

    // 提交时不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交如下的方法
    public static ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }
        ListNode a = h1, b = h2;
        int diff = 0;
        while (a.next != null) {
            diff++;
            a = a.next;
        }
        while (b.next != null) {
            diff--;
            b = b.next;
        }
        if (a != b) {
            return null;
        }
        if (diff > 0) {
            a = h1;
            b = h2;
        } else {
            a = h2;
            b = h1;
        }
        diff = Math.abs(diff);
        while (diff-- != 0) {
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

}
