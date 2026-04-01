package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



//interface IPO {
//	void input();
//	void process();
//	void output();
//};


public class TestZip {

	public static void main(String[] args) throws IOException {
		String path = "D:/mm/dev/Java/PrjIO/src/ex04/";
//입력파일
		String filename = "zipcode_20130201(1).csv";
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		
//출력파일
		String filename2 = "result.txt";
		FileWriter fw = new FileWriter(path + filename2);
		BufferedWriter bw = new BufferedWriter(fw);
		
//제목출력		
		String title = "ZIPCODE, SIDO, GUGUN, DONG, BUNJI, SEQ";
		System.out.println(title);
		bw.write(title);
//입력하기	
		Scanner in = new Scanner(System.in);
		System.out.println("입력하세요 : 동, 건물명");
		
		
		String input = in.nextLine();
		String [] key = input.split(" ");
		String dong = key[0];
		String build = input.substring(dong.length()).trim();
//		String build = key[1];
		System.out.println("dong  입력 : "+dong);
		System.out.println("build 입력 : "+build);

		
//---------------------------------------------------------
//		ZIPCODE ,SIDO, GUGUN, DONG,          BUNJI,  SEQ
//		135-806 ,서울,  강남구, 개포1동 경남아파트,         ,1
		
		String line ="";
		int sear = 0;
		int tot = 0;
		
		br.readLine();		// 제목줄 skip
		
		
		while((line = br.readLine()) != null) {
			tot++;
			String [] li = line.trim().split(",");
			String ZIPCODE = li[0].trim();
			String SIDO	 = li[1].trim();
			String GUGUN = li[2].trim();
			String DONG	 = li[3].trim();
			String BUNJI = li[4].trim();
			int SEQ = Integer.parseInt(li[5].trim());
			
			
			
			if(DONG.indexOf(dong) != -1  && DONG.indexOf(build) != -1) {
			sear++;	
			
			String fmt = "%s %s %s %s %s %d\n";
			String msg = String.format(fmt, ZIPCODE, SIDO, GUGUN, DONG, BUNJI, SEQ);
			
			System.out.println(msg);
			bw.write(msg);
			}//if
		}//while	
//---------------------------------------------------------
//출력
		System.out.println("검색된 자료 수 : "+ sear);
		System.out.println("전체자료 수 : " + tot);
		bw.write("검색된 자료 수 : "+ sear + "\n");
		bw.write("전체자료 수 : " + tot + "\n");	
//---------------------------------------------------------
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}//main
}//class
