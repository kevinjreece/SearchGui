import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Logs a user into the Search GUI
 * @author kevinjreece
 * */
public class SearchGui {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SearchController control = new SearchController();
				SearchLoginPanel login = new SearchLoginPanel(control);
				SearchFrame frame = new SearchFrame(control);
				
				Object[] options = {"Submit", "Cancel"};
				int result = JOptionPane.showOptionDialog(null, login, "Record Indexer Search",
								JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
								null, options, options[0]);
						
			    if (result == JOptionPane.OK_OPTION) {
			    	control.validateUser();
			    }
				
			}
		});
	}
}