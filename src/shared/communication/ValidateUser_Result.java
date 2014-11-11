package shared.communication;

import shared.model.User;

/**
 * Contains the return value of the user validation
 * @author kevinjreece
 */
public class ValidateUser_Result {
	private boolean _is_valid;
	private User _user;
	private String _message;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			output.append(_message + "\n");
			output.append(_user.getFirstName() + "\n");
			output.append(_user.getLastName() + "\n");
			output.append(_user.getIndexedRecords() + "\n");
		}
		else {
			output.append(_message);
		}
		
		return output.toString();
	}

	/**
	 * @return the _is_valid
	 */
	public boolean isValid() {
		return _is_valid;
	}

	/**
	 * @param is_valid the is_valid to set
	 */
	public void setIsValid(boolean is_valid) {
		this._is_valid = is_valid;
	}

	/**
	 * @return the _user
	 */
	public User getUser() {
		return _user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this._user = user;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this._message = message;
	}
}
