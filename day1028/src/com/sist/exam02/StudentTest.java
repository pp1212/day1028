package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student lee = new Student("이건우",100,100,100);
		
		//Student 객체인 lee의 정보를 파일로 기록하고 싶음
		//- 문자단위로 출력 	(이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력)
		//- 바이트단위로 출력	(객체를 통째로 출력 가능)
		
		//문자단위로 출력
		try {
			FileWriter fw = new FileWriter("c:/myData/lee.txt");
			
			//객체의 이름을 파일로 출력
			fw.write(lee.getName()+",");
			
			//객체의 국어점수 파일로 출력
			fw.write(lee.getKor()+",");	
			
			//객체의 영어점수를 파일로 출력
			fw.write(lee.getEng()+",");
			
			//객체의 수학점수를 파일로 출력
			fw.write(lee.getMath()+"");		//문자열로 출력하기 위하여 + ""
			
			//파일의 사용이 끝났으니 파일을 닫아 줌
			fw.close();
			
			System.out.println("파일을 생성하였습니다.");
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
