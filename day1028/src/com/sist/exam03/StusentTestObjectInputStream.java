package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StusentTestObjectInputStream {

	public static void main(String[] args) {
		//c:/myData/lee.stu 파일의 내용을 읽어 들여
		//객체의 정보를 화면에 출력
		
		try {
			//객체단위로 입력을 위한 ObjectInputStream의 객체 생성
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//파일로부터 객체를 읽어 들여 객체참조변수에 저장
			Student lee = (Student)ois.readObject();
			
			//객체의 정보를 출력 
			System.out.println("이름:"+lee.getName());
			System.out.println("국어:"+lee.getKor());
			System.out.println("영어:"+lee.getEng());
			System.out.println("수학:"+lee.getMath());
		
			//파일을 닫아 줌
			ois.close();
	
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
