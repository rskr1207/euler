package problem_4;

public class problem_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.
		 * 
		 * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.
		 * 
		 * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?
		 * 
		 * 3자리 수의 곱에 대한 가장 큰 대칭수 찾기
		 * 
		 * (1000 -1)^2 < X <(100)^2 대칭수 범위
		 * 1.자릿수 연산에서 나올수 있는 가장 큰 값과 작은값을 찾는다.
		 * 2.가장 큰 값에서 부터 -1씩 감소시키며 대칭수를 찾는다. Search_Palindrome + Check_Palindrome
		 * 3.대칭수를 찾으면 곱셈 연산으로 나올수 있는 값인지를 체크한다. Search_Palindrome의 for문 내부
		 */
		System.out.println(Search_Palindrome(5));
	}

	public static String Search_Palindrome(int digit) {
		int max = (int)Math.pow(10, digit) -1;
		int min = (int)Math.pow(10, digit-1);
		
		for(int i = (int)Math.pow(max, 2) ; i > Math.pow(min, 2) ;i--)
		{
			if(Check_Palindrome(i))
			{
				for(int j = max; j>min;j--)
				{
					if(i%j == 0 && i/j>min && max>i/j)
					{
						return new String( j + "*"+ i/j+" = " +i);
					}
						
				}
				
			}
		}
		return null;
	}
	public static boolean Check_Palindrome(int number)
	{
		String Str_number = String.valueOf(number);
		int Str_length = Str_number.length();
		boolean check = true;
		for(int i = 0; i < Str_length/2;i++)
		{
			String a =String.valueOf(Str_number.charAt(i));
			String b = String.valueOf(Str_number.charAt((Str_length-1) -i));
			if(!a.equals(b))
			{
				check = false;
				return check;
			}
		}
		return check;
	}
	
}
