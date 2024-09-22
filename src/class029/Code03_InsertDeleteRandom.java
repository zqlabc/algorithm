package class029;

/**
 * ClassName: f
 * Package: class029
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/22 17:16
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

// 插入、删除和获取随机元素O(1)时间的结构
public class Code03_InsertDeleteRandom {

    // 测试链接 : https://leetcode.cn/problems/insert-delete-getrandom-o1/
    class RandomizedSet {

        //<值,下标>
        public HashMap<Integer,Integer> map;
        public ArrayList<Integer> arr;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int index = map.get(val);
            int endVal=arr.get(arr.size()-1);
            arr.set(index,endVal);
            map.put(endVal,index);
            map.remove(val);
            arr.remove(arr.size()-1);
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }

    }

}