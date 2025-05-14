package main;

import presentacion.controlador.Controlador;
import presentancion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Controlador controlador= new Controlador(ventanaPrincipal);
		controlador.inicializar();
	}
		
}
