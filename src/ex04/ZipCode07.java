package ex04;
//부산의 부산진구 우편번호를 파일 .csv 로 출력

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
     
public class ZipCode07 {

	public static void main(String[] args) throws IOException {

//File		
//	-경로
		String path = ZipCode07.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File("D:\\mm\\dev\\Java\\PrjIO\\src\\ex04\\Zipcode_utf8.csv");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
		String filename = "D:\\mm\\dev\\Java\\PrjIO\\src\\ex04\\부전2동.csv";
		FileWriter fw = new FileWriter(filename);
		
//제목줄 skip
		br.readLine();	
		
		String line = "";  
		int cnt = 0;
		

		System.out.println("우편번호");
//while
		
		while ( (line = br.readLine()) != null) { 
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String dong 	= li[3].trim();


			if(dong.indexOf("부전2동") > -1 ) {
				System.out.println(zipcode);
				fw.write(zipcode + "\n");
				cnt++;
			}//if		
		}//while

		br.close();
		fr.close();
		fw.close();
		System.out.println(new File(filename).getAbsolutePath());
		System.out.println(path + " 위치에    " + filename + "(이)가 저장되었습니다.");
	}//main
}//class
