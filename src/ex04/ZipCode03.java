package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
     

//3. 부산, 울산, 대구 우편번호 zipCode 의 갯수
//	부산:3605		cnt1
//	대구:820		cnt2
//	울산:2782		cnt3

public class ZipCode03 {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 시도를 입력하세요(부산, 대구, 울산)");
		String sidos = in.nextLine();
		
		
//File		
		String path = ZipCode03.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File(path + fname);
		
// 프로그래 강제 종료		
		if( !file.exists()) {
			System.out.println(file + "이 없습니다.");
			System.exit(-1); 
		}
			
			
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
//제목줄 skip
//		String title = br.readLine();	== > 나중에 제목을 확인하거나 출력할 수도 있으면
		br.readLine();
		String line = "";  
		
//cnt
		int cnt1 = 0;	//부산		=>sido가 ㅇㅇ일때 비교 -> 
		int cnt2 = 0;	//대구
		int cnt3 = 0;	//울산
		
//while
		
		while ( (line = br.readLine()) != null) { 
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String sido		= li[1].trim();
			String gugun	= li[2].trim();
			String dong 	= li[3].trim();
			String bunji	= li[4].trim();
			int	   seq		= Integer.parseInt(li[5].trim());
			
			
			switch(sido) {
				case "부산" : cnt1++;	break;
				case "대구" : cnt2++;	break;
				case "울산" : cnt3++;	break;
			}//switch

			

			
		}//while
		System.out.println( "부산 : " + cnt1 + "건");
		System.out.println( "대구 : " + cnt2 + "건");
		System.out.println( "울산 : " + cnt3 + "건");
//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
