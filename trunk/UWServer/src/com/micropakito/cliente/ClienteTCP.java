/*
 * Created on 02-sep-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.micropakito.cliente;

/**
 * @author userxp
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.net.*;

import java.io.*;

import com.micropakito.compartido.Message;
import com.micropakito.compartido.definiciones.UserLogin;

public class ClienteTCP {

	public static void main (String[] argumentos)throws IOException {
	
		Socket cliente = null;
		PrintWriter escritor = null;
		BufferedReader lector = null;
		String DatosEnviados = null;
		String maquina;
		int puerto;
		
		ObjectOutputStream out; 
		Message messageObject ;
		
		BufferedReader DatosTeclado = new BufferedReader ( new InputStreamReader (System.in));
	
		if (argumentos.length !=2){
	
			maquina = "localhost";
			puerto = 12346;
	
			System.out.println ("Establecidos valores por defecto:\nEQUIPO = localhost\nPORT = 12345");
		}
	
		else {
			maquina = argumentos [0];
			Integer pasarela = new Integer (argumentos[1]);
			puerto = pasarela.parseInt(pasarela.toString());
			System.out.println ("Conectado a " + maquina + " en puerto: " + puerto);
		}
		try { 
			cliente = new Socket (maquina , puerto);
		}
		catch (Exception e) {
	
			System.out.println ("Fallo : "+ e.toString());
			System.exit (0);
	
		}
	
		try {
	
			out = new ObjectOutputStream(cliente.getOutputStream());
			UserLogin ul = new UserLogin( "micropakito", "passmicro" );
			Message ms = new Message( 1000 , "Vamos a logarnos", Class.forName("com.micropakito.compartido.definiciones.UserLogin"), ul );

			out.writeObject( ms );
			out.flush();

			ObjectInputStream in  = new ObjectInputStream( cliente.getInputStream() );
			messageObject = (Message)in.readObject();
			
			
			
		}
		catch (Exception e){
	
			System.out.println ("Fallo : "+ e.toString());
	
			cliente.close();
	
			System.exit (0);
	
		}
	
		do{
	
			DatosEnviados = DatosTeclado.readLine();
	
			escritor.println (DatosEnviados);
	
			if (!DatosEnviados.equals("FIN")){
	
				System.out.println (lector.readLine());
				System.out.println (lector.readLine());
				System.out.println (lector.readLine());
				System.out.println (lector.readLine());
				System.out.println (lector.readLine());
	
			}
	
		}
		while (!DatosEnviados.equals("FIN"));
	
		System.out.println ("Finalizada conexión con el servidor");
	
		try {
			escritor.close();
		} 
		catch (Exception e){
		
		}
	
	}
}