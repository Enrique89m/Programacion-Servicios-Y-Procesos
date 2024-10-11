package Ejercicios1.Ejercicio8;

public class EsPalindromo {
    public static void main(String[] args) {
        String resultado = args[0].toUpperCase().replace(" ", "");
        String cadenaDelReves = "";

        for (int i = resultado.length()-1; i >= 0; i--) {
            cadenaDelReves = cadenaDelReves + resultado.charAt(i);
        }

        if (resultado.equals(cadenaDelReves)){
            System.out.println("La cadena pasada SI es palindromo");
        }else{
            System.out.println("La cadena pasada NO es palindromo");
        }
    }

}