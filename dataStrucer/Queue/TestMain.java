package Queue;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Queue queue=new Queue(12);
        queue.addElement(3);
        queue.addElement(3);
        queue.addElement(3);
        queue.deleteElement();
        queue.show();
        boolean empty = queue.isEmpty();
        System.out.println(empty);
    }

}
class Queue{
    private  int MaxSize;
    private int font;
    private int rear;
    private int[] arr;

    public Queue(int MaxSize){
        this.MaxSize=MaxSize;
        arr=new int[MaxSize];
        font=-1;
        rear=-1;
    }
    //队列为空的话返回true
    public boolean isEmpty(){
        if (font==rear){
            return true;
        }
        return false;
    }
    //队列满的话返回true
    public boolean isFool(){
        if(rear==MaxSize-1){
            return true;
        }
        return false;
    }
    //添加元素，添加成功的话返回true
    public boolean addElement(int element){
        if (isFool()==true){
            return false;
        }
        rear++;
        arr[rear]=element;
        return true;
    }
    //删除元素，成功则返回true
    public boolean deleteElement(){
        if (isEmpty()){
            return false;
        }
        font++;
        return true;
    }
    //输出队列所有元素
    public void show (){
        for (int i=font+1;i<rear+1;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }


}
