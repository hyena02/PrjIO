package ex04;
//부산의 부전2동 우편번호만 화면 출력해보기

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
     
public class ZipCode06 {

	public static void main(String[] args) throws IOException {
//Keyboard 입력		
		Scanner in = new Scanner(System.in);
				
//File		
		String path = ZipCode06.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
//제목줄 skip
		String title = br.readLine();	
		String line = "";  
		int cnt = 0;
		
		System.out.println("읍면동 : ");
		String inAddr = in.nextLine();
		System.out.println("우편번호");
//while
		
		while ( (line = br.readLine()) != null) { 
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String dong 	= li[3].trim();
			
//			String sido		= li[1].trim();
//			String gugun	= li[2].trim();
//			String bunji	= li[4].trim();
			int	   seq		= Integer.parseInt(li[5].trim());

			if(dong.indexOf("부전2동") > -1 ) {
				String fmt = "[%-7s]";
				String addr = String.format(fmt,li[0]);
				System.out.println(addr);
				cnt++;
			}//if		
		}//while
		br.close();
		fr.close();
		System.out.println("총" + cnt + "건");
	}//main
}//class
