package com.sist.draw02;

import java.awt.Graphics;
import javax.swing.JPanel;

public class LinePanel extends JPanel {

	//맴버변수로 설정
	int x1 = 10;
	int y1 = 10;
	int x2 = 300;
	int y2 = 300;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawLine(x1,y1,x2,y2);
	}
	
	
}
