package problem_1;
// 중복값을 효율적으로 처리하는 것이 관건
public class problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1000까지의 3과 5의 배수의 합구하기");
		int sum = 0;
		for(int i =0; i<1000;i++)
		{
			if(i %3 == 0 ||i%5 == 0 ) sum+=i;
		}
		System.out.println("합은 : "+sum);
		
		
		
	}

}
