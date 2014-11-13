import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import shared.communication.*;
import shared.model.*;


public class SearchController {
	private SearchLoginPanel _lpanel;
	private SearchFrame _sframe;
	private ProjectSelectPanel _ppanel;
	private FieldSelectPanel _fpanel;
	private SearchTextPanel	_spanel;
	private DisplayResultPanel _dpanel;
	
	private String _host;
	private int _port;
	private String _username;
	private String _password;
	
	private List<Project> _all_projects;
	private Project _selected_project;
	private List<Field> _all_fields;
	private List<URL> _all_found_urls;
	
	public SearchLoginPanel getLpanel() {
		return _lpanel;
	}

	public void setLpanel(SearchLoginPanel _lpanel) {
		this._lpanel = _lpanel;
	}

	public SearchFrame getSFrame() {
		return _sframe;
	}
	
	public void setSFrame(SearchFrame value) {
		_sframe = value;
	}
	
	public ProjectSelectPanel getPpanel() {
		return _ppanel;
	}

	public void setPpanel(ProjectSelectPanel ppanel) {
		this._ppanel = ppanel;
	}

	public FieldSelectPanel getFpanel() {
		return _fpanel;
	}

	public void setFpanel(FieldSelectPanel fpanel) {
		this._fpanel = fpanel;
	}

	public SearchTextPanel getSpanel() {
		return _spanel;
	}

	public void setSpanel(SearchTextPanel spanel) {
		this._spanel = spanel;
	}

	public DisplayResultPanel getDpanel() {
		return _dpanel;
	}

	public void setDpanel(DisplayResultPanel dpanel) {
		this._dpanel = dpanel;
	}

	public List<Field> getAllFields() {
		return _all_fields;
	}

	public void setAllFields(List<Field> all_fields) {
		this._all_fields = all_fields;
	}
	
	public List<URL> getAllFoundUrls() {
		return _all_found_urls;
	}

	public void setAllFoundUrls(List<URL> all_found_urls) {
		this._all_found_urls = all_found_urls;
	}
	
	public void validateUser() {
		_host = _lpanel.getFieldText(SearchLoginPanel.FieldTitle.HOST);
		_port = Integer.parseInt(
					_lpanel.getFieldText(SearchLoginPanel.FieldTitle.PORT));
		ClientCommunicator client = new ClientCommunicator(_host, _port);
		
		_username = _lpanel.getFieldText(SearchLoginPanel.FieldTitle.USERNAME);
		_password = _lpanel.getFieldText(SearchLoginPanel.FieldTitle.PASSWORD);
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
			
			_ppanel.updateProjects();
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
		
		_all_projects = result.getAllProjects();
		return _all_projects;
	}
	
	public void setSelectedProject(int index) {
		_selected_project = _all_projects.get(index);
		
		ClientCommunicator client = new ClientCommunicator(_host, _port);
		GetFields_Params params = new GetFields_Params();
		GetFields_Result result = new GetFields_Result();
		params.setUsername(_username);
		params.setPassword(_password);
		params.setProjectId(_selected_project.getProjectId());
		
		try {
			result = client.getFields(params);
		}
		catch (Exception err) {
			result.setIsValid(false);
			err.printStackTrace();
			return;
		}
		
		setAllFields(result.getFields());
		_fpanel.updateFields();
		
		return;
	}

	public void performSearch() {
//		System.out.println("Perform search. . .");
		
		_all_found_urls = new ArrayList<URL>();
		ClientCommunicator client = new ClientCommunicator(_host, _port);
		String values_string = _spanel.getText();
		List<String> values = new ArrayList<String>(Arrays.asList(values_string.split("\\s*,\\s*")));
		int[] field_ids = _fpanel.getSelectedIndices();
		List<Integer> fields = new ArrayList<Integer>();
		
		for (int i = 0; i < field_ids.length; i++) {
			Field each_field = _all_fields.get(field_ids[i]);
			fields.add(each_field.getFieldId());
		}
		
		Search_Params params = new Search_Params();
		Search_Result result = new Search_Result();
		params.setUsername(_username);
		params.setPassword(_password);
		params.setHost(_host);
		params.setPort(_port);
		

		params.setFieldIds(fields);
		params.setValues(values);
		
		try {
			result = client.search(params);
		} catch (ClientException e) {
			e.printStackTrace();
			return;
		}

		List<Value> all_values = result.getFoundImages();
		
		for (Value each : all_values) {
			String url_str = each.getImageUrl();
			URL url;
			try {
				url = new URL(url_str);
				if (!_all_found_urls.contains(url)) {
					_all_found_urls.add(url);	
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		_dpanel.setResults();
		
		return;
	}

	

}
