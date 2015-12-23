package wielomiany;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wielomian extends Panel{
	public Wielomian(){
		this.setSize(500,500);
	//	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	int xx,yy,rr=10;
	
	public void rysuj(int...args){

		this.setSize(600,600);
		this.setVisible(true);
		int a=args[0];
		int b=args[1];
		int h=args[2];
		double wynik;
		double x;
		int ileKrokow;
		ileKrokow= ((b-a)/h)+1;
		double[] X = new double[ileKrokow];
		double[] Y = new double[ileKrokow];
		int counter=0;
		
		for(int i=a; i<=b; i=i+h)
		{
			X[counter]=i;
			wynik=0;
			x=1;
			for(int j=args.length-1, k=0; j>2; j--, k++){
				if(k>0)		
				 x*=i;	
				wynik += x*args[j];
			}
			Y[counter]=wynik;
	//		drawCircle(xx,yy,rr);
		counter++;
		}
		
		double krX=znajdzKrokX(ileKrokow);
		
		double krY=znajdzKrokY(Y);
		for(int i=0; i<X.length; i++){
			int x1=(int)(((i+1)*krX));
			int y1=(int)((this.getHeight()/2)-krY*Y[i]);
			drawCircle(x1,y1,rr);
			getGraphics().drawLine(x1,this.getHeight()/2-3,x1, this.getHeight()/2+3);
			getGraphics().drawLine(this.getWidth()/2-3,x1,this.getWidth()/2+3, x1);
		}

		getGraphics().drawLine(0,this.getHeight()/2,this.getWidth(), this.getHeight()/2);
		getGraphics().drawLine(this.getWidth()/2,0,this.getWidth()/2, this.getHeight());
		getGraphics().drawLine(this.getWidth()-20,this.getHeight()/2-20,this.getWidth(), this.getHeight()/2);
		getGraphics().drawLine(this.getWidth()-20,this.getHeight()/2+20,this.getWidth(), this.getHeight()/2);
		getGraphics().drawLine(this.getWidth()/2-20,20,this.getWidth()/2,0);
		getGraphics().drawLine(this.getWidth()/2+20,20,this.getWidth()/2,0);
	}

	private double znajdzKrokX(int x){
		return ((this.getWidth())/x);
	}
	private double znajdzKrokY(double[] y){
		double min=0, max=0;
		for(int i=0; i<y.length; i++){
			if(y[i]<min)
				min=y[i];
			if(y[i]>max)
				max=y[i];
		}
		
		return (this.getHeight())/((max-min)*2);
	}
/*	private double znajdzMax(double y[]){
		double max = y[0];
		for(int i=1; i<y.length; i++)
			if(y[i]>max)
				max=y[i];
		return max;
	}
*/
	  public void paint(Graphics arg0) {
		  rysuj(-10,10,1,-56,3,-15,75,-41,1);

	    }

	public  void drawCircle( int x, int y, int r){
        Graphics2D g2 = (Graphics2D) getGraphics();
        Ellipse2D e = new Ellipse2D.Double(x,y,r,r);
        g2.draw(e);
        GradientPaint gp = new GradientPaint(x-r/2, y-r/2, Color.red,x+r/2, y+r/2, Color.blue, false);
        // Fill with a gradient.
        g2.setPaint(gp);
        g2.fill(e);
        g2.draw(e);
    }
}
