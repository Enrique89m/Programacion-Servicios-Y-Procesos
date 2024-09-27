package Ejercicios1.Ejercicio7;

public class SumadorArgs {
    public static int suma(int num1, int num2) {
        int resultadoSuma = 0;
        for (int i = num1; i <= num2; i++) {
            resultadoSuma += i;
        }
        return resultadoSuma;
    }
    public static void main(String[] args) {
            int numero1 = Integer.parseInt(args[0]);
            int numero2 = Integer.parseInt(args[1]);
            System.out.println("La suma de todos los numeros entre " + numero1 + " y "+ numero2 + " es "+ suma(numero1, numero2));
    }
}
