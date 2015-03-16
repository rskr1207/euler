package ploblem_3;

public class ploblem_3 {
	/*
	 * � ���� �Ҽ��� �����θ� ��Ÿ���� ���� ���μ����ض� �ϰ�, �� �Ҽ����� �� ���� ���μ���� �մϴ�. ���� ��� 13195��
	 * ���μ��� 5, 7, 13, 29 �Դϴ�. 600851475143�� ���μ� �߿��� ���� ū ���� ���ϼ���.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = Long.valueOf("600851475143");
		System.out.println("���� ū �Ҽ��� ="+PrimeFactorization(a));

	}
	
	//���μ� ����
	public static int PrimeFactorization(long input) {
		/*
		 * 1.�Ҽ��� ��� ���� ��� ����Ʈ ���� 2.2���� �����ؼ� ������ �� ���� == 0�̸� �Ҽ� üũ(2�� ������ 2�� ���
		 * ����) 3.�Ҽ� Ȯ�� �Ǹ� �Է°��� �Ҽ��� ������, 2���� �ٽ� �Ҽ� �˻� �� �Ҽ� üũ �����?? 1) ������ for��
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
	//�Ҽ� üũ
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
