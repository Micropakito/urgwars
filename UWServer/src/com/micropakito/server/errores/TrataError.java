/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.server.errores;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TrataError {
	
	private int id;
	private String desc;
	private Exception ex;
	
	public TrataError () {}
	
	public TrataError (int id, String desc, Exception ex) {
		
		setId(id);
		setDesc(desc);
		setEx(ex);
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

	public Exception getEx() {
		return ex;
	}

	public void Trata () {
	
		//tratamiento del error. De momento sólo por pantalla.
        System.out.println("Mi descripcion:" + this.getDesc() );
		System.out.println ("Error Producido:" + this.ex.getMessage() );
		System.out.println ("Traza del error:" + this.ex.getStackTrace().toString() );
		System.out.println("\n");
		if ( this.getId() == 100 ) {
			//error fatal
			System.exit (0);
		}
		
	}

}
