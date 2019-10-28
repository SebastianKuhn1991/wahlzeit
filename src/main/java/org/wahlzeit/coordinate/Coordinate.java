package org.wahlzeit.coordinate;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
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
		
		distance = Math.sqrt(Math.pow(c.getX()- this.x, 2)+Math.pow(c.getY()- this.y, 2)+Math.pow(c.getZ()- this.z, 2));
		
		return distance;
	}
	
	public boolean isEqual(Coordinate c) {
		
		if(c.getX() == this.x && c.getY() == this.y && c.getZ() == this.z) {
			return true;
		} else {
			return false;
		}
	}
	
}
