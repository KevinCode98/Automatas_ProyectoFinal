import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.print("Ingresa tu cadena: ");
//        String cadena = s.nextLine() + " ";
//        Automata.cadena = cadena;
//        new ControlAutomata();
//
//        System.out.println("\n\n--------------- RESULTADO ---------------");
//        System.out.println("Asignación = " + Asignacion.cantidadAsignacion);
//        System.out.println("Comentario = " + Comentario.cantidadComentario);
//        System.out.println("Palabras reservadas = " + Identificador.cantidadPalabrasReservadas);
//        System.out.println("Identificador = " + Identificador.cantidadIdentificador);
//        System.out.println("Numero entero = " + NumeroEntero.cantidadNumeroEntero);
//        System.out.println("Numero flotante = " + NumeroFlotante.cantidadNumeroFlotante);
//        System.out.println("Operado lógico = " + OperadoLogico.cantidadOperadoLogico);
//        System.out.println("Operador aritmético = " + OperadorAritmetico.cantidadOperadorAritmetico);
//        System.out.println("Operador relacional = " + OperadorRelacional.cantidadOperadorRelacional);

        Runnable ventana = new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        };

        try {
            SwingUtilities.invokeAndWait(ventana);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}