package doubleLinked;

/**
 * @Author He
 * @Date 2020/3/27 9:00
 * @Version 1.0
 */
public class doubleLinkedList {
    public static void main(String[] args) {

    }
}

class doubleLinked{
    private Node headNode=new Node(0, "");
    //不考虑顺序添加

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }
    //不按顺序添加节点
    public  boolean addNode(Node newNode){

        Node temp=headNode;
        while (true){
            if (temp.getNext()==null){
                temp.setNext(newNode);
                newNode.setPre(temp);
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
            temp.getNext().setPre(newNode);
            temp.setNext(newNode);
            newNode.setPre(temp);
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
                temp.getNext().getNext().setPre(temp);
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
  //表反转
  //ic  doubleLinked.Node reverse(doubleLinked.Node headNodel){
  //doubleLinked.Node newNode=new doubleLinked.Node(0,"0");
  //doubleLinked.Node temp;
  //while (headNodel.getNext()!=null){
  //    temp=headNodel.getNext();
  //    headNodel.setNext(headNodel.getNext().getNext());
  //    temp.setNext(newNode.getNext());
  //    newNode.setNext(temp);
  //}
  //headNodel.setNext(newNode.getNext());
  //return headNodel;
  //
  //表数据反转输出且不改变链表的结构
  //ic void reversePrint(doubleLinked.Node headNode){
  //Stack<String> stack=new Stack();
  //while (headNode.getNext()!=null){
  //    stack.push(headNode.getNext().toString());
  //    headNode.setNext(headNode.getNext().getNext());
  //}
  //while(!stack.empty()){
  //    System.out.println(stack.pop());
  //}
  //
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


class Node{
    private int no;
    private Node next;
    private Node pre;
    private String name;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
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
        return "doubleLinked.Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}