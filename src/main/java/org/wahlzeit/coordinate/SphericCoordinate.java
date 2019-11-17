package org.wahlzeit.coordinate;

public class SphericCoordinate implements Coordinate {

	private double phi;
	private double theta;
	private double radius;
	
	public SphericCoordinate(double phi,double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	public double getVar1() {
		return phi;
	}

	public void setVar1(double phi) {
		this.phi = phi;
	}

	public double getVar2() {
		return theta;
	}

	public void setVar2(double theta) {
		this.theta = theta;
	}

	public double getVar3() {
		return radius;
	}

	public void setVar3(double radius) {
		this.radius = radius;
	}
	
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(this.radius*Math.sin(this.theta)*Math.cos(this.phi),this.radius*Math.sin(this.theta)*Math.sin(this.phi),this.radius*Math.cos(this.theta));
	}
	
	public double getCartesianDistance(Coordinate c) {
		return asCartesianCoordinate().getCartesianDistance(c);
	}
	
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/*
	 * used haversine formula
	 */
	public double getCentralAngle(Coordinate c) {
		if(!(c instanceof SphericCoordinate)) {
			c = c.asSphericCoordinate();
		}
		
		double divLat = Math.toRadians(c.getVar1() - this.phi);
		double divLon = Math.toRadians(c.getVar2() - this.theta);
		
		double latitudeA = Math.toRadians(this.phi);
		double latitudeB = Math.toRadians(c.getVar1());
		
		double mem = Math.pow(Math.asin(divLat/2),  2) + Math.acos(latitudeA) * Math.cos(latitudeB) * Math.pow(Math.asin(divLon/2), 2);
		double result = 2 * Math.asin(Math.sqrt(mem));
		
		return result;
	}
	
	public boolean isEqual(Coordinate c) {
		if(!(c instanceof SphericCoordinate)) {
			c = c.asSphericCoordinate();
		}
		
		if(c.getVar1() == this.phi && c.getVar2() == this.theta && c.getVar3() == this.radius) {
			return true;
		} else {
			return false;
		}
	}
	
}
