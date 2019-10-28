package org.wahlzeit.coordinate;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
	public Coordinate() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Coordinate(double x,double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public double getDistance(Coordinate c) {
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(c.x- this.x, 2)+Math.pow(c.y- this.y, 2)+Math.pow(c.z- this.z, 2));
		
		return distance;
	}
	
	public boolean isEqual(Coordinate c) {
		
		if(c.x == this.x && c.y == this.y && c.z == this.z) {
			return true;
		} else {
			return false;
		}
	}
	
}
