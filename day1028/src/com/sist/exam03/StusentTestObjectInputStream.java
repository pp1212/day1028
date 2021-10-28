package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StusentTestObjectInputStream {

	public static void main(String[] args) {
		//c:/myData/lee.stu ������ ������ �о� �鿩
		//��ü�� ������ ȭ�鿡 ���
		
		try {
			//��ü������ �Է��� ���� ObjectInputStream�� ��ü ����
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//���Ϸκ��� ��ü�� �о� �鿩 ��ü���������� ����
			Student lee = (Student)ois.readObject();
			
			//��ü�� ������ ��� 
			System.out.println("�̸�:"+lee.getName());
			System.out.println("����:"+lee.getKor());
			System.out.println("����:"+lee.getEng());
			System.out.println("����:"+lee.getMath());
		
			//������ �ݾ� ��
			ois.close();
	
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}

	}

}
