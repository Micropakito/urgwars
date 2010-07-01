/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.compartido;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Respuesta {
	private int intResult;
	private String strResult;
	private Message resp ;
	
	public Respuesta(int intResult, String strResult, Message resp ) {
		
		setIntResult(intResult);
		setStrResult(strResult);
		setResp(resp);
	
	}

	public void setIntResult(int intResult) {
		this.intResult = intResult;
	}

	public int getIntResult() {
		return intResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setResp(Message resp) {
		this.resp = resp;
	}

	public Message getResp() {
		return resp;
	}

	
}
