package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.VentanaModificarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorModificar implements ActionListener {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaModificarPersona ventanaModificar;
	private ArrayList<Persona> listaPersonas;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();

	public ControladorModificar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		ventanaModificar = VentanaModificarPersona.getInstancia();
		ventanaPrincipal.getMnitemModificar().addActionListener(e -> {
			ventanaModificar.setVisible(true);
			cargarModal();
		});

		configurarListeners();
	}

	private void configurarListeners() {
		// Si se selecciona una persona de la lista:
		ventanaModificar.getListaPersonas().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Persona personaSeleccionada = ventanaModificar.getListaPersonas().getSelectedValue();
				if (personaSeleccionada != null) {
					cargarDatosPersona(personaSeleccionada);
				}
			}
		});

		// Btn Modificar
		ventanaModificar.getBtnModificar().addActionListener(e -> {
			Persona personaSeleccionada = ventanaModificar.getPersonaSeleccionada();
			if (personaSeleccionada == null) {
				JOptionPane.showMessageDialog(ventanaModificar, "Debe seleccionar una persona para modificar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			modificarPersona(personaSeleccionada);
		});
	}

	private void cargarDatosPersona(Persona persona) {
		ventanaModificar.getTxtNombre().setText(persona.getNombre());
		ventanaModificar.getTxtApellido().setText(persona.getApellido());
		ventanaModificar.getTxtDni().setText(persona.getDNI());
	}

	private void modificarPersona(Persona persona) {
		String nombre = ventanaModificar.getTxtNombre().getText();
		String apellido = ventanaModificar.getTxtApellido().getText();
		String dni = ventanaModificar.getTxtDni().getText();

		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
			JOptionPane.showMessageDialog(ventanaModificar, "Todos los campos son obligatorios.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDNI(dni);

		boolean exito = personaNegocio.update(persona);

		if (exito) {
			JOptionPane.showMessageDialog(ventanaModificar, "Persona modificada con éxito.");
			cargarModal();
		} else {
			JOptionPane.showMessageDialog(ventanaModificar, "Error al modificar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
		;
	}

	private void cargarModal() {
		listaPersonas = personaNegocio.obtenerPersonas();
		ControladorGeneral.cargarModal(listaPersonas, ventanaModificar.getModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
