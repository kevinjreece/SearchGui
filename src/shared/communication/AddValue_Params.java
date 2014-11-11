package shared.communication;

import shared.model.Value;

/**
 * @author kevinjreece
 */
public class AddValue_Params {
	private Value _value;

	/**
	 * @return the value
	 */
	public Value getValue() {
		return _value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Value value) {
		this._value = value;
	}
}
