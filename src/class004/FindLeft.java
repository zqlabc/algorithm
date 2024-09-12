package class004;

import java.util.Arrays;

/**
 * ClassName: FindLeft
 * Package: class004
 * Description:
 *  大于等于num最左位置
 * @Author 曾清林
 * @Create 2024/9/12 20:19
 * @Version 1.0
 */
public class FindLeft {

    // 为了验证
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }




    public static int right(int[] arr,int num){
        int ans=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=num){
                ans=i;
                return ans;
            }
        }
        return ans;
    }

    public static int exist(int[] arr,int num){
        int l=0,r=arr.length-1,m=0;
        int ans=-1;
        while (l<=r){
            m=(l+r)/2;
            if(arr[m]>=num) {
                ans = m;
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return ans;
    }
}
