package conclusion.basicStruct;

/**
 * 数组题目汇总
 *
 * 1)
 * Created by ly on 2017/4/14.
 */
public class Array {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
                {3,5,9,23}
        };
        System.out.println(matrix.length + "->" + matrix[0].length);
        System.out.println(checkNumber(matrix, 4, 4, 7));
    }

    /**
     * 二维数组中查找指定元素
     */
    public static boolean checkNumber(int[][] matrix, int rows, int cols, int k) {
        boolean found = false;
        if(matrix != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols-1;
            //从第一行最后一个元素开始遍历
            while (row < rows && col >= 0) {
                if(matrix[row][col] == k) {
                    found = true;
                    break;
                }
                else if(matrix[row][col] > k) {
                    col--;  //最右上角元素比k大，则删去该列
                }
                else
                    row++;  //最右上角元素比k小，则删去该行
            }
        }
        return found;
    }
}
