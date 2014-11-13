import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import shared.model.Project;


@SuppressWarnings("serial")
public class ProjectSelectPanel extends JPanel {
	private SearchController _control;
	private JLabel _label;
	private JComboBox<String> _projects;
	
	public ProjectSelectPanel(SearchController control) {
		_control = control;
		_control.setPpanel(this);
		
		setLayout(new BorderLayout());
		
		_label = new JLabel("Projects");
		_label.setHorizontalAlignment(JLabel.CENTER);
		add(_label, BorderLayout.NORTH);
		
		_projects = new JComboBox<String>();
		_projects.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = _projects.getSelectedIndex();
//				System.out.println("Index of item selected: " + index);
				_control.setSelectedProject(index);
			}
		});
		add(_projects, BorderLayout.CENTER);
	}
	
	public void updateProjects() {
		List<Project> project_list = _control.getProjects();
		
		for (Project each : project_list) {
			_projects.addItem(each.getTitle());
		}
		
		return;
	}
}
