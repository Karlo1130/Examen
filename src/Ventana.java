import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{
	
	ListaDeUsuarios tabla;
	
	public Ventana() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setTitle("Gestion de Usuarios");
		this.setSize(600, 800);

		tabla = new ListaDeUsuarios();
		
		JScrollPane test = new JScrollPane(tabla);
		this.add(test);

		this.repaint();
		this.revalidate();
	}

	
}
