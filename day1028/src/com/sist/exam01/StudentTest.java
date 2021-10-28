package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {
		
		//텍스트 파일의 내용을 컴퓨터 메모리로 읽어 들이기 위하여 FileReader클래스 이용
		//이 fileReader의 생성자는 예외를 가짐->예외처리 해야 함
		try {
			FileReader fr = new FileReader("c:/myData/student.txt");
			
			//파일로부터 한글자씩 읽어들이는 메소드 : read() 읽어들인 문자의 정수값 반환
			//파일의 끝에 도달하면 -1을 반환
			//파일의 끝까지 읽어들이도록 한다
			
			//읽어들인 문자들을 모아서 문자열을 만들기 위한 변수
			//한문자씩 읽어 들여서 여기 누적하기 위하여 초기값 "" 설정
			String str ="";
			
			int ch;		//파일로부터 한글자씩 읽어들이기 위한 변수
			while( true) {
				ch = fr.read();	//파일로부터 한글자를 읽어들임
				if(ch == -1) {	//파일의 끝에 도달하면 반복문 탈출
					break;
				}
				
				//읽어들인 문자의 숫자값을 다시 문자로 형변환하여 변수에 저장
				char data = (char)ch;	//'A'=65
				//System.out.print(data);
				
				//읽어들인 문자를 문자열 변수str에 누적
				str = str + data;
			}
			//파일의 내용을 모두 읽고나면 반복문을 탈출
			//파일의 사용이 끝나면 파일을 닫아주어야 함
			fr.close();
				
			//반복문을 탈출하면
			//문자열변수 str에 파일의 내용일 모두 담겨져 있음
			System.out.println(str);
			//홍길동,100,80,90
			
			//이 문자열을 갖고 ","로 분리
			//String클래스의 split메소드를 이용하여 분리
			//split을 분리한 데이터들을 문자열 배열로 반환
			String []arr = str.split(",");
			
			//분리된 데이터를 갖고 있는 배열의 첫번째 요소는 이름
			String name = arr[0];				
			
			//분리된 데이터를 갖고 있는 배열의 두번째 요소는 국어점수
			//arr[1]는 String ,이것을 int로 변환하여 변수 kor에 저장
			int kor = Integer.parseInt(arr[1]);
			
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			//총점을 계산
			int tot = kor + eng +math;
			
			//평균 계산
			int avg = tot/3;
			
			System.out.println("이름:"+name);
			System.out.println("국어:"+kor);
			System.out.println("영어:"+eng);
			System.out.println("수학:"+math);
			System.out.println("총점:"+tot);
			System.out.println("평균:"+avg);
			
			
		}catch (Exception e) {
			//예외가 발생되면 예외메세지 출력
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		
	}

}
