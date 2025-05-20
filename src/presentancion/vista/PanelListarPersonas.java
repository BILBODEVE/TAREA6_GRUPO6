package presentancion.vista;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
<<<<<<< HEAD
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
=======
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

>>>>>>> 676eed125df1db7cdc216da2bb4ce619d1daa282
import entidad.Persona;

public class PanelListarPersonas extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JTable tablaPersonas;
	private DefaultTableModel modeloTabla;
	private JScrollPane scroll;

	public PanelListarPersonas() {
		setLayout(null);

		lblTitulo = new JLabel("Listado de personas registradas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(90, 20, 300, 30);
		add(lblTitulo);

<<<<<<< HEAD
		// Columnas
		String[] columnas = { "Nombre", "Apellido", "DNI" };
=======
		modelLista = new DefaultListModel<>();
		listaPersonas = new JList<>(modelLista);
		listaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
>>>>>>> 676eed125df1db7cdc216da2bb4ce619d1daa282

		// Modelo de tabla
		modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "DNI"}, 0) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Desactiva la edición
		    }
		};
		tablaPersonas = new JTable(modeloTabla);
		tablaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tablaPersonas.setRowHeight(22);

		scroll = new JScrollPane(tablaPersonas);
		scroll.setBounds(30, 70, 400, 200);
		add(scroll);
	}

	// Método para agregar personas a la tabla
	public void agregarPersona(String nombre, String apellido, String dni) {
		modeloTabla.addRow(new Object[]{nombre, apellido, dni});
	}

	// También podrías usar uno que reciba un objeto Persona
	public void agregarPersona(Persona p) {
		modeloTabla.addRow(new Object[]{p.getNombre(), p.getApellido(), p.getDNI()});
	}

	public void limpiarTabla() {
		modeloTabla.setRowCount(0);
	}

	public JTable getTabla() {
		return tablaPersonas;
	}

	public DefaultTableModel getModel() {
		return modeloTabla;
	}
}
