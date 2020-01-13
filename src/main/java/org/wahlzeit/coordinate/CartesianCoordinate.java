package org.wahlzeit.coordinate;
import org.wahlzeit.model.PatternInstance;

@PatternInstance(
		patternName = "Factory Method",
		participants = {
				"Concrete Product"
		}
)

public class CartesianCoordinate extends AbstractCoordinate{
	
	public CartesianCoordinate(double x,double y, double z) {
		super(x, y, z);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
}
