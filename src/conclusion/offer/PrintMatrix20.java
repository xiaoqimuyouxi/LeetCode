package conclusion.offer;

/**
 * 面试题20：
 *      基本思路：
 *          1）首先考虑一圈一圈的循环打印，到什么时候循环结束
 *          2）考虑如何打印一圈，总共分四步，要考虑清楚每一步存在的条件
 * Created by ly on 2017/4/23.
 */
public class PrintMatrix20 {
    public static void printMatrix(int[][] numbers, int columns, int rows) {
        if(numbers == null || columns <= 0 || rows <= 0) {
            return;
        }
        int start = 0;
        while (columns > start*2 && rows > start*2) {
            printMatrixInCircle(numbers, columns, rows, start);
            ++start;
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns-1-start;
        int endY = rows-1-start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            printNumber(number);
        }

        //从上到下打印一列，第二步的前提条件是终止行号大于起始行号
        if(start < endY) {
            for (int i = start+1; i <= endY; i++) {
                int number = numbers[i][endX];
                printNumber(number);
            }
        }


        //从右到左打印一行，第三步的前提是不仅要满足第二步的条件，也要满足终止列号大于起始列号
        if(start < endX && start < endY) {
            for(int i = endX-1; i >= start; i--) {
                int number = numbers[endY][i];
                printNumber(number);
            }
        }


        //从下到上打印一列，第四步的前提是至少有三行两列，所以终止行号比起始行号大2，终止列号比起始列号大
        if(endY - start > 2 && endX > start) {
            for (int i = endY-1; i > start; i--) {
                int number = numbers[i][start];
                printNumber(number);
            }
        }

    }
    public static void printNumber(int n) {
        System.out.print(n + ", ");
    }

    public static void main(String[] args) {
        int numbers[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printMatrix(numbers, 4, 4);
    }
}
