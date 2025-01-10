package restaurante;

import java.io.*;
import java.util.*;

public class Hilo extends Thread {
	private FileWriter file_primeros;
	private FileWriter file_segundos;
	private FileWriter file_postres;
 
public Hilo(FileWriter file_primeros, FileWriter file_segundos, FileWriter file_postres,String nom){
	super(nom);
 this.file_primeros = file_primeros;
 this.file_segundos = file_segundos;
 this.file_postres = file_postres;
 }

public void run() {
	File file_entrada= new File("menu.txt");
	Scanner sc = null;
	boolean prim_primeros = true;
	boolean prim_segundos = true;
	boolean prim_postres = true;
	String cadena_leida="";
//	System.out.println(currentThread().toString());
//Definimos scaner sobre el fichero de entrada
 try {
	 sc = new Scanner(file_entrada);
 } catch (FileNotFoundException e1) {
	 e1.printStackTrace();
 }
 //Bucle principal que ejecutaran los 3 hilos, cada uno escribirá en su fichero
try {
	 while (sc.hasNext()){
		 cadena_leida = sc.nextLine();
		 String[] partes = cadena_leida.split("-");
	 switch (partes[0]) {
	 	case "1": 
	 		if (currentThread().getName().equals("Hilo1")){
	 				if (prim_primeros) {
	 						prim_primeros = false;
	 				}else {
	 						file_primeros.write(partes[1]+"\n");
	 						System.out.println("El hilo1 escribe..."+partes[1]); }
	 			};
	 			break;
	 	case "2": 
	 		if (currentThread().getName().equals("Hilo2")){
			 if (prim_segundos) {
				 prim_segundos = false;
			 	}else {
					 file_segundos.write(partes[1]+"\n");
					 System.out.println("El hilo2 escribe..."+partes[1]);
					 }
				 };
				 break;
	 	case "3": 
	 		if (currentThread().getName().equals("Hilo3")){
				 if (prim_postres) {
					 prim_postres = false;
				 }else {
					file_postres.write(partes[1]+"\n");
					System.out.println("El hilo3 escribe..."+partes[1]);
					}
				};
				break;

		default: System.out.println("Hilo desconocido "+currentThread().getName());
		 break;
		 	}//switch*/
		 }//while
	 }catch (Exception e) {
		 System.out.println(e.getMessage());
	 }

 //Se cierran los ficheros de salida y el escaner
	 try {
		 file_primeros.close();
		 file_segundos.close();
		 file_postres.close();
		 sc.close();
	 } catch (IOException e) {
		 e.printStackTrace();
	 }

 	}

 
}
