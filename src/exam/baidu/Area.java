package exam.baidu;

import java.text.DecimalFormat;

/**
 * 百度校招笔试第一题：
 *
 * 求两圆相交的面积
 *
 * Created by ly on 2017/9/15.
 */
public class Area {
    public static void main(String[] args) {

    }
    public double area(int x1, int y1, int r1, int x2, int y2, int r2) {
        double res = 0;
        double d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));    //  求两圆心距离
        if(d >= r1+r2 || r1 == 0 || r2 == 0) {  //两圆不相交情况
            res = 0;
        }
        else if(d <= Math.abs(r1-r2)) {  //包含关系
            if(r1 >= r2) {
                res = Math.PI*r2*r2;
            }
            else res = Math.PI*r1*r1;
        }
        else {
            double alpha = Math.acos((d*d+r1*r1-r2*r2)/2*d*r1); //余弦定理取得相交弧所对本圆的圆心角
            res = alpha*r1*r1;  //本圆扇形面积
            alpha = Math.acos((d*d+r2*r2-r1*r1)/2*d*r2);
            res += alpha*r2*r2;  //第二个圆的扇形面积
            double s = (d+r1+r2)/2; //海伦公式
            res -= Math.sqrt(s*(s-d)*(s-r1)*(s-r2))*2;  //两扇形面积减去两三角形面积即为交集
        }
        DecimalFormat format = new DecimalFormat("0.000");
        System.out.println(format.format(res));
        return res;
    }
}
