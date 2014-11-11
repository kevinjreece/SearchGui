package shared.communication;

import java.util.List;

import shared.model.Value;

/**
 * Contains the return value of a database search
 * @author kevinjreece
 */
public class Search_Result {
	private boolean _is_valid;
	private List<Value> _found_values;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			for (Value each : _found_values) {
				output.append(each.getImageId() + "\n");
				output.append(each.getImageUrl() + "\n");
				output.append(each.getRowNumber() + "\n");
				output.append(each.getFieldId() + "\n");
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
	 * @return the _found_images
	 */
	public List<Value> getFoundImages() {
		return _found_values;
	}

	/**
	 * @param found_images the found_images to set
	 */
	public void setFoundImages(List<Value> found_values) {
		this._found_values = found_values;
	}
}
