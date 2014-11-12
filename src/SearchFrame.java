import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
class SearchFrame extends JFrame {
	
	private SearchLoginPanel _login;
	
	public SearchLoginPanel getLoginPanel() {
		return _login;
	}
	
	public void setLoginPanel(SearchLoginPanel value) {
		_login = value;
	}
	
	public SearchFrame(SearchController control) {
		_login = new SearchLoginPanel();
		control.setSFrame(this);

		Object[] options = {"Submit", "Cancel"};
		int result = JOptionPane.showOptionDialog(null, _login, "Record Indexer Search",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, options, options[0]);
				
	    if (result == JOptionPane.OK_OPTION) {
			
	    	control.validateUser();
	    	
//	    	for (SearchLoginPanel.FieldTitle field_title : 
//	    		SearchLoginPanel.FieldTitle.values()) {
//	    		System.out.printf("%10s: %s%n", field_title.getTitle(),
//	    				login.getFieldText(field_title));
//	         }
	    }
	}
	
}