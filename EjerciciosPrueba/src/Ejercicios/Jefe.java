package TemaSincr;

class Empleado extends Thread{
	 String nombre;
	 Saludo saludo;
    boolean esJefe;
	
	Empleado(Saludo salu, boolean jefe, String n){
		this.nombre = n;
       this.saludo = salu;
       this.esJefe = jefe;
		
	}
	
	public void run() {
		
       System.out.println(nombre + " llegó.");
       try {
			Thread.sleep(1000);
			if(esJefe)
				saludo.SaludoJefe(nombre);
			else
				saludo.SaludoEmpleado(nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Saludo {
	private boolean HaLlegadoJefe;
	
	Saludo(){
		this.HaLlegadoJefe=false;
	}
	
	public synchronized void  SaludoEmpleado(String nom) {
		try {
			if(!this.HaLlegadoJefe) {
				wait();
				System.out.println(nom+"\n Buenos dias jefe.");
			}else{
				System.out.println(nom+"\n Perdon por el retraso.");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public synchronized void SaludoJefe(String nom) {
		
		System.out.println(nom+" Buenos dias a todos.");
		this.HaLlegadoJefe=true;
		notifyAll();
		
		
	}
}
public class Jefe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Saludo s = new Saludo();
		Empleado e1 = new Empleado(s,false,"A");
		Empleado e2 = new Empleado(s,false,"B");
		Empleado e3 = new Empleado(s,false,"C");
		Empleado e4 = new Empleado(s,false,"D");
		Empleado e5 = new Empleado(s,true,"BOSS");
		
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
		

		
	}

}