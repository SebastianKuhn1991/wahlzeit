package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;

public class CarManager {
	
	public Set<CarType> types = new HashSet<CarType>();
	public Set<Car> cars = new HashSet<Car>();
	
	public Car createCar(String typeName) {
		CarType ct = getCarType(typeName);
		Car result = ct.createInstance();
		cars.add(result);
		return result;
	}
	
	public CarType getCarType(String typeName) {
		
		for (CarType mem : types) {
			if (mem.getName().equals(typeName)) {
				return mem;
			}
		} 

		CarType memCar = new CarType(this, typeName);
		types.add(memCar);
		return memCar;
	}
}
