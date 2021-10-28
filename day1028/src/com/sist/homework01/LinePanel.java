package com.sist.homework01;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener {

	//�ɹ������� ����
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//��,�簢��,�� �߿� ������ �׸����� ���� �ɹ������� ����
	//��:0
	//�簢��:1
	//��:2
	int drawType;
	
	//����ڰ� �׸� "��"���� ��� ���� ����Ʈ�� ����
	ArrayList<GraphicInfo> list;
	
	//�����ڿ��� "���콺 �̺�Ʈ"�� ���
	public LinePanel() {
		
		//����Ʈ�� ������
		list = new ArrayList<GraphicInfo>();
		
		//this�� �ǹ̴� ���콺�̺�Ʈ�� �߻��Ͽ��� �� �̺�Ʈó�� ��簴ü�� "�ڽ�"�̶�� �ǹ�
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		//�θ��� paintComponent�� ��û�Ͽ� ȭ���� ������ ������
		super.paintComponent(g);
		
		
		//System.out.println("�ٽ� �׷��ݴϴ�!");
		//g.drawLine(x1,y1,x2,y2);
		
		//����Ʈ�� ��� ��� ���� �׷���
		for(GraphicInfo info : list) {
			x1 = info.getX1();
			y1 = info.getY1();
			x2 = info.getX2();
			y2 = info.getY2();
			int width = x2 - x1;
			int height = y2 - y1;
			
			switch(info.getDrawType()) {
				case 0:g.drawLine(x1,y1,x2,y2);break;
				case 1:g.drawRect(x1,y1,width,height);break;
				case 2:g.drawOval(x1,y1,width,height);break;
			}
			
			
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
		
		//�ϳ��� "��"�� �ϼ��� �� ����Ʈ ���� ������x,������y,����x,����y�� ���� �ִ� GraphicObject��ü�� �����Ͽ�
		//����Ʈ�� ��´�
		list.add(new GraphicInfo(x1, y1, x2, y2,drawType));
		repaint();		//��ǥ�� �ٲ�����ϱ� �ٽ� �׷��޶�� ȣ��
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