package com.placamas.seguridad;
import java.util.Random;

public class ManejadorDeContrase�as {
    
    private Random numeroAleatorio = new Random(4);
    private final int num = 1+numeroAleatorio.nextInt(10);
    

    public String encriptarContrase�a(String contrase�a){
   
        char arreglo[] = contrase�a.toCharArray();
        for (int i = 0; i < arreglo.length; i++) {
            
            arreglo[i] = (char)(arreglo[i]+(char)num);
            
        }
        String encriptado = String.valueOf(arreglo);
        
        return encriptado;
    }
   
    public String desentriptarContrase�a(String contrase�a){
        char arreglo[] = contrase�a.toCharArray();
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (char)(arreglo[i]-(char)num);
        }
        String desencriptado = String.valueOf(arreglo);
        
        return desencriptado;
    }
    
    public static void main(String args[]){
       ManejadorDeContrase�as man =  new ManejadorDeContrase�as();
        System.out.println(""+man.encriptarContrase�a("null"));;
        System.out.println(""+man.desentriptarContrase�a(man.encriptarContrase�a("null")));

    }
   
     
}
