package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
     

//3. 부산, 울산, 대구 우편번호 zipCode 의 갯수
//	sis  	 	cnt
//	부산:3605		cnt[0]
//	대구:820		cnt2[1]
//	울산:2782		cnt3[2]
//4. 한국의 시도명 출력 - 17건 

public class ZipCode033 {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 시도를 입력하세요(부산, 대구, 울산)");
		String sidos 	= in.nextLine();		//"부산, 대구, 경남"
		String [] sis 	= sidos.trim().split(",");
		String [] sidoList = new String[sis.length];
		int [] cnt = new int[sis.length];
		
		for (int i = 0; i < sidoList.length; i++) {
			sis[i] =sis[i].trim(); 
			sidoList[i] = sis[i].trim();
			cnt[i]= 0;
		}
		
		
//File		
		String path = ZipCode033.class.getResource("").getPath();
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

//while		
		while ( (line = br.readLine()) != null) { 
			
			String [] li 	= line.trim().split(",");
			String sido		= li[1].trim();
			
			String zipcode	= li[0].trim();
			String gugun	= li[2].trim();
			String dong 	= li[3].trim();
			String bunji	= li[4].trim();
			int	   seq		= Integer.parseInt(li[5].trim());
			
			
			for (int i = 0; i < sis.length; i++) {
				if(sido.equals(sis[i])) {
					cnt[i]++;
				}//if
			}//for

		}//while
		for (int i = 0; i < cnt.length; i++) {
			System.out.println( sis[i]+" : " + cnt[i] + "건");
			
		}

//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
