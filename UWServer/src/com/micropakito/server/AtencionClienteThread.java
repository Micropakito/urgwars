/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.server;

/**
 * @author userxp
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.io.*;
import java.net.*;

import com.micropakito.compartido.Message;
import com.micropakito.server.clientes.Cliente;
import com.micropakito.server.errores.TrataError;
import com.micropakito.server.paquete.Paquete;
import com.micropakito.server.utilidades.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

	
public class AtencionClienteThread extends Thread {

	Socket SockCliente;
	private ServerHilo srv;
	
	public AtencionClienteThread( Socket Cliente , ServerHilo srv ){

            SockCliente = Cliente;
            this.srv = srv; 
            this.start();

	}
			
    @Override
	public void run(){

            new Log("Nuevo Cliente en Servidor").Trata() ;

            try {

                Message messageObject ;

                do {
                    ObjectInputStream in  = new ObjectInputStream( SockCliente.getInputStream() );
                    messageObject = (Message)in.readObject();

                } while ( TrataMensaje ( messageObject ) ) ;

//                SockCliente.close();

            } catch (IOException e){

                new TrataError(200, "Error IO al recibir objeto", e).Trata();


            } catch (Exception ex) {

                new TrataError(200, "Error generico al recibir objeto", ex).Trata();

            }
	}

	public boolean TrataMensaje( Message ms ) {

            System.out.println("id del mensaje" + ms.getID() );
            //Trato como si fuera una accion de Struts.
            //Instancio la propia clase mapeada, y ejecuto siempre el mismo método.

            Paquete paq = new Paquete(ms.getID(), ms.getDesc(),  ms.getClase(), ms.getObjeto(), this.getSrv() );

            ObjectOutputStream salida;
            try {
                salida = new ObjectOutputStream( SockCliente.getOutputStream() );
                salida.writeObject( paq.getMsg() );
                salida.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(AtencionClienteThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            //PrintWriter output = new PrintWriter(s.getOutputStream());

            

            
//		switch ( ms.getID() ) {
//
//			case 1000: //login
//				//en caso de que se produzca un login correcto añado al array de clientes.
//				Login(ms);
//
//			case 2000: //
//
//		}
		return true;
	}
	
	/*
	 * sincronizado para que no se ataque a la vez al array de clientes
	 */
	private synchronized void anadeCliente ( Cliente cli ) {
		getSrv().getClientes().put( cli.getId(), cli );
	}
	
	public void enviaObjetoCliente ( Object Objeto ) {
		
        try {
            ObjectOutputStream out  = new ObjectOutputStream ( SockCliente.getOutputStream() );
            out.writeObject(Objeto);
        }
        catch (Exception ex) {
            new TrataError(200, "Error enviado objeto", ex ).Trata();
        }
	}

    /**
     * @return the srv
     */
    public ServerHilo getSrv() {
        return srv;
    }

    /**
     * @param srv the srv to set
     */
    public void setSrv(ServerHilo srv) {
        this.srv = srv;
    }
}
