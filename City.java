import java.util.*;

public class City
{
	private String cityName;
	private double X, Y;
	
	public City(){}
	
	/////CONSTRUCTORS/////
	public City(String cityName, int x, int y)
	{
		this.cityName = cityName;
		X = x;
		Y = y;
	}
	
	/////ACCESSORS/////
	public double distance(City cityIn)
	{
		double changeInX = X - cityIn.getX();
		double changeInY = Y - cityIn.getY();
		double xDistanceSquared = (changeInX*changeInX) + (changeInY*changeInY);
		double xDistance = Math.sqrt(xDistanceSquared);
		
		return xDistance;
	}
	
	public double getX()
	{
		return X;
	}
	public double getY()
	{
		return Y;
	}
	
	public String toString()
	{
		return cityName;
	}
	
	/////MUTATORS/////
	
	public void setX(double x)
	{
		X = x;
	}
	public void setY(double y)
	{
		Y = y;
	}
	public void setName(String s)
	{
		cityName = s;
	}
}