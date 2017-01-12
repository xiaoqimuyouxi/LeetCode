package Easy3;

/**
 * 396题 旋转函数
 * Created by ly on 2017/1/12.
 */
public class RotateFunction {
    //611ms
    //时间复杂度：O(n^2)
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int tmp = 0;
        int max = Integer.MIN_VALUE;
        while(tmp < n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {    //计算F
                sum += i*A[i];
            }
            //顺时针旋转A中的元素
            int last = A[n-1];
            for(int j = n-1; j > 0; j--) {
                A[j] = A[j-1];
            }
            A[0] = last;
            tmp++;
            if(max <= sum) {
                max = sum;
            }
        }
        return max;
    }

    //5ms  时间复杂度：O(n)
    /**
     * F(k) = 0*Bk[0] + 1*Bk[1] + … + (n-1)Bk[n-1]
     * F(k-1) = 0*Bk-1[0] + 1*Bk-1[1] + … + (n-1)*Bk-1[n-1]
     *      =0*Bk[1] + 1*Bk[2] + … + (n-2)*Bk[n-1] + (n-1)*Bk[0]
     *
     * F(k) - F(k-1) = Bk[1] + Bk[2] + … + Bk[n-1] + (1-n)*Bk[0]
     *              = sum - n*Bk[0]
     * F(k) = F(k-1) + sum - n*Bk[0]
     *
     * k=0, Bk[0] = A[0]
     * k=1, Bk[0] = A[len-1]
     * k=2, Bk[0] = A[len-2]
     * ……
     *
     * @param A
     * @return
     */
    public int maxRotateFunction1(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            sum += A[i];
            max += i*A[i];
        }
        int preF = max;
        for (int i = n-1; i > 0; i--) {
            if(max <= (preF+sum-n*A[i])) {
                max = preF+sum-n*A[i];
            }
            preF = preF+sum-n*A[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,6};
        RotateFunction r = new RotateFunction();
        System.out.println(r.maxRotateFunction1(A));
    }
}
