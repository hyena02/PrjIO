package ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileScore {

	public static void main(String[] args) throws IOException {
		String path = "D:/mm/dev/Java/PrjIO/bin/ex02/";
		String filename = "data.txt";
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		br.readLine();	// 제목줄 skip
		
		while((line = br.readLine() ) != null) {
//			System.out.println( line );
			String [] li = line.split(",");
			String name = li[1].trim();
			int kor = Integer.parseInt(li[0].trim());
			int eng = Integer.parseInt(li[1].trim());
			int na = Integer.parseInt(li[2].trim());
			int tot = kor + eng + mat;
			double avg = tot / 3.0;
			System.out.println(num + " " + name +" " +tot + " " + avg);
			
		};
		
		br.close();
		fr.close();
	}
}
