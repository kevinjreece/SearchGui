import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class SearchLoginPanel extends JPanel {
	
	enum FieldTitle {
		HOST("Host", "localhost"), PORT("Port", "8080"), USERNAME("Username", "sheila"), PASSWORD("Password", "parker");
		private String _title;
		private String _default;

		private FieldTitle(String title, String def) {
			this._title = title;
			this._default = def;
		}

		public String getTitle() {
			return _title;
		}
		
		private String getDefault() {
			return _default;
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
			text.setText(title.getDefault());
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