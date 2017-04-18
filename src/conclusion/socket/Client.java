package conclusion.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by ly on 2017/4/18.
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int length = 100;
        String host = "localhost";
        int port = 1122;
        Socket[] sockets = new Socket[length];
        for(int i = 0; i < length; i++) {
            sockets[i] = new Socket(host, port);
            System.out.println("第 " + (i+1) + " 次连接成功！");
        }
        Thread.sleep(3000);
        for (int i = 0; i < length; i++) {
            sockets[i].close();
        }
    }
}
