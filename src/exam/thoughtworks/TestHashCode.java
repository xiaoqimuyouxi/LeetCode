package exam.thoughtworks;

/**
 * Created by ly on 2017/9/11.
 */
public class TestHashCode {
    String user;
    public TestHashCode(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        TestHashCode t = (TestHashCode) obj;
        if(user.equals(t.user)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    public static void main(String[] args) {
        TestHashCode t1 = new TestHashCode("aa");
        TestHashCode t2 = new TestHashCode("aa");
        System.out.println(t1.equals(t2));
    }
}
