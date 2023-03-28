import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaDeUsuarios extends JTable {

	private String[] columns = {"Usuario", "Nombre", "Acciones"};
	private Object[][] data;
	private DefaultTableModel table;
	private int posicionUsuario;
	private String email;
	
	public ListaDeUsuarios(String email) {

		this.email = email;
		
		this.posicionUsuario = posicionUsuario;
		//cambia el tamaño de las filas
		this.setRowHeight(40);
		this.setSelectionBackground(Color.green);
		
		//evita que puedas mover las columnas de posicion
		this.tableHeader.setReorderingAllowed(false);
		//evita que puedas cambiar el tamaño de las columnas
		this.tableHeader.setResizingAllowed(false);
		
		this.setFocusable(false);
		
		crearTabla();
		
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
	
	public void eliminarUsuario(int numUsuarioEliminar) {
		
		String archivo = "users.txt";
		
		int numeroUsuario = 0;
		
		try {
			File archivoTemporal = new File("archivoTemporal");
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));
			
			BufferedReader reader = new BufferedReader(new FileReader(archivo));
			String line = reader.readLine();
			
			//copia los datos en un nuevo archivo menos el del usuario especificado
			while (line != null) {
				
				if (numeroUsuario != numUsuarioEliminar) {
					writer.write(line);
					writer.newLine();
				}

				line = reader.readLine();
				numeroUsuario++;
			}

			reader.close();
			writer.close();
			
			File borrador = new File(archivo);
			borrador.delete();
			
			archivoTemporal.renameTo(borrador);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		crearTabla();
	}

	public void crearTabla() {
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

		//pasa las acciones realizadas por el boton
		TablaEventos eventos = new TablaEventos() {
			
			@Override
			public void eliminar(int row, JButton button) {
				// TODO Auto-generated method stub
				if (row == 4) {
					button.setEnabled(true);
				}
				
				int seleccion = JOptionPane.showConfirmDialog(button,
						"Estas seguro que deseas eliminarlo?", "Eliminar Usuario", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				System.out.println(row);
				
				if(seleccion == 0) {
					
					eliminarUsuario(row);
				}
			}
			
		};
		
		this.getColumnModel().getColumn(2).setCellRenderer(new ButtonRender());
		this.getColumnModel().getColumn(2).setCellEditor(new EditorCeldas(eventos));
		
	}
	
}	