package class029;

/**
 * ClassName: f
 * Package: class029
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/22 16:22
 * @Version 1.0
 */


import class028.Code03_CopyListWithRandomPointer;

import java.util.HashMap;

// 实现LRU结构
public class Code02_LRU {

    // 测试链接 : https://leetcode.cn/problems/lru-cache/
    class LRUCache {

        class DoubleNode {
           public int key;
           public int val;

           public DoubleNode last;
           public DoubleNode next;

           public DoubleNode(int k,int v){
               key=k;
               val=v;
           }

        }

        class DoubleList {
            private DoubleNode head;
            private DoubleNode tail;

            public DoubleList() {
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newNode) {
                if(newNode==null){
                    return;
                }
                if(head==null){
                    head=newNode;
                    tail=newNode;
                }else {
                    tail.next = newNode;
                    newNode.last = tail;
                    newNode.next=null;
                    tail=newNode;
                }
            }

            public void moveNodeToTail(DoubleNode node) {
                if(tail==node){
                    return;
                }
                if(node==head){
                    head=node.next;
                    head.last=null;
                }else {
                    node.last.next=node.next;
                    node.next.last=node.last;
                }
                tail.next=node;
                node.last=tail;
                node.next=null;
                tail=node;
            }

            public DoubleNode removeHead() {
                if(head==null){
                    return null;
                }
                DoubleNode ans=head;
                if(head==tail){
                    head=null;
                    tail=null;
                }else {
                    head=ans.next;
                    head.last=null;
                    ans.next=null;
                }
                return ans;
            }

        }

        private HashMap<Integer, DoubleNode> keyNodeMap;

        private DoubleList nodeList;

        private final int capacity;

        public LRUCache(int cap) {
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
            capacity = cap;
        }

        public int get(int key) {
            if(keyNodeMap.containsKey(key)){
                DoubleNode doubleNode = keyNodeMap.get(key);
                nodeList.moveNodeToTail(doubleNode);
                return doubleNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(keyNodeMap.containsKey(key)){
                DoubleNode doubleNode = keyNodeMap.get(key);
                doubleNode.val=value;
                nodeList.moveNodeToTail(doubleNode);
                keyNodeMap.put(key,doubleNode);
            }else {
                if(capacity==keyNodeMap.size()){
                    DoubleNode doubleNode = nodeList.removeHead();
                    keyNodeMap.remove(doubleNode.key);
                }
                DoubleNode newNode=new DoubleNode(key,value);
                keyNodeMap.put(key,newNode);
                nodeList.addNode(newNode);
            }
        }

    }

}