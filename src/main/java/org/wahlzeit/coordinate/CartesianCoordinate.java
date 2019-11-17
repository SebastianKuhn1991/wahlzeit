package org.wahlzeit.coordinate;

public class CartesianCoordinate implements Coordinate{

	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x,double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getVar1() {
		return x;
	}

	public void setVar1(double x) {
		this.x = x;
	}

	public double getVar2() {
		return y;
	}

	public void setVar2(double y) {
		this.y = y;
	}

	public double getVar3() {
		return z;
	}

	public void setVar3(double z) {
		this.z = z;
	}
	
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	public double getCartesianDistance(Coordinate c) {
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(c.getVar1()- this.x, 2)+Math.pow(c.getVar2()- this.y, 2)+Math.pow(c.getVar3()- this.z, 2));
		
		return distance;
	}
	
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		double theta = Math.acos(this.z / radius);
		double phi = Math.atan(this.y / this.x);
		
		return new SphericCoordinate(phi, theta, radius);
	}
	
	public double getCentralAngle(Coordinate c) {
		return asSphericCoordinate().getCentralAngle(c);
	}
	
	public boolean isEqual(Coordinate c) {
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		if(c.getVar1() == this.x && c.getVar2() == this.y && c.getVar3() == this.z) {
			return true;
		} else {
			return false;
		}
	}
	
}
