package Query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二分查找法如果一直差找不到，left和right会一直趋于接近并重合，最终出现left大于right的情况，此时可以判断出数组中没有要查找的元素
 * @Author He
 * @Date 2020/4/7 20:55
 * @Version 1.0
 */
public class BinaryQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 6, 7, 8, 9,10,11};
        System.out.println(start(arr, 5));

    }

    public static List<Integer> start(int[] arr, int findValue) {
        List<Integer> result = query(0, arr.length - 1, arr, findValue);
        return result;
    }

    public static List<Integer> query(int left, int right, int[] arr, int findValue) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if(left>right){
            return new ArrayList<>();
        }
        if (findValue > midValue) {
            return query(mid + 1, right, arr, findValue);
        }
        if (findValue < midValue) {
            return query(left, mid - 1, arr, findValue);
        }
        else   {

            int temp=mid-1;
            ArrayList<Integer> list=new ArrayList<>();

            while (temp>-1&&arr[mid]==arr[temp]){
                list.add(temp);
                temp--;
            }
            list.add(mid);
            int temp2=mid+1;
            while (temp2<arr.length&&arr[temp2]==arr[mid]){
                list.add(temp2);
                temp2++;
            }
            return list;
        }
    }

}
