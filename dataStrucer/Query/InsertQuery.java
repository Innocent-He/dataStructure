package Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author He
 * @Date 2020/4/8 21:12
 * @Version 1.0
 */
public class InsertQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 6, 7, 8, 9,10,11};
        System.out.println(start(arr, 5));

    }

    public static List<Integer> start(int[] arr, int findValue) {
        List<Integer> result = query(0, arr.length - 1, arr, findValue);
        return result;
    }

    public static List<Integer> query(int left, int right, int[] arr, int findValue) {
        int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
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
