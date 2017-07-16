package conclusion.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ly on 2017/7/10.
 */
public class Server1 {
    static ServerSocket serverSocket;
    public Server1() throws IOException {
        serverSocket = new ServerSocket(1362);
        System.out.println("服务器启动！");

    }

    public static void main(String[] args) throws IOException{
        Server1 server1 = new Server1();
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("服务器接收：" + socket.getInetAddress());
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);
                pw.write("我是服务器！");
                pw.flush();

                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                System.out.println("我是服务器，客户端说：" + br.readLine());

                pw.close();
                os.close();
                br.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(socket != null) {
                    try {
                        socket.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
