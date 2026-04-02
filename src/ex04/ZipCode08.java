package ex04;
//부산의 부산진구 우편번호를 파일 .csv 로 출력

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
     
public class ZipCode08 {

	public static void main(String[] args) throws IOException {

//File		
//	-경로
		String path = ZipCode08.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File("D:\\mm\\dev\\Java\\PrjIO\\src\\ex04\\Zipcode_utf8.csv");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
//제목줄 skip
		br.readLine();	
		String line = "";  
//ArrayList
		ArrayList<String> seoulList = new ArrayList<String>();
		ArrayList<String> busanList = new ArrayList<String>();
		ArrayList<String> seoulList = new ArrayList<String>();
//while
		while ( (line = br.readLine()) != null) { 
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String sido		= li[1].trim();

			if(sido.equals("서울") > -1 ) {
				seoulList;


			}//if		
		}//while
		String filename = "D:\\mm\\dev\\Java\\PrjIO\\src\\ex04\\부산진구" +  + ".csv";
		FileWriter fw = new FileWriter(filename);

		br.close();
		fr.close();
		fw.close();
		System.out.println(new File(filename).getAbsolutePath());
		System.out.println(path + " 위치에    " + filename + "(이)가 저장되었습니다.");
	}//main
}//class

