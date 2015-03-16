package lotto;

import java.util.Arrays;
import java.util.Random;

public class lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] LottoNumber = new int[6];
		int i=0;
		while(i<6)
		{
			int tem =random.nextInt(46); 
			if(0<tem && tem<46)
			{
				if(check(LottoNumber,tem))
				{	
				LottoNumber[i] = tem;
				i++;
				}
			}
		}
		Arrays.sort(LottoNumber);
		System.out.println("로또 번호 : "+Arrays.toString(LottoNumber));
	}
	
	public static boolean check(int[] Number, int tem)
	{
		for(int i =0; i<Number.length;i++)
		{
			if(Number[i] == tem)
			{
				return false;
			}
		}
		return true;
	}

}
