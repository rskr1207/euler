package ploblem_15;

import java.math.BigInteger;

//�Ʒ��� ���� 2 �� 2 ������ ���� �� �𼭸����� ����Ͽ� ������ �Ʒ� �𼭸����� �����ϴ� ���� ��� 6������ �ֽ��ϴ� (�Ž��� ������ �ʱ�� �մϴ�).
//�׷��� 20 �� 20 ���ڿ��� ��� �� ���� ��ΰ� �ֽ��ϱ�?
public class ploblem_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		String Result = SearchResult(n);
		System.out.println(Result);
	}

	private static String SearchResult(int n) {
		// TODO Auto-generated method stub
		BigInteger total = new BigInteger("1") ;
		BigInteger remove = new BigInteger("1");
		//��� ����� ��� ���ϱ�
		for(int i = (n*2);i>1;i--)
		total = total.multiply(BigInteger.valueOf(i));
		//���ŵ� �� ���ϱ�
		for(int i=n;i>1;i--)
		remove = remove.multiply(BigInteger.valueOf(i));
		remove = remove.multiply(remove);
		total = total.divide(remove);
		return total.toString();
	}

}
