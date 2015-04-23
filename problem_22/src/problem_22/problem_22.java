package problem_22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class problem_22 {
	// 여기 5천개 이상의 영문 이름들이 들어있는 46KB짜리 텍스트 파일 names.txt 이 있습니다 (우클릭해서 다운로드 받으세요).
	// 이제 각 이름에 대해서 아래와 같은 방법으로 점수를 매기고자 합니다.
	//
	// 먼저 모든 이름을 알파벳 순으로 정렬합니다.
	// 각 이름에 대해서, 그 이름을 이루는 알파벳에 해당하는 숫자(A=1, B=2, ..., Z=26)를 모두 더합니다.
	// 여기에 이 이름의 순번을 곱합니다.
	// 예를 들어 "COLIN"의 경우, 알파벳에 해당하는 숫자는 3, 15, 12, 9, 14이므로 합이 53, 그리고 정렬했을 때
	// 938번째에 오므로 최종 점수는 938 × 53 = 49714가 됩니다.
	//
	// names.txt에 들어있는 모든 이름의 점수를 계산해서 더하면 얼마입니까?
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// step1.파일 읽기
		// step2.이름 정렬
		// step3.이름 값 계산

		// Step1 && Step2
		String[] Name = ReadName();
		System.out.println(Arrays.toString(Name));
		// Step3
		int value = NameValue(Name);
		System.out.println(value);
	}

	private static int NameValue(String[] name) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < name.length; i++) {
			name[i].toUpperCase();
			char[] temp = name[i].toCharArray();
			int temp_num = 0;
			for (int k = 1; k < temp.length - 1; k++) {
				// System.out.println(Character.getNumericValue(temp[k])-9);
				temp_num += Character.getNumericValue(temp[k]) - 9;
			}
			// System.out.println("temp_num =" + temp_num);
			sum += (temp_num * (i + 1));
		}
		return sum;
	}

	private static String[] ReadName() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("names.txt");
		FileReader FR = new FileReader(file);
		BufferedReader BR = new BufferedReader(FR);
		String line;
		String names = "";
		while ((line = BR.readLine()) != null) {
			names += line;
		}
		BR.close();
		String[] name = names.split(",");
		Arrays.sort(name);
		return name;
	}
}
