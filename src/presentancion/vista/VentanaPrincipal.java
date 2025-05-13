package presentancion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal {

	private static final long serialVersionUID = 1L;
	private JFrame ventana;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setTitle("Agenda");
		ventana.setBounds(100, 100, 450, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		ventana.getContentPane().add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);

		JMenu jmenuPersona = new JMenu("Persona");
		menuBar.add(jmenuPersona);

		JMenuItem mnitemAgregar = new JMenuItem("Agregar");
		jmenuPersona.add(mnitemAgregar);

		JMenuItem mnitemModificar = new JMenuItem("Modificar");
		jmenuPersona.add(mnitemModificar);

		JMenuItem mnitemEliminar = new JMenuItem("Eliminar");
		jmenuPersona.add(mnitemEliminar);

		JMenuItem mnitemListar = new JMenuItem("Listar");
		jmenuPersona.add(mnitemListar);
		panel.add(menuBar);

		JLabel lblTitulo = new JLabel("Bienvenido al registro de personas");
		lblTitulo.setBounds(33, 105, 367, 61);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblTitulo);
	}

	public void setVisible(boolean state) {
		this.ventana.setVisible(state);
	}
}
