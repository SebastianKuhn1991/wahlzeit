package org.wahlzeit.coordinate;

public class CartesianCoordinate extends AbstractCoordinate{
	
	public CartesianCoordinate(double x,double y, double z) {
		super(x, y, z);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
}
