package class029;

/**
 * ClassName: f
 * Package: class029
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/22 18:59
 * @Version 1.0
 */

import java.util.PriorityQueue;

// 快速获得数据流的中位数的结构
public class Code05_MedianFinder {

    // 测试链接 : https://leetcode.cn/problems/find-median-from-data-stream/
    class MedianFinder {
        public PriorityQueue<Integer> minHeap;//把大的一半挡在小根堆
        public PriorityQueue<Integer> maxHeap;//把小的一半放在大根堆

        public MedianFinder() {
            minHeap = new PriorityQueue<>((a, b) -> a - b);
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                return minHeap.size() > maxHeap.size() ? (double) minHeap.peek() : (double) maxHeap.peek();
            }
        }

        private void balance() {
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

}