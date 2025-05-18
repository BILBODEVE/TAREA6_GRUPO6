package presentancion.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import entidad.Persona;

public class VentanaModificarPersona extends JFrame {
	private static final long serialVersionUID = 1L;
	private static VentanaModificarPersona instancia;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> listModelPersona;
	private JScrollPane scrollPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;

	public VentanaModificarPersona() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null); // centra la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setBounds(0, 0, 400, 400);
		
		agregarControles();
	}

	private void agregarControles() {
		lblTitulo = new JLabel("Seleccione la persona que desea modificar:");
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

		txtNombre = new JTextField();
		txtNombre.setBounds(10, 291, 96, 20);
		contentPane.add(txtNombre);
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
		txtApellido.setBounds(122, 291, 96, 20);
		contentPane.add(txtApellido);
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
		txtDni.setBounds(231, 291, 96, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		txtDni.setEditable(false);
		txtDni.setBackground(Color.WHITE);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(279, 331, 89, 23);
		contentPane.add(btnModificar);
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

	public void cambiarVisibilidad(boolean state) {
		super.setVisible(state);
	}

	public static VentanaModificarPersona getInstancia() {
		if (instancia == null || !instancia.isDisplayable()) {
			try {
				instancia = new VentanaModificarPersona();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instancia;
	}
}
