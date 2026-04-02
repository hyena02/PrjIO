package ex04;

//1. 전국의 롯데백화점의 갯수 출력
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ZipCode01 {

	public static void main(String[] args) throws IOException {
		String path = ZipCode01.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
//제목줄 skip
		String title = br.readLine();	
		String line = ""; // 
		System.out.println("집번호      시도       구군            동(건물)                             번지               SEQ");
//while
		int cnt = 0;
		while ( (line = br.readLine()) != null) { // null 은 equals 로비교가능하다ㅏ~이잉이이ㅣㅣㅣㅣㅣㅣㅣㅣ이잉
			
			String [] li 	= line.trim().split(",");
			String zipcode	= li[0].trim();
			String sido		= li[1].trim();
			String gugun	= li[2].trim();
			String dong 	= li[3].trim();
			String bunji	= li[4].trim();
			int	   seq		= Integer.parseInt(li[5].trim());
			if(dong.indexOf("롯데백화점") > -1 ) {  // .contains
				String fmt = "%-10s %-8s %-15s %-15s %-12s %-12d";
				String addr = String.format(fmt, zipcode,sido, gugun, dong, bunji,seq);
				System.out.println(addr);
				cnt++;
			}//if
		}//while
		
		System.out.println( cnt + "건");
		
//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
