package shared.communication;

import shared.model.User;

/**
 * @author kevinjreece
 */
public class AddUser_Params {
	private User _user;

	/**
	 * @return the user
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
}
