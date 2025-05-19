package presentancion.vista;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import entidad.Persona;

public class PanelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;

	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> listModelPersona;
	private JScrollPane SCPeliminar;
	private JLabel lblEliminarUsuarios;
	private JButton btnEliminarPersona;
	private Persona personaSeleccionada;

	public PanelEliminarPersona() {
		setLayout(null);

		lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuarios.setBounds(25, 11, 150, 20);
		add(lblEliminarUsuarios);

		SCPeliminar = new JScrollPane();
		SCPeliminar.setBounds(25, 50, 245, 140);
		add(SCPeliminar);

		listModelPersona = new DefaultListModel<Persona>();
		listPersonas = new JList<Persona>(listModelPersona);
		SCPeliminar.setRowHeaderView(listPersonas);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listPersonas.setLayoutOrientation(JList.VERTICAL);

		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(280, 50, 100, 30);
		add(btnEliminarPersona);
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
}
