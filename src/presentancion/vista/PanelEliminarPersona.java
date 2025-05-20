package presentancion.vista;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class PanelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tablaPersonas;
	private DefaultTableModel modeloTabla;
	private JScrollPane scroll;
	private JLabel lblEliminarUsuarios;
	private JButton btnEliminarPersona;

	public PanelEliminarPersona() {
		setLayout(null);

		lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuarios.setBounds(25, 11, 150, 20);
		add(lblEliminarUsuarios);

		// Modelo con columnas y celdas no editables
		modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "DNI"}, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tablaPersonas = new JTable(modeloTabla);
		tablaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // para seleccionar una sola fila

		scroll = new JScrollPane(tablaPersonas);
		scroll.setBounds(25, 50, 388, 142);
		add(scroll);

		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(313, 242, 100, 30);
		add(btnEliminarPersona);
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JButton getBtnEliminarPersona() {
		return btnEliminarPersona;
	}

	public Persona getPersonaSeleccionada() {
		int fila = tablaPersonas.getSelectedRow();
		if (fila != -1) {
			String nombre = (String) modeloTabla.getValueAt(fila, 0);
			String apellido = (String) modeloTabla.getValueAt(fila, 1);
			String dni = (String) modeloTabla.getValueAt(fila, 2);
			return new Persona(nombre, apellido, dni);
		}
		return null;
	}
}