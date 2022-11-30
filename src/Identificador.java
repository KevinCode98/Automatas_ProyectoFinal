import java.util.ArrayList;
import java.util.Arrays;

public final class Identificador extends Automata {
    private String identificador = "";
    public static int cantidadIdentificador = 0;
    public static int cantidadPalabrasReservadas = 0;
    private final ArrayList<String> palabrasReservadas = new ArrayList<>(
            Arrays.asList("if", "else", "switch", "case", "default", "for", "while", "break", "int", "String", "double", "char"));

    public Identificador() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName()+ "\n");

        if ((Automata.cadena.charAt(Automata.position) >= 65 && Automata.cadena.charAt(Automata.position) <= 90) ||
                (Automata.cadena.charAt(Automata.position) >= 97 && Automata.cadena.charAt(Automata.position) <= 122) ||
                (Automata.cadena.charAt(Automata.position) == '_')) {

            identificador += Automata.cadena.charAt(Automata.position);
            if (palabrasReservadas.contains(identificador) && ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
                aceptado = true;
                GUI.logStringBuilder.append("identificador = " + identificador+ "\n");

                Identificador.cantidadPalabrasReservadas++;
                return;
            }

            if (ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
                aceptado = true;
                GUI.logStringBuilder.append("identificador = " + identificador+ "\n");
                Identificador.cantidadIdentificador++;
                return;
            }
            Automata.position++;
            q0();
        }
        GUI.appendLogTextArea();
    }
}
