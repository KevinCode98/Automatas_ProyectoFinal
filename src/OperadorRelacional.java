public final class OperadorRelacional extends Automata {
    public static int cantidadOperadorRelacional = 0;

    public OperadorRelacional() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName()+ "\n");
        if ((Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>') &&
                ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
            return;
        }


        if (Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>' ||
                Automata.cadena.charAt(Automata.position) == '=' || Automata.cadena.charAt(Automata.position) == '!') {
            Automata.position++;
            q1();
        }
        GUI.appendLogTextArea();
    }

    private void q1() {
        GUI.logStringBuilder.append("Entro en el estado q1 -> " + this.getClass().getSimpleName()+ "\n");
        if (Automata.cadena.charAt(Automata.position) == '=' &&
                ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
        }
        GUI.appendLogTextArea();
    }
}
