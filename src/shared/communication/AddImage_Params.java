package shared.communication;

import shared.model.Image;

/**
 * @author kevinjreece
 */
public class AddImage_Params {
	private Image _image;

	/**
	 * @return the image
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
}
