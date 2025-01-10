package TemaSincr; 
class Contador{
	int valor;
	
	public Contador(int valor){
		this.valor = valor;
	}
	
	public  void incrementar(){
		valor++;
	}
	
	public  void decrementar(){
		valor--;
	}
	
	public int getValor(){
		return valor;
	}
}

class HiloIncrementa extends Thread{
	Contador c;
	public HiloIncrementa(Contador c){
		this.c = c;
	}
	
	@Override
	public void run(){
		synchronized(c){
			for (int i = 0; i < 100; i++) {
				c.incrementar();
				System.out.println("incremento. Valor final: "+c.getValor());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) { }
			}
		}
		
		System.out.println("Fin de incremento. Valor final: "+c.getValor());
	}
}
class HiloDecrementa extends Thread{
	Contador c;
	public HiloDecrementa(Contador c){
		this.c = c;
	}
	@Override
	public void run(){
		synchronized(c) {
			for (int i = 0; i < 100; i++) {
				c.decrementar();
				System.out.println("Decremento. Valor final: "+c.getValor());
				try {
				Thread.sleep(10);
				} catch (InterruptedException e) { }
			}
		}
		
	System.out.println("Fin de decremento. Valor final: "+c.getValor());
	}
}

public class Ejercicio2 {
	public static void main(String[] args){
		Contador c = new Contador(100);
		HiloIncrementa tinc = new HiloIncrementa(c);
		HiloDecrementa tdec = new HiloDecrementa(c);
		tinc.start();
		tdec.start();
		}
}
