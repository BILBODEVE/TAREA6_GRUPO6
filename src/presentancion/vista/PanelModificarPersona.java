package presentancion.vista;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entidad.Persona;

public class PanelModificarPersona extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> listModelPersona;
	private JScrollPane scrollPane;
	private Persona personaSeleccionada;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;

	public PanelModificarPersona() {
		setLayout(null);
		setBounds(0, 0, 461, 400);

		lblTitulo = new JLabel("Seleccione la persona que desea modificar:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(10, 11, 271, 25);
		add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 421, 140);
		add(scrollPane);

		listModelPersona = new DefaultListModel<Persona>();
		listPersonas = new JList<Persona>(listModelPersona);
		scrollPane.setViewportView(listPersonas);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listPersonas.setLayoutOrientation(JList.VERTICAL);

		txtNombre = new JTextField();
		txtNombre.setBounds(10, 221, 96, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ' || txtNombre.getText().length() >= 45) {
					e.consume();
				}
			}
		});

		txtApellido = new JTextField();
		txtApellido.setBounds(116, 221, 96, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ' || txtApellido.getText().length() >= 45) {
					e.consume();
				}
			}
		});

		txtDni = new JTextField();
		txtDni.setBounds(222, 221, 96, 20);
		add(txtDni);
		txtDni.setColumns(10);
		txtDni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || txtDni.getText().length() >= 20) {
					e.consume();
				}
			}
		});

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(342, 220, 89, 23);
		add(btnModificar);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public Persona getPersonaSeleccionada() {
		return listPersonas.getSelectedValue();
	}

	public void setPersonaSeleccionada(Persona persona) {
		this.personaSeleccionada = persona;
	}

	public JList<Persona> getListaPersonas() {
		return listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return this.listModelPersona;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
}
