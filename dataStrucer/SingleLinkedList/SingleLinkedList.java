package SingleLinkedList;

import java.util.Stack;

/**
 * @Author He
 * @Date 2020/3/25 18:07
 * @Version 1.0
 */
public class SingleLinkedList {
    public static void main(String[] args) {
 //   SingleLinkedList.Node hgy1 = new SingleLinkedList.Node(1, "hgy");
 //   SingleLinkedList.Node hgy3 = new SingleLinkedList.Node(3, "hgy1");
 //   SingleLinkedList.Node hgy2 = new SingleLinkedList.Node(2, "hgy211");
 //   SingleLinkedList.SingleLinked singleLinked = new SingleLinkedList.SingleLinked();
 //   singleLinked.addByNo(hgy1);
 //   singleLinked.addByNo(hgy2);
 //   singleLinked.addByNo(hgy3);
 //   singleLinked.list();
 //   SingleLinkedList.Node reverse = singleLinked.reverse(singleLinked.getHeadNode());
 //   singleLinked.setHeadNode(reverse);
 //   singleLinked.list();
 //   singleLinked.reversePrint(singleLinked.getHeadNode());

        //circleLinked测试
        circleLinked cir=new circleLinked();
        cir.addNode(new Node(1,"丹怡"));
        cir.addNode(new Node(2,"高雲"));
        cir.addNode(new Node(3,"小明"));
        cir.addNode(new Node(4,"小红"));
        cir.addNode(new Node(5,"小黄"));
        cir.show();
        System.out.println("=======");
        cir.JosefulQue(5);
    }
}

class SingleLinked{
    private Node headNode=new Node(0, "");
    //不考虑顺序添加

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public  boolean addNode(Node newNode){
        Node temp=headNode;
        while (true){
            if (temp.getNext()==null){
                temp.setNext(newNode);
                return true;
            }else{
                temp=temp.getNext();
            }
        }
    }
    //按照顺序添加节点
    public void addByNo(Node newNode){
        Node temp=headNode;
        boolean flag=false;
        while(true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo()>newNode.getNo()){
                break;
            }else if (temp.getNext().getNo()==newNode.getNo()){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if (flag==true){
            System.out.println("已经有此数据了！");
        }else{
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }
    //更新数据
    public boolean update(Node newNode){
        Node temp=headNode;
        while(true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo()==newNode.getNo()){
                temp.getNext().setName(newNode.getName());
                return true;
            }
        }
        System.out.println("链表中无此节点");
        return false;
    }
    //删除指定no的节点
    public boolean deleteNode(Integer no){
        Node temp=headNode;
        while(true){
            if (temp.getNext()==null){
                System.out.println("链表中没有此节点");
                break;
            }
            if (temp.getNext().getNo()==no){
                temp.setNext(temp.getNext().getNext());
                return true;
            }
            temp=temp.getNext();
        }
        return false;
    }
    //判断链表中有多少个有效数据
    public static int length(Node headNode){
        int length=0;
        while(headNode.getNext()!=null){
            length++;
            headNode=headNode.getNext();
        }
        return length;
    }
    //将链表反转
    public  Node reverse(Node headNodel){
        Node newNode=new Node(0,"0");
        Node temp;
        while (headNodel.getNext()!=null){
            temp=headNodel.getNext();
            headNodel.setNext(headNodel.getNext().getNext());
            temp.setNext(newNode.getNext());
            newNode.setNext(temp);
        }
        headNodel.setNext(newNode.getNext());
        return headNodel;
    }
    //将链表数据反转输出且不改变链表的结构
    public void reversePrint(Node headNode){
        Stack<String> stack=new Stack();
        while (headNode.getNext()!=null){
            stack.push(headNode.getNext().toString());
            headNode.setNext(headNode.getNext().getNext());
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }


//遍历输出
    public void list(){
        if (headNode.getNext()==null){
            System.out.println("此节点为空");
        }else{
            Node temp=headNode;
            while (true){
                System.out.println(temp.getNext());
                temp=temp.getNext();
                if (temp.getNext()==null) {
                    break;
                }
            }
        }
    }
}


class circleLinked{
    Node headNode;
    public void addNode(Node newNode){
        if (headNode==null){
            headNode=newNode;
            headNode.setNext(headNode);
        }else {
            Node temp=headNode;
            while(temp.getNext()!=headNode){
                temp=temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(headNode);
        }
    }
    public void show(){
        Node temp=headNode;
        if (headNode==null){
            System.out.println("链表为空");
        }else{
        while(temp.getNext()!=headNode){
            System.out.println(temp);
            temp=temp.getNext();
        }
            System.out.println(temp);
        }
    }
    public void JosefulQue(int i){
        Node temp=headNode;
        Node first;
        while(temp!=null){
             first=temp;
            for (int j=0;j<i-1;j++){
                temp=temp.getNext();
            }
            for (int k=0;k<i-2;k++){
                first=first.getNext();
            }
            System.out.println(temp);
            first.setNext(temp.getNext());
            temp=temp.getNext();
            if (first.getNext()==first){
                System.out.println(first);
                break;
            }
        }
    }
}
class Node{
    private int no;
    private Node next;
    private String name;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingleLinkedList.Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
