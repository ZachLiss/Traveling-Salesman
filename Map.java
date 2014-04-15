//////////////////////////////////////////////
/// Zach Liss --- zll1@pitt.edu --- 1/30/12///
//////////////////////////////////////////////

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Map extends JPanel
{
	public Color BACKGROUND = Color.blue;
	public Color FOREGROUND = Color.red;
	
	public int width, height;
	public int box_x, box_y;
	public final int BOXWIDTH = 5, BOXHEIGHT = 5;
	public int line_x, line_y, line_xx, line_yy;

	public int NUMBOXES, NUMLINES;
	public int[] boxXs;
	public int[] boxYs;
	public int[] lineXs;
	public int[] lineYs;
	public int[] lineXXs;
	public int[] lineYYs;
	
	public Map(int w, int h, int s)
	{
		this.width = w;
		this.height = h;
		setPreferredSize(new Dimension(w,h));
		
		boxXs = new int[s+1];
		boxYs = new int[s+1];
		lineXs = new int[s+1];
		lineYs = new int[s+1];
		lineXXs = new int[s+1];
		lineYYs = new int[s+1];
	}
	
	public void box(int x, int y) 
	{
		boxXs[NUMBOXES] = x;
		boxYs[NUMBOXES] = y;
		NUMBOXES++;
	}

	public void line(int x, int y, int xx, int yy) 
	{
    	lineXs[NUMLINES] = x ;
    	lineYs[NUMLINES] = y ;
    	lineXXs[NUMLINES] = xx ;
    	lineYYs[NUMLINES] = yy ;
  		NUMLINES++;
	}
	
	public void resetLines() {NUMLINES = 0;}
	public void resetBoxes() {NUMBOXES = 0;}
	

	public void paintComponent(Graphics g) 
	{
    	super.paintComponent(g) ;
    	g.setColor(BACKGROUND) ;
    	g.fillRect(0,0,width,height) ;
    	g.setColor(FOREGROUND) ;
    	
    	for(int i = 0; i < NUMBOXES; i++)
    	{
    		g.fillRect(boxXs[i], boxYs[i], BOXWIDTH, BOXHEIGHT);
    		g.drawLine(lineXs[i], lineYs[i], lineXXs[i], lineYYs[i]);
    	}
	}

	public void updateTour()
	{
		repaint();
	}
}