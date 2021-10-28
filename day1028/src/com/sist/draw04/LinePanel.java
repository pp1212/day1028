package com.sist.draw04;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener {

	//맴버변수로 설정
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//사용자가 그린 "선"들을 담기 위한 리스트를 선언
	ArrayList<GraphicInfo> list;
	
	//생성자에서 "마우스 이벤트"를 등록
	public LinePanel() {
		
		//리스트를 생성함
		list = new ArrayList<GraphicInfo>();
		
		//this의 의미는 마우스이벤트가 발생하였을 때 이벤트처리 담당객체가 "자신"이라는 의미
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//System.out.println("다시 그려줍니다!");
		//g.drawLine(x1,y1,x2,y2);
		
		//리스트에 담긴 모든 선을 그려줌
		for(GraphicInfo info : list) {
			g.drawLine(info.getX1(),info.getY1(),info.getX2(),info.getY2());
		}
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
		
		//하나의 "선"이 완성될 때 리스트 선의 시작점x,시작점y,끝점x,끝점y를 갖고 있는 GraphicObject객체를 생성하여
		//리스트에 담는다
		list.add(new GraphicInfo(x1, y1, x2, y2));
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
