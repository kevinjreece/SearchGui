package shared.communication;

import shared.model.Image;

/**
 * Contains the return value of getting a sample image
 * @author kevinjreece
 */
public class GetSampleImage_Result {
	private boolean _is_valid;
	private Image _sample_image;
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (_is_valid) {
			output.append(_sample_image.getImageUrl());
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
	 * @return the _sample_image
	 */
	public Image getSampleImage() {
		return _sample_image;
	}
	
	/**
	 * @param sample_image the sample_image to set
	 */
	public void setSampleImage(Image sample_image) {
		this._sample_image = sample_image;
	}
}
