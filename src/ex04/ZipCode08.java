package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode08 {

	public static void main(String[] args)  {
      // 7. 부산 부산진구 우편번호를 파일로 출력
      String path = ZipCode08.class.getResource("").getPath();
      String inFname = "zipcode_utf8.csv";
      String outFname = "zipcode_busanjingu.csv";
      
      FileReader fr = null;						  		  	  		    //파일읽기 
      FileWriter fw = null;							  		  			//빠르게읽기
      BufferedReader br = null;										  	//파일쓰기
      BufferedWriter bw = null;						                    //빠르게쓰기
      //바깥에서 변수 생성 ->	 껍데기만 있음
      
      int cnt	=0;						        					    //몇개 파일 만들었는지 세기 (카운트변수)
      
      try {									      						//에러 날수도 있는 코드 실행 try
             fr  = new FileReader(path + inFname);					    //파일 읽기 시작
             br  = new BufferedReader(fr);							    //더빠르게 읽기 위한 래퍼
          // try 안에서 실제 생성 -> 진짜로 파일열고 객체 만들어짐
          // 이유 : finally 에서 닫아야하기 때문에 
          // fr 은 try 안에서만 살아있음 -> 지역변수이기 때문에
          br.readLine();								   				//csv 제목 줄 skip
          String line = "";							    				//한 줄씩 담을 변수 준비
          String prevSido = "";						    				//이전 시도 저장용
          
          
  //시도 바뀌면 파일 새로 생성        
          while((line = br.readLine()) != null) {						//한줄 읽어서 line 에 넣고 값 있으면 계속 반복
             PostVo postVo = new PostVo(line);						    //csv 한 줄을 객체로 쪼개는 것
             String sido   = postVo.getSido();						    //postVo 에서 시도 가져오기

             if(!sido.equals(prevSido)) {							    // 지금 시도 != 이전시도    -> 즉 처음 나오거나 바뀐순간
            	 
            	 if(bw !=null) bw.close();							    // 전에 쓰던 파일 닫기
            	 if(fw !=null) fw.close();						    	// 전에 쓰던 파일 닫기
            	 
            	 
                outFname = path + sido + ".csv";						//파일 이름 만들기
                File oFile = new File(outFname); 						// 실제 파일 객체 생성
                
                if( oFile.exists()){								    // 기존 파일 삭제(이미 있으면 지움, 덮어쓰기용)
                   oFile.delete();
                } 
                fw = new FileWriter( oFile,true ); //true : append		// 새파일 열기 , 쓰기 준비 완료 
                bw = new BufferedWriter(fw);						     
                   
                prevSido = sido;						    			// 다음 비교를 위해 저장
                cnt++;						    						// 파일 개수 증가 
             }
             
             bw.write( postVo.getAddress());							// 파일에 한 줄 쓰기 
             bw.newLine();												// 줄바꿈 - 정석
          }
             
      } catch (IOException e) {							    			// 파일 에러잡기 
         e.printStackTrace();
         
      } finally {							    						// 무조건 실행되는 부분 
	      try {
	         if(br != null) br.close();									// 열었더 파일들 닫기
	         if(fr != null) fr.close();	
	         if(bw != null) bw.close();
	         if(fw != null) fw.close();
	         
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	     
      	}//finally
      }//try
      System.out.println(cnt + "개 파일 생성");								// 결과 출력 = 만든 파일 개수 출력
   }//main
}// class
