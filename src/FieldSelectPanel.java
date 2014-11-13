import java.awt.*;
import java.util.List;

import javax.swing.*;

import shared.model.Field;
import shared.model.Project;


public class FieldSelectPanel extends JPanel {
	private SearchController _control;
	private DefaultListModel<String> _field_model;
	private JList<String> _field_list;
	private JScrollPane _scroll;
	private JLabel _label;
	
	FieldSelectPanel(SearchController control) {
		_control = control;
		_control.setFpanel(this);
		
		_field_model = new DefaultListModel<String>();
		_field_list = new JList<String>(_field_model);
		
		_field_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		_field_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		_field_list.setVisibleRowCount(-1);
		
		
		setLayout(new BorderLayout());
		
		_label = new JLabel("Fields");
		_label.setHorizontalAlignment(JLabel.CENTER);
		add(_label, BorderLayout.NORTH);
		
		_scroll = new JScrollPane(_field_list);
		add(_scroll, BorderLayout.CENTER);
		
	}
	
	public void updateFields() {
		List<Field> field_list = _control.getAllFields();
		_field_model.clear();
		
		for (Field each : field_list) {
			_field_model.addElement(each.getTitle());
		}
		
//		System.out.println(getPreferredSize());
		
		return;
	}
	
	public int[] getSelectedIndices() {
		return _field_list.getSelectedIndices();
	}
}
