package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.PanelModificarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorModificar implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelModificarPersona panelModificar;
	private ArrayList<Persona> listaPersonas;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();

	public ControladorModificar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;

		this.panelModificar = new PanelModificarPersona();
		this.ventanaPrincipal.getPanelContenido().add(panelModificar, "MODIFICAR");

		ventanaPrincipal.getMnitemModificar().addActionListener(e -> {
			ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanelContenido(), "MODIFICAR");
			cargarModal();
		});

		configurarListeners();
	}

	private void configurarListeners() {
		panelModificar.getListaPersonas().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Persona personaSeleccionada = panelModificar.getListaPersonas().getSelectedValue();
					if (personaSeleccionada != null) {
						panelModificar.setPersonaSeleccionada(personaSeleccionada);
						cargarDatosPersona(personaSeleccionada);
					}
				}
			}
		});

		// Botón Modificar
		panelModificar.getBtnModificar().addActionListener(e -> {
			Persona personaSeleccionada = panelModificar.getPersonaSeleccionada();
			if (personaSeleccionada == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una persona para modificar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			modificarPersona(personaSeleccionada);
		});
	}

	private void cargarDatosPersona(Persona persona) {
		panelModificar.getTxtNombre().setText(persona.getNombre());
		panelModificar.getTxtApellido().setText(persona.getApellido());
		panelModificar.getTxtDni().setText(persona.getDNI());
	}

	private void modificarPersona(Persona persona) {
		String nombre = panelModificar.getTxtNombre().getText();
		String apellido = panelModificar.getTxtApellido().getText();
		String dni = panelModificar.getTxtDni().getText();

		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDNI(dni);

		boolean exito = personaNegocio.update(persona);

		if (exito) {
			JOptionPane.showMessageDialog(null, "Persona modificada con éxito.");
			cargarModal(); // Refrescar lista
		} else {
			JOptionPane.showMessageDialog(null, "Error al modificar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarModal() {
		listaPersonas = personaNegocio.obtenerPersonas();
		ControladorGeneral.cargarModal(listaPersonas, panelModificar.getModel());
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
