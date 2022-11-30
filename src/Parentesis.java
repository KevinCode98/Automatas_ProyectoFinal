public class Parentesis extends Automata {
    public static int cantidadParentesis = 0;

    public Parentesis() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Automata.cadena.charAt(Automata.position) = " + Automata.position + "\n");
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName() + "\n");
        if ((Automata.cadena.charAt(Automata.position) == '(' ||
                Automata.cadena.charAt(Automata.position) == ')')
                && ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
            aceptado = true;
            ++Parentesis.cantidadParentesis;
        }
        GUI.appendLogTextArea();
    }
}
