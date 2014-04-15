//////////////////////////////////////////////
/// Zach Liss --- zll1@pitt.edu --- 1/30/12///
//////////////////////////////////////////////

import java.awt.* ;
import javax.swing.* ;
import java.util.Random ;
import java.util.Date ;

public class MyDemonstrateTSP
{
	public static int WIDTH = 750, HEIGHT = 750, PAUSE = 25 ;
	public static int boxWIDTH = 5, boxHEIGHT = 5;
	public static int NUMSTOPS = 50;

	public static void main(String[] args) 
	{
 		Tour tour = new Tour();
    	Random r = new Random() ;
   		JFrame frame = new JFrame("Traveling Salesman Problem") ;
		Map p = new Map (WIDTH,HEIGHT,NUMSTOPS);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(p) ;
    	frame.pack() ;
    	frame.setVisible(true) ;
    	
    	for(int i = 0; i < NUMSTOPS; i++)
    	{
    		City nextCity = new City("X", r.nextInt(WIDTH-5), r.nextInt(HEIGHT-5));
    		tour.addCity(nextCity);
    	}
    	tour.addCity(tour.getCity(0));

    	for(int i = 0; i < tour.getNumCities(); i++)
    	{
    		p.box((int) tour.getCity(i).getX(), (int) tour.getCity(i).getY());
    		p.line((int) tour.getCity(i).getX(), (int) tour.getCity(i).getY(), (int)tour.getCity(i+1).getX(), (int)tour.getCity(i+1).getY());
   		}
    	p.updateTour();
    	sleep(PAUSE);
    	
	double newDist = 0;
	double oldDist = -1;
    while (newDist != oldDist) 
    {
    	p.resetLines();
    	p.resetBoxes();
    	
    	oldDist = tour.calcDistance();
    	tour.improve();
    	newDist = tour.calcDistance();
    	for(int i = 0; i < tour.getNumCities(); i++)
    	{
    		p.box((int) tour.getCity(i).getX(), (int) tour.getCity(i).getY());
    		p.line((int) tour.getCity(i).getX(), (int) tour.getCity(i).getY(), (int)tour.getCity(i+1).getX(), (int)tour.getCity(i+1).getY());	
   		}
		p.updateTour();
    	sleep(PAUSE) ;
    }
  }

	public static void sleep(long milliseconds) 
	{
    	Date d ;
   		long start, now ;
		d = new Date() ;
    	start = d.getTime() ;
    	do 
    	{
    		d = new Date() ; 
    		now = d.getTime() ; 
    	} while ( (now - start) < milliseconds ) ;
  	}

}
