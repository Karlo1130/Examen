import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Main  extends JWindow{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon("TortuFast.png");
		ImageIcon icon2 = new ImageIcon("TurtleDab.png");
		
		SplashScreen splashScreen = new SplashScreen(icon,icon2);
        for (int i = 0; i <= 100; i++) {
            splashScreen.setProgress(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        splashScreen.dispose();
		
		Ventana ventana = new Ventana();
		
	}

}
