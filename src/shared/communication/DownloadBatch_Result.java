package shared.communication;

import java.util.List;

import shared.model.Field;
import shared.model.Image;
import shared.model.Project;


/**
 * Contain the return value of downloading a batch from a project
 * @author kevinjreece
 */
public class DownloadBatch_Result {
	private boolean _is_valid;
	private Project _project;
	private Image _image;
	private List<Field> _fields;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			output.append(_image.getImageId() + "\n"
						+ _project.getProjectId() + "\n"
						+ _image.getImageUrl() + "\n"
						+ _project.getFirstYCoord() + "\n"
						+ _project.getRecordHeight() + "\n"
						+ _project.getRecordsPerImage() + "\n"
						+ _fields.size() + "\n");
			
			for (Field each : _fields) {
				output.append(each.getFieldId() + "\n"
							+ each.getColumnNumber() + "\n"
							+ each.getTitle() + "\n"
							+ each.getHelpHtml() + "\n"
							+ each.getXCoord() + "\n"
							+ each.getWidth() + "\n");
				if (each.getKnownData() != null) {
					output.append(each.getKnownData() + "\n");
				}
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
	 * @return the _image
	 */
	public Image getImage() {
		return _image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this._image = image;
	}

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

	/**
	 * @return the fields
	 */
	public List<Field> getFields() {
		return _fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this._fields = fields;
	}
}
