package structure.singleLinkedList.test;

/**
 * @Author He
 * @Date 2020/3/25 19:03
 * @Version 1.0
 */
public class test1 {
    public static void main(String[] args) {
        Node a=new Node();
        Node b=a;
        System.out.println(a);
        b.a="ac";
        System.out.println(a);
        System.out.println(b);
    }

}
