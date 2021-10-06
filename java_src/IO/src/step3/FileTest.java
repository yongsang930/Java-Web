package step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("c:\\java-kosta/file.txt");

		if (!file.exists()) {
			System.out.println("파일을 생성합니다.");
			file.createNewFile();
		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		int ch;
		String path = file.getPath();
		System.out.println("path: " + path);

		if (file.canWrite()) {
			System.out.println("쓰기가능파일");
			bw.write("hello\n");
			bw.flush();
		}

		if (file.canRead()) {
			System.out.println("읽기가능파일");
			while ((ch = br.read()) != -1) {
				System.out.print((char) ch);
			}
		}

		if (file.canExecute()) {
			System.out.println("실행가능파일");
		}

		if (file.isFile()) {
			System.out.println("파일");
		}

		if (file.isHidden()) {
			System.out.println("숨김 속성");
		}

		long size = file.length();
		System.out.println("파일크기 " + size);
		System.out.println(path + " 파일삭제");
		file.delete();

		File dir = new File("c:\\java-kosta/files");
		if (!dir.exists()) {
			System.out.println("디렉토리 생성");
			dir.mkdir();
		}

		String[] fileNemas = dir.list();
		System.out.println("파일목록");
		for (ch = 0; ch < fileNemas.length; ch++) {
			System.out.println(fileNemas[ch]);
		}
		br.close();
		bw.close();
	}
}
