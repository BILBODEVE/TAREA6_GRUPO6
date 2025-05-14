package presentancion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaAgregarPersona extends JFrame {

	private static final long serialVersionUID = 1L;
	private static VentanaAgregarPersona instancia;
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;

	private VentanaAgregarPersona() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		agregarControles();		
	}
	
	private void agregarControles() {
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(88, 54, 80, 21);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(88, 98, 49, 14);
		contentPane.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(88, 140, 49, 14);
		contentPane.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(210, 54, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(210, 95, 96, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(210, 137, 96, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(135, 182, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public void cambiarVisibilidad(boolean state) {
		super.setVisible(state);
	}
	
	public static VentanaAgregarPersona getInstancia() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VentanaAgregarPersona();
        }
        return instancia;
    }
}
