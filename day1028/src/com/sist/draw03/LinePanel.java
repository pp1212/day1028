package com.sist.draw03;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener {

	//맴버변수로 설정
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//생성자에서 "마우스 이벤트"를 등록
	public LinePanel() {
		
		//this의 의미는 마우스이벤트가 발생하였을 때 이벤트처리 담당객체가 "자신"이라는 의미
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("다시 그려줍니다!");
		g.drawLine(x1,y1,x2,y2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		repaint();		//좌표가 바뀌었으니까 다시 그려달라고 호출
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
