package conclusion.offer;

import java.util.ArrayList;

/**
 * Created by ly on 2017/7/4.
 */
public class P20PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (rows > start*2 && cols > start*2) {
            printACircle(matrix, rows, cols, start, result);
            start++;
        }
        return result;
    }

    //打印一个圈
    public void printACircle(int[][] matrrix, int rows, int cols, int start, ArrayList<Integer> result) {
        int endX = rows-1-start;    //终止行号
        int endY = cols-1-start;

        //从左到右打印第一行
        for(int i = start; i <= endY; i++) {
            result.add(matrrix[start][i]);
        }

        //从上到下打印一列
        if(start < endX) {
            for(int j = start+1; j <= endX; j++) {
                result.add(matrrix[j][endY]);
            }
        }

        //从右到左打印一行
        if(start < endX && start < endY) {
            for(int i = endY-1; i >= start; i--) {
                result.add(matrrix[endX][i]);
            }
        }

        //从下到上打印一列
        if(start < endX-1 && start < endY) {
            for(int j = endX-1; j > start; j--) {
                result.add(matrrix[j][start]);
            }
        }
    }

    public static void main(String[] args) {
        P20PrintMatrix p = new P20PrintMatrix();
        int numbers[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        ArrayList<Integer> res = p.printMatrix(numbers);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
