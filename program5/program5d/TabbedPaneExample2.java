
/* 5d. Develop a Swing program in Java to create a Tabbed Pane
of Cyan, Magenta and Yellow and display the concerned color
whenever the specific tab is selected in the Pane. */

package pgr5d;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneExample2 extends JFrame {

	public TabbedPaneExample2() {

		JTabbedPane tab = new JTabbedPane();

		// Cyan Tab
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.add(new JLabel("CYAN"));

		// Magenta Tab
		JPanel p2 = new JPanel();
		p2.setBackground(Color.MAGENTA);
		p2.add(new JLabel("MAGENTA"));

		// Yellow Tab
		JPanel p3 = new JPanel();
		p3.setBackground(Color.YELLOW);
		p3.add(new JLabel("YELLOW"));

		tab.addTab("Cyan", p1);
		tab.addTab("Magenta", p2);
		tab.addTab("Yellow", p3);

		tab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index = tab.getSelectedIndex();
				System.out.println(tab.getTitleAt(index) + " Tab Selected");
			}
		});

		add(tab);

		setTitle("Tabbed Pane Example");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TabbedPaneExample2();
	}
}