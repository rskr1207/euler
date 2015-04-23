package problem_22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class problem_22 {
	// ���� 5õ�� �̻��� ���� �̸����� ����ִ� 46KB¥�� �ؽ�Ʈ ���� names.txt �� �ֽ��ϴ� (��Ŭ���ؼ� �ٿ�ε� ��������).
	// ���� �� �̸��� ���ؼ� �Ʒ��� ���� ������� ������ �ű���� �մϴ�.
	//
	// ���� ��� �̸��� ���ĺ� ������ �����մϴ�.
	// �� �̸��� ���ؼ�, �� �̸��� �̷�� ���ĺ��� �ش��ϴ� ����(A=1, B=2, ..., Z=26)�� ��� ���մϴ�.
	// ���⿡ �� �̸��� ������ ���մϴ�.
	// ���� ��� "COLIN"�� ���, ���ĺ��� �ش��ϴ� ���ڴ� 3, 15, 12, 9, 14�̹Ƿ� ���� 53, �׸��� �������� ��
	// 938��°�� ���Ƿ� ���� ������ 938 �� 53 = 49714�� �˴ϴ�.
	//
	// names.txt�� ����ִ� ��� �̸��� ������ ����ؼ� ���ϸ� ���Դϱ�?
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// step1.���� �б�
		// step2.�̸� ����
		// step3.�̸� �� ���

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
