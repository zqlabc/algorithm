package class008;

/**
 * ClassName: d
 * Package: class008
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/14 15:00
 * @Version 1.0
 */
public class PartitionList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static  ListNode partition (ListNode head,int num){
        ListNode leftHead=null,leftTail=null;
        ListNode rightHead=null,rightTail=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=null;//
            if(head.val>num){
                if(rightHead==null){
                    rightHead=head;
                }else {
                    rightTail.next=head;
                }
                rightTail=head;
            }else {
                if(leftHead==null){
                    leftHead=head;
                }else {
                    leftTail.next=head;
                }
                leftTail=head;
            }
            head=next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next=rightHead;
        return leftHead;
    }
}
