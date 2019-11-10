package org.wahlzeit.model;

public class CarPhotoFactory extends PhotoFactory{
	
	public CarPhotoFactory() {
		super();
	}

	/**
	 * @methodtype factory
	 */
	public CarPhoto createPhoto() {
		return new CarPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public CarPhoto createPhoto(PhotoId id) {
		return new CarPhoto(id);
	}

}
