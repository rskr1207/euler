package ploblem_5;

public class ploblem_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 ~ 10 ������ � ���ε� ������ �������� ���� ���� ���� 2520�Դϴ�.
		//
		// �׷��� 1 ~ 20 ������ � ���ε� ������ �������� ���� ���� ���� ���Դϱ�?
		Search(20);

	}

	public static void Search(int input) {
		// 1. �����⸦ ���� �� ����
		// 2. ���������� ���� �극��ũ
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
