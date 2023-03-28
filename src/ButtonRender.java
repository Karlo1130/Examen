import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonRender extends DefaultTableCellRenderer{

	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Component comp = super.getTableCellRendererComponent(table, value, 
				isSelected, hasFocus, row, column);

		PanelBotones btnPanel = new PanelBotones();
		
		//cambia el color de la celda dependiendo de su posicion
		if (isSelected == false && row%2==0) {
			btnPanel.setBackground(Color.orange);
		} else if(isSelected) {
			btnPanel.setBackground(table.getSelectionBackground());
		} else {
			btnPanel.setBackground(Color.white);
		}
		
		return btnPanel;
		
	}
	
}
