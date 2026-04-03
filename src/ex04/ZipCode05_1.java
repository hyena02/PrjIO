package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class ZipCode05_1 {
				// return잉벗엇어서서서ㅓㅅ void
	public static void main(String[] args) throws IOException {

		// 4. 한국의 시도명 출력 - 17건 
//			   서울 32123
//			   부산 1212
//			   ...  ??
//			   충북
		String path = ZipCode05_1.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File infile = new File(path+ fname);
		
		if(!infile.exists()) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		
		
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);
//첫줄 skip
		br.readLine();
		String line = "";
		int totcnt = 0;
		String prevSido = "";
		long startTime = System.nanoTime();
		
		int cnt = 0;
		while((line = br.readLine() ) != null) {
			PostVo vo = new PostVo( line );
			String sido = vo.getSido();
			if(!sido.equals(prevSido)) {
				prevSido = sido ; // 이전sido -> 현재 sido 로 바꾼다
				System.out.print(sido + ", ");
				cnt++;
			}//if	//lineCount
			totcnt++;
		}//while
//ArrayList 2개 -> 
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		System.out.println("\n시도수    : " + cnt);
		System.out.println("전체 자료수: " + totcnt);
		System.out.println("실행 시간  : "  + execTime + "s");
		
	}//main
}//class
