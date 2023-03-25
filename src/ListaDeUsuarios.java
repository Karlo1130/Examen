import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaDeUsuarios extends JTable {

	private String[] columns = {"Usuario", "Nombre", "Acciones"};
	private Object[][] data;
	private DefaultTableModel table;
	
	public ListaDeUsuarios() {

		//cambia el tamaño de las filas
		this.setRowHeight(40);
		this.setSelectionBackground(Color.green);
		
		//evita que puedas mover las columnas de posicion
		this.tableHeader.setReorderingAllowed(false);
		//evita que puedas cambiar el tamaño de las columnas
		this.tableHeader.setResizingAllowed(false);
		
		this.setFocusable(false);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();

			String[] lineArray = null;

			data = new Object[getNumeroUsuarios()][columns.length];

			int aux = 0;
			
			//añade los datos de la base de datos a la matriz data
			while (line != null) {
				lineArray = line.split(", ");

				for (int i = 0; i < lineArray.length-3; i++) {
					data[aux][i] = lineArray[i];
				}

				line = reader.readLine();
				aux++;
			}

			reader.close();

			table = new DefaultTableModel(data, columns);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.setModel(table);
		
		//pasa las acciones realizadas por los botones
		TablaEventos eventos = new TablaEventos() {
			
			@Override
			public void eliminar(int row) {
				// TODO Auto-generated method stub
				System.out.println("eliminar"+row);
			}
			
			@Override
			public void editar(int row) {
				// TODO Auto-generated method stub
				System.out.println("editar"+row);
			}
		};
		
		this.getColumnModel().getColumn(2).setCellRenderer(new ButtonRender());
		this.getColumnModel().getColumn(2).setCellEditor(new EditorCeldas(eventos));
	}

	//obtiene el numero de usuarios que contiene la base de datos
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
	
	//hace que las celdas no sean editables y las editables
	public boolean isCellEditable(int row, int column) {
		if(column == 2) {
			return true;
		} else {
			return false;
		}
	}

}

