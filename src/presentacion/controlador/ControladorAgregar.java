package presentacion.controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

import presentancion.vista.VentanaAgregarPersona;
import presentancion.vista.VentanaModificar;
import presentancion.vista.VentanaPrincipal;

public class ControladorAgregar implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregarPersona ventanaAgregarPersona;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();
	private DefaultListModel<Persona> listaPersonas;

	
	public ControladorAgregar(VentanaPrincipal vPrincipal, DefaultListModel<Persona> listaPersonas) {
        this.ventanaPrincipal = vPrincipal;
        this.listaPersonas = listaPersonas;		
		ventanaPrincipal.getMnitemAgregar().addActionListener(a->EventoClickMenu_AgregarPersona(a));
	}	

	public void EventoClickMenu_AgregarPersona(ActionEvent a) {
		
		ventanaAgregarPersona= VentanaAgregarPersona.getInstancia();
		ventanaAgregarPersona.cambiarVisibilidad(true);
		
		ventanaAgregarPersona.getBtnAceptar().addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            agregarPersona();
	        }
	    });
	
	}
	
	private void agregarPersona() {
        String nombre = ventanaAgregarPersona.getTxtNombre().getText();
        String apellido = ventanaAgregarPersona.getTxtApellido().getText();
        String dni = ventanaAgregarPersona.getTxtDni().getText();
        PersonaNegocioImpl pni= new PersonaNegocioImpl();
        

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(ventanaAgregarPersona, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(pni.verificarPersonaExiste(dni)) {
        	JOptionPane.showMessageDialog(ventanaAgregarPersona, "El DNI ingresado ya se encuentra registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        	return;
        }

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDNI(dni);

        boolean exito = personaNegocio.insert(persona);

        if (exito) {
            JOptionPane.showMessageDialog(ventanaAgregarPersona, "Persona agregada con éxito.");
            ventanaAgregarPersona.dispose(); // o ventanaAgregarPersona.cambiarVisibilidad(false);
        } else {
            JOptionPane.showMessageDialog(ventanaAgregarPersona, "Error al agregar la persona.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	

	public void inicializar()
	{
		ventanaPrincipal.setVisible(true);;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
