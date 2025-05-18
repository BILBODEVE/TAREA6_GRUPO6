package presentancion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu jmenuPersona;
	private JMenuItem mnitemAgregar;
	private JMenuItem mnitemModificar;
	private JMenuItem mnitemEliminar;
	private JMenuItem mnitemListar;
	private JLabel lblTitulo;
	
	public VentanaPrincipal() {
		setTitle("Agenda");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); //centra la ventana

		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);

		jmenuPersona = new JMenu("Persona");
		menuBar.add(jmenuPersona);

		mnitemAgregar = new JMenuItem("Agregar");
		jmenuPersona.add(mnitemAgregar);

		mnitemModificar = new JMenuItem("Modificar");
		jmenuPersona.add(mnitemModificar);

		mnitemEliminar = new JMenuItem("Eliminar");
		jmenuPersona.add(mnitemEliminar);

		mnitemListar = new JMenuItem("Listar");
		jmenuPersona.add(mnitemListar);
		panel.add(menuBar);

		lblTitulo = new JLabel("Bienvenido al registro de personas");
		lblTitulo.setBounds(33, 105, 367, 61);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblTitulo);
	}
	
	public JMenuItem getMnitemAgregar() {
		return mnitemAgregar;
	}

	public void setMnitemAgregar(JMenuItem mnitemAgregar) {
		this.mnitemAgregar = mnitemAgregar;
	}

	public JMenuItem getMnitemModificar() {
		return mnitemModificar;
	}


	public JMenuItem getMnitemEliminar() {
		return mnitemEliminar;
	}

	public void setMnitemEliminar(JMenuItem mnitemEliminar) {
		this.mnitemEliminar = mnitemEliminar;
	}

	public JMenuItem getMnitemListar() {
		return mnitemListar;
	}

	public void setMnitemListar(JMenuItem mnitemListar) {
		this.mnitemListar = mnitemListar;
	}

	public void setVisible(boolean state) {
		super.setVisible(state);
	}
}
