package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZipCode06 {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		// 6. 부산의 부전2동 우편번호만 화면 출력
		String fn 	  = "D:/mm/dev/java/PrjIO/src/ex04/zipcode_utf8.csv";
		FileReader fr = null; // 초기화를 하지않음 -> null 
		BufferedReader br = null;
		br.readLine();		// 제목줄 skip -> IOException 필요 -> add exception try 어쩌고
		String line = "";
		try {
			fr = new FileReader(fn);
			br = new BufferedReader(fr);
			while((line = br.readLine()) !=null ) {
				PostVo postVo = new PostVo (line);
				String sido = postVo.getSido();
				String dong = postVo.getDong();
				
				if(sido.equals("부산") && dong.equals("부전2동")) {
					System.out.println( postVo );
				}//if			
			}//try
			
		} catch (FileNotFoundException e) {
			System.out.println(fn + "파일이 없습니다");
		} catch (IOException e) {
			System.out.println("데이터 입력에 문제가 있습니다");
		} catch (Exception e) {		// 자식이 밑에 있어야함 
			System.out.println("문제발생" + e.getMessage());
		} finally {			 // Exception 발생과 상관없이 무조건 실행
			try {
				if(br !=null)br.close();
				if(br !=null)fr.close();
			} catch (IOException e) {

			}			
		}//finally
		System.out.println("작업 끝");
	}//main
}//class
