package presentancion.vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class VentanaListarPersona extends JFrame{
	private static final long serialVersionUID = 1L;
	private static VentanaListarPersona instancia;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> listModelPersona;
	private JScrollPane scrollPane;
	
	private JTable tablaPersonas;
	private DefaultTableModel modeloTabla;
	private String[] columnas = {"Nombre", "Apellido", "Dni"};

	public VentanaListarPersona() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null); //centra la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setBounds(0, 0, 400, 400);
		agregarControles();
		
        modeloTabla = new DefaultTableModel(null, columnas) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; //celdas no editables
            }
        };

        tablaPersonas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPersonas);
        contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	private void agregarControles() {
		lblTitulo = new JLabel("Listado de personas:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(20, 20, 271, 25);
		getContentPane().add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 56, 350, 140);
		getContentPane().add(scrollPane);

		listModelPersona = new DefaultListModel<Persona>();
		listPersonas = new JList<Persona>(listModelPersona);
		scrollPane.setViewportView(listPersonas);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listPersonas.setLayoutOrientation(JList.VERTICAL);
	}

	public JList<Persona> getListaPersonas() {
		return listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return this.listModelPersona;
	}

	public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
	
	public void cambiarVisibilidad(boolean state) {
		super.setVisible(state);
	}

	public static VentanaListarPersona getInstancia() {
		if (instancia == null || !instancia.isDisplayable()) {
			try {
				instancia = new VentanaListarPersona();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instancia;
	}

}
