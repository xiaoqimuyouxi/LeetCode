package conclusion.offer.baidu;


/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by ly on 2017/5/5.
 */
public class Find {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        boolean found = false;
        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns-1;
            while (row < rows && column >= 0) {
                if(target < array[row][column]) {
                    column--;
                }
                else if(target == array[row][column]) {
                    found = true;
                    break;
                }
                else {
                    row++;
                }
            }
        }
        return found;
    }

    static void Test(int[][] arr, int target, boolean expected) {
        if(Find(target, arr) == expected) {
            System.out.println("Succeed!");
        }
        else {
            System.out.println("Failed!");
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13}
        };
        Test(arr, 7, true);
        Test(arr, 1, true);
        Test(arr, 5, false);
        Test(null, 4, false);
    }
}
