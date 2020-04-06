package sort.shellSort;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/4/1 21:45
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={1,5,2,8,0,6,10,23,67};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp;
        int length = arr.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                for (int j = i - gap; j >= 0; j-=gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            gap=gap/2;


        }
    }
    public static void shellSort2(int[] arr){
        int insertValue;
        int length = arr.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i=gap;i<length;i++){
                int j=i;
                insertValue=arr[j];
                while(j-gap>=0&&insertValue<arr[j-gap]){
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                arr[j]=insertValue;
            }
            gap=gap/2;
        }
    }
}
