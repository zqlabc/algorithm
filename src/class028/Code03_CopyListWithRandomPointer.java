package class028;

/**
 * ClassName: f
 * Package: class028
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/21 15:19
 * @Version 1.0
 */


// 复制带随机指针的链表
// 测试链接 : https://leetcode.cn/problems/copy-list-with-random-pointer/
public class Code03_CopyListWithRandomPointer {

    // 不要提交这个类
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }

    // 提交如下的方法
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1 -> 2 -> 3 -> ...
        // 变成 : 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> ...
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy = null;
        //利用新老关系，设置新节点的random指针
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        cur = head;
        Node ans = cur.next;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return ans;
    }

}
