package presentancion.vista;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import entidad.Persona;

public class VentanaEliminarPersona extends JFrame {

	private static final long serialVersionUID = 1L;
	private static VentanaEliminarPersona instancia;

	private JPanel contentPane;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> listModelPersona;
	private JScrollPane SCPeliminar;
	private JLabel lblEliminarUsuarios;
	private JButton btnEliminarPersona;
	private Persona personaSeleccionada;

	public VentanaEliminarPersona() {

		setTitle("Eliminar Persona");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 311);
		setResizable(false);
		setLocationRelativeTo(null); //centra la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		agregarControles();
	}

	private void agregarControles() {
		lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuarios.setBounds(97, 28, 120, 14);
		contentPane.add(lblEliminarUsuarios);

		SCPeliminar = new JScrollPane();
		SCPeliminar.setBounds(18, 56, 245, 140);
		getContentPane().add(SCPeliminar);

		listModelPersona = new DefaultListModel<Persona>();
		listPersonas = new JList<Persona>(listModelPersona);
		SCPeliminar.setViewportView(listPersonas);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listPersonas.setLayoutOrientation(JList.VERTICAL);

		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(109, 232, 89, 23);
		contentPane.add(btnEliminarPersona);
	}

	public Persona getPersonaSeleccionada() {
		return listPersonas.getSelectedValue();
	}

	public void setPersonaSeleccionada(Persona persona) {
		this.personaSeleccionada = persona;
	}

	public JButton getBtnEliminarPersona() {
		return btnEliminarPersona;
	}

	public void setBtnEliminarPersona(JButton btnEliminarPersona) {
		this.btnEliminarPersona = btnEliminarPersona;
	}

	public JList<Persona> getListaPersonas() {
		return listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return this.listModelPersona;
	}

	public void cambiarVisibilidad(boolean state) {
		super.setVisible(state);
	}

	public static VentanaEliminarPersona getInstancia() {
		if (instancia == null || !instancia.isDisplayable()) {
			try {
				instancia = new VentanaEliminarPersona();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instancia;
	}
}