package sort;

import java.util.Arrays;

/**
 * @Auther: Ben
 * @Date: 2018/11/1 13
 * @Description:
 */
public class Sorts {
    public static void bubbleSort(int[] a){
        if(a.length <= 1){
            return;
        }
        for(int i = 0; i < a.length; i++){
            boolean flag = false;
            for (int j = 0; j < a.length - 1; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;  //只要有一次数据没有比较，就证明这次不用比较了
            }
        }
    }

    /**
     * 插入排序，a 表示数组，n 表示数组大小
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,1,3,2};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

        insertionSort(a,a.length);
    }
}
