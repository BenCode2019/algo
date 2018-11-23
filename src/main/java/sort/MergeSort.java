package sort;

/**
 * @Auther: Ben
 * @Date: 2018/11/6 13
 * @Description:
 */
public class MergeSort {

    /**
     * 归并排序
     * @param a
     * @param n
     */
    public void mergeSort(int[] a,int n){
        mergeSort_c(a,0,n);
    }

    private void mergeSort_c(int[] a,int p,int r){
        int q = r/2;
        mergeSort_c(a,p,q);
        mergeSort_c(a,q+1,r);
        merge(a,p,q,r);
    }

    private void merge(int[] a,int p,int q,int r){
        int i = 0;
        int j = q + 1;
        int k = 0;
        int tmp[] = new int[r-p+1];
        while(i < q && i < r){
            if(a[i] < a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

    }
}
