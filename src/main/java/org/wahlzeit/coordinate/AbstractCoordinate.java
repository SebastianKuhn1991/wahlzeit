package org.wahlzeit.coordinate;

public abstract class AbstractCoordinate implements Coordinate {

	/*
	 * Implements the CartesianCoordinate class
	 * The SphericCoordinate class uses override to implement its methods which are different
	 */
	
	//x or phi
	private double var1;
	//y or theta
	private double var2;
	//z or radius
	private double var3;
	
	public AbstractCoordinate(double var1, double var2, double var3) {
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}
	
	@Override
	public double getVar1() {
		return this.var1;
	}

	@Override
	public void setVar1(double v) {
		this.var1 = v;
	}

	@Override
	public double getVar2() {
		return this.var2;
	}

	@Override
	public void setVar2(double v) {
		this.var2 = v;
	}

	@Override
	public double getVar3() {
		return this.var3;
	}

	@Override
	public void setVar3(double v) {
		this.var3 = v;
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(c.getVar1()- this.var1, 2)+Math.pow(c.getVar2()- this.var2, 2)+Math.pow(c.getVar3()- this.var3, 2));
		
		return distance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(this.getVar1(), 2) + Math.pow(this.getVar2(), 2) + Math.pow(this.getVar3(), 2));
		double theta = Math.acos(this.getVar3() / radius);
		double phi = Math.atan(this.getVar2() / this.getVar1());
		
		return new SphericCoordinate(phi, theta, radius);
	}

	@Override
	public double getCentralAngle(Coordinate c) {
		return asSphericCoordinate().getCentralAngle(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		return equals(c);
	}

	@Override
	public boolean equals(Coordinate c) {
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		if(this == c) {
			return true;
		}

		if(Double.compare(c.getVar1(), this.var1) == 0
				&& Double.compare(c.getVar2(), this.var2) == 0
				&& Double.compare(c.getVar3(), this.var3) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
