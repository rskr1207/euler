package ploblem_7;

public class ploblem_7 {
	public static void main(String[] args) {
		// 소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.
		//
		// 이 때 10,001번째의 소수를 구하세요.
		System.out.println(SearchPrime(10001));
	}

	public static int SearchPrime(int count) {
		int Count = 0, i = 2;
		while (true) {
			
			if (CheckPrime(i)) {
				Count++;
				if (Count == count) return i;
				else i++;
			} else {
				i++;
			}
		}
	}

	public static boolean CheckPrime(int division) {
		boolean check = true;
		if (division == 2) {
			return true;
		}
		for (int i = 2; i < division; i++) {
			if (division % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}
