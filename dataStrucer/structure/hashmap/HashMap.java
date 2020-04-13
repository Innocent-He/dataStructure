package structure.hashmap;

/**
 * @Author He
 * @Date 2020/4/13 10:08
 * @Version 1.0
 */
public class HashMap {


    public static void main(String[] args) {
        HashTab tab=new HashTab(10);
        tab.addEmp(new Empty("王五",1));
        tab.findByEmpId(2);
    }
}

class Empty {
    public String name;
    public Integer id;
    public Empty next;

    public Empty(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empty{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class EmpLinkedList {
    private Empty head;


    public void addEmp(Empty newEmp) {
        if (head==null){
            head=newEmp;
        }else {
            Empty temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            temp = newEmp;
        }
    }

    public void list() {
        Empty temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void  findById(int id,int serial){
        if (head==null){
            System.out.println("没有此用户信息");
            return;
        }
        Empty temp=head;

        while (temp.id!=id){
            if (temp==null){
                System.out.println("没有此角色");
                break;
            }
            temp=temp.next;
        }
        if (temp.id==id){
            System.out.println(temp+"找到了！,在第"+serial+"个数组");
        }

    }
}
//哈希表的数据结构是由数组加链表来完成，通过查找值的key值取得的哈希值快速定位到要查找的元素处于哪一个数组中的链表中
class HashTab{
    private EmpLinkedList[] empLinkedListsArray;
    private int size;
    public HashTab(int size){
        this.size=size;
        empLinkedListsArray=new EmpLinkedList[size];
        for (int i=0;i<size;i++){
            empLinkedListsArray[i]=new EmpLinkedList();
        }
    }
    public void addEmp(Empty newEmp){
        //首先进行哈希判断该员工添加到哪条链表
        int num = toHash(newEmp.id);
        empLinkedListsArray[num].addEmp(newEmp);
    }
    public void list(){
        int num=0;
        while (num<size){
            empLinkedListsArray[num].list();
            num++;
        }
    }
    //在这里只是简单地通过员工id与数组的size取余进行哈希，
    // 而在jdk中hashMap的哈希算法是将key的高位与低位进行运算进行哈希
    public int toHash(int id){
        return id%size;
    }
    public void findByEmpId(int id){
        empLinkedListsArray[toHash(id)].findById(id,toHash(id));
    }
}