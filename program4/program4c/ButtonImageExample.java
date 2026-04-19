/* 4c. Develop a Swing program in Java to display a message
   "Digital Clock is pressed" or "Hour Glass is pressed"
   depending upon the JButton with image either Digital Clock
   or Hour Glass is pressed by implementing the event handling
   mechanism with addActionListener(). */

package pgr4c;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonImageExample {

	JLabel l1;

	ButtonImageExample() {

		JFrame f = new JFrame("Button Image Example");

		l1 = new JLabel();
		l1.setBounds(50, 30, 700, 80);
		l1.setFont(new Font("Arial", Font.BOLD, 30));

		// Images from package folder pgr4c.images
		ImageIcon img1 = new ImageIcon(getClass().getResource("/pgr4c/images/clock.jpg"));
		ImageIcon img2 = new ImageIcon(getClass().getResource("/pgr4c/images/hourglass.png"));

		JButton b1 = new JButton("Digital Clock", img1);
		JButton b2 = new JButton("Hour Glass", img2);

		b1.setBounds(50, 150, 250, 100);
		b2.setBounds(320, 150, 250, 100);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("Digital Clock is pressed");
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("Hour Glass is pressed");
			}
		});

		f.add(b1);
		f.add(b2);
		f.add(l1);

		f.setSize(650, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ButtonImageExample();
	}
}