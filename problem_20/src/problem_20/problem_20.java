package problem_20;

import java.math.BigInteger;

public class problem_20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 1~100 ������ �� ���ϱ�
		// 2. ���� ���� ���ڿ��� �����
		// 3. ���ڿ��� �����ڸ��� ���� ���Ѵ�.
		BigInteger a = new BigInteger("1");
		int sum = 0;
		// 1
		for (long i = 1; i < 100; i++) {
			a = a.multiply(BigInteger.valueOf(i));
		}
		// 2
		String b = a.toString();
		// 3
		for (int i = 0; i < b.length() - 1; i++) {
			Character Char = new Character(b.charAt(i));
			sum += Integer.valueOf(Char.toString());
		}
		// ���
		System.out.println(sum);
	}
}
