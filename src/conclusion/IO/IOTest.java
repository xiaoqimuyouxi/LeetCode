package conclusion.IO;

import java.io.*;

/**
 * Created by ly on 2017/8/28.
 */
public class IOTest {
    public static void main(String[] args) throws Exception {
        String str = "中国人";

        /*//文件字节流
        FileOutputStream fos = new FileOutputStream("./src/conclusion/IO/1.txt");
        fos.write(str.getBytes());  //需要先将字符流转换成字节流才能写入
        fos.close();*/

        /*//字符流
        PrintWriter pw = new PrintWriter("./src/conclusion/IO/1.txt", "utf-8");
        pw.write(str);
        pw.close();*/

        FileWriter fw = new FileWriter("./src/conclusion/IO/1.txt");
        fw.write(str);
        fw.close();

        /*FileInputStream fis = new FileInputStream("./src/conclusion/IO/1.txt");
        byte[] bf = new byte[1024];
        int len = fis.read(bf);
        String res = new String(bf, 0, len, "utf-8");*/

        /*BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./src/conclusion/IO/1.txt")));
        String res = br.readLine();
        br.close();*/

        FileReader fr = new FileReader("./src/conclusion/IO/1.txt");
        char[] buf = new char[1024];
        int len = fr.read(buf);
        String res = new String(buf, 0, len);

        System.out.println(res);
    }
}
