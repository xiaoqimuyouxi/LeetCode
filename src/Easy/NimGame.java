package Easy;

//292��		Nim ��Ϸ
public class NimGame {
	/**
	 * ��n��[1,3]ʱ�����ֱ�ʤ��

              ��n == 4ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[1,3]�����Σ���ʱ���ֱظ���

              ��n��[5,7]ʱ�����ֱ�ʤ�����ֱַ�ͨ��ȡ��[1,3]��ʯͷ���ɽ�״̬ת��Ϊn == 4ʱ�����Σ���ʱ���ֱظ���

              ��n == 8ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[5,7]�����Σ���ʱ���ֱظ���
	 * @param n
	 * @return
	 * 0ms
	 */
	public static boolean canWinNim(int n) {
        if(n <= 0)
        	return false;
        if(n%4 != 0) {
        	return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(canWinNim(7));
	}
}
