package org.wahlzeit.coordinate;

public class SphericCoordinate extends AbstractCoordinate {
	
	public SphericCoordinate(double phi,double theta, double radius) {
		super(phi, theta, radius);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws NullPointerException{
		
		try {
			CartesianCoordinate cc = new CartesianCoordinate(this.getVar3()*Math.sin(this.getVar2())*Math.cos(this.getVar1())
				,this.getVar3()*Math.sin(this.getVar2())*Math.sin(this.getVar1())
				,this.getVar3()*Math.cos(this.getVar2()));
		
			assertNotNull(cc);
		
			return cc;
		}catch(NullPointerException e) {
			return this.asCartesianCoordinate();
		}
	}
	
	@Override
	public CartesianDistanceValue getCartesianDistance(Object c) throws NullPointerException{
		try {
			assertNotNull(c);			
			return asCartesianCoordinate().getCartesianDistance(c);
		}catch(NullPointerException e) {
			throw e;
		}
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/*
	 * used haversine formula
	 */
	@Override
	public SphericDistanceValue getCentralAngle(Object c) 
			throws NullPointerException, IllegalStateException, IllegalArgumentException{
		try {
			assertNotNull(c);
			
			if(!(c instanceof Coordinate)) {
				throw new IllegalArgumentException("The given Object is not a Coordinate object");
			}
			
			Coordinate corC = (Coordinate)c;
		
			if(!(c instanceof SphericCoordinate)) {
				corC = corC.asSphericCoordinate();
			}
		
			assertIsObjectType(corC);
		
			doubleValueCheckVar1 = corC.getVar1();
			doubleValueCheckVar2 = corC.getVar2();
			doubleValueCheckVar3 = corC.getVar3();
		
			assertOtherObjectValues(corC);
		
			double divLat = Math.toRadians(corC.getVar1() - this.getVar1());
			double divLon = Math.toRadians(corC.getVar2() - this.getVar2());
		
			double latitudeA = Math.toRadians(this.getVar1());
			double latitudeB = Math.toRadians(corC.getVar1());
		
			double mem = Math.pow(Math.asin(divLat/2),  2) + Math.acos(latitudeA) * Math.cos(latitudeB) * Math.pow(Math.asin(divLon/2), 2);
			double result = 2 * Math.asin(Math.sqrt(mem));
		
			SphericDistanceValue distanceObject = new SphericDistanceValue(result);
			
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
	public boolean equals(Object c) 
			throws NullPointerException, IllegalStateException, IllegalArgumentException{
		try {
			assertNotNull(c);
			
			if(!(c instanceof Coordinate)) {
				throw new IllegalArgumentException("The given Object is not a Coordinate object");
			}
			
			Coordinate corC = (Coordinate)c;
		
			if (!(c instanceof SphericCoordinate)) {
				corC = corC.asSphericCoordinate();
			}
		
			assertIsObjectType(corC);
		
			doubleValueCheckVar1 = corC.getVar1();
			doubleValueCheckVar2 = corC.getVar2();
			doubleValueCheckVar3 = corC.getVar3();
		
			assertOtherObjectValues(corC);
		
			if(this == corC) {
				return true;
			}

			if(Double.compare(corC.getVar1(), this.getVar1()) == 0
					&& Double.compare(corC.getVar2(), this.getVar2()) == 0
					&& Double.compare(corC.getVar3(), this.getVar3()) == 0) {
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
	public void assertIsObjectType(Coordinate c)
		throws IllegalArgumentException {
		if (!(c instanceof SphericCoordinate)) {
			String msg = "Unable to convert the object to the same type";
			throw new IllegalArgumentException(msg);
		}
	}
}
