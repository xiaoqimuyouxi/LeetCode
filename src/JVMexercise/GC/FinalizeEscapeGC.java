package JVMexercise.GC;

/**
 * 一次对象自我拯救的演示
 * Created by ly on 2017/7/16.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC saveHook = null;

    public void isAlive() {
        System.out.println("yes, i am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.saveHook = this;   //将这个对象的引用赋值给仍然存活的对象进行自救
    }

    public static void main(String[] args) throws InterruptedException {
        saveHook = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        saveHook = null;
        System.gc();

        //因为finalize()方法优先级很低，所以暂停0.5秒等待他
        Thread.sleep(500);

        if(saveHook != null) {
            saveHook.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }

        //下面这段代码与上面完全相同，但是这次自救却失败了，因为同一个对象的finalize()方法只会被调用一次，也就是只有一次自救机会
        saveHook = null;
        System.gc();
        Thread.sleep(500);
        if(saveHook != null) {
            saveHook.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }
    }
}
