package TemaSincr;

class DatoCompartido {
	
	int dato;
	boolean disponible = false;
	
	public synchronized int obtener() {
		if (!disponible)
			try {
			wait();
			} catch (Exception e) {}
		
			disponible = false;
			notify();
			return dato;
	}
	public synchronized void poner(int nuevoDato) {
		if (disponible)
			try {
			wait();
			} catch (Exception e) {}
			dato = nuevoDato;
			disponible = true;
			notify();
	}
}
class Productor extends Thread {
	
	DatoCompartido dato;
	
	public Productor( DatoCompartido dato)
	{
		this.dato = dato;
	}
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			dato.poner(i);
			System.out.println("Número producido " + i);
			try
			{
			Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
}
class Consumidor extends Thread
{
	DatoCompartido dato;
	public Consumidor(DatoCompartido dato)
	{
		this.dato = dato;
	}
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			int n = dato.obtener();
			System.out.println("Número consumido " + n);
			try
			{
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
}
public class CompartiirDatos {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DatoCompartido sd = new DatoCompartido();
		
		Productor p = new Productor(sd);
		Consumidor c = new Consumidor(sd);
		
		
		p.start();
		c.start();
		
		p.join();
		
		System.out.println("Fin ");
	}

}
