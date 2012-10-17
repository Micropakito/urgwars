/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.utilidades;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micropakito
 */
public class TrataFechas {

    /*
     recibe la fecha en formato dd-mm-yyyy
     */
    public static Date convierteMysqJava(String fecha){
        try {
            DateFormat formatter ;
            Date date ;
            formatter = new SimpleDateFormat("dd-MM-yyyy");

            date = (Date) formatter.parse(fecha);
            return date;

        } catch (ParseException ex) {
            return null;
        }
    
    }
    //devuelve una fecha en formato dd-mm-yyyy
    public static String convierteJavaMySql(Date fecha){

        return fecha.getDay() + "-" + fecha.getMonth() + "-" +fecha.getYear() ;

    }

}
