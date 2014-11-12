import java.awt.EventQueue;

import javax.swing.JFrame;


/**
 * Logs a user into the Search GUI
 * @author kevinjreece
 * */
public class SearchGui {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SearchController control = new SearchController();
				SearchFrame frame = new SearchFrame(control);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}