package ploblem_2;

public class problem_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 400�� ������ �Ǻ���ġ ������ �� ¦���鸸���� ���ϱ�
		int number_1 = 1, number_2 = 1,number_sum = 0, sum = 0;
		while (number_sum < 4000000) {
			number_sum = number_1 + number_2;
			if (number_sum % 2 == 0)
				sum += number_sum;
			number_1 = number_2;
			number_2 = number_sum;
		}
		System.out.println(sum);
	}
}
