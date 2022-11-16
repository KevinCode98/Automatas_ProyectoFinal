import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingresa tu cadena: ");
        String cadena = s.nextLine() + " ";
        Automata.cadena = cadena;
        inicializarAutomata(cadena);

        System.out.println("\n\n--------------- RESULTADO ---------------");
        System.out.println("Asignacion.cantidadAsignacion = " + Asignacion.cantidadAsignacion);
        System.out.println("Comentario.cantidadComentario = " + Comentario.cantidadComentario);
        System.out.println("Identificador.cantidadPalabrasReservadas = " + Identificador.cantidadPalabrasReservadas);
        System.out.println("Identificador.cantidadIdentificador = " + Identificador.cantidadIdentificador);
        System.out.println("NumeroEntero.cantidadNumeroEntero = " + NumeroEntero.cantidadNumeroEntero);
        System.out.println("NumeroFlotante.cantidadNumeroFlotante = " + NumeroFlotante.cantidadNumeroFlotante);
        System.out.println("OperadoLogico.cantidadOperadoLogico = " + OperadoLogico.cantidadOperadoLogico);
        System.out.println("OperadorAritmetico.cantidadOperadorAritmetico = " + OperadorAritmetico.cantidadOperadorAritmetico);
        System.out.println("OperadorRelacional.cantidadOperadorRelacional = " + OperadorRelacional.cantidadOperadorRelacional);
    }

    public static void inicializarAutomata(String cadena) {
        System.out.println("\n-------------------------------------\n");
        if (Automata.position + 1 >= Automata.cadena.length()) return;

        if (cadena.charAt(Automata.position) == ' ') Automata.position++;
        System.out.println("cadena.charAt(Automata.position) = " + cadena.charAt(Automata.position));
        new Identificador(cadena).esAceptado();
        new Asignacion(cadena).esAceptado();
        new NumeroEntero(cadena).esAceptado(); // ->
        new NumeroFlotante(cadena).esAceptado();
        new OperadoLogico(cadena).esAceptado();
        new OperadorAritmetico(cadena).esAceptado();
        new OperadorRelacional(cadena).esAceptado();
        new Comentario(cadena).esAceptado();
    }
}