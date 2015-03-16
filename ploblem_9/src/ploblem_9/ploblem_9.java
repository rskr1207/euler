package ploblem_9;

public class ploblem_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a^2 + b^2 = c^2 && a+b+c = 1000
		//a<b<C
		for(int c = 3;c<1000;++c)
		{
			for(int b = 0;b<c;++b)
			{
				for(int a =0;a<b;++a)
				{
					if((a*a) + (b*b)==(c*c))
					{
						if(a+b+c == 1000){
							System.out.println(a*b*c);
							break;
						}
					}
				}
			}
		}
	}

}
