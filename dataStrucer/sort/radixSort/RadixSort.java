package sort.radixSort;

import java.util.Arrays;

/**
 * 此算法空间占用率极大，但是速度效率高。运用了桶排序的思想
 *
 * @Author He
 * @Date 2020/4/6 21:45
 * @Version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){

        int[][] bucket=new int[10][arr.length];
        /*它的索引代表桶的序号，值代表桶存有元素的数量，初始默认值为0*/
        int[] bucketElementCounts;
        int flag;
        int times=1;
        while (true) {
            bucketElementCounts=new int[10];
             flag = 0;

            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = (arr[i] /times)% 10;
                if (digitOfElement!=0){
                    flag++;
                }
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            times=times*10;
//            此处判断循环次数是否是最大数的位数
            if (flag==0){
                break;
            }
            int index = 0;
//        遍历每个桶
            for (int i = 0; i < bucket.length; i++) {
//            遍历检查每个桶的容量,不为0的话将数字依次取出
                if (bucketElementCounts[i] != 0) {
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }

            }
        }

    }
}
