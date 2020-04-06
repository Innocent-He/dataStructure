package sort.insertSort;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/3/31 20:42
 * @Version 1.0
 */
public class insertSort {
    public static void main(String[] args) {
        int[] arr={1,5,2,3,95,32,54};
        insertedSort(arr);
    }
    public static void insertedSort(int [] arr){
            int insertValue;
            int insertSeat;
        for (int i=1;i<arr.length;i++){
            insertValue=arr[i];
            insertSeat=i-1;
            while (insertSeat>=0&&insertValue<arr[insertSeat]){
                arr[insertSeat+1]=arr[insertSeat];
                insertSeat--;
            }
            arr[insertSeat+1]=insertValue;
            System.out.println("第"+i+"次排序的结果是:"+ Arrays.toString(arr));
        }
    }
}
