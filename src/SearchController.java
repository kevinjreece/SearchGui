import java.awt.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import shared.communication.*;
import shared.model.*;


public class SearchController {

	private SearchFrame _sframe;
	private String _host;
	private int _port;
	private String _username;
	private String _password;
	
	public SearchFrame getSFrame() {
		return _sframe;
	}
	
	public void setSFrame(SearchFrame value) {
		_sframe = value;
	}
	
	public void validateUser() {
		_host = _sframe.getLoginPanel().getFieldText(SearchLoginPanel.FieldTitle.HOST);
		_port = Integer.parseInt(
					_sframe.getLoginPanel().getFieldText(SearchLoginPanel.FieldTitle.PORT));
		ClientCommunicator client = new ClientCommunicator(_host, _port);
		
		_username = _sframe.getLoginPanel().getFieldText(SearchLoginPanel.FieldTitle.USERNAME);
		_password = _sframe.getLoginPanel().getFieldText(SearchLoginPanel.FieldTitle.PASSWORD);
		ValidateUser_Params params = new ValidateUser_Params();
		ValidateUser_Result result = new ValidateUser_Result();
		params.setUsername(_username);
		params.setPassword(_password);
		
		try {
			result = client.validateUser(params);
		}
		catch (ClientException err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(_sframe,
				    "Server error!",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (result.isValid()) {
			int indexed = result.getUser().getIndexedRecords();
			String message = "Welcome " + result.getUser().getFirstName() + ".\n"
					+ "You have indexed " + indexed + " records.\n";
			
			JOptionPane.showMessageDialog(_sframe,
				    message,
				    "Valid",
				    JOptionPane.PLAIN_MESSAGE);
			
			SearchPanel search = new SearchPanel(this);
			
			_sframe.setLayout(new BorderLayout());
			_sframe.add(search, BorderLayout.CENTER);
			_sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			_sframe.setMinimumSize(new Dimension(300, 200));
			_sframe.setVisible(true);
		}
		else {
			String message = "Invalid username/password combination.\n";
			
			JOptionPane.showMessageDialog(_sframe,
				    message,
				    "Invalid",
				    JOptionPane.PLAIN_MESSAGE);
		}
		
		return;
	}
	
	public List<Project> getProjects() {
		ClientCommunicator client = new ClientCommunicator(_host, _port);
		GetProjects_Params params = new GetProjects_Params();
		GetProjects_Result result = new GetProjects_Result();
		params.setUsername(_username);
		params.setPassword(_password);
		
		try {
			result = client.getProjects(params);
		}
		catch (Exception err) {
			result.setIsValid(false);
			err.printStackTrace();
		}
		
		return result.getAllProjects();
	}
	
}
