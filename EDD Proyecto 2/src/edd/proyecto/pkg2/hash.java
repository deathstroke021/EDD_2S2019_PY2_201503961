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

//UTIL: ASCII, USUARIO UNICO, REHASH

class nodoHash {
    char estado;
    String nombrevar;
    String tipo;
    String ambito;
    String valor;
    
    public nodoHash(String nombrevar, String Tipo, String Ambito, String Valor){
        this.nombrevar = nombrevar;
        this.tipo = Tipo;
        this.ambito = Ambito;
        this.valor = Valor;
    }
    
    
    
}

public class hash {
    
    private int tamano;
    private static int[]tamanos;
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float factorUtil;
    private nodoHash[] vectorHash;
    
    public hash() {
    this.tamanos = new int[] {23,29,37,47,59,59,67,73,79,83,89,97,103,107,113,127,137,149,157,167,179,197,211,227,239,251,263,277,293,311,997};
    this.indiceTam = 0;
    this.ocupados = 0;
    this.factorUtil =  65.0f;
    this.tamano = tamanos[indiceTam];
    this.vectorHash = new nodoHash[tamano];
    this.porcentajeUtil = calcularPorcentajeUtil();
    
    
}
      
    private int DobleHashing(String id, int factor){
        int tmp=generarClave(id);
        return funcion1(tmp)+(factor*funcion2(tmp)%tamano);
        
    }
    
    private float calcularPorcentajeUtil(){
        return (ocupados * 100)/tamano;
    }
    
    private int funcion1(int clave){
        return clave%tamano;
    }
    
    private int funcion2(int clave){
        return 1+(clave%(tamano-1));
    }
    
    private int generarClave(String id){
        String codigo="";
        int tmp = 0;
        for(int i=0; i<id.length();i++){
            codigo+=id.codePointAt(i);
        }
        
        if(codigo.length()>9){
            return reduccion(codigo);
 
        }
        else{
            return Integer.parseInt(codigo);
        }
        
    }
    
    private int reduccion(String codigo){
        int tmp = 0;
        while(codigo.length()>9){
            String aux = "";
            for(int i=0;i<codigo.length()/2;i++){
                aux+=codigo.charAt(i);
            }
            if (aux.length()>9){
                tmp=reduccion(aux);
                aux="";
            }
            else{
                tmp = Integer.parseInt(aux);
                aux="";
            }
            
            for(int i=codigo.length()/2;i<codigo.length();i++){
                aux+=codigo.charAt(i);
            }
            if (aux.length()>9){
                tmp=reduccion(aux);
                aux="";
            }
            else{
                tmp = Integer.parseInt(aux);
                aux="";
            }
            
            codigo = tmp+"";
        }
        return tmp;
        
    }
    
    public void insertar(String nombreVar, String Tipo, String Ambito, String Valor){
        boolean insertado = false;
        if(porcentajeUtil<=65.00f){
            for(int i=0;i<tamano;i++){
                int posicion = DobleHashing(nombreVar,i);
                
                if(posicion>tamano){
                    posicion-=tamano;
                }
                
                if(vectorHash[posicion]==null || vectorHash[posicion].estado == 'b'){
                    vectorHash[posicion] = new nodoHash(nombreVar, Tipo, Ambito, Valor);
                    ocupados+=1;
                    porcentajeUtil=calcularPorcentajeUtil();
                    insertado = true;
                    break;               
                }
                else{
                    
                    if(vectorHash[posicion].nombrevar.equals(nombreVar)){
                        System.out.println("La variable a insertar ya existe en la tabla: " + nombreVar);  
                    break;             
                }
                    else{
                        System.out.println("Colision en la posicion: " + posicion);
                        
                    }
                    
                }
            }
            if(insertado==true){
                System.out.println("Se inserto correcatmente el dato " + nombreVar);
                
            }
            else{
                System.out.println("No se pudo insertar el dato: " + nombreVar);
            }
        }
        else{
            System.out.println("Hacer rehashing - > porcentaje util: " + porcentajeUtil);
            rehashing();
            insertar(nombreVar, Tipo, Ambito, Valor);
    }
    
}
    
    private void rehashing(){
        nodoHash [] tmp= vectorHash;
        int tamanoTmp = tamano;
        if(indiceTam<tamanos.length){
            indiceTam+=1;
             if(indiceTam==tamanos.length - 1){
            System.out.println("Se alcanzo el tamaño maximo del arreglo hash");
        }
        }
       
        tamano = tamanos[indiceTam];
        vectorHash = new nodoHash[tamano];
        ocupados = 0;
        porcentajeUtil = calcularPorcentajeUtil();
        for(int i = 0;i<tamanoTmp;i++){
            if(tmp[i]!=null){
                insertar(tmp[i].nombrevar,tmp[i].tipo,tmp[i].ambito,tmp[i].valor);
            }
        }
        System.out.println("Rehashing realizado correctamemte");
    }
    
    public nodoHash extraerNodo(String nombreVar){
        boolean encontrado = false;
        nodoHash tmp = null;
        int pos = 0;
        for(int i= 0;i<tamano;i++){
            int posicion= DobleHashing(nombreVar,i);
            
            if(posicion>=tamano){
                posicion-=tamano;
                pos = posicion;
                
            }
            
            if(vectorHash[posicion]!= null){
                if(vectorHash[posicion].nombrevar.equals(nombreVar)){
                    tmp = vectorHash[posicion];
                    encontrado = true;
                    break;
                
            }
                
            }
        
    }
        
        if(encontrado){
            System.out.println("Se encontro la vaiable en la posicion: " +pos);
            
        }
        else{
            System.out.println("La variable " +nombreVar + " no se encuentra en la tabla");
        }
        return tmp;
    }
    
    

}