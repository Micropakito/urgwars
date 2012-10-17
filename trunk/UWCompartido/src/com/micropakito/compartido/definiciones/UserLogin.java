/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.compartido.definiciones;

import java.io.Serializable;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserLogin implements Serializable {

	private String login ;
	private String pass;
        private String server;
	
	public UserLogin (String login, String pass ) {
	
		setLogin(login);
		setPass(pass);
        	
	}
        public UserLogin (String login, String pass, String server ) {
	
		setLogin(login);
		setPass(pass);
                setServer(server);
		
	}
        public UserLogin() {


        }

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

        /**
        * @return the server
        */
        public String getServer() {
            return server;
        }

        /**
        * @param server the server to set
        */
        public void setServer(String server) {
            this.server = server;
        }

}
