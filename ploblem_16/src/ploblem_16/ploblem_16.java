package ploblem_16;
import java.math.BigInteger;
public class ploblem_16 {
//	2^15 = 32768 �� �� �ڸ����� ���ϸ� 3 + 2 + 7 + 6 + 8 = 26 �Դϴ�.
//
//	2^1000�� �� �ڸ����� ��� ���ϸ� ���Դϱ�?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num = BigInteger.valueOf(1);
		int sum=0;
		for(int i = 1; i<=1000;i++)
			num = num.multiply(BigInteger.valueOf(2));
		String str_num = num.toString();
		for(int i=0;i<str_num.length();i++)
		{
			Character Char = new Character(str_num.charAt(i));
			sum += Integer.valueOf(Char.toString());
		}
		System.out.println(sum);
	}
}
