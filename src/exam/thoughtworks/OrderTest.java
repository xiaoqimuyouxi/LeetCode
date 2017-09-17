package exam.thoughtworks;

import org.junit.Test;

/**
 * Created by ly on 2017/9/11.
 */
@SuppressWarnings("all")
public class OrderTest {
    @Test
    public void test1() {
        BookService bookService = new BookService();
        System.out.println("abcdefghijklmnopqrst1234567890");
        bookService.acceptOrder("abcdefghijklmnopqrst1234567890");

        System.out.println("U001 2016-06-02 22:00~22:00 A");
        bookService.acceptOrder("U001 2016-06-02 22:00~22:00 A");

        System.out.println("U002 2017-08-01 19:00~22:00 A");
        bookService.acceptOrder("U002 2017-08-01 19:00~22:00 A");

        System.out.println("U003 2017-08-02 13:00~17:00 B");
        bookService.acceptOrder("U003 2017-08-02 13:00~17:00 B");

        System.out.println("U004 2017-08-03 15:00~16:00 C");
        bookService.acceptOrder("U004 2017-08-03 15:00~16:00 C");

        System.out.println("U005 2017-08-05 09:00~11:00 D");
        bookService.acceptOrder("U005 2017-08-05 09:00~11:00 D");

        bookService.printRevenue();
    }

    @Test
    public void test2() {
        BookService bookService = new BookService();
        System.out.println("U002 2017-08-01 19:00~22:00 A");
        bookService.acceptOrder("U002 2017-08-01 19:00~22:00 A");

        System.out.println("U003 2017-08-01 18:00~20:00 A");
        bookService.acceptOrder("U003 2017-08-01 18:00~20:00 A");

        System.out.println("U002 2017-08-01 19:00~22:00 A C");
        bookService.acceptOrder("U002 2017-08-01 19:00~22:00 A C");

        System.out.println("U002 2017-08-01 19:00~22:00 A C");
        bookService.acceptOrder("U002 2017-08-01 19:00~22:00 A C");

        System.out.println("U003 2017-08-01 18:00~20:00 A");
        bookService.acceptOrder("U003 2017-08-01 18:00~20:00 A");

        System.out.println("U003 2017-08-02 13:00~17:00 B");
        bookService.acceptOrder("U003 2017-08-02 13:00~17:00 B");

        bookService.printRevenue();
    }

    @Test
    public void test3() {
        BookService bookService = new BookService();
        System.out.println("U003 2017-08-02 13:00~17:00 B");
        bookService.acceptOrder("U003 2017-08-02 13:00~17:00 B");

        System.out.println("U003 2017-08-02 13:00~17:00 B C");
        bookService.acceptOrder("U003 2017-08-02 13:00~17:00 B C");

        System.out.println("U003 2017-08-02 20:00~22:00 B");
        bookService.acceptOrder("U003 2017-08-02 20:00~22:00 B");

        System.out.println("U003 2017-08-02 19:00~22:00 B C");
        bookService.acceptOrder("U003 2017-08-02 19:00~22:00 B C");

        System.out.println("U003 2017-08-02 20:00~22:00 B C");
        bookService.acceptOrder("U003 2017-08-02 20:00~22:00 B C");

        bookService.printRevenue();
    }
}
