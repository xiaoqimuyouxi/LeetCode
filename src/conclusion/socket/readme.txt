JAVA Socket简介

    所谓socket 通常也称作”套接字“，用于描述IP地址和端口，是一个通信链的句柄。应用程序通常通过”套接字”向网络发出请求或者应答网络请求。

    以J2SDK-1.3为例，Socket和ServerSocket类库位于Java.NET包中。ServerSocket用于服务器端，Socket是建立网络连接时使用的。
    在连接成功时，应用程序两端都会产生一个Socket实例，操作这个实例，完成所需的会话。对于一个网络连接来说，套接字是平等的，并没有差别，
    不因为在服务器端或在客户端而产生不同级别。不管是Socket还是ServerSocket它们的工作都是通过SocketImpl类及其子类完成的。

重要的Socket API：

    java.Net.Socket继承于java.lang.Object，有八个构造器，其方法并不多，下面介绍使用最频繁的三个方法，其它方法大家可以见JDK-1.3文档。

        . Accept方法用于产生”阻塞”，直到接受到一个连接，并且返回一个客户端的Socket对象实例。”阻塞”是一个术语，它使程序运行暂时”停留”在这个地方，
            直到一个会话产生，然后程序继续；通常”阻塞”是由循环产生的。
        . getInputStream方法获得网络连接输入，同时返回一个InputStream对象实例。
        . getOutputStream方法连接的另一端将得到输入，同时返回一个OutputStream对象实例。

    注意： 其中getInputStream和getOutputStream方法均会产生一个IOException，它必须被捕获，因为它们返回的流对象，通常都会被另一个流对象使用。

SocketImpl介绍

    既然不管是Socket还是ServerSocket它们的工作都是通**过SocketImpl类及其子类完成的，那么当然要介绍啦。

    抽象类 SocketImpl 是实际实现套接字的所有类的通用超类。创建客户端和服务器套接字都可以使用它。

    具体JDK见：
    http://www.javaweb.cc/help/JavaAPI1.6/index.html?java/nio/ReadOnlyBufferException.html

    由于它是超类具体代码实现还是见下面的Socket

TCP 编程

    构造ServerSocket：具体API见：http://www.javaweb.cc/help/JavaAPI1.6/index.html?java/nio/ReadOnlyBufferException.html

    构造方法：

        ServerSocket() ~创建非绑定服务器套接字。
        ServerSocket(int port) ~创建绑定到特定端口的服务器套接字。
        ServerSocket(int port, int backlog) ~利用指定的 backlog 创建服务器套接字并将其绑定到指定的本地端口号。
        ServerSocket(int port, int backlog, InetAddress bindAddr) ~使用指定的端口、侦听 backlog 和要绑定到的本地 IP 地址创建服务器。

    1.1 绑定端口

    除了第一个不带参数的构造方法以外, 其他构造方法都会使服务器与特定端口绑定, 该端口有参数 port 指定. 例如, 以下代码创建了一个与 80 端口绑定的服务器:

          ServerSocket serverSocket = new ServerSocket(80);

    如果运行时无法绑定到 80 端口, 以上代码会抛出 IOException, 更确切地说, 是抛出 BindException, 它是 IOException 的子类. BindException 一般是由以下原因造成的:

    1、端口已经被其他服务器进程占用;
    2、在某些操作系统中, 如果没有以超级用户的身份来运行服务器程序, 那么操作系统不允许服务器绑定到 1-1023 之间的端口.
    如果把参数 port 设为 0, 表示由操作系统来为服务器分配一个任意可用的端口. 有操作系统分配的端口也称为匿名端口. 对于多数服务器, 会使用明确的端口,
     而不会使用匿名端口, 因为客户程序需要事先知道服务器的端口, 才能方便地访问服务器.

1.2 设定客户连接请求队列的长度

  当服务器进程运行时, 可能会同时监听到多个客户的连接请求. 例如, 每当一个客户进程执行以下代码:
     Socket socket = new Socket("www.javathinker.org", 80);

就意味着在远程 www.javathinker.org 主机的 80 端口上, 监听到了一个客户的连接请求. 管理客户连接请求的任务是由操作系统来完成的.
操作系统把这些连接请求存储在一个先进先出的队列中. 许多操作系统限定了队列的最大长度, 一般为 50 . 当队列中的连接请求达到了队列的最大容量时,
服务器进程所在的主机会拒绝新的连接请求. 只有当服务器进程通过 ServerSocket 的 accept() 方法从队列中取出连接请求, 使队列腾出空位时,
队列才能继续加入新的连接请求.

对于客户进程, 如果它发出的连接请求被加入到服务器的请求连接队列中, 就意味着客户与服务器的连接建立成功, 客户进程从 Socket 构造方法中正常返回.
如果客户进程发出的连接请求被服务器拒绝, Socket 构造方法就会抛出 ConnectionException.

Tips: 创建绑定端口的服务器进程后, 当客户进程的 Socket构造方法返回成功, 表示客户进程的连接请求被加入到服务器进程的请求连接队列中.
    虽然客户端成功返回 Socket对象, 但是还没跟服务器进程形成一条通信线路. 必须在服务器进程通过 ServerSocket 的 accept() 方法从请求连接队列中取出连接请求,
    并返回一个Socket 对象后, 服务器进程这个Socket 对象才与客户端的 Socket 对象形成一条通信线路.

ServerSocket 构造方法的 backlog 参数用来显式设置连接请求队列的长度, 它将覆盖操作系统限定的队列的最大长度. 值得注意的是, 在以下几种情况中,
    仍然会采用操作系统限定的队列的最大长度:

    1、backlog 参数的值大于操作系统限定的队列的最大长度;
    2、backlog 参数的值小于或等于0;
    3、在ServerSocket 构造方法中没有设置 backlog 参数.

以下的 Client.java 和 Server.java 用来演示服务器的连接请求队列的特性.


1.3 设定绑定的IP 地址

    如果主机只有一个IP 地址, 那么默认情况下, 服务器程序就与该IP 地址绑定. ServerSocket 的第 4 个构造方法
    ServerSocket(int port, int backlog, InetAddress bingAddr) 有一个 bindAddr 参数, 它显式指定服务器要绑定的IP 地址,
    该构造方法适用于具有多个IP 地址的主机. 假定一个主机有两个网卡, 一个网卡用于连接到 Internet, IP为 222.67.5.94,
    还有一个网卡用于连接到本地局域网, IP 地址为 192.168.3.4. 如果服务器仅仅被本地局域网中的客户访问, 那么可以按如下方式创建
    ServerSocket:

        ServerSocket serverSocket = new ServerSocket(8000, 10, InetAddress.getByName(“192.168.3.4”));

1.4 默认构造方法的作用

    ServerSocket 有一个不带参数的默认构造方法. 通过该方法创建的 ServerSocket 不与任何端口绑定, 接下来还需要通过 bind() 方法与特定端口绑定.

    这个默认构造方法的用途是, 允许服务器在绑定到特定端口之前, 先设置ServerSocket 的一些选项. 因为一旦服务器与特定端口绑定,
    有些选项就不能再改变了.比如：SO_REUSEADDR 选项

    在以下代码中, 先把 ServerSocket 的 SO_REUSEADDR 选项设为 true, 然后再把它与 8000 端口绑定:
        1.ServerSocket serverSocket = new ServerSocket();
        2.serverSocket.setReuseAddress(true); //设置 ServerSocket 的选项
        3.serverSocket.bind(new InetSocketAddress(8000));  //与8000端口绑定
如果把以上程序代码改为:

  1.ServerSocket serverSocket = new ServerSocket(8000);
  2.serverSocket.setReuseAddress(true);//设置 ServerSocket 的选项

那么 serverSocket.setReuseAddress(true) 方法就不起任何作用了, 因为 SO_REUSEADDR 选项必须在服务器绑定端口之前设置才有效.
