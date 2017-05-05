package conclusion.test;

import java.util.Scanner;

/**
 * 测一个三角形是普通三角形、等腰三角形、等边三角形的流程图，测试用例。
 * Created by ly on 2017/5/5.
 */
public class triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        judge(a, b, c);
    }

    public static void judge(int a, int b, int c) {
        if(a == b && b == c) {
            System.out.println("等边三角形");
        }else if(a+b>c && a+c>b && b+c>a) {
            if(a == b || a == c || b == c) {
                System.out.println("等腰三角形");
            }
            else{
                System.out.println("普通三角形");
            }
        }
        else {
            System.out.println("非法输入");
        }
    }
}
