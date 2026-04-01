package ex03;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream {
	public static void main(String[] args) throws IOException {
		//현재 경로
		String path =
				TestInputStream.class.getResource("").getPath();
//경로출력		
		System.out.println(path);
		///D:/mm/dev/Java/PrjIO/bin/ex03/  => 실행되는 .class 의 위치가 bin -> bin 이라고 뜸
		
		String inFile = path + "data2.dat";
		
		FileInputStream fis = new FileInputStream(inFile);
		int ch;
		while((ch = fis.read()) != -1) {   // EOF : End Of File(-1)이 아닐 동안 반복
//출력			
			System.out.print( (char) ch );
		};
		
		fis.close();

	}

}
