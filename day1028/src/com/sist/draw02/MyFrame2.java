package com.sist.draw02;

import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

	private LinePanel2 lp2;
	
	public MyFrame2() {
		lp2 = new LinePanel2();
		add(lp2);
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
		
	}
}
