package ploblem_14;

public class ploblem_14 {
	static int count = 0;
	static long Max_number = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long number = 1000000;
		while(true)
		{
			//System.out.println(number);
			CollatzConjecture(number);
			if(number==1)break;
			number--;
		}
		System.out.println(count);
		System.out.println(Max_number);
	}

	private static void CollatzConjecture(long number) {
		// TODO Auto-generated method stub
		int cnt = 0;
		long temp = number;
		while(true)
		{
			//System.out.println(number);
			if(number%2 == 0)
			{
				number /=2;
			}
			else
			{
				number = (3*number)+1;
			}
			if(number == 1)break;
			cnt++;
		}
		if(cnt>count){
			count = cnt;
			Max_number = temp;
		}
		//System.out.println(cnt);
	}

}
