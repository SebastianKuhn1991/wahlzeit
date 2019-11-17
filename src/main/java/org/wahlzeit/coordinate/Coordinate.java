package org.wahlzeit.coordinate;

public interface Coordinate {
	
	public double getVar1();
	
	public void setVar1(double v);
	
	public double getVar2();
	
	public void setVar2(double v);
	
	public double getVar3();
	
	public void setVar3(double v);
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate c);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getCentralAngle(Coordinate c);
	
	public boolean isEqual(Coordinate c);
}
