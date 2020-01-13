package org.wahlzeit.coordinate;
import java.lang.IllegalArgumentException;
import java.lang.Object;

import org.wahlzeit.model.PatternInstance;

@PatternInstance(
		patternName = "Factory Method",
		participants = {
				"Concrete Product"
		}
)

public abstract class AbstractCoordinate implements Coordinate {

	/*
	 * Implements the CartesianCoordinate class
	 * The SphericCoordinate class uses override to implement its methods which are different
	 */
	
	//x or phi
	private final double var1;
	//y or theta
	private final double var2;
	//z or radius
	private final double var3;
	
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
	public double getVar2() {
		return this.var2;
	}

	@Override
	public double getVar3() {
		return this.var3;
	}

	@Override
	public CartesianDistanceValue getCartesianDistance(Object c)
			throws NullPointerException, IllegalStateException, IllegalArgumentException{
		
		try {
			assertNotNull(c);

			if(!(c instanceof Coordinate)) {
				throw new IllegalArgumentException("The given Object is not a Coordinate object");
			}
			
			Coordinate corC = (Coordinate)c;
		
			if(!(c instanceof CartesianCoordinate)) {
				corC = corC.asCartesianCoordinate();
			}
		
			//Postcondition
			assertIsObjectType(corC);
		
			doubleValueCheckVar1 = corC.getVar1();
			doubleValueCheckVar2 = corC.getVar2();
			doubleValueCheckVar3 = corC.getVar3();
		
			assertOtherObjectValues(corC);
		
			double distance = 0;
		
			distance = Math.sqrt(Math.pow(corC.getVar1()- this.var1, 2)+Math.pow(corC.getVar2()- this.var2, 2)+Math.pow(corC.getVar3()- this.var3, 2));
		
			CartesianDistanceValue distanceObject = new CartesianDistanceValue(distance);
			
			assertNotNull(distanceObject);
			
			assertOtherObjectValues(corC);			
			
			return distanceObject;
		}catch(NullPointerException e) {
			throw new NullPointerException("The given object was null");
		}catch(IllegalStateException e) {
			throw e;
		}catch(IllegalArgumentException e) {
			throw e;
		}
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws NullPointerException{
		try {
			double radius = Math.sqrt(Math.pow(this.getVar1(), 2) + Math.pow(this.getVar2(), 2) + Math.pow(this.getVar3(), 2));
			double theta = Math.acos(this.getVar3() / radius);
			double phi = Math.atan(this.getVar2() / this.getVar1());
		
			SphericCoordinate sc = new SphericCoordinate(phi, theta, radius);
		
			assertNotNull(sc);
			
			return sc;
		}catch(NullPointerException e) {
			return this.asSphericCoordinate();
		}
	}

	@Override
	public SphericDistanceValue getCentralAngle(Object c) throws NullPointerException{
		try {
			assertNotNull(c);
			return asSphericCoordinate().getCentralAngle(c);
		}catch(NullPointerException e) {
			throw e;
		}
	}

	@Override
	public boolean isEqual(Object c) 
			throws NullPointerException, IllegalStateException, IllegalArgumentException{
		try {
			assertNotNull(c);
			return equals(c);
		}catch(NullPointerException e) {
			throw new NullPointerException("The given object was null");
		}catch(IllegalStateException e) {
			throw e;
		}catch(IllegalArgumentException e) {
			throw e;
		}
	}

	@Override
	public boolean equals(Object c) 
			throws NullPointerException, IllegalStateException, IllegalArgumentException {
		try {
			assertNotNull(c);
			
			if(!(c instanceof Coordinate)) {
				throw new IllegalArgumentException("The given Object is not a Coordinate object");
			}
			
			Coordinate corC = (Coordinate)c;
		
			if(!(c instanceof CartesianCoordinate)) {
				corC = corC.asCartesianCoordinate();
			}
		
			assertIsObjectType(corC);
		
			doubleValueCheckVar1 = corC.getVar1();
			doubleValueCheckVar2 = corC.getVar2();
			doubleValueCheckVar3 = corC.getVar3();
		
			assertOtherObjectValues(corC);
			if(this == corC) {
				return true;
			}

			if(Double.compare(corC.getVar1(), this.var1) == 0
					&& Double.compare(corC.getVar2(), this.var2) == 0
					&& Double.compare(corC.getVar3(), this.var3) == 0) {
				assertOtherObjectValues(corC);
				return true;
			} else {
				assertOtherObjectValues(corC);
				return false;
			}
		}catch(NullPointerException e) {
			throw new NullPointerException("The given object was null");
		}catch(IllegalStateException e) {
			throw e;
		}catch(IllegalArgumentException e) {
			throw e;
		}
	}
	
	@Override
	public void assertNotNull(Object c)
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
