package JVMexercise.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by ly on 2017/7/18.
 */
public class MethodHandlerTest {
    static class classA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        //方法类型，包含方法返回值，方法具体参数
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new classA();

        getPrintlnMH(obj).invokeExact("icyfenix");
    }
}
