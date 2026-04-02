package ex04;
//망
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
     
public class ZipCode05 {

	public static void main(String[] args) throws IOException {
//Keyboard 입력		
		Scanner in = new Scanner(System.in);
				
//File		
		String path = ZipCode05.class.getResource("").getPath();
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

			
			
			
 
//5. 부산의 대연동 우편번호만 출력

			
		}//while
		System.out.println( cnt + "건");
//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
