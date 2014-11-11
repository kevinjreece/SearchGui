package shared.communication;

import java.util.List;
import shared.model.*;

/**
 * Contains the return value from getting all projects
 * @author kevinjreece
 */
public class GetProjects_Result {
	private boolean _is_valid;
	private List<Project> _all_projects;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			for (Project each : _all_projects) {
				output.append(each.getProjectId() + "\n");
				output.append(each.getTitle() + "\n");
			}
		}
		else {
			output.append("FAILED\n");
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
	 * @return the _all_projects
	 */
	public List<Project> getAllProjects() {
		return _all_projects;
	}

	/**
	 * @param all_projects the all_projects to set
	 */
	public void setAllProjects(List<Project> all_projects) {
		this._all_projects = all_projects;
	}
}
