
import java.util.*;

public class Pentagono extends Thread {

	static int num=1;
	
public void run() {
	int acumulado=0;
	int aleat=0;
	
	Random r = new Random();

	

	String[] pinta = {"X","XX"};
	
	System.out.print("\nVirus "+Pentagono.num+":");
	Pentagono.num++;
	
	while (acumulado < 100) {
	
		aleat = (int)(r.nextDouble()*2);
		
		if (aleat == 0) 
			acumulado = acumulado + 5;
		else 
			acumulado = acumulado + 10;
	
	  if (acumulado <= 100) 
		  System.out.print(pinta[aleat]);
	  else 
		  System.out.print("X");
	
	
	
	try {
	
		Thread.sleep(200);
	
	} catch (InterruptedException e) {
		e.printStackTrace();}
	}
	
	
	

System.out.print(" 100%");

	
}
public static void main(String[] args) {

System.out.println("MISSION IMPOSIBLE: OPERACION PENTÁGONO");
System.out.println("Introduzca numero de virus a cargar...");

Scanner s = new Scanner(System.in);
int numvirus = s.nextInt();
Thread[] hilos = new Thread[numvirus];

for (int i=0; i < numvirus; i++) {

    hilos[i] = new Thread(new Pentagono());
    hilos[i].start();

try {

	  hilos[i].join();

} catch (InterruptedException e) {e.printStackTrace();}

}

System.out.println("\n\nEL PENTAGONO HA SIDO INFECTADO!");

}

}