package shared.communication;

import shared.model.Project;

/**
 * @author kevinjreece
 */
public class AddProject_Params {
	private Project _project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return _project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this._project = project;
	}
}
