
package ej23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ej23 {

    
    public static void main(String[] args) throws IOException {
        float nota, notamedia= 0, notamax= 0,notamin= 0,notaAcumulada = 0, porPeq = 0, porMed = 0, porGra = 0;
      String nombre, nombremax="", nombremin="";
      int contador= 0, notaPeq= 0, notaMed= 0, notaGra= 0;
      Ej23 objeto;
      objeto=new Ej23();
      
      nombre= objeto.pedirNombre();
      while(!nombre.equalsIgnoreCase("*")){
          nota= objeto.pedirNota();
          contador++;
          notaAcumulada= notaAcumulada+nota;
          if (nota<5){
              notaPeq++;
              
          }else{
              if (nota>8){
                  notaGra++;
              }else{
                  notaMed++;
              }
          }
          
    if (nota>notamax) {
        nombremax=nombre;
        notamax=nota;
      
      }else{ 
       if (nota<notaPeq) {
        nombremin=nombre;
        notamin=nota;
        
    
      }
    }
    notamedia = notaAcumulada / contador;
    nombre = objeto.pedirNombre();
      
      } 
    
         porPeq = (float) notaPeq / contador * 100;
         porMed = (float) notaMed / contador * 100;
         porGra = (float) notaGra / contador * 100;
     
    System.out.println("EL ALUMNO/A CON LA NOTA MAS ALTA ES: "  + nombremax);
    System.out.println("EL ALUMNO/A CON LA NOTA MAS BAJA ES: " + nombremin);
    System.out.println("LA MEDIA DE LOS ALUMNOS ES : " + notamedia);
    
    System.out.println("MENOR QUE 5  " + notaPeq + "\t" + porPeq);
    System.out.println("ENTRE 5 Y 8  " + notaMed + "\t" + porMed);
    System.out.println("MAS DE 8     " + notaGra + "\t" + porGra);
       
   }
    public String pedirNombre() throws IOException {
    InputStreamReader flujo=new InputStreamReader (System.in);
    BufferedReader teclado=new BufferedReader (flujo);
    
    String nombre;
    System.out.print("INTRODUZCA NOMBRE: ");
    nombre=(teclado.readLine());
    while(nombre.equalsIgnoreCase("")){
    System.out.print(" ERROR VUELVA A INTRODUCIR NOMBRE: ");
    nombre=(teclado.readLine());
    
    }
    return nombre;
    
    }
    
    public float pedirNota() throws IOException {
    InputStreamReader flujo=new InputStreamReader (System.in);
    BufferedReader teclado=new BufferedReader (flujo);
    float nota = 0;
    boolean mal=true;
    while(mal){
        try{
        System.out.print("INTRODUZCA NOTA: ");
        nota = Float.parseFloat(teclado.readLine());
        while (nota < 0) {
            System.out.println("NOTA INCORRECTA.");
            System.out.print("VUELVA A INTRODUCIR NOTA: ");
            nota = Float.parseFloat(teclado.readLine()); 
        }//WHILE
        mal=false;
        }
        catch(NumberFormatException ex)
        {
             System.out.print("NO ES UN NUMERO.");
        }
        }
        return nota;
    }//PEDIR ESTATURA

}//C