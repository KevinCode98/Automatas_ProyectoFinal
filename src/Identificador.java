import java.util.ArrayList;
import java.util.Arrays;

public final class Identificador extends Automata {
    public static int cantidadIdentificador = 0;
    public static int cantidadPalabrasReservadas = 0;

    private final ArrayList<String> palabrasReservadas = new ArrayList<>(
            Arrays.asList("if", "else", "switch", "case", "default", "for", "while", "break", "int", "String", "double", "char"));
    private String identificador;

    public Identificador() {
        super();
        identificador = "";
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q0 -> " + this.getClass().getSimpleName());
        identificador += Automata.cadena.charAt(position);
        if ((Automata.cadena.charAt(Automata.position) >= 65 && Automata.cadena.charAt(Automata.position) <= 90) ||
                (Automata.cadena.charAt(Automata.position) >= 97 && Automata.cadena.charAt(Automata.position) <= 122) ||
                (Automata.cadena.charAt(Automata.position) == '_')) {
            if (Automata.cadena.charAt(Automata.position + 1) == ' ' || Automata.cadena.charAt(Automata.position + 1) == '\n') {
                System.out.println("identificador = " + identificador);
                GUI.textArea.setText(GUI.textArea.getText() + "\n" + "identificador = " + identificador);
                aceptado = true;

                // Saber si se encuentra con alguna palabra reservada
                if (palabrasReservadas.contains(identificador)) {
                    System.out.println("identificador Palabra reservada = " + identificador);
                    GUI.textArea.setText(GUI.textArea.getText() + "\n" + "identificador Palabra reservada = " + identificador);
                    ++cantidadPalabrasReservadas;
                    return;
                }
                ++Identificador.cantidadIdentificador;
                return;
            }
            Automata.position++;
            q0();
        }
    }
}
