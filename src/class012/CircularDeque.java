package class012;

/**
 * ClassName: d
 * Package: class012
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/14 18:16
 * @Version 1.0
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 设计循环双端队列
// 测试链接 : https://leetcode.cn/problems/design-circular-deque/
public class CircularDeque {

    class MyCircularDeque1 {

        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerFirst(value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (deque.isEmpty()) {
                return false;
            }
            size--;
            deque.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if (deque.isEmpty()) {
                return false;
            }
            size--;
            deque.pollLast();
            return true;
        }

        public int getFront() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public int getRear() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    // 提交时把类名、构造方法改成 : MyCircularDeque
    // 自己用数组实现，常数操作快，但是leetcode数据量太小了，看不出优势
    class MyCircularDeque2 {
        int size;
        int left;
        int right;
        int limit;
        int[] deque;

        public MyCircularDeque2(int k) {
            limit = k;
            size = left = right = 0;
            deque = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    left = right = 0;
                    deque[0] = value;
                } else {
                    left = left == 0 ? (limit - 1) : (left - 1);
                    deque[left] = value;
                }
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    left = right = 0;
                    deque[0] = value;
                } else {
                    right = right == (limit - 1) ? 0 : (right + 1);
                    deque[right] = value;
                }
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            {
                size--;
                left = left == (limit - 1) ? 0 : (left + 1);
            }
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                size--;
                right = right == 0 ? (limit - 1) : (right - 1);
            }
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque[left];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque[right];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
