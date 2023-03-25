import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelBotones extends JPanel{

	private JButton editar;
	private JButton eliminar;
	
	public PanelBotones(){
		
		this.setBackground(Color.red);
		
		//crea el boton editar
		editar = new JButton("Editar");
		editar.setBackground(Color.blue);
		this.add(editar);

		//crea el boton eliminar
		eliminar = new JButton("Eliminar");
		eliminar.setBackground(Color.cyan);
		this.add(eliminar);

	}
	
	//agrega actionListeners a los botones
	public void iniciarEvento(TablaEventos evento, int row) {
		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				evento.editar(row);
			}
		});
		
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				evento.eliminar(row);
			}
		});
	}
	
}
