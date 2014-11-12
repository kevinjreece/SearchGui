import java.awt.*;
import java.util.List;

import javax.swing.*;

import shared.model.Project;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel {
	
	SearchPanel(SearchController control) {
		List<Project> projects = control.getProjects();
		Object[] project_objs = projects.toArray();
		JList<Object> project_list = new JList<Object>(project_objs);
		JList<Object> field_list = new JList<Object>();
		
		project_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		project_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		project_list.setVisibleRowCount(-1);
		
		field_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		field_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		field_list.setVisibleRowCount(-1);
		
		JScrollPane project_scroller = new JScrollPane(project_list);
		project_scroller.setSize(new Dimension(200, 200));
		
		JScrollPane field_scroller = new JScrollPane(field_list);
		field_scroller.setSize(new Dimension(200, 200));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc = createGbc(0, 0, 1, 1);
		add(new JLabel("Projects"), gbc);
		
		gbc = createGbc(0, 1, 1, 4);
		add(project_scroller, gbc);
		
		gbc = createGbc(1, 0, 1, 1);
		add(new JLabel("Fields"));
		
		gbc = createGbc(1, 1, 1, 4);
		add(field_scroller, gbc);
	}
	
	private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
	private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
	
	private GridBagConstraints createGbc(int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		return gbc;
	}
}
