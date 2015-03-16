package ploblem_12;
//1부터 n까지의 자연수를 차례로 더하여 구해진 값을 삼각수라고 합니다.
//예를 들어 7번째 삼각수는 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28이 됩니다.
//이런 식으로 삼각수를 구해 나가면 다음과 같습니다.
//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//이 삼각수들의 약수를 구해봅시다.
// 1: 1 <-1
// 3: 1, 3 <-2
// 6: 1, 2, 3, 6 <-3 
//10: 1, 2, 5, 10 <-4
//15: 1, 3, 5, 15 <-5
//21: 1, 3, 7, 21 <-6
//28: 1, 2, 4, 7, 14, 28 <-7
//위에서 보듯이, 5개 이상의 약수를 갖는 첫번째 삼각수는 28입니다.
//그러면 500개 이상의 약수를 갖는 가장 작은 삼각수는 얼마입니까?
//2 = (1+2)*(2/2) = 3;
//3 = (1+3)*(3/2) =
public class ploblem_12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.삼각수 구하기
		// 2.삼각수의 약수 구하기(알고리즘 check) + 약수의 갯수 check
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
