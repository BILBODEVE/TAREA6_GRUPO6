package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentancion.vista.VentanaAgregarPersona;
import presentancion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregarPersona ventanaAgregarPersona;

	
	public Controlador(VentanaPrincipal vPrincipal) {
	
		ventanaPrincipal= vPrincipal;		
		ventanaPrincipal.getMnitemAgregar().addActionListener(a->EventoClickMenu_AgregarPersona(a));
		
	}	

	public void EventoClickMenu_AgregarPersona(ActionEvent a) {
		
		ventanaAgregarPersona= VentanaAgregarPersona.getInstancia();
		ventanaAgregarPersona.cambiarVisibilidad(true);
	
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
