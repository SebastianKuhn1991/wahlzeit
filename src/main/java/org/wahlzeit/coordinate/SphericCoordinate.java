package org.wahlzeit.coordinate;

public class SphericCoordinate extends AbstractCoordinate {
	
	public SphericCoordinate(double phi,double theta, double radius) {
		super(phi, theta, radius);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(this.getVar3()*Math.sin(this.getVar2())*Math.cos(this.getVar1()),this.getVar3()*Math.sin(this.getVar2())*Math.sin(this.getVar1()),this.getVar3()*Math.cos(this.getVar2()));
	}
	
	@Override
	public double getCartesianDistance(Coordinate c) {
		return asCartesianCoordinate().getCartesianDistance(c);
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/*
	 * used haversine formula
	 */
	@Override
	public double getCentralAngle(Coordinate c) {
		if(!(c instanceof SphericCoordinate)) {
			c = c.asSphericCoordinate();
		}
		
		double divLat = Math.toRadians(c.getVar1() - this.getVar1());
		double divLon = Math.toRadians(c.getVar2() - this.getVar2());
		
		double latitudeA = Math.toRadians(this.getVar1());
		double latitudeB = Math.toRadians(c.getVar1());
		
		double mem = Math.pow(Math.asin(divLat/2),  2) + Math.acos(latitudeA) * Math.cos(latitudeB) * Math.pow(Math.asin(divLon/2), 2);
		double result = 2 * Math.asin(Math.sqrt(mem));
		
		return result;
	}	
}
