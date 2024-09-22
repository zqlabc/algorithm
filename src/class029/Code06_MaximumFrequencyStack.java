package class029;

/**
 * ClassName: f
 * Package: class029
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/22 19:19
 * @Version 1.0
 */


import java.util.ArrayList;
import java.util.HashMap;

// 最大频率栈
public class Code06_MaximumFrequencyStack {

    // 测试链接 : https://leetcode.cn/problems/maximum-frequency-stack/
    class FreqStack {

        // 出现的最大次数
        private int topTimes;
        // 每层节点
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();//出现次数为的节点
        // 每一个数出现了几次
        private HashMap<Integer, Integer> valueTimes = new HashMap<>();

        public void push(int val) {
            valueTimes.put(val,valueTimes.getOrDefault(val,0)+1);//记录val的出现次数
            int curTopTimes=valueTimes.get(val);
            if(!cntValues.containsKey(curTopTimes)){
                cntValues.put(curTopTimes,new ArrayList<>());//如果不存在curTopTimes次数的节点数组，新建一个
            }
            ArrayList<Integer> curTimeValues = cntValues.get(curTopTimes);
            curTimeValues.add(val);
            cntValues.put(curTopTimes,curTimeValues);
            topTimes=Math.max(curTopTimes,topTimes);
        }

        public int pop() {
            ArrayList<Integer> topTimeValues = cntValues.get(topTimes);
            int ans=topTimeValues.remove(topTimeValues.size()-1);
            if(topTimeValues.size()==0){
                cntValues.remove(topTimes--);
            }
            int times = valueTimes.get(ans);
            if(times==1){
                valueTimes.remove(ans);
            }else {
                valueTimes.put(ans, times-1);
            }
            return ans;
        }
    }

}
