import java.util.Random;

public class Carrera implements Runnable {

	private String nombre;
	
	
	public Carrera(String _nombre) {
		nombre = _nombre;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub

		Random r = new Random();
		for (int i = 0; i < 1500; i++) {
			try {
				Thread.sleep(r.nextInt(3));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("El corredor " + nombre + " lleva "+i);
		}
		
		System.out.println("El corredor " + nombre + " ha terminado");
		
		
	}

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		String[] corredores = { "Hicham El Guerrouj", "Noah Ngeny",
								"Mohamed Farah", "Bernard Lagat", "Rashid Ramzi",
								"Ryan Gregson", "Fermín Cacho", "Teddy Flack" };

		// Instanciamos y lanzamos los ocho corredores
	/*	for (int i = 0; i < corredores.length; i++) {
			new Thread(new Carrera(corredores[i])).start();
		}
*/
		Thread t1 = new Thread(new Carrera(corredores[0]));
		t1.start();
		Thread t2 = new Thread(new Carrera(corredores[1]));
		t2.start();
		Thread t3 = new Thread(new Carrera(corredores[2]));
		t3.start();
		Thread t4 = new Thread(new Carrera(corredores[3]));
		t4.start();
		Thread t5 = new Thread(new Carrera(corredores[4]));
		t5.start();
		Thread t6 = new Thread(new Carrera(corredores[5]));
		t6.start();
		Thread t7 = new Thread(new Carrera(corredores[6]));
		t7.start();
		Thread t8 = new Thread(new Carrera(corredores[7]));
		t8.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		t7.join();
		t8.join();

	}

}
