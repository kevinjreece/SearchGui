import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;


/**
 * Logs a user into the Search GUI
 * @author kevinjreece
 * */
public class SearchGui {
	
	private static void createAndShowGui() {
		SearchLoginPanel login = new SearchLoginPanel();

		Object[] options = {"Submit", "Cancel"};
		int result = JOptionPane.showOptionDialog(null, login, "Record Indexer Search",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, options, options[0]);
				
	    if (result == JOptionPane.OK_OPTION) {
			
	    	// TODO: do something with info
	    	
	    	for (SearchLoginPanel.FieldTitle field_title : 
	    		SearchLoginPanel.FieldTitle.values()) {
	    		System.out.printf("%10s: %s%n", field_title.getTitle(),
	    				login.getFieldText(field_title));
	         }
	    }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}

@SuppressWarnings("serial")
class SearchLoginPanel extends JPanel {
	
	enum FieldTitle {
		HOST("Host"), PORT("Port"), USERNAME("Username"), PASSWORD("Password");
		private String title;

		private FieldTitle(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}
	};
	
	private Map<FieldTitle, JTextField> fieldMap = new HashMap<FieldTitle, JTextField>();
	
	public SearchLoginPanel() {
//		setTitle("Search Login");
//		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Search Login"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc = null;
		for (int i = 0; i < FieldTitle.values().length; i++) {
			FieldTitle title = FieldTitle.values()[i];
			gbc = createGbc(0, i);
			add(new JLabel(title.getTitle() + ":", JLabel.LEFT), gbc);
			gbc = createGbc(1, i);
			JTextField text = new JTextField(10);
			add(text, gbc);
			
			fieldMap.put(title, text);
		}
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
	private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
	
	private GridBagConstraints createGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
		gbc.fill = (x == 0) ? GridBagConstraints.BOTH
				: GridBagConstraints.HORIZONTAL;

		gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
		gbc.weightx = (x == 0) ? 0.1 : 1.0;
		gbc.weighty = 1.0;
		return gbc;
	}
	 
	 public String getFieldText(FieldTitle fieldTitle) {
		 return fieldMap.get(fieldTitle).getText();
	 }
}