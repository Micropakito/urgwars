/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.cliente.internacional;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Texto {

	private Locale currentLocale;
	private ResourceBundle messages;
	
	private String language ;
	private String country ;

	public Texto() {}
	
	public Texto (String language, String country ){
	
		setLanguage(language);
		setCountry(country); 
		Config();
	}

	public void Config () {
	
		setCurrentLocale(new Locale(this.getLanguage(), this.getCountry() ));

	}

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setMessages(ResourceBundle messages) {
		this.messages = messages;
	}

	public ResourceBundle getMessages() {
		return messages;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
	
	public String dameTexto( String recurso, String clave ){
	
		messages = ResourceBundle.getBundle( recurso, currentLocale );
		return messages.getString(clave);
		
	}
	public String dameTexto(String clave) {
		return messages.getString(clave);
	}
	
	public static void main (String[] argumentos) {
	
		Texto tx = new Texto("us", "EN");
		System.out.println( tx.dameTexto("textoGenerico", "nombre") );
	
	}		
		
}
