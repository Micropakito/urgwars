/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.compartido;

import java.io.Serializable;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Message implements Serializable {
	
	private int ID      ; // código que identifica el mensaje
	private String desc ; // descripcion del mensaje
	private Class clase ; // clase del objeto
	private Object objeto; // objeto enviado
	
	public Message ( int ID, String desc, Class clase, Object objeto ) {

		setID(ID);
		setDesc(desc);
		setClase(clase);
		setObjeto(objeto);
		
	}
        public Message ( ) { }
	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setClase(Class clase) {
		this.clase = clase;
	}

	public Class getClase() {
		return clase;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public Object getObjeto() {
		return objeto;
	}

}

