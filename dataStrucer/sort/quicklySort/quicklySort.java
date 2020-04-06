package sort.quicklySort;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/4/2 21:18
 * @Version 1.0
 */
public class quicklySort {
    public static void main(String[] args) {
        int[] arr={-3,2,45,21,5,-2,4,7,-23};
        Sort(arr,0,8);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序的核心思想是不断地数据交换将左右两边的数据按大小分割开来
     * 而如果出现小于中心数的左边索引大于或者等于（一般是等于）右边索引时，则说明本轮循环已完成，重新选择中心数
     * @param arr
     * @param left
     * @param right
     */
    public static void Sort(int[] arr,int left,int right){
        int mid=arr[(right+left)/2];
        int l=left;
        int r=right;
        int temp;
        while (l<r){

            while(arr[l]<mid){
                l++;
            }
            while (arr[r]>mid){
                r--;
            }
            //如果出现这种情况提前结束，不允许交换数据
            if (l>=r){
             break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
           if (arr[l]==mid){
               r--;
           }
           if (arr[r]==mid){
               l++;
           }
        }

        //一次循环结束，说明已经将arr[mid]左右两边的数分割完成，开始进行下一轮
        if (l==r){
            l--;
            r++;
        }
        //各自进行左右两边的排序
        if (left<l) {
            Sort(arr, left, l);
        }
        if (right>r) {
            Sort(arr, r, right);
        }
    }
}
