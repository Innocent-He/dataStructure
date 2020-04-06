package sort.selectSort;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/3/30 21:11
 * @Version 1.0
 */
public class selectSort {
    public static void main(String[] args) {
        int[] lis={10,-1,2,8,6,5,12};
        sort(lis);
    }
    public static void sort(int[] lis){
        int length=lis.length;
        int min=0;
        while (min!=length-1) {
            for (int i = min + 1; i < length; i++) {
                if (lis[min] > lis[i]) {
                    int exch = lis[i];
                    lis[i] = lis[min];
                    lis[min] = exch;
                }
            }
            System.out.println("第"+min+"此排序结果是："+Arrays.toString(lis));
            min++;
        }
    }
}
