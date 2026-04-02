package ex04;

//4. 한국의 시도명 출력 - 17건 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
     
public class ZipCode04 {

	public static void main(String[] args) throws IOException {
////Keyboard 입력		
//		Scanner in = new Scanner(System.in);
				
//File		
		String path = ZipCode04.class.getResource("").getPath();
		String fname = "Zipcode_utf8.csv";
		File file = new File(path + fname);
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
//제목줄 skip
		String title = br.readLine();	
		String line = "";  

		Set<String> sidoSet = new HashSet<>();
		
		System.out.println("한국의 시도명");
//while
		
		while ( (line = br.readLine()) != null) { // null 은 equals 로비교가능하다ㅏ~이잉이이ㅣㅣㅣㅣㅣㅣㅣㅣ이잉
			String [] li 	= line.trim().split(",");
			String sido		= li[1].trim();
			
			sidoSet.add(sido);
			
			}
		int cnt = 0;
		for (String sido1 : sidoSet) {
			System.out.print(sido1 + ", ");
			cnt++;
			
			
		}//while
		System.out.println("\n" +  cnt + "개");
		
		
		
		
//닫기 close
		br.close();
		fr.close();
		
	}//main
}//class
