package class022;

/**
 * ClassName: f
 * Package: class022
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/19 14:30
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

// 合并K个有序链表
// 测试链接：https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
public class Code01_MergeKSortedLists {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交以下的方法
    public static ListNode mergeKLists(ArrayList<ListNode> arr) {
        //小跟堆
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:arr){
            if (node!=null){
                heap.add(node);
            }
        }
        if(heap.isEmpty()){
            return null;
        }
        ListNode h=heap.poll();
        ListNode pre=h;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur=heap.poll();
            pre.next=cur;
            pre=cur;
            if(cur.next!=null){
                heap.add(cur.next);
            }
        }
        return h;
    }

}
