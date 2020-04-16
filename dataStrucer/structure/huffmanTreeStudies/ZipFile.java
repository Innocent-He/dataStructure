package structure.huffmanTreeStudies;

import java.io.*;

/**
 * @author He
 * @version 1.0
 * @date 2020/4/16 9:39
 */
public class ZipFile {
    public static void main(String[] args) {
        String src="C:\\Users\\H\\Desktop\\内功\\算法\\资料\\压缩测试文件\\1.mp4";
        String dst="C:\\Users\\H\\Desktop\\内功\\算法\\资料\\压缩测试文件\\dst.zip";
        zipFile(src,dst);

    }
    public static void zipFile(String srcFile,String dstFile){
        //创建输出流
        OutputStream os=null;
        ObjectOutputStream oos=null;
        //创建文件输入流
        FileInputStream is=null;
        try {
            //根据源文件路径创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个源文件大小的字节数组
            byte[] b = new byte[is.available()];
            //读取文件存入b数组中
            is.read(b);
            //将数组压缩放入字节数组中
            byte[] huffmanBytes=HuffmanTreeCode.zip(b);
            //创建文件输出流，以便存放压缩文件
            os=new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos=new ObjectOutputStream(os);
            //将霍夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //将霍夫曼编码也写入（对象流的方式）压缩文件以便解压使用
            oos.writeObject(HuffmanTreeCode.huffmanCodes);
        }catch (Exception e){
            e.getMessage();
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
