package org.wahlzeit.coordinate;

public class SphericCoordinate extends AbstractCoordinate {
	
	public SphericCoordinate(double phi,double theta, double radius) {
		super(phi, theta, radius);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
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
	public double getCartesianDistance(Coordinate c) {
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
	public double getCentralAngle(Coordinate c) {
		try {
			assertNotNull(c);
		
			if(!(c instanceof SphericCoordinate)) {
				c = c.asSphericCoordinate();
			}
		
			assertIsObjectType(c);
		
			doubleValueCheckVar1 = c.getVar1();
			doubleValueCheckVar2 = c.getVar2();
			doubleValueCheckVar3 = c.getVar3();
		
			assertOtherObjectValues(c);
		
			double divLat = Math.toRadians(c.getVar1() - this.getVar1());
			double divLon = Math.toRadians(c.getVar2() - this.getVar2());
		
			double latitudeA = Math.toRadians(this.getVar1());
			double latitudeB = Math.toRadians(c.getVar1());
		
			double mem = Math.pow(Math.asin(divLat/2),  2) + Math.acos(latitudeA) * Math.cos(latitudeB) * Math.pow(Math.asin(divLon/2), 2);
			double result = 2 * Math.asin(Math.sqrt(mem));
		
			assertOtherObjectValues(c);
		
			return result;
		}catch(NullPointerException e) {
			throw new NullPointerException("The given object was null");
		}catch(IllegalStateException e) {
			throw e;
		}catch(IllegalArgumentException e) {
			throw e;
		}
	}
	
	@Override
	public boolean equals(Coordinate c) {
		try {
			assertNotNull(c);
		
			if (!(c instanceof SphericCoordinate)) {
				c = c.asSphericCoordinate();
			}
		
			assertIsObjectType(c);
		
			doubleValueCheckVar1 = c.getVar1();
			doubleValueCheckVar2 = c.getVar2();
			doubleValueCheckVar3 = c.getVar3();
		
			assertOtherObjectValues(c);
		
			if(this == c) {
				return true;
			}

			if(Double.compare(c.getVar1(), this.getVar1()) == 0
					&& Double.compare(c.getVar2(), this.getVar2()) == 0
					&& Double.compare(c.getVar3(), this.getVar3()) == 0) {
				assertOtherObjectValues(c);
				return true;
			} else {
				assertOtherObjectValues(c);
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
