package jasen.io;

import org.junit.Test;

import java.io.*;

/**
 * 处理流：缓冲流
 * -- 字节流
 * BufferedInputStream
 * BufferedOutputStream
 * -- 字符流
 * BufferedReader
 * BufferedWriter
 * <p>
 * 缓冲流的作用：提高传输效率
 *
 * @author xiaosen
 */
public class BufferedTest {
    /**
     * BufferedReader
     * BufferedWriter
     * BufferedInputStream
     * BufferedOutputStream
     */
    @Test
    public void bufferReaderAndWriter() {
        // 1
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("fileTest.txt"), 1024);
            bufferedWriter = new BufferedWriter(new FileWriter("fileTestCopySSS.txt", true), 1024);
            // 不等于-1 说明还有值可以继续读
            int len = 0;
            // 每次读多少
            char[] cbuf = new char[1024];
            while ((len = bufferedReader.read(cbuf)) != -1) {
                bufferedWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                assert bufferedReader != null;
                bufferedReader.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * BufferedInputStream
     * BufferedOutputStream
     */
    @Test
    public void bufferedInputSteamAndOutputStream() {
        // 被拷贝的文件路径
        String filePathSrc = "/Users/xiaosen/Downloads/我的影片-1080p30的副本.MOV";
        // 拷贝的文件路径
        String filePathCopy = "/Users/xiaosen/Downloads/我的影片-1080p30的副本2.MOV";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePathSrc));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePathCopy));
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(b)) != -1) {
                bufferedOutputStream.write(b, 0, len);
            }


        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedInputStream != null;
                bufferedInputStream.close();
                assert bufferedOutputStream != null;
                bufferedOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
