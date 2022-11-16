public class ControlAutomata {
    public ControlAutomata() {
        q0();
    }

    private void q0() {
        if (Automata.position + 1 >= Automata.cadena.length()) return;
        if (Automata.cadena.charAt(Automata.position) == ' ' || Automata.cadena.charAt(Automata.position) == '\n'
                || Automata.cadena.charAt(Automata.position) == '\t') {
            Automata.position++;
            q0();
        } else q1();
    }

    private void q1() {
        System.out.println("cadena.charAt(Automata.position) = " + Automata.cadena.charAt(Automata.position));
        if (new Identificador().esAceptado()) return;
        if (new Asignacion().esAceptado()) return;
        if (new NumeroEntero().esAceptado()) return;
        if (new NumeroFlotante().esAceptado()) return;
        if (new OperadoLogico().esAceptado()) return;
        if (new OperadorAritmetico().esAceptado()) return;
        if (new OperadorRelacional().esAceptado()) return;
        if (new Comentario().esAceptado()) return;
    }
}
