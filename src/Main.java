import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    ArrayList<String> palabrasReservadas = (ArrayList<String>)
            Arrays.asList("if", "else", "switch", "case", "default", "for", "while", "break", "int", "String", "double", "char");

    public static void main(String[] args) {
        System.out.print("Ingresa tu cadena: ");
        String cadena = s.nextLine();

        Automata asignacion = new Asignacion(cadena);
        asignacion.esAceptado();

        Automata comentario = new Comentario(cadena);
        comentario.esAceptado();

        Automata identificador = new Identificador(cadena);
        identificador.esAceptado();

        Automata numeroEntero = new NumeroEntero(cadena);
        numeroEntero.esAceptado();

        Automata numeroFlotante = new NumeroFlotante(cadena);
        numeroFlotante.esAceptado();

        Automata operadoLogico = new OperadoLogico(cadena);
        operadoLogico.esAceptado();

        Automata operadorAritmetico = new OperadorAritmetico(cadena);
        operadorAritmetico.esAceptado();

        Automata operadorRelacional = new OperadorRelacional(cadena);
        operadorRelacional.esAceptado();
    }
}