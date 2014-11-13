import java.awt.*;

import javax.swing.*;


public class SearchTextPanel extends JPanel {
	private SearchController _control;
	private JLabel _label;
	private JTextField _search_text;
	
	public SearchTextPanel(SearchController control) {
		_control = control;
		_control.setSpanel(this);
		
		setLayout(new FlowLayout());
		
		_label = new JLabel("Enter search terms:");
		add(_label);
		
		_search_text = new JTextField("", 10);
		add(_search_text);
	}
	
	public String getText() {
		return _search_text.getText();
	}
}
