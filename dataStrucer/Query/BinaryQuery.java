package Query;

/**
 *
 * 二分查找法如果一直差找不到，left和right会一直趋于接近并重合，最终出现left大于right的情况，此时可以判断出数组中没有要查找的元素
 * @Author He
 * @Date 2020/4/7 20:55
 * @Version 1.0
 */
public class BinaryQuery {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(start(arr, 10));

    }

    public static int start(int[] arr, int findValue) {
        int result = query(0, arr.length - 1, arr, findValue);
        return result;
    }

    public static int query(int left, int right, int[] arr, int findValue) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if(left>right){
            return -1;
        }
        if (findValue > midValue) {
            return query(mid + 1, right, arr, findValue);
        }
        if (findValue < midValue) {
            return query(left, mid - 1, arr, findValue);
        }
        if (midValue == findValue) {
            return mid;
        } else {
            return -1;
        }
    }

}
