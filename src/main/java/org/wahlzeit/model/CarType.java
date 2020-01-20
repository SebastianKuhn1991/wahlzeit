package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class CarType extends DataObject{
	
	public CarManager carManager = null;
	private CarType superType = null;
	public Set<CarType> subType = new HashSet<CarType>();
	private String name = null;
	
	public CarType (CarManager cm, String name) {
		carManager = cm;
		this.name = name;
	}
	
	public Car createInstance() {
		return new Car(this, carManager);
	}
	
	public boolean isSubtype() {
		if(superType != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public CarType getSuperType() {
		return superType;
	}
	
	public Iterator<CarType> getSubTypeIterator() {
		return subType.iterator();
	}
	
	public void addSuperType(CarType ct) {
		assert (ct != null) : "SuberType cannot be null";
		superType = ct;
	}
	
	public void addSubType(CarType ct) {
		assert (ct != null) : "SubType cannot be null";
		subType.add(ct);
	}
	
	public boolean hasInstance(Car car) {
		assert (car != null) : "null is not a possible value for this method";
		
		if (car.getType() == this) {
			return true;
		}
		
		for (CarType type : subType) {
			if (type.hasInstance(car)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String getName() {
		return name;
	}
}
