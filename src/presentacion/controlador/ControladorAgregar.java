package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.PanelAgregarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorAgregar implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona panelAgregarPersona;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();
	private ArrayList<Persona> listaPersonas;

	public ControladorAgregar(VentanaPrincipal vPrincipal) {
		this.ventanaPrincipal = vPrincipal;

		panelAgregarPersona = new PanelAgregarPersona();
		ventanaPrincipal.getPanelContenido().add(panelAgregarPersona, "AGREGAR");

		ventanaPrincipal.getMnitemAgregar().addActionListener(a -> EventoClickMenu_AgregarPersona(a));
	}

	public void EventoClickMenu_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanelContenido(), "AGREGAR");

		panelAgregarPersona.getBtnAceptar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarPersona();
			}
		});
	}

	private void agregarPersona() {
		String nombre = panelAgregarPersona.getTxtNombre().getText().trim();
		String apellido = panelAgregarPersona.getTxtApellido().getText().trim();
		String dni = panelAgregarPersona.getTxtDni().getText().trim();
		PersonaNegocioImpl pni = new PersonaNegocioImpl();

		// Validación de campos vacíos
		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Verificar si ya existe el DNI
		if (pni.verificarPersonaExiste(dni)) {
			JOptionPane.showMessageDialog(null, "El DNI ingresado ya se encuentra registrado.",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Crear persona y setear atributos
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDNI(dni);

		// Insertar persona
		boolean exito = personaNegocio.insert(persona);

		if (exito) {
			JOptionPane.showMessageDialog(null, "Persona agregada con éxito.");
			limpiarTxts();
		} else {
			JOptionPane.showMessageDialog(null, "Error al agregar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}
	
	public void limpiarTxts() {
		panelAgregarPersona.getTxtNombre().setText("");
		panelAgregarPersona.getTxtApellido().setText("");
		panelAgregarPersona.getTxtDni().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
