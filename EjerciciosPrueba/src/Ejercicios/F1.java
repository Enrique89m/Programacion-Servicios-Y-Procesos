

import java.util.*;


 class Coche extends Thread {
 private int numero;
 private boolean frenar;
 private int distancia;

public Coche(String nombre, int numero) {
 super(nombre);
 this.numero = numero;
 frenar = false;
 distancia = 0;
 System.out.println("Coche creado: "+nombre+"("+numero+")"); 
 }
public void run() {
 Random r = new Random();
 int num;
 while (frenar == false) {
	 num = (int)(r.nextDouble()*100);
	 distancia += num;
	
	 if (distancia > 500) {
	 frenar = true;
	 }else {
		 try {
		 Thread.sleep(1000);
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }
	  System.out.println(getName()+"("+numero+") lleva recorrido "+distancia+"km!");
	 }
 }
 System.out.println("-----------------------------------------------------------------------");
 System.out.println("El "+getName()+"("+numero+") ha finalizado al recorrer"+distancia+"km.");
 }
}

public class F1 {

public static void main(String[] args) {
 Scanner s = new Scanner(System.in);
 int numcoches=0;
 String marcacoche="";
 ArrayList<Coche> lista_coches = new ArrayList<Coche>();

 System.out.println("Introduzca numero de coches a competir:");
 numcoches = s.nextInt();
 s.nextLine();
 for (int i=1; i <= numcoches; i++) {
	 System.out.println("Introduzca marca del coche "+i+": ");
	 marcacoche = s.nextLine();
	 Coche c = new Coche(marcacoche,i);
	 lista_coches.add(c);
 }
 System.out.println("Que empiece la carrera!");

 for (int i = 0; i < lista_coches.size(); i++) {
     Coche coche = lista_coches.get(i);
     coche.start();
 }
}
}