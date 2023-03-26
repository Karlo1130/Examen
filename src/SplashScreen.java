import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class SplashScreen extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JProgressBar progressBar;
    private JLabel label;
    public int mover=0;
    
    public SplashScreen(ImageIcon img,ImageIcon img2) {
        initComponents(img,img2);
    }
    

    public void initComponents(ImageIcon img,ImageIcon img2) {
    	
    		mover =100;
        panel = new JPanel(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.decode("#007D96"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        label = new JLabel();
        panel.add(label, BorderLayout.CENTER);
        
        progressBar = new JProgressBar();
        progressBar.setBounds(100,450,500,100);
        progressBar.setStringPainted(true);
        panel.add(progressBar);
        
        ImageIcon icon = new ImageIcon();
        icon = img;
        JLabel tortuLogin = new JLabel();
        tortuLogin.setBounds(mover,375,100,100);
        tortuLogin.setIcon(new ImageIcon(img.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        tortuLogin.setBackground(Color.decode("#FFFFFF"));
        panel.add(tortuLogin);
        
        ImageIcon icon2 = new ImageIcon();
        icon2 = img2;
        JLabel tortuLogin2 = new JLabel();
        tortuLogin2.setBounds(250,100,200,200);
        tortuLogin2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        tortuLogin2.setBackground(Color.decode("#FFFFFF"));
        panel.add(tortuLogin2);
        
        JLabel nombres = new JLabel("-Powered by KarloBurrito-",JLabel.CENTER);
        nombres.setFont(new Font("Times new roman", Font.BOLD,15));
        nombres.setSize(400, 40);
        nombres.setLocation(150, 700);
        nombres.setOpaque(true);
        nombres.setBackground(Color.decode("#007D96"));
		panel.add(nombres);
        
        setUndecorated(true);
        setSize(700, 800);
        setLocation(0,0);
        getContentPane().add(panel);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void setProgress(int value) {
        progressBar.setValue(value);
    }
    
    public void setMessage(String message) {
        progressBar.setString(message);
    }
    
    /*public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        for (int i = 0; i <= 100; i++) {
            splashScreen.setProgress(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        splashScreen.dispose();
    }*/
}