package tests;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import util.MyFrame;

class PruebaTimer extends MyFrame {

	boolean parpadeo;

	private Timer timer;
	String cadena;
	int i;

	JLabel lbl;
	JLabel lbl2;


	public PruebaTimer() {
		super("", null, 700, 700, JFrame.EXIT_ON_CLOSE);
		i = 0;

		lbl = new JLabel("Este texto parpadea");
		lbl.setSize(100, 100);
		lbl.setLocation(200, 200);
		this.add(lbl);

		lbl2 = new JLabel(i + "");
		lbl2.setSize(100, 100);
		lbl2.setLocation(400, 200);
		this.add(lbl2);

		parpadeo = false;

		cadena = "Loteria";
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (i % 4 == 0) {
					PruebaTimer.this.setTitle(cadena.substring(cadena.length() - ((i / 4) % cadena.length() + 1)));
				}
				if (i % 6 == 0) {
					if (parpadeo = !parpadeo) {
						lbl.setForeground(Color.CYAN);
					} else {
						lbl.setForeground(Color.YELLOW);
					}
				}
				if (i % 9 == 0) {
					lbl2.setText("" + i / 9);
				}
				i++;
			}
		});
		timer.start();
		


	}

	

}

