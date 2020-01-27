package org.wahlzeit.model;

public class CarPhoto extends Photo{
	
	private Car car;
	
	public CarPhoto() {
		super();
	}
	
	public CarPhoto(PhotoId id) {
		super(id);
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
}