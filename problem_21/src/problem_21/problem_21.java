package problem_21;

import java.util.ArrayList;
import java.util.Arrays;

public class problem_21 {
	// n�� ����� �߿��� �ڽ��� ������ ���� ���� d(n)���� �������� ��,
	// ���� �ٸ� �� ���� a, b�� ���Ͽ� d(a) = b �̰� d(b) = a �̸�
	// a, b�� ģȭ���̶� �ϰ� a�� b�� ���� ģȭ��(��ּ�)��� �մϴ�.
	//
	// ���� ��� 220�� ����� �ڽ��� �����ϸ� 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 �̹Ƿ� �� ����
	// d(220) = 284 �Դϴ�.
	// �� 284�� ����� �ڽ��� �����ϸ� 1, 2, 4, 71, 142 �̹Ƿ� d(284) = 220 �Դϴ�.
	// ���� 220�� 284�� ģȭ���� �˴ϴ�.
	//
	// 10000 ������ ģȭ������ ��� ã�Ƽ� �� ���� ���ϼ���.

	public static void main(String[] args) {
		//1.ģȭ�� Ȯ��
		//2.ģȭ���� ArraysList�� ����(�ߺ� ����)
		//3.ArraysList���� ģȭ���� ������ sum�� ���Ѵ�.
		int n = 2;
		ArrayList<Integer> AL = new ArrayList<Integer>();
		int sum = 0;
		while (true) {
			int temp = FactorizationSum(n);
			int temp2 = FactorizationSum(temp);
			if (temp2 == n && temp != temp2) {
				if(!AL.contains(n))AL.add(n);
				if(!AL.contains(temp))AL.add(temp);
			}
			if (n >=10000)
				break;
			else
				n++;
		}
		for(int i = 0;i<AL.size();i++)
		{	
			sum += AL.get(i);
		}
		System.out.println(sum);
	}

	private static int FactorizationSum(int n) {
		// TODO Auto-generated method stub
		int sum = 1;
		if (n == 1)
			return 0;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0)
				sum += i + (n / i);
		}
		if (n % Math.sqrt(n) == 0)
			sum += Math.sqrt(n);
		return sum;
	}
}
