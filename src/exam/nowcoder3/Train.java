package exam.nowcoder3;

import java.util.Scanner;

/**
 * 贪心思想，要培养一个战力和潜力和最大的兵王，就要尽可能多的增加其战力，即打赢所有潜力大于战力的新兵，记他们的潜力战力差的总和为add。
 选兵王，有两种情况：
 1）如果潜力qian大于战力zhan，不能与自己交战，所以要先从add中减去自己的部分，最终兵王战力潜力和为 add-(qian-zhan)+qian+zhan = add+2*zhan
 2）否则直接加上他的潜力战力即 add+qian+zhan

 故对两种情况，分别找到战力最大值maxZhan与潜力战力和的最大值maxSum，比较2*maxZhan和maxSum, 取大的加上add即为正确答案

 注意这里,当maxSum=(zhan+qian)>2*maxZhan时，因为zhan>qian,由反证可知zhan>maxZhan,自然可以打赢所有潜力大于战力的新兵。
 * Created by ly on 2017/8/29.
 */
public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //这里必须要用长整型，因为数据非常大
        long maxZhan = 0, add = 0, maxSum = 0, zhan = 0, qian = 0;
        for (int i = 0; i < n; i++) {
            zhan = scanner.nextInt();
            qian = scanner.nextInt();
            if(qian > zhan) {
                maxZhan = Math.max(maxZhan, zhan);
                add += (qian - zhan);
            }
            else {
                maxSum = Math.max(maxSum, zhan+qian);
            }
        }
        System.out.println(add + Math.max(2*maxZhan, maxSum));
    }
}
