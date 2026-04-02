package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

interface Ipo {
	void input(String fname) throws IOException; // interface는 inplements ipo 랑 같아야함 input/process/output
	void process();
	void output();
}//interface

class ZipcodeMap implements Ipo{

	
	FileReader 		fr; // 여기에 new (X) ->전역변수
	BufferedReader  br;//main 에
		
	Map<String, Integer> sidoMap = new TreeMap<>();
	int totalCnt	= 0;
	
	
@Override
	public void input(String fname) throws IOException { // Vo 배열에 담는작업 
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		
		br.readLine(); // 첫줄재끼고
		String line ="";// 문자열 변수만들어서~
		while ((line = br.readLine()) != null) {// 그것을 line 이 null 이 아닐동안 반복스~
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			
			sidoMap.put(sido, sidoMap.getOrDefault(sido, 0)  + 1);
			totalCnt++;
		}
		br.close();
		fr.close();
	}

@Override
	public void process() {
		
	}

@Override
	public void output() {
		for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
			String key = sidoList.getKey();
			Integer val = sidoList.getValue();
			
			System.out.println(key + "=" +val);
		}
		System.out.println("총 " + totalCnt + "건");
	}
	
}//ZipcodeMap class




public class ZipCode055_4 {
//Map 사용
	public static void main(String[] args) throws IOException {
		ZipcodeMap zMap = new ZipcodeMap();
		
		String path = ZipcodeMap.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		
		zMap.input(path + fname);  // f2 => change input ->String
		zMap.process();
		zMap.output();
		
		
	}//main
}//class
