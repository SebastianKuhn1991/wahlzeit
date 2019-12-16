package org.wahlzeit.coordinate;

public interface Coordinate {
	
	public double getVar1();
	
	public double getVar2();
	
	public double getVar3();
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public CartesianDistanceValue getCartesianDistance(Object c);
	
	public SphericCoordinate asSphericCoordinate();
	
	public SphericDistanceValue getCentralAngle(Object c);
	
	public boolean isEqual(Object c);

	public boolean equals(Object c);
	
	public void assertNotNull(Object c);
	
	public void assertIsObjectType(Coordinate c);
	
	public void assertOtherObjectValues(Coordinate c);
}
