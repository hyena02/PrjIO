package ex04;
//시도 총 17건
//전체 자료수:52144
//실행시간 : 0.0990663s
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ZipCode05_2 {
				// return잉벗엇어서서서ㅓㅅ void
	public static void main(String[] args) throws IOException {

		// 4. 한국의 시도명 출력 - 17건 
//			   서울
//			   부산
//			   ... 
//			   충북
		String path = ZipCode05_2.class.getResource("").getPath();
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

		Set<String> set = new HashSet<>();
		long startTime = System.nanoTime();
		
		
		while((line = br.readLine() ) != null) {
			PostVo vo = new PostVo( line );
			String sido = vo.getSido();
			set.add(sido);
//			System.out.println(vo);
			totcnt++;
		}//while
		
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		for (String sido : set) {
			System.out.println(sido);
		}
		System.out.println(set.size() + "건");
		System.out.println("전체 자료수:" + totcnt);
		System.out.println("실행시간 : " + execTime + "s");
		
	}//main
}//class
