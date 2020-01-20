package org.wahlzeit.model;

public class Car {

	private CarManager carManager = null;
	protected CarType carType = null;
	
	public Car(CarType ct, CarManager cm) {
		carManager = cm;
		carType = ct;
	}
	
	public CarType getType() {
		return carType;
	}
	
	public CarManager getManager() {
		return carManager;
	}
}
