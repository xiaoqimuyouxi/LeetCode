package conclusion.socket;

import java.io.*;
import java.net.Socket;

/**
 * 服务器线程处理类
 * Created by ly on 2017/4/18.
 */
public class ServerThread extends Thread {
    //和本线程相关的socket
    Socket socket = null;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //线程执行的相应操作，响应客户端的请求
    public void run() {
        InputStream is = null;
        BufferedReader br = null;

        OutputStream os = null;
        PrintWriter pw = null;

        try {
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {    //循环读取客户端请求
                System.out.println("我是服务器，客户端请求：" + info);
            }
            socket.shutdownInput(); //关闭输入流

            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush(); //将缓冲输出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pw != null) {
                    pw.close();
                }
                if(os != null) {
                    os.close();
                }
                if(br != null) {
                    br.close();
                }
                if(is != null) {
                    is.close();
                }
                if(socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
