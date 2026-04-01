package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileScore {

	public static void main(String[] args) throws IOException {
		String path = "D:/mm/dev/Java/PrjIO/bin/ex02/";
		
		//입력파일
		String filename = "data.txt";
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		
		//출력파일
		String filename2 = "result.txt";
		FileWriter fw = new FileWriter(path + filename2);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		String line = "";
		br.readLine();	// 제목줄 skip
		
		String title = "번호 이름 국어 영어 수학 총점 평균";
		System.out.println(title);
		bw.write(title);
		
		while((line = br.readLine() ) != null) {
//			System.out.println( line );
			String [] li = line.trim().split(",");
			int num = Integer.parseInt(li[0].trim());
			String name = li[1].trim();
			int kor = Integer.parseInt(li[2].trim());
			int eng = Integer.parseInt(li[3].trim());
			int mat = Integer.parseInt(li[4].trim());
			int tot = kor + eng + mat;
			double avg = tot / 3.0;
//			double avg = Math.round(tot / 3.0);	
			
			
			
			String fmt = " %-2d %s %d %d %d %d %.2f\n";
			String msg = String.format(fmt, num, name,kor, eng, mat, tot, avg);
			System.out.println(msg);
			bw.write(msg);
		};
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
	}
}
