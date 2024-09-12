package class004;


/**
 * ClassName: FindPeekElement
 * Package: class004
 * Description:  二分找峰值
 *
 * @Author 曾清林
 * @Create 2024/9/12 20:20
 * @Version 1.0
 */
public class FindPeekElement {

    // 为了验证
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            if (right(arr) != exist(arr)) {
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


    public static int right(int[] arr){
        if(arr.length==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        int ans=-1;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]&&arr[i]>arr[i-1]){
                ans=i;
                return ans;
            }
        }
        return ans;
    }

    public static int exist(int[] arr){
        int ans=-1;
        if(arr.length==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        int l=1,r=arr.length-2,m=0;
        while (l<=r){
            m=(l+r)/2;
            if(arr[m-1]>arr[m]){
                r=m-1;
            } else if (arr[m]<arr[m+1]) {
                l=m+1;
            }else {
                ans=m;
                break;
            }
        }
        return ans;
    }
}
