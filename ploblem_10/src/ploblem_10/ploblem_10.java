package ploblem_10;

// 10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.
// 이백만(2,000,000) 이하 소수의 합은 얼마입니까?
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
