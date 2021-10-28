package com.sist.draw01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LinePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawLine(10,10,110,10);
	}
	
}
