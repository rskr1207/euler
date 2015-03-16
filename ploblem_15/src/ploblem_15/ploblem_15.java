package ploblem_15;

import java.math.BigInteger;

//아래와 같은 2 × 2 격자의 왼쪽 위 모서리에서 출발하여 오른쪽 아래 모서리까지 도달하는 길은 모두 6가지가 있습니다 (거슬러 가지는 않기로 합니다).
//그러면 20 × 20 격자에는 모두 몇 개의 경로가 있습니까?
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
		//모든 경우의 길수 구하기
		for(int i = (n*2);i>1;i--)
		total = total.multiply(BigInteger.valueOf(i));
		//제거될 길 구하기
		for(int i=n;i>1;i--)
		remove = remove.multiply(BigInteger.valueOf(i));
		remove = remove.multiply(remove);
		total = total.divide(remove);
		return total.toString();
	}

}
