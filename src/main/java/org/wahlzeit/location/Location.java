package org.wahlzeit.location;

import org.wahlzeit.coordinate.CartesianCoordinate;
import org.wahlzeit.coordinate.Coordinate;
import org.wahlzeit.model.Photo;

public class Location {

	public Coordinate coordinate;
	
	public Location(Coordinate c) {
		
		try {
			assertNotNull(c);
			this.coordinate = c;
		}catch(NullPointerException e) {
			throw new NullPointerException("The Object of type Coordinate was null");
		}
	}
	
	public void assertNotNull(Coordinate c)
		throws NullPointerException {
		if(c == null) {
			throw new NullPointerException();
		}
	}
}
