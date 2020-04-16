package structure.huffmanTreeStudies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author He
 * @version 1.0
 * @date 2020/4/15 10:47
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr={1,72,2,12,567,13,78,341};
        System.out.println(createHuffmanTree(arr));
    }

    public static huffmanNode createHuffmanTree(int[] arr) {
        List<huffmanNode> nodes = new ArrayList<>();
        //将数组的元素全部放入list中
        for (int value : arr) {
            nodes.add(new huffmanNode(value));
        }
        //将list最小的元素加起来然后跟原有的元素进行重新排序
        while (nodes.size()>1) {
            Collections.sort(nodes);
            System.out.println(nodes);
            huffmanNode left=nodes.get(0);
            huffmanNode right=nodes.get(1);
            huffmanNode parent=new huffmanNode(left.value+right.value);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

        }
        return nodes.get(0);

    }
}

/**
 * 这里需要重写compareto方法，以便进行node之间的对比，才能用Collections.sort方法
 */
class huffmanNode implements Comparable<huffmanNode>{
    int value;
    huffmanNode left;
    huffmanNode right;

    public huffmanNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "huffmanNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(huffmanNode o) {
        return this.value-o.value;
    }
}
