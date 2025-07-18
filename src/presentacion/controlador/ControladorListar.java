package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.PanelListarPersonas;
import presentancion.vista.VentanaPrincipal;

public class ControladorListar implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelListarPersonas panelListar;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();

	public ControladorListar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;

		panelListar = new PanelListarPersonas();
		ventanaPrincipal.getPanelContenido().add(panelListar, "LISTAR");

		ventanaPrincipal.getMnitemListar().addActionListener(e -> {
			cargarPersonas();
			ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanelContenido(), "LISTAR");
		});
	}

	private void cargarPersonas() {		
		DefaultTableModel modelo = panelListar.getModel();
		modelo.setRowCount(0);

		ArrayList<Persona> personas = personaNegocio.obtenerPersonas();
		for (Persona p : personas) {
			modelo.addRow(new Object[] { p.getNombre(), p.getApellido(), p.getDNI() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}