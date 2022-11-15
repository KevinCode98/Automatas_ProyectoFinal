import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingresa tu cadena: ");
        String cadena = s.nextLine();

//        Comentario comentario = new Comentario(cadena);
//        comentario.esComentario();
//
        NumeroEntero numeroEntero = new NumeroEntero(cadena);
        numeroEntero.esNumeroEntero();

//        NumeroFlotante numeroFlotante = new NumeroFlotante(cadena);
//        numeroFlotante.esNumeroFlotante();
    }
}