package structure.huffmanTreeStudies;

import java.util.*;

/**
 * @author He
 * @version 1.0
 * @date 2020/4/15 11:35
 */
public class HuffmanTreeCode {
    public static void main(String[] args) {
        String s="i like like like java do you like a jasadfrq";
        byte[] bytes1 = s.getBytes();
        byte[] zip = zip(bytes1);
        System.out.println(new String(zip));



    }

    //将下列方法封装为一个方法，输入字符串，输出字节数组
    public static byte[] zip(byte[] bytes){
        //将字符串中每个字符转换为字节存入字节数组中
        //将字节的转换为node类型的对象，node的data表示的是字节，node的weight代表这个字节出现的次数，并将node存入list中
        List<Node> nodes = getNodes(bytes);
        //将这个list中的所有node根据weight，权值小的离顶端远，权值大的离顶端近，最后返回顶端节点，生成霍夫曼树
        Node root = createHuffmanTree(nodes);
        //对每个节点进行霍夫曼编码是的每个节点有唯一的霍夫曼码,key是Node的data属性即字符串的每个字节，value是他的霍夫曼码
        Map<Byte, String> codes = getCodes(root);

        //将字节数组转换为它的霍夫曼码，并将所有霍夫曼吗拼接为一个大的字符串，并将这个字符串拆分为多个字节存入数组zip
        byte[] zip = zip(bytes, codes);

        return zip;
    }
    //将压缩的字节数组转化为原本的字节数组
    public static byte[] deCode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder=new StringBuilder();
        //这里的stringBuilder存放的是压缩过后的字节码拼接后的字符串
        for (int i=0;i<huffmanBytes.length;i++){
            //如果是最后一位，则不需要补足高位
            boolean flag=(i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,huffmanBytes[i]));
        }
        Map<String,Byte> map=new HashMap<>();
        //将原本的key与value互换
        for (Map.Entry<Byte,String> set:huffmanCodes.entrySet()){
            map.put(set.getValue(),set.getKey());
        }
        List<Byte> lis=new ArrayList<>();
        //逐个判断是否是哈夫曼码。如果是则放入list中
        for (int i=0;i<=stringBuilder.length();){
            int count;
            for (count=i+1;count<stringBuilder.length()+1;count++) {
                //左闭右开
                if (map.containsKey(stringBuilder.substring(i, count))) {
                    lis.add(map.get(stringBuilder.substring(i, count)));
                    break;
                }
            }
            i=count;
        }
        byte[] result=new byte[lis.size()];
        for (int i=0;i<lis.size();i++){
            result[i]=lis.get(i);
        }
        return result;
    }

    /**
     * 将一个byte转换为一个二进制的字符串返回
     * @param flag 表示此字节是否需要补高位，需要则是true
     * @param b 需要转换的字节
     * @return  二进制的字符串，按补码返回
     */
    private static String byteToBitString(boolean flag,byte b){
        int temp=b;
        if (flag) {
            //如果传入的b是正数，那么他在转化为二进制的时候位数可能不满足8位，因此需要补位，这里通过位或运算来实现
            //位或运算256=1 0000 0000
            temp |= 256;
        }
        //将字节转换为二进制，返回的是temp对应的int类型的32位二进制补码
        String str=Integer.toBinaryString(temp);
        if (flag){
            //将int类型的补码截取后8位即是我们需要的byte类型的补码
            return str.substring(str.length()-8);
        }else {
            //如果是最后一个字节是负数需要截取后八位
            if (temp<0){
                return str.substring(str.length()-8);
            }
            //如果是正数则无需补足高位直接返回
            return str;
        }
    }
    //将字节数组转换为节点list，每个字节信息输入node中
    private static List<Node> getNodes(byte[] bytes){
        List<Node> nodes=new ArrayList<>();
        Map<Byte,Integer> map=new HashMap<>();
        for (Byte b:bytes){
            Integer count=map.get(b);
            if (count==null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    //将一组节点转变为霍夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left= nodes.get(0);
            Node right= nodes.get(1);
            Node parent=new Node(null,left.weight+right.weight);
            parent.left=left;
            parent.right=right;
            nodes.add(parent);
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);

    }
    //前序遍历树
    private static void pre(Node root){
        if (root==null){
            return;
        }
        System.out.println(root);
        pre(root.left);
        pre(root.right);
    }



    //将霍夫曼编码过后的字符串拆分为8个长度为单位的二进制字节数组
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder=new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //这里是判断需要多大的字节数组存储字节，也即不够8的倍数则在除的结果+1
        int len=(stringBuilder.length()+7)/8;
        byte[] huffmanBytes=new byte[len];
        int index=0;
        String subString;
        for (int i=0;i<stringBuilder.length();i=i+8){
            //最后一个字节不满足8位，则有多少放入多少
            if (i+8>stringBuilder.length()){
                subString=stringBuilder.substring(i);
            }else {
                //substring方法左闭右开
                subString = stringBuilder.substring(i, i + 8);
            }
            //将此字符串所代表的数字转换二进制字节存入数组中,这里的二进制字节代表的是补码
            huffmanBytes[index]=(byte) Integer.parseInt(subString,2 );
            index++;
        }
        return huffmanBytes;
    }


    //将以root为顶端节点的赫夫曼树进行编码
    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        getCodes(root,"",new StringBuilder());

        return huffmanCodes;
    }
    //存放每个字母的霍夫曼编码
    static public Map<Byte,String> huffmanCodes=new HashMap<>();
    //对霍夫曼树进行编码
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        //将原有的霍夫曼吗扩展到新的以便下一次追加递归
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node!=null){
            //判断是否叶子节点，不是叶子节点则进行递归
            if (node.data==null){
                getCodes(node.left,"0",stringBuilder1);
                getCodes(node.right,"1",stringBuilder1);
             //如果是叶子节点则将此节点的霍夫曼编码存入map中
            }else{
                huffmanCodes.put(node.data,stringBuilder1.toString());

            }
        }
    }
}


class Node implements Comparable<Node>{
    //该节点所代表的的字符
    Byte data;
    //该节点的权值，即出现的次数
    int weight;
    Node left;
    Node right;

    public Node(Byte data,int weight) {
        this.data=data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }


}
