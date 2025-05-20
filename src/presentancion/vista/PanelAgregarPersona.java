package presentancion.vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;

	public PanelAgregarPersona() {

		setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(86, 11, 80, 21);
		add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(86, 55, 49, 14);
		add(lblApellido);

		lblDni = new JLabel("DNI");
		lblDni.setBounds(86, 97, 49, 14);
		add(lblDni);

		txtNombre = new JTextField();
		txtNombre.setBounds(218, 11, 136, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ' || txtNombre.getText().length() >= 45) {
					e.consume(); // Con esto ignora el caracter si no cumple las condiciones necesarias
				}
			}
		});

		txtApellido = new JTextField();
		txtApellido.setBounds(218, 52, 136, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ' || txtApellido.getText().length() >= 45) {
					e.consume();
				}
			}
		});

		txtDni = new JTextField();
		txtDni.setBounds(218, 94, 136, 20);
		add(txtDni);
		txtDni.setColumns(10);
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || txtDni.getText().length() >= 20) {
					e.consume();
				}
			}
		});

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(157, 137, 89, 23);
		add(btnAceptar);
	}

	// Getters
	public JButton getBtnAceptar() {
		return btnAceptar;
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
}
