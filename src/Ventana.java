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
		
		//JScrollPane test = new JScrollPane(new ListaDeUsuarios());
		JScrollPane test = new JScrollPane(tabla);
		this.add(test);

		this.repaint();
		this.revalidate();
	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("le");
//		
//		int column = tabla.getColumnModel().getColumnIndexAtX(e.getX()); 
//		int row = e.getY()/tabla.getRowHeight();
//		
//		if(row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
//			Object value = tabla.getValueAt(row, column);
//			if(value instanceof JButton) {
//				((JButton)value).doClick();
//				JButton boton = (JButton) value;
//				System.out.println("lol");
//			}
//		}
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
