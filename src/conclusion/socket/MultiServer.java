package conclusion.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * 基于TCP协议的Socket通信，实现用户登录服务器端
 * Created by ly on 2017/4/18.
 */
public class MultiServer {
    public static void main(String[] args) {
        try {
            //创建一个服务器端socket，并绑定一个端口，监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;  //记录客户端的数量
            System.out.println("服务器即将启动，等待客户端的连接");
            //循环监听等待客户端的连接
            while (true) {
                //调用accept()方法开始监听
                socket = serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();   //启动线程

                count++;    //统计客户端的数量
                System.out.println("客户端的数量：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("客户端的IP为：" + address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
