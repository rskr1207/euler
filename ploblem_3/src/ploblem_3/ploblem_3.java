package ploblem_3;

public class ploblem_3 {
	/*
	 * 어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다. 예를 들면 13195의
	 * 소인수는 5, 7, 13, 29 입니다. 600851475143의 소인수 중에서 가장 큰 수를 구하세요.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = Long.valueOf("600851475143");
		System.out.println("가장 큰 소수는 ="+PrimeFactorization(a));

	}
	
	//소인수 분해
	public static int PrimeFactorization(long input) {
		/*
		 * 1.소수를 담기 위한 어레이 리스트 생성 2.2부터 시작해서 나머지 값 연산 == 0이면 소수 체크(2를 제외한 2의 배수
		 * 제외) 3.소수 확인 되면 입력값을 소수로 나누고, 2부터 다시 소수 검색 ※ 소수 체크 방법은?? 1) 무식한 for문
		 */
		int division = 2;
		int MaxPrime = 0;
		while (true) {
			if (input != 1) {
				if (division == 2 || division % 2 != 0) {
					if (input % division == 0) {
						if (CheckPrime(division)) {
							if (MaxPrime < division)
								MaxPrime = division;
							input /= division;
							division = 2;
						}
					} else {
						division++;
					}
				} else {
					division++;
				}
			} else {
				System.out.println("break");
				break;
			}
		}
	return MaxPrime;
	}
	//소수 체크
	public static boolean CheckPrime(int division) {
		boolean check = true;
		for (int i = 2; i < division; i++) {
			if (division % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}
