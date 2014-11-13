import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.List;

public class DisplayResultPanel extends JPanel implements MouseListener {
	private SearchController _control;
	private DefaultListModel<String> _result_model;
	private JList<String> _result_list;
	private JScrollPane _scroll;
	private JLabel _label;
	
	public DisplayResultPanel(SearchController control) {
		_control = control;
		_control.setDpanel(this);
		
		_result_model = new DefaultListModel<String>();
		_result_list = new JList<String>(_result_model);
		_result_list.addMouseListener(this);
		_result_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_result_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		_result_list.setVisibleRowCount(-1);
		
		
		setLayout(new BorderLayout());
		
		_label = new JLabel("Results");
		_label.setHorizontalAlignment(JLabel.CENTER);
		add(_label, BorderLayout.NORTH);
		
		_scroll = new JScrollPane(_result_list);
		_scroll.setPreferredSize(new Dimension(260, 37));
		add(_scroll, BorderLayout.CENTER);
	}
	
	public void setResults() {
		List<URL> all_urls = _control.getAllFoundUrls();
		_result_model.clear();
		
		if (all_urls != null) {
			for (URL each : all_urls) {
				_result_model.addElement(each.toString());
			}
		}
		return;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String url_str = _result_list.getSelectedValue();
			try {
				URL url = new URL(url_str);
				Image image = ImageIO.read(url);
				JLabel img_label = new JLabel(new ImageIcon(image));
				JOptionPane.showMessageDialog(this,
					    img_label,
					    "Selected Image",
					    JOptionPane.PLAIN_MESSAGE);
				
			} catch (Exception err) {
				err.printStackTrace();
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
