package jasen.io;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File类
 * 1.凡是与输入、输出相关的类、接口等都定义在java.io包下
 * 2.File是一个类，可以有构造器创建其对象。此对象对应着一个文件（.txt .avi .doc .ppt .mp3 .jpg）或文件目录
 * 3.File类对象是与平台无关的。
 * 4.File中的方法，仅涉及到如何创建、删除、重命名等等。只要涉及文件内容的，File是无能为力的，必须由io流来完成。
 * 5.File类的对象常作为io流的具体类的构造器的形参。
 */
public class TestFile {
    /**
     * 路径：
     * 绝对路径：包括盘符在内的完整的文件路径
     * 相对路径：在当前文件目录下的文件的路径
     * <p>
     * getName()
     * getPath()
     * getAbsoluteFile()
     * getAbsolutePath()
     * getParent()
     * renameTo(File newName)
     */
    @Test
    public void test1() {
        File file1 = new File("D:/config.txt");
        File file2 = new File("D:/co.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println();
        System.out.println(file2.getName());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getParent());
        //要提供完整路径
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    /**
     * 文件检测
     * exists()
     * canWrite()
     * canRead()
     * isFile()
     * isDirectory()
     */
    @Test
    public void test2() {
        System.out.println(System.getProperty("user.dir"));//通过改行代码确定当前路径的相对位置。
        File file = new File("src/IO/config.txt");//注意File的相对路径是相对于当前的user.dir来说的，
        File dir = new File("src/IO/test");
        System.out.println(file.exists());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isDirectory());
        System.out.println(new Date(file.lastModified()));
        System.out.println(file.length());
        System.out.println();
        System.out.println(dir.exists());
        System.out.println(dir.canExecute());
        System.out.println(dir.canRead());
        System.out.println(dir.canWrite());
        System.out.println(dir.isDirectory());
        System.out.println(new Date(dir.lastModified()));
        System.out.println(dir.length());
    }

    /**
     * createNewFile()
     * delete()
     * mkDir():创建一个文件目录。只有在上层文件目录存在的情况下，才能返回true
     * mkDirs():创建一个文件目录。若上层文件目录不存在，一并创建
     * list()
     * listFiles()
     */
    @Test
    public void test3() throws IOException {
        File file1 = new File("src/IO/a.txt");
        //创建新的文件
        System.out.println(file1.createNewFile());
        File file2 = new File("src/IO/a");
        //创建相对目录，如果成功返回true否则返回false,注意要保证上级目录存在
        file2.mkdir();
        File file3 = new File("D:/TTT/TTT");
        //创建目录，如果上级目录不存在则一并创建。
        file3.mkdirs();
        File file4 = new File("src/IO");
        //返回目录下的文件列表
        File[] files = file4.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}