package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
     
public class ZipCode02 {

	public static void main(String[] args) throws IOException {
//Keyboard 입력		
		Scanner in = new Scanner(System.in);
				
//File		
		String path = ZipCode02.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
//제목줄 skip
		String title = br.readLine();	
		String line = "";  
		int cnt = 0;
		
		System.out.println("읍면동 건물명 : ");
		String inAddr = in.nextLine();
		System.out.println("집번호      시도       구군            동(건물)\t\t번지\t\t\tSEQ");
//while
		
		while ( (line = br.readLine()) != null) { // null 은 equals 로비교가능하다ㅏ~이잉이이ㅣㅣㅣㅣㅣㅣㅣㅣ이잉
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String sido		= li[1].trim();
			String gugun	= li[2].trim();
			String dong 	= li[3].trim();
			String bunji	= li[4].trim();
			int	   seq		= Integer.parseInt(li[5].trim());
//1. 전국의 롯데백화점의 갯수 출력
			if(dong.indexOf(inAddr) > -1 ) {  // .contains
				String fmt = "[%-7s] %-8s %-15s %-15s %-15s %-12d\n";
				String addr = String.format(fmt, zipcode,sido, gugun, dong, bunji,seq);
				System.out.println(addr);
				cnt++;
			}//if
			
			
			
//2. (읍면동 건물명:)
//3. 부산, 울산, 대구 우편번호
//4. 한국의 시도명 출력 - 17건 
//5. 부산의 대연동 우편번호만 출력
//6. 부산 남구의 우편번호를 파일( .csv )로 출력
			
		}//while
		System.out.println( cnt + "건");
//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
