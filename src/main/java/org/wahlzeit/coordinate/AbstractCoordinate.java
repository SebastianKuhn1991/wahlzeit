package org.wahlzeit.coordinate;
import java.lang.IllegalArgumentException;

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
	
	protected double doubleValueCheckVar1;
	protected double doubleValueCheckVar2;
	protected double doubleValueCheckVar3;
	
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
		
		assertNotNull(c);
		
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		//Postcondition
		assertIsObjectType(c);
		
		doubleValueCheckVar1 = c.getVar1();
		doubleValueCheckVar2 = c.getVar2();
		doubleValueCheckVar3 = c.getVar3();
		
		assertOtherObjectValues(c);
		
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(c.getVar1()- this.var1, 2)+Math.pow(c.getVar2()- this.var2, 2)+Math.pow(c.getVar3()- this.var3, 2));
		
		assertOtherObjectValues(c);
		
		return distance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws NullPointerException{
		double radius = Math.sqrt(Math.pow(this.getVar1(), 2) + Math.pow(this.getVar2(), 2) + Math.pow(this.getVar3(), 2));
		double theta = Math.acos(this.getVar3() / radius);
		double phi = Math.atan(this.getVar2() / this.getVar1());
		
		SphericCoordinate sp = new SphericCoordinate(phi, theta, radius);
		
		if(sp == null) {
			String msg = "creating a new SphericCoordinate object failed";
			throw new NullPointerException(msg);
		}
		
		return sp;
	}

	@Override
	public double getCentralAngle(Coordinate c) {
		assertNotNull(c);
		return asSphericCoordinate().getCentralAngle(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		assertNotNull(c);
		return equals(c);
	}

	@Override
	public boolean equals(Coordinate c) {
		
		assertNotNull(c);
		
		if(!(c instanceof CartesianCoordinate)) {
			c = c.asCartesianCoordinate();
		}
		
		assertIsObjectType(c);
		
		doubleValueCheckVar1 = c.getVar1();
		doubleValueCheckVar2 = c.getVar2();
		doubleValueCheckVar3 = c.getVar3();
		
		assertOtherObjectValues(c);
		
		if(this == c) {
			return true;
		}

		if(Double.compare(c.getVar1(), this.var1) == 0
				&& Double.compare(c.getVar2(), this.var2) == 0
				&& Double.compare(c.getVar3(), this.var3) == 0) {
			assertOtherObjectValues(c);
			return true;
		} else {
			assertOtherObjectValues(c);
			return false;
		}
	}
	
	@Override
	public void assertNotNull(Coordinate c)
		throws NullPointerException {
		if(c == null) {
			String msg = "The Object was null";
			throw new NullPointerException(msg);
		}
	}
	
	@Override
	public void assertIsObjectType(Coordinate c)
		throws IllegalArgumentException {
		if (!(c instanceof CartesianCoordinate)) {
			String msg = "Unable to convert the object to the same type";
			throw new IllegalArgumentException(msg);
		}
	}
	
	@Override
	public void assertOtherObjectValues(Coordinate c)
		throws IllegalStateException {
		if(c.getVar1() != doubleValueCheckVar1
				|| c.getVar2() != doubleValueCheckVar2
				|| c.getVar3() != doubleValueCheckVar3) {
			String msg = "unexpected change of object variable values";
			throw new IllegalStateException(msg);
		}
	}
}
