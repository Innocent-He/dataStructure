package structure.huffmanTreeStudies;

import java.io.*;
import java.util.Map;

/**
 * @author He
 * @version 1.0
 * @date 2020/4/16 10:07
 */
public class UnZip {
    public static void main(String[] args) {
        unZipFile("C:\\Users\\H\\Desktop\\内功\\算法\\资料\\压缩测试文件\\dst.zip","C:\\Users\\H\\Desktop\\内功\\算法\\资料\\压缩测试文件\\2.png");
    }
    public static void unZipFile(String src,String dest){
        InputStream is=null;
        ObjectInputStream ois=null;
        OutputStream os=null;
        try {
            //创建路径为src的文件输入流
            is=new FileInputStream(src);
            //创建一个和is关联的对象输入流
            ois=new ObjectInputStream(is);
            //读取编码后的字节码数组
            byte[] huffmanBytes=(byte[]) ois.readObject();
            //读取霍夫曼编码表，
            Map<Byte,String> huffmanCodes=(Map<Byte,String>) ois.readObject();
            //将字节码数组通过霍夫曼编码表来进行解码
            byte[] bytes=HuffmanTreeCode.deCode(huffmanCodes,huffmanBytes);
            //创建以dest为路径的文件输出流
            os=new FileOutputStream(dest);
            //将解码过后的字节码数组写入到os中
            os.write(bytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
