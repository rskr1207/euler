package problem_1;
// �ߺ����� ȿ�������� ó���ϴ� ���� ����
public class problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1000������ 3�� 5�� ����� �ձ��ϱ�");
		int sum = 0;
		for(int i =0; i<1000;i++)
		{
			if(i %3 == 0 ||i%5 == 0 ) sum+=i;
		}
		System.out.println("���� : "+sum);
		
		
		
	}

}
