package conclusion.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by ly on 2017/4/18.
 */
public class MultiClient {
    public static void main(String[] args) {

        try {
            //1.创建客户端socket，指定服务器地址和端口
            Socket socket = new Socket("localhost", 8888);

            //2.获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream(); //字节输出流
            PrintWriter pw = new PrintWriter(os);   //将输出流包装成打印流
            pw.write("用户名：dfwe, 密码：ddddd");
            pw.flush();
            socket.shutdownOutput();    //关闭输出流

            //3.获取输入流，并获取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = bf.readLine()) != null) {
                System.out.println("我是客户端，服务器响应为：" + info);
            }
            //关闭资源
            bf.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
