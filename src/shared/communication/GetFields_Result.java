package shared.communication;

import java.util.List;
import shared.model.*;

/**
 * Contains the return value of getting the fields of a project
 * @author kevinjreece
 */
public class GetFields_Result {
	private boolean _is_valid;
	List<Field> _fields;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			for (Field each : _fields) {
				output.append(each.getProjectId() + "\n");
				output.append(each.getFieldId() + "\n");
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
	 * @return the _fields
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
