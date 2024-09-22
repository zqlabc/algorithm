package class028;

/**
 * ClassName: f
 * Package: class028
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/21 16:25
 * @Version 1.0
 */
// 返回链表的第一个入环节点
// 测试链接 : https://leetcode.cn/problems/linked-list-cycle-ii/
public class Code05_LinkedListCycleII {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交如下的方法
    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while (slow!=fast){
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}