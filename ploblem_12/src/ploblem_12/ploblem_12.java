package ploblem_12;
//1���� n������ �ڿ����� ���ʷ� ���Ͽ� ������ ���� �ﰢ����� �մϴ�.
//���� ��� 7��° �ﰢ���� 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28�� �˴ϴ�.
//�̷� ������ �ﰢ���� ���� ������ ������ �����ϴ�.
//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//�� �ﰢ������ ����� ���غ��ô�.
// 1: 1 <-1
// 3: 1, 3 <-2
// 6: 1, 2, 3, 6 <-3 
//10: 1, 2, 5, 10 <-4
//15: 1, 3, 5, 15 <-5
//21: 1, 3, 7, 21 <-6
//28: 1, 2, 4, 7, 14, 28 <-7
//������ ������, 5�� �̻��� ����� ���� ù��° �ﰢ���� 28�Դϴ�.
//�׷��� 500�� �̻��� ����� ���� ���� ���� �ﰢ���� ���Դϱ�?
//2 = (1+2)*(2/2) = 3;
//3 = (1+3)*(3/2) =
public class ploblem_12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.�ﰢ�� ���ϱ�
		// 2.�ﰢ���� ��� ���ϱ�(�˰��� check) + ����� ���� check
		long i = 1;
		long sum;
		while(true)
		{ 
			sum = i*(i+1)/2;
			//System.out.println(i + "  " + sum);
			if(check(sum)) break;
			i++;
		}
		System.out.println(i + "  " + sum);
	}
	private static boolean check(long sum) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1;i<Math.sqrt(sum);i++)
		if(sum%i == 0)count++;
		count *=2;
		if(sum%Math.sqrt(sum)==0) count++; 
		//System.out.println("sum = "+sum + " count="+count);
		return count>=500 ? true:false;
	}
}
