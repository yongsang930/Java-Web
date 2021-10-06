package Diary;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Cont {

	public String date;

	public void write() {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> v = new ArrayList<String>();

		Calendar c = Calendar.getInstance();

		FileWriter fos = null;

		System.out.println("1.읽기 | 2.지난날");

		int a = sc.nextInt();
		int y = 0, m = 0, dd = 0;

		if (a == 1) {
			y = c.get(Calendar.YEAR);
			m = c.get(Calendar.MONTH) + 1;
			dd = c.get(Calendar.DATE);

			date = y + "년 " + m + "월 " + dd + "일";
			System.out.println(date);
		} else {
			date = sc.next();
		}
		v.add(date); // arrayList에 담고
		System.out.println("내용");

		while (true) {
			String x = null;
			x = sc.next();

			if (x.equals("끝"))
				break;

			v.add(x);
		}

		File f = new File("MyDiary");

		if (!f.exists())
			f.mkdir();

		try {
			fos = new FileWriter("././MyDiary/" + date + " .txt");
			for (int i = 0; i < v.size(); i++) {
				fos.write("\n");
				fos.write(v.get(i));
			}
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void read() {
		File f = new File("MyDiary"); // MyDiary에 대한 파일의 객체를 생성
		File[] fs = f.listFiles(); // 파일 목록을 읽어들이기
		String date;
		FileReader fr = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("읽기 목록");
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
		System.out.println("원하는 날짜를 입력하세요 :");
		date = sc.next();
		
		try {
			fr = new FileReader("././MyDiary/"+date+" .txt");
			int i;
			while((i=fr.read())!=-1) {
				System.out.println((char)i);
			}
			fr.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
