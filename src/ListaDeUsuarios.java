import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaDeUsuarios extends JTable implements MouseListener{

	private String[] columns = {"Usuario", "Nombre", "Acciones"};
	private Object[][] data;
	private DefaultTableModel table;
	private JButton button;
	
	public ListaDeUsuarios() {

		this.setDefaultRenderer(Object.class, new ButtonRender());
		this.addMouseListener(this);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();

			String[] lineArray = null;

			data = new Object[getNumeroUsuarios()][columns.length];

			int aux = 0;

			while (line != null) {
				lineArray = line.split(", ");

				for (int i = 0; i < lineArray.length-3; i++) {
					data[aux][i] = lineArray[i];
				}

				data[aux][2] = button = new JButton();

				line = reader.readLine();
				aux++;
			}

			reader.close();

			table = new DefaultTableModel(data, columns);

		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		this.setModel(table);	
		System.out.println("si");
//		button.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				/*
//				int column = getColumnModel().getSelectedColumnCount(); 
//				int row = getRowHeight();
//
//				/*if(row < getRowCount() && row >= 0 && column < getColumnCount() && column >= 0) {*/
//					Object value = getValueAt(row, column);
//					if(value instanceof JButton) {
//						((JButton)value).doClick();
//						JButton boton = (JButton) value;
//						System.out.println("lol");
//					}
//				/*}
//				*/
//			}
//			
//		});
		
			
	}

	public int getNumeroUsuarios() {

		int numLines = 0;

		try {
			BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
			String lineCounter = readerCounter.readLine();

			while(lineCounter!=null) {
				numLines++;
				lineCounter = readerCounter.readLine();
			}

			readerCounter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		return numLines;

	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int column = getColumnModel().getColumnIndexAtX(e.getX()); 
		int row = e.getY()/getRowHeight();
		System.out.println(row);
		/*
		if(row < getRowCount() && row >= 0 && column < getColumnCount() && column >= 0) {
			Object value = getValueAt(row, column);
			if(value instanceof JButton) {
				((JButton)value).doClick();
				JButton boton = (JButton) value;
				
			}
		}*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

