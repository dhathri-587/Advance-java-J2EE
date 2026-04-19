

/* 5c. Develop a Swing program in Java to add the countries
USA, India, Vietnam, Canada, Denmark, France,
Great Britain, Japan, Africa, Greenland, Singapore
into a JList and display the capital of the countries
on console whenever the countries are selected on the list. */

package pgr5c;

import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListCapitalExample extends JFrame {

	private JList<String> countryList;
	private HashMap<String, String> capitalMap;

	public JListCapitalExample() {

		// Create model and add countries
		DefaultListModel<String> listModel = new DefaultListModel<>();

		listModel.addElement("USA");
		listModel.addElement("India");
		listModel.addElement("Vietnam");
		listModel.addElement("Canada");
		listModel.addElement("Denmark");
		listModel.addElement("France");
		listModel.addElement("Great Britain");
		listModel.addElement("Japan");
		listModel.addElement("Africa");
		listModel.addElement("Greenland");
		listModel.addElement("Singapore");

		// Create capital map
		capitalMap = new HashMap<>();
		capitalMap.put("USA", "Washington DC");
		capitalMap.put("India", "New Delhi");
		capitalMap.put("Vietnam", "Hanoi");
		capitalMap.put("Canada", "Ottawa");
		capitalMap.put("Denmark", "Copenhagen");
		capitalMap.put("France", "Paris");
		capitalMap.put("Great Britain", "London");
		capitalMap.put("Japan", "Tokyo");
		capitalMap.put("Africa", "No Single Capital");
		capitalMap.put("Greenland", "Nuuk");
		capitalMap.put("Singapore", "Singapore");

		// Create JList
		countryList = new JList<>(listModel);

		countryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					String country = countryList.getSelectedValue();

					String capital = capitalMap.get(country);

					System.out.println("Country: " + country + " -> Capital: " + capital);
				}
			}
		});

		add(new JScrollPane(countryList));

		setTitle("JList Capital Example");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JListCapitalExample();
	}
}