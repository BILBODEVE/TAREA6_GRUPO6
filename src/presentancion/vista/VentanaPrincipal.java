package presentancion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private static final long serialVersionUID = 1L;
	private JFrame ventana;
	private JPanel panelContenido;
	private CardLayout cardLayout;
	private JMenuBar menuBar;
	private JMenu jmenuPersona;
	private JMenuItem mnitemAgregar;
	private JMenuItem mnitemModificar;
	private JMenuItem mnitemEliminar;
	private JMenuItem mnitemListar;
	private JLabel lblTitulo;
	
	public VentanaPrincipal() {
		
		ventana = new JFrame();
		ventana.setTitle("Agenda");
		ventana.setBounds(100, 100, 452, 455);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
			
		cardLayout = new CardLayout();
		panelContenido = new JPanel(cardLayout);
		panelContenido.setBounds(0, 0, 438, 396); 
		ventana.getContentPane().add(panelContenido);

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
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setLayout(null);

		lblTitulo = new JLabel("Bienvenido al registro de personas");
		lblTitulo.setBounds(33, 105, 367, 61);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBienvenida.add(lblTitulo);

		panelContenido.add(panelBienvenida, "BIENVENIDA");
		
		ventana.setJMenuBar(menuBar);
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
		this.ventana.setVisible(state);
	}
	
	public JPanel getPanelContenido() {
	    return panelContenido;
	}

	public CardLayout getCardLayout() {
	    return cardLayout;
	}
}
