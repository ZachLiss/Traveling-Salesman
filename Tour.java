//////////////////////////////////////////////
/// Zach Liss --- zll1@pitt.edu --- 1/30/12///
//////////////////////////////////////////////

import java.util.*;

public class Tour
{
	private double distance;
	int numCities;
	private ArrayList <City> cities;
	
	public Tour()
	{
		this.cities = new ArrayList <City> ();
		distance = 0;
		numCities = -1;
	}
	
	public void addCity(City newCity)
	{
		cities.add(newCity);
		numCities++;
	}
	
	/////ACCESSORS/////
	public double getDistance()
	{
		return distance;
	}
	
	public City getCity(int x)
	{
		return cities.get(x);
	}
	
	public int getNumCities()
	{
		return numCities;
	}
	////////////////////////
	
	public double calcDistance()
	{
		double tourDistance = 0;
		City curCity, nextCity;
		for(int i = 0; i < numCities-1; i++)
		{
			curCity = cities.get(i);
			nextCity = cities.get(i+1);
			tourDistance = tourDistance + curCity.distance(nextCity);
		}
		distance = tourDistance;
		return tourDistance;
	}
	/*
	// alternate improve() method that basically does the same thing
	// only has a different stopping method for the loop. I'm using the improve method
	// below because I feel that the boolean stopping point is better.
	public void improve()
	{
		double newDist = 0;
		//while(newDist != getDistance())
		{
			newDist = getDistance();
			
			for(int i = 0; i < cities.size()-1; i++)
			{
				
				double xEdge = cities.get(i).distance(cities.get(i+1));
				for(int j = i+2; j < cities.size()-1; j++)
				{
					double yEdge = cities.get(j).distance(cities.get(j+1));
					double swapXEdge, swapYEdge, swapDist, regDist;
				
					swapXEdge = cities.get(i).distance(cities.get(j));
					swapYEdge = cities.get(i+1).distance(cities.get(j+1));
					
					regDist = xEdge + yEdge;
					swapDist = swapXEdge + swapYEdge;
			
					if(swapDist < regDist)
					{
						String tempName = cities.get(i+1).toString();
						double tempX = cities.get(i+1).getX();
						double tempY = cities.get(i+1).getY();
						
						cities.get(i+1).setName(cities.get(j).toString());
						cities.get(i+1).setX(cities.get(j).getX());
						cities.get(i+1).setY(cities.get(j).getY());
						
						cities.get(j).setName(tempName);
						cities.get(j).setX(tempX);
						cities.get(j).setY(tempY);
						
						newDist = calcDistance();
						distance = newDist;
				
					}
				}
				
			
			}
		}
	}*/
	
	public void improve()
	{
		boolean SWAP = true;
		do
		{
			SWAP = true;
			int i;
			for(i = 0; i < cities.size()-1; i++)
			{	
				double xEdge = cities.get(i).distance(cities.get(i+1));
				for(int j = i+2; j < cities.size()-1; j++)
				{
					double yEdge = cities.get(j).distance(cities.get(j+1));
					double swapXEdge, swapYEdge, swapDist, regDist;
				
					swapXEdge = cities.get(i).distance(cities.get(j));
					swapYEdge = cities.get(i+1).distance(cities.get(j+1));
					
					regDist = xEdge + yEdge;
					swapDist = swapXEdge + swapYEdge;
			
					if(swapDist < regDist)
					{
						String tempName = cities.get(i+1).toString();
						double tempX = cities.get(i+1).getX();
						double tempY = cities.get(i+1).getY();
						
						cities.get(i+1).setName(cities.get(j).toString());
						cities.get(i+1).setX(cities.get(j).getX());
						cities.get(i+1).setY(cities.get(j).getY());
						
						cities.get(j).setName(tempName);
						cities.get(j).setX(tempX);
						cities.get(j).setY(tempY);
						
						distance = calcDistance();
						SWAP = false;
						break;
					}
				}		
			}
		}while(SWAP);
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < numCities; i++)
		{
			b.append(cities.get(i) + " -- ");
		}
		return b.toString();
	}
}