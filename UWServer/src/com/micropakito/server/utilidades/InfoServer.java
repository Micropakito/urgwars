/*
 * Created on 10-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.server.utilidades;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.micropakito.server.ServerHilo;
import com.micropakito.server.errores.TrataError;


import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;



/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class InfoServer {

	private int id;
	private int puerto;
	private String nombre;
	private String descripcion;
	private int maxPlayers;
	ServerHilo hiloServidor;
		
	public InfoServer (int id, int puerto, String nombre, String descripcion, int maxPlayers) {
	
		this.id = id;
		this.puerto = puerto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.maxPlayers = maxPlayers;
	
	}
	
	public InfoServer( ServerHilo hiloServidor ) {
		
		this.hiloServidor = hiloServidor;
		this.id = hiloServidor.getPuerto() - Constantes.puertoInicio;
        System.out.println("id server ->" + this.id );
		this.puerto = hiloServidor.getPuerto();
	}
	/**
	 * Funcion que carga el fichero de configuración del servidor. 
	 * Será un fichero properties con el mismo nombre que el id pasado.
	 *
	 * * */
	public void cargaInfo ( ) {
		try {
			SAXBuilder builder = new SAXBuilder(false); 
			Document doc=builder.build("ConfigServer.xml");
			Element raiz = doc.getRootElement();
			//System.out.println(raiz.getAttributeValue("txt"));
			
			List equipos = raiz.getChildren("server");
			Iterator it = equipos.iterator();
			while ( it.hasNext() ) {
			
				Element elmnt = ( Element ) it.next();
				
				if ( elmnt.getAttribute("id").getValue().equals( Integer.toString( this.getId() ) ) ) {
					setNombre(elmnt.getChild("nombre").getText());
					setDescripcion(elmnt.getChild("desc").getText());
					setMaxPlayers( Integer.parseInt(elmnt.getChild("max_player").getText()) );
				}
			}
		}
		
		catch (Exception e){
		
			TrataError te = new TrataError( 300, "Imposible parsear xml configuarcion server", e );
		
		}
		
				
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

}
