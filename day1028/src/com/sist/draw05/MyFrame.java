package com.sist.draw05;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//MyFrame클래스 자신이 JMenuItem을 눌렀을 때 이벤트처리 담당자가 되도록 하기 위하여
//ActionListener 인터페이스 구현
public class MyFrame extends JFrame implements ActionListener{

	private LinePanel lp;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		
		//메뉴바를 생성
		JMenuBar jmb = new JMenuBar();
		
		//주메뉴 "파일" 생성
		JMenu mn_file = new JMenu("파일");
		
		//부메뉴 새파일 생성
		JMenuItem file_new = new JMenuItem("새파일");
		
		//부메뉴 열기를 생성
		JMenuItem file_open = new JMenuItem("열기");
		
		//부메뉴 저장을 생성
		JMenuItem file_save = new JMenuItem("저장");
		
		//부메뉴들을 주메뉴에 담는다
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//주메뉴를 메뉴바에 담음
		jmb.add(mn_file);
		
		//메뉴바를 프레임에 설정
		this.setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대하여 이벤트 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
		
	}

	
	//각각의 JMenuItem을 누르면 actionperformed메소드가 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem중에 어떤 메뉴가 눌러졌는지 파악하기 위하여 매개변수 ActionEvent의 getActionCommand()이용
		String cmd = e.getActionCommand();
		//System.out.println(cmd+"가 눌러짐");
		
		if(cmd.equals("저장")) {
			try {
				//현재 화면에 그려진 모든 "선"들을 파일로 저장("c:/myData/data.pan")
				//현재 화면에 그려진 모든 "선"들의 정보는 LinePanel객체인 lp의 list에 담겨져 있음
				//list객체를 통째로 파일로 출력하기 위하여 ObjectOutputStream을 이용
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				//LinePanel 객체의 맴버변수인 list를 파일로 출력
				oos.writeObject(lp.list);
				
				oos.close();
				
			} catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("열기")) {
			//c:/myData/data.pan" 파일의 내용을 읽어 들여
			//LinePanel객체인 lp의 list에 저장하도록 함
			//화면을 다시 그리기 위하여 LinePanel 객체인 lp의 repaint를 호출
			try {
				//객체 단위로 파일의 내용을 읽어들이기 위하여 ObjectInputStream 객체 생성
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//파일로부터 데이터를 읽어들여 LinePanel 객체인 lp의 list에 담음
				//object로 다 받을 수 있기 때문에 (ArrayList<GraphicInfo>)형변환 해야 함
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위하여 repaint를 호출
				lp.repaint();
				
				//파일을 닫아줌
				ois.close();
				
				
			} catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
			
		}else if(cmd.equals("새파일")) {
			System.out.println("새파일의 처리입니다.");
		}
		
	}
}
