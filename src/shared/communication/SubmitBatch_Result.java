package shared.communication;

import java.util.List;

import shared.model.Value;

/**
 * @author kevinjreece
 *
 */
public class SubmitBatch_Result {
	private boolean _is_valid;
	private List<Value> _values;
	
	@Override
	public String toString() {
		if (_is_valid) {
			return "TRUE\n";
		}
		else {
			return "FAILED\n";
		}
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
	 * @return the values
	 */
	public List<Value> getValues() {
		return _values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<Value> values) {
		this._values = values;
	}

}
