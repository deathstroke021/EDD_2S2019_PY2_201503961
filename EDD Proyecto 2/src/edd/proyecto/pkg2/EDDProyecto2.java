/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto.pkg2;

/**
 *
 * @author Fernando Armira
 */
public class EDDProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login log = new Login();
        log.setVisible(true);
        
        hash h = new hash();
        
        h.insertar("luis", "int", "Barcelona", "15");
        h.insertar("dale", "float", "Madrid", "20");
        h.insertar("llamas", "int", "Barcelona", "15");
        h.insertar("todo", "float", "Madrid", "20");
        h.insertar("tengomiedo", "int", "Barcelona", "15");
        h.insertar("error", "float", "Madrid", "20");
        h.insertar("tmp", "int", "Barcelona", "15");
        h.insertar("tevas", "float", "Madrid", "20");
        h.insertar("tmp", "int", "Barcelona", "15");
        h.insertar("varl", "float", "Madrid", "20");
        h.insertar("sinpensar", "int", "Barcelona", "15");
        h.insertar("como va", "float", "Madrid", "20");
        h.insertar("yoes", "int", "Barcelona", "15");
        h.insertar("cora", "float", "Madrid", "20");
        h.insertar("palpito", "int", "Barcelona", "15");
        h.insertar("delito", "float", "Madrid", "20");
        h.insertar("matar", "int", "Barcelona", "15");
        h.insertar("mDA", "float", "Madrid", "20");
        h.insertar("GOMEZ", "int", "Barcelona", "15");
        
        
        nodoHash tmp = h.extraerNodo("llamas");
        System.out.println(tmp.nombrevar +" "+ tmp.ambito + " " + tmp.tipo );
        tmp = h.extraerNodo("luis");
        System.out.println(tmp.nombrevar +" "+ tmp.ambito + " " + tmp.tipo );
        if(tmp==null){
            System.out.println("vacio");
        }
        
        System.out.println("**************************HASH 2******************************************");
        
        hash2 h2 = new hash2(19);
        h2.insert("Apple");
        h2.insert("Aelpp");
        h2.displayTable();
        System.out.println(h2.find("Apple"));
                
                
        
    }
    
}
