package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student lee = new Student("이건우",100,100,100);
		
		//Student 객체인 lee의 정보를 파일로 기록하고 싶음
		//- 문자단위로 출력 	(이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력)
		//- 바이트단위로 출력	(객체를 통째로 출력 가능)
		
		//바이트단위(객체단위)로 출력
		try {
			//확장자는 .bmp- 그림, .avi-동영상 , .mp3-노래
			//객체단위로 출력하기 위한 ObjectOutputStream객체를 생성
			//이때 확장자는 텍스트파일이 아니기 때문에 .txt로 하지 않음
			//프로그램의 성격에 맞도록 알맞게 확장자이름 정해줌
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			
			//객체를 출력		
			oos.writeObject(lee);
			
			//파일사용이 끝났으니 파일을 닫아줌
			oos.close();
			
			System.out.println("파일이 생성되었습니다.");
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
