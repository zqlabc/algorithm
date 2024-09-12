package class004;

import java.util.Arrays;

/**
 * ClassName: FindNumber
 * Package: class004
 * Description:二分查找
 *
 * @Author 曾清林
 * @Create 2024/9/12 20:07
 * @Version 1.0
 */
public class FindNumber {

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



    public static boolean right(int[] arr,int num){
        if(arr==null||arr.length==0){
            return false;
        }
        for(int n:arr){
            if(n==num){
                return true;
            }
        }
        return false;
    }

    public static boolean exist(int[] arr,int num){
        if(arr==null||arr.length==0){
            return false;
        }
        int l=0;
        int r=arr.length-1;
        int m=0;
        while (l<=r){
            m=(l+r)/2;
            if(arr[m]==num){
                return true;
            }else if(arr[m]<num){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return false;
    }

}
