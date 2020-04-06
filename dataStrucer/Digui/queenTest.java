package Digui;

import java.util.Map;

/**
 * @Author He
 * @Date 2020/3/29 10:28
 * @Version 1.0
 */


public class queenTest {
    private int[] queen=new int[8];
    private int MaxSize=8;
    int count=1;
//n表示第几个皇后
    public void check(int n){
        if (n==8){
            print();
            count++;
            return;
        }

        for (int i=1;i<=MaxSize;i++){
            queen[n]=i;
            if (judge(n)){
                check(n+1);

            }
        }
    }

    /**
     * 如果与前边的皇后冲突则返回false
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n){
        for (int i=0;i<n;i++){
            if (queen[i]==queen[n]||Math.abs(n-i)== Math.abs(queen[i]-queen[n])){
                return false;
            }
        }
        return true;
    }
    public void print(){
        for (int i=0;i<MaxSize;i++){
            System.out.print(queen[i]+" ");
        }
        System.out.println(count);
    }
}
class Test{


    public static void main(String[] args) {
        queenTest q=new queenTest();
        q.check(0);
    }
}
