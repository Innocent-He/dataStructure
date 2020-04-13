package structure.tree;

/**
 * @Author He
 * @Date 2020/4/13 11:55
 * @Version 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree(new Node(5,"乐乐"));
        binaryTree.add(new Node(3,"33"),binaryTree.top);
        binaryTree.add(new Node(2,"33"),binaryTree.top);
        binaryTree.add(new Node(4,"44"),binaryTree.top);
        binaryTree.add(new Node(7,"77"),binaryTree.top);
        binaryTree.add(new Node(6,"77"),binaryTree.top);
        binaryTree.add(new Node(8,"55"),binaryTree.top);
        binaryTree.postQuery(binaryTree.top,4);
    }
}
class Node{
    int id;
    String name;
    Node left;
    Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class BinaryTree{
    Node top;

    public BinaryTree(Node top) {
        this.top = top;
    }

    void add(Node newNode, Node insert){
        if (newNode.id>insert.id){
            if (insert.right!=null) {
                add(newNode, insert.right);
            }else {
                insert.right=newNode;
                return;
            }
        }else {
            if (insert.left!=null){
                add(newNode,insert.left);
            }else {
                insert.left=newNode;
                return;
            }
        }
    }
    //前序遍历
    void preTraversal(Node top){
        System.out.println(top);
        if (top.left!=null){
            preTraversal(top.left);
        }
        if (top.right!=null){
            preTraversal(top.right);
        }else {
            return;
        }
    }
    //中序遍历
    void midTraversal(Node top){
        if (top.left!=null){
            midTraversal(top.left);
        }
        System.out.println(top);
        if (top.right!=null){
            midTraversal(top.right);
        }
    }
    //后序遍历
    void postTraversal(Node top){
        if (top.left!=null){
            postTraversal(top.left);
        }
        if (top.right!=null){
            postTraversal(top.right);
        }
        System.out.println(top);
    }
    void preQuery(Node top,int findNo){
        if (top.id==findNo){
            System.out.println(top);
        }
        if (top.left!=null){
            preQuery(top.left,findNo);
        }
        if (top.right!=null){
            preQuery(top.right,findNo);
        }
    }
    void midQuery(Node top,int findNo){
        if (top.left!=null){
            midQuery(top.left,findNo);
        }
        if (top.id==findNo){
            System.out.println(top);
        }
        if (top.right!=null){
            midQuery(top.right,findNo);
        }
    }
    void postQuery(Node top,int findNo){
        if (top.left!=null){
            postQuery(top.left,findNo);
        }
        if (top.right!=null){
            postQuery(top.right,findNo);
        }
        if (top.id==findNo){
            System.out.println(top);
        }
    }
}
