package shared.communication;

import java.util.List;

/**
 * Contains the parameters needed to search the database
 * @author kevinjreece
 */
public class Search_Params {
	private List<Integer> _field_ids;
	private List<String> values;
	private String _username;
	private String _password;
	private String _host;
	private int _port;
	
	/**
	 * @return the _username
	 */
	public String getUsername() {
		return _username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this._username = username;
	}
	
	/**
	 * @return the _password
	 */
	public String getPassword() {
		return _password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this._password = password;
	}

	/**
	 * @return the field_ids
	 */
	public List<Integer> getFieldIds() {
		return _field_ids;
	}

	/**
	 * @param field_ids the field_ids to set
	 */
	public void setFieldIds(List<Integer> fieldIds) {
		_field_ids = fieldIds;
	}

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return _host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this._host = host;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return _port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this._port = port;
	}
}
