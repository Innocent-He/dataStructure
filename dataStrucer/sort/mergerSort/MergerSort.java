package sort.mergerSort;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/4/4 20:32
 * @Version 1.0
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] tem=new int[8];
        megerSort(arr,0,arr.length-1,tem);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并算法之分治部分的核心思想是，将一个完整的数组，
     * 通过不断地递归进行分治方法，最终将其分解为多个单个元素的数组，
     * 再调用归并方法，将其一个一个的组合起来
     * 最终实现完整排序，典型的空间换时间
     * 注意：这期间arr只有一个，不会变化，只是每个索引上的元素会变
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void megerSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            megerSort(arr, left, mid, temp);
            megerSort(arr, mid+1, right, temp);
            sum(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并算法之归并的核心思想是将两个数组归并时，
     * 如果第一个数组的第一个元素小于第二个数组的第一个元素，
     * 则将第一个数组的第一个元素先放入辅助数组，
     * 就这样依次找到最小的元素放入辅助数组，
     * 这样这个数组就是有序的，最终将辅助元素完整的赋值给原数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void sum(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            if (arr[i]<arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                j++;
                t++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
