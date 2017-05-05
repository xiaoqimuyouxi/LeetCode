package conclusion.offer;

import org.junit.Test;

import java.util.Scanner;

/**
 * 求字符串中第一次出现的不重复的字符
 *
 * 基本思路：
 *      1）初始化一个数组，数组中的值初始化为-1
 *      2）更新数组中的数据，数组的索引即为字符串中字符对应的ASCII码，该索引对应的值即为字符在字符串中的下标
 *      3）在更新过程中，如果出现数组中某个值大于等于0，则说明出现重复，将改值设置为-2
 *      4）最后遍历数组，找到数组中所有值大于等于0，且最小的值即为第一次出现的不重复字符在字符串中的索引，它在数组中的索引的字符型（char）即为所求
 * Created by ly on 2017/5/5.
 */
public class FirstAppearingOnce {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] occurance = new int[256];
        int index = 0;
        for(int i = 0; i < 256; i++) {
            occurance[i] = -1;
        }

        for(int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if(occurance[c] == -1 ) {
                occurance[c] = j;
            }
            else if(occurance[c] >= 0) {
                occurance[c] = -2;
            }
        }

        char c = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if(occurance[i] >= 0) {
                if(min > occurance[i]) {
                    c = (char)i;
                    min = occurance[i];
                }
            }
        }
        System.out.println(c);*/

        main();
    }

    /**
     * 下面是剑指offer中指定格式的写法
     */
    private int[] occurance = new int[256];
    private int index = 0;

    public FirstAppearingOnce() {
        for(int i = 0; i < 256; i++) {
            occurance[i] = -1;
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(occurance[ch] == -1) {
            occurance[ch] = index;
        }
        else if(occurance[ch] >= 0) {
            occurance[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c = '#';
        int min = Integer.MAX_VALUE;	//第一次出现不重复字符的索引
        for(int i = 0; i < 256; i++) {
            if(occurance[i] >= 0) {
                if(min > occurance[i]) {
                    c = (char)i;
                    min = occurance[i];
                }
            }
        }
        return c;
    }

    /**
     * 测试用例编写
     */
    static void Test(String testName, FirstAppearingOnce chars, char expected) {
        if(testName != null && testName.trim().length() != 0) {
            System.out.println(testName + " begins!");
        }

        if(chars.FirstAppearingOnce() == expected) {
            System.out.println("Succeed!");
        }
        else {
            System.out.println("Failed!");
        }
    }

    static void main() {
        FirstAppearingOnce chars = new FirstAppearingOnce();
        Test("test1", chars, '\0');

        chars.Insert('g');
        Test("test2", chars, 'g');

        chars.Insert('o');
        Test("test3", chars, 'g');

        chars.Insert('o');
        Test("test4", chars, 'g');

        chars.Insert('g');
        Test("test5", chars, '#');

        chars.Insert('l');
        Test("test6", chars, 'l');

        chars.Insert('e');
        Test("test7", chars, 'l');
    }
}
