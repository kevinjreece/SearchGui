package shared.communication;

import shared.model.Field;

/**
 * @author kevinjreece
 */
public class AddField_Params {
	private Field _field;

	/**
	 * @return the field
	 */
	public Field getField() {
		return _field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(Field field) {
		this._field = field;
	}
}
