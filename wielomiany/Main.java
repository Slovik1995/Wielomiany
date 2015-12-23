package wielomiany;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main{
	public static void main(String[] arg){
		Frame f = new JFrame();
		 f.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent we){
	               System.exit(0);
	            }
	        });
		f.setVisible(true);
		f.setSize(600, 600);
		Wielomian w = new Wielomian();
		f.add(w);
	//	w.rysuj(1,10,2,1,2,1,5);
	}
}
	