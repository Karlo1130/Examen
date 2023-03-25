import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class EditorCeldas extends DefaultCellEditor{
	
	private TablaEventos evento;
	
	public EditorCeldas(TablaEventos evento) {
		super(new JCheckBox());
		this.evento = evento;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		PanelBotones btnPanel = new PanelBotones();

		//manda a llamar a la funcion
		btnPanel.iniciarEvento(evento, row);
		
		btnPanel.setBackground(table.getSelectionBackground());
		
		return btnPanel;
	}

}
	