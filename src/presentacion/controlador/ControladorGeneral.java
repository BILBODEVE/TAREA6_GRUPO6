package presentacion.controlador;

import presentancion.vista.VentanaPrincipal;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class ControladorGeneral {

	private VentanaPrincipal ventanaPrincipal;
	private ControladorAgregar controladorAgregar;
	private ControladorModificar controladorModificar;
	private ControladorEliminar controladorEliminar;
	private ControladorListar controladorListar;

	public ControladorGeneral() {
		ventanaPrincipal = new VentanaPrincipal();

		controladorAgregar = new ControladorAgregar(ventanaPrincipal);
		controladorModificar = new ControladorModificar(ventanaPrincipal);
		controladorEliminar = new ControladorEliminar(ventanaPrincipal);
		controladorListar = new ControladorListar(ventanaPrincipal);

		inicializar();
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}

	public static void cargarModal(ArrayList<Persona> personas, DefaultListModel<Persona> modal) {
		modal.removeAllElements();
		if (personas != null) {
			for (Persona persona : personas) {
				modal.addElement(persona);
			}
		}
	}
}
