package ploblem_6;

public class ploblem_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subtraction(100);
	}
	public static void Subtraction(int input)
	{
		int Sumpow=0, Powsum = 0;
		for(int i = 1; i<=input; i++)
		{
			Powsum +=Math.pow(i, 2);
			Sumpow += i;
		}
		Sumpow = (int) Math.pow(Sumpow, 2);
	    System.out.println(Sumpow - Powsum);
	}
}
