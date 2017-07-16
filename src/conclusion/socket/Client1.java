package conclusion.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by ly on 2017/7/10.
 */
public class Client1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String host = "localhost";
        Socket client = new Socket(host, 1362);
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("我是客户端!");
        pw.flush();
        client.shutdownOutput();    //关闭输出流

        InputStream in = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        System.out.println("我是客户端，服务器说：" + br.readLine());

        System.out.println("客户端申请连接");
        Thread.sleep(3000);
        System.out.println("客户端数据传输成功");
        pw.close();
        os.close();
        br.close();
        in.close();
        client.close();
    }
}
