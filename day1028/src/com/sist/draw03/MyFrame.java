package com.sist.draw03;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private LinePanel lp;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
		
	}
}
