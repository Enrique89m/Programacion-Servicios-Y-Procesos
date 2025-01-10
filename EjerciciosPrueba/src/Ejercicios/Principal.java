package restaurante;

import java.io.*;

public class Principal {
	
public static void main(String[] args)throws IOException {

		
	 File primeros = new File("primeros.txt");
	 File segundos = new File("segundos.txt");
	 File postres = new File("postres.txt");
	 
	 FileWriter file_primeros=null;
	 FileWriter file_segundos=null;
	 FileWriter file_postres=null;
	
	 //Creación de ficheros de salida y del Scanner sobre el de entrada
	 try {
	
	 primeros.createNewFile();
	 file_primeros = new FileWriter(primeros);
	 segundos.createNewFile();
	 file_segundos = new FileWriter(segundos);
	 postres.createNewFile();
	 file_postres = new FileWriter(postres);
	 }catch(IOException e) {
	 System.out.println(e.getMessage());
	 }
	
	//ThreadGroup grupo = new ThreadGroup("Menu diario");
	
	 Hilo h1 = new Hilo(file_primeros,file_segundos,file_postres,"Hilo1");
	 Hilo h2 = new Hilo(file_primeros,file_segundos,file_postres,"Hilo2");
	 Hilo h3 = new Hilo(file_primeros,file_segundos,file_postres,"Hilo3");
	// Thread h1 = new Thread( h, "Hilo1");
	// Thread h2 = new Thread( h, "Hilo2");
	// Thread h3 = new Thread( h, "Hilo3");
	 h1.start();
	 h2.start();
	 h3.start();
	
	 }
}

