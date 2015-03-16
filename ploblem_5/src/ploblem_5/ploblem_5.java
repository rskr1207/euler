package ploblem_5;

public class ploblem_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.
		//
		// 그러면 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?
		Search(20);

	}

	public static void Search(int input) {
		// 1. 나누기를 당할 값 설정
		// 2. 나머지연산 조건 브레이크
		int result = input+1;
		boolean check;
		while (true) {
			check = true;
			for (int i = input; i > 2; i--) {
				if (result % i != 0) {
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println(result);
				break;
			} 
			else
			{
				result++;
			}
		}
	}
}
