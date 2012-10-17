/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.utilidades;


import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;



/**
 *
 * @author Micropakito
 */
public class LeeXML {

    private Document documento = null;
    private String xml = null;

    public LeeXML (String xml) {

        this.xml = xml;

    }

    public String getClass(String id) {

          try {
                SAXBuilder builder=new SAXBuilder(false);
                //usar el parser Xerces y no queremos
                //que valide el documento
                Document doc  = builder.build(this.getXml());
                //construyo el arbol en memoria desde el fichero
                // que se lo pasaré por parametro.
                Element raiz=doc.getRootElement();
                //cojo el elemento raiz
//                System.out.println("La liga es de tipo:"+
//                            raiz.getAttributeValue("tipo"));
                //todos los hijos que tengan como nombre plantilla
                List acciones = raiz.getChildren("action-mapping");
                Iterator i = acciones.iterator();
                while (i.hasNext()){
                    Element e= (Element)i.next();
                    //primer hijo que tenga como nombre club
                    if (e.getAttribute("id").getValue().equals(id)) {
                        Element clase = e.getChild("class");
                        return clase.getText();
                    }
                   // Element clase = e.getChild("class");
                   // System.out.println("clase" + clase.getText());
                    
                }
                // Dejamos de mano del lector el sacar el nombre
                //de los arbitros, animate!!
             }catch (Exception e){
                e.printStackTrace();
             }

        return null;
     }

    /**
     * @return the documento
     */
    public Document getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Document documento) {
        this.documento = documento;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * @param xml the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }


}
