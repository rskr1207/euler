package problem_18;

import java.util.TreeMap;
import java.util.TreeSet;

public class problem_18 {
	// 75
	// 95 64
	// 17 47 82
	// 18 35 87 10
	// 20 04 82 47 65
	// 19 01 23 75 03 34
	// 88 02 77 73 07 63 67
	// 99 65 04 28 06 16 70 92
	// 41 41 26 56 83 40 80 70 33
	// 41 48 72 33 47 32 37 16 94 29
	// 53 71 44 65 25 43 91 52 97 51 14
	// 70 11 33 28 77 73 17 78 39 68 17 57
	// 91 71 52 38 17 14 91 43 58 50 27 29 48
	// 63 66 04 68 89 53 67 30 73 16 69 87 40 31
	// 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
	// 2진 트리
	// 일반 트리
	// 정렬 이전의 트리 구조

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.트리값 입력
		//2.트리 높이 구하기
		TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
		int[] num = { 75, 95, 64, 17, 47, 82, 18, 35, 87, 10, 20, 04, 82, 47,
				65, 19, 01, 23, 75, 03, 34, 88, 02, 77, 73, 07, 63, 67, 99, 65,
				04, 28, 06, 16, 70, 92, 41, 41, 26, 56, 83, 40, 80, 70, 33, 41,
				48, 72, 33, 47, 32, 37, 16, 94, 29, 53, 71, 44, 65, 25, 43, 91,
				52, 97, 51, 14, 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
				91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 63, 66, 04,
				68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 04, 62, 98, 27, 23,
				9, 70, 98, 73, 93, 38, 53, 60, 04, 23 };
		for (int i = 1; i <= num.length; i++) {
			treemap.put(i, num[i-1]);
		}
		int level = 1;
		int size = treemap.size();
		while(true)
		{
			int sum =(1+level)*level/2; 
			if(sum>size)
			{
				level--;
				break;
			}
			level++;
		}
		int sum = 0;
		for(int i=1;i<=level;i++)
		{
			System.out.println("(1+i)*i/2="+((1+i)*i/2)+" , " +treemap.get((1+i)*i/2) );
			sum += treemap.get((1+i)*i/2);
		}
		
		System.out.println(level);
		System.out.println(sum);
		System.out.println(treemap.lastEntry());
		System.out.println(treemap.firstEntry());
		System.out.println(treemap.size());
		
	}
}
