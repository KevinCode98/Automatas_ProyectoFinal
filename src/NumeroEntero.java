public final class NumeroEntero extends Automata {
    public static int cantidadNumeroEntero = 0;


    public NumeroEntero() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName()+ "\n");
        if ((Automata.cadena.charAt(Automata.position) >= 48 && Automata.cadena.charAt(Automata.position) <= 57) ||
                (Automata.cadena.charAt(Automata.position) == '-' && Automata.cadena.charAt(position + 1) != ' ')) {

            if (ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
                aceptado = true;
                ++NumeroEntero.cantidadNumeroEntero;
                return;
            }
            ++Automata.position;
            q0();
        }
        GUI.appendLogTextArea();
    }
}
