package ploblem_10;

// 10 ������ �Ҽ��� ��� ���ϸ� 2 + 3 + 5 + 7 = 17 �� �˴ϴ�.
// �̹鸸(2,000,000) ���� �Ҽ��� ���� ���Դϱ�?
public class ploblem_10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3;
		long sum = 2;
		long start = System.currentTimeMillis();
		while(i<2000000)
		{			
			if(chackpriame(i))
			{
				//System.out.println("while enter ="+i +"  sum="+sum );
				sum+=i;
			}
			i+=2;
		}	
		System.out.println("sum="+sum);
		System.out.println("time = "+ (System.currentTimeMillis() - start));
	}
	private static boolean chackpriame(int i) {
		// TODO Auto-generated method stub
		for(int j = 3; j<=Math.sqrt(i);j+=2)
		{
			if(i%j == 0)
			{
			return false;
			}
		}
		return true;
	}
}
