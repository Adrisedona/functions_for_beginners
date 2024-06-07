package util;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

	public MyFrame(String title, LayoutManager layoutManager, int width, int height, int operation) {
		super(title);
		setLayout(layoutManager);
		setDefaultCloseOperation(operation);
		setSize(width, height);
	}	
}
