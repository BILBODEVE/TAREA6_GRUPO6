package presentancion.vista;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;

public class PanelListarPersonas extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JList<Persona> listaPersonas;
	private DefaultListModel<Persona> modelLista;
	private JScrollPane scroll;

	public PanelListarPersonas() {
		setLayout(null);

		lblTitulo = new JLabel("Listado de personas registradas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(90, 20, 300, 30);
		add(lblTitulo);

		modelLista = new DefaultListModel<>();
		listaPersonas = new JList<>(modelLista);
		listaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scroll = new JScrollPane(listaPersonas);
		scroll.setBounds(30, 70, 350, 180);
		add(scroll);
	}

	public DefaultListModel<Persona> getModel() {
		return modelLista;
	}

	public JList<Persona> getLista() {
		return listaPersonas;
	}
}
