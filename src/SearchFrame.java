import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
class SearchFrame extends JFrame {
	private SearchController _control;
	private SearchTextPanel _search;
	private ProjectSelectPanel _projects;
	private FieldSelectPanel _fields;
	private JButton _submit;
	private DisplayResultPanel _display;
	
	public SearchFrame(SearchController control) {
		_control = control;
		_control.setSFrame(this);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 300));

		_search = new SearchTextPanel(_control);
		add(_search);
		
		_projects = new ProjectSelectPanel(_control);
		add(_projects);
		
		_fields = new FieldSelectPanel(_control);
		add(_fields);
		
		_submit = new JButton("Search");
		_submit.setAlignmentX(CENTER_ALIGNMENT);
		_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_control.performSearch();
			}
		});
		add(_submit);
		
		_display = new DisplayResultPanel(_control);
		add(_display);
		
	}
	
}










