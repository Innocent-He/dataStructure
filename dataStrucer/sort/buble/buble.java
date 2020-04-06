package sort.buble;

import java.util.Arrays;

/**
 * @Author He
 * @Date 2020/3/30 20:34
 * @Version 1.0
 */
public class buble {
    public static void main(String[] args) {
        int[] list = {3, 9, -1, 10, -2};
        System.out.println(Arrays.toString(list));
    }
}

class bublesort {
    public static int[] sort(int[] lis) {
        int length = lis.length;
        int flag=0;
        while (length != 1) {
            for (int i = 0; i < length - 1; i++) {
                if (lis[i] > lis[i + 1]) {
                    int exc = lis[i + 1];
                    lis[i + 1] = lis[i];
                    lis[i] = exc;
                    flag++;
                }
            }
            if (flag==0){
                break;
            }
            flag=0;
            length--;
        }
        return lis;
    }
}
