import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    
    public SplashScreen() {
        initComponents();
    }
    
    public void initComponents() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("Tortu.png"));
        label = new JLabel(icon, SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        
        progressBar = new JProgressBar();
        progressBar.setPreferredSize(new Dimension(200, 20));
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Arial", Font.PLAIN, 12));
        progressBar.setString("Loading...");
        panel.add(progressBar, BorderLayout.SOUTH);
        
        setUndecorated(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
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