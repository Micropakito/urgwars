/*
 * Created on 04-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.server.utilidades;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Log {
	
	private String mensaje;
	
	public Log() {}
	
	public Log(String mensaje) {
		setMensaje(mensaje);
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void Trata() {
		//Tratamiento del Log (almacenar fichero etc)
		System.out.println( this.getMensaje() );
	}
        public void TrataConTxtBox(javax.swing.JTextArea txtInfo) {
		//Tratamiento del Log (almacenar fichero etc)
		System.out.println( this.getMensaje() );
                //txtInfo.append( this.getMensaje() + "\n" );
	}
}
