package problem_4;

public class problem_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �տ������� ���� ���� �ڿ������� ���� ���� ����� ���� ���� ��Ī��(palindrome)��� �θ��ϴ�.
		 * 
		 * �� �ڸ� ���� ���� ���� �� �ִ� ��Ī�� �� ���� ū ���� 9009 (= 91 �� 99) �Դϴ�.
		 * 
		 * �� �ڸ� ���� ���� ���� �� �ִ� ���� ū ��Ī���� ���Դϱ�?
		 * 
		 * 3�ڸ� ���� ���� ���� ���� ū ��Ī�� ã��
		 * 
		 * (1000 -1)^2 < X <(100)^2 ��Ī�� ����
		 * 1.�ڸ��� ���꿡�� ���ü� �ִ� ���� ū ���� �������� ã�´�.
		 * 2.���� ū ������ ���� -1�� ���ҽ�Ű�� ��Ī���� ã�´�. Search_Palindrome + Check_Palindrome
		 * 3.��Ī���� ã���� ���� �������� ���ü� �ִ� �������� üũ�Ѵ�. Search_Palindrome�� for�� ����
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
