package problem_21;

import java.util.ArrayList;
import java.util.Arrays;

public class problem_21 {
	// n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
	// 서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면
	// a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.
	//
	// 예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은
	// d(220) = 284 입니다.
	// 또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
	// 따라서 220과 284는 친화쌍이 됩니다.
	//
	// 10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.

	public static void main(String[] args) {
		//1.친화쌍 확인
		//2.친화쌍을 ArraysList에 저장(중복 제거)
		//3.ArraysList에서 친화수를 꺼내며 sum을 구한다.
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
