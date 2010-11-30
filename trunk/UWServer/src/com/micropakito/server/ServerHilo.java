/*
 * Created on 10-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.server;


import java.net.*;
import java.util.ArrayList;

import com.micropakito.server.errores.TrataError;
import com.micropakito.server.utilidades.InfoServer;


/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ServerHilo extends Thread {
	
//	clientes conectados a este hilo del server
	ArrayList clientes = new ArrayList() ; 
	private Servidores servidores;
	
	private ServerSocket socketServidor ;
	private Socket socketCliente ;
        
// 	puerto del server	
	private int puerto ;
        private String nombre;
	/**
         * Constructor ServerHilo
         */
	public ServerHilo ( int puerto, Servidores servidores, int id ) {
               
		this.servidores = servidores;
                this.servidores.addServer(id, this);
                this.nombre = "Nombre: " + puerto;
                setPuerto(puerto);
		this.start();
		
	}
	public ArrayList getClientes () {
		return clientes;
	}
	public void setClientes (ArrayList clientes ) {
		this.clientes = clientes;
	}
		
	public static void main(String[] args) {}
	
	public void run(){
	
		//ServerSocket socketServidor = null;
		//Socket socketCliente = null;
            try {
                socketServidor = new ServerSocket ( this.getPuerto() );
                            //cargo información del servidor
                InfoServer is = new InfoServer( this );
                            //añado al arraylist con los hilos del servidor
                //this.getServidores().add( is.getId() , this );
                is.cargaInfo();
           }

            catch (Exception e){
                TrataError te = new TrataError( 100, "Error Arrancando Servidor", e );
                te.Trata();
            }

           // new Log("Servidor iniciado... (Socket TCP). Puerto de escucha:" + this.getPuerto()).TrataConTxtBox(this.getServidor().getTxtInfo() ); ;
             //System.out.println ("Servidor iniciado... (Socket TCP). Puerto de escucha:" + this.getPuerto() );
            while(true) {
                try {
                    setSocketCliente(socketServidor.accept());

                    System.out.println( "Cerrado ??" + socketServidor.isClosed() );

                    AtencionClienteThread cliente = new AtencionClienteThread( getSocketCliente() , this );
                }
                catch (Exception e) {
                    new TrataError(200, "Error Aceptando Cliente", e).Trata();
                    //socketServidor.close();
                }
            }
	}
        public void Parar() {
            try {
                this.getSocketServidor().close();
               // new Log("Servidor detenido" + this.getPuerto() ).TrataConTxtBox(this.getServidor().getTxtInfo() ); ;
            }
            catch (Exception ex) {
               // new Log("Error Parando Servidor: " + ex.getMessage() ).TrataConTxtBox(this.getServidor().getTxtInfo() ); ;
            }

        }
	public void setSocketServidor(ServerSocket socketServidor) {
		this.socketServidor = socketServidor;
	}

	public ServerSocket getSocketServidor() {
		return socketServidor;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setSocketCliente(Socket socketCliente) {
		this.socketCliente = socketCliente;
	}

	public Socket getSocketCliente() {
		return socketCliente;
	}

    public Servidores getServidores() {
        return servidores;
    }

    public void setServidores(Servidores servidores) {
        this.servidores = servidores;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
}
