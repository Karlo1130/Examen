import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{

	public Ventana() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setTitle("Gestion de Usuarios");
		this.setSize(600, 800);

		JScrollPane test = new JScrollPane(new ListaDeUsuarios());
		this.add(test);

		this.repaint();
		this.revalidate();
	}
	
}
