package JVMexercise.OOM;

/**
 * String.intern()返回引用的测试
 *
 * Created by ly on 2017/7/15.
 */
public class RuntimeConstantPoolOOMtest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        //这一次返回false，是因为 "java" 这个字符串在之前已经出现过，字符串常量池中已经有它的引用了，不符合"首次出现的原则"，
        //而前面str1和str2这两个字符串都是第一次出现，所以返回true
        String str3 = new StringBuilder("J").append("ava").toString();
        System.out.println(str3.intern() == str3);
    }
}
