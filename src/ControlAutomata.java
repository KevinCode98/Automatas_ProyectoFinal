public class ControlAutomata {
    public static boolean automataEncontrado;
    public static int contadorErrores = 0;

    public ControlAutomata() {
        ControlAutomata.automataEncontrado = false;
        q0();
    }

    public static boolean saberSiHayEspacio(int position) {
        if (Automata.position + 1 >= Automata.cadena.length()) return false;

        return (Automata.cadena.charAt(position) == ' ' || Automata.cadena.charAt(position) == '\n' ||
                Automata.cadena.charAt(position) == '\t');
    }

    private void q0() {
        if (Automata.position + 1 >= Automata.cadena.length()) return;
        if (Automata.cadena.charAt(Automata.position) == ' ' || Automata.cadena.charAt(Automata.position) == '\n' ||
                Automata.cadena.charAt(Automata.position) == '\t') {
            Automata.position++;
            q0();
        } else {
            q1();
        }
    }

    private void q1() {
        if (Automata.position + 1 >= Automata.cadena.length()) return;

        System.out.println("cadena.charAt(Automata.position) = " + Automata.cadena.charAt(Automata.position));
        if (new NumeroFlotante().esAceptado()) q0();
        else if (new Identificador().esAceptado()) q0();
        else if (new NumeroEntero().esAceptado()) q0();
        else if (new OperadorAritmetico().esAceptado()) q0();
        else if (new OperadorRelacional().esAceptado()) q0();
        else if (new OperadoLogico().esAceptado()) q0();
        else if (new Comentario().esAceptado()) q0();
        else if (new Asignacion().esAceptado()) q0();
        else if (new Parentesis().esAceptado()) q0();
        else if (new Llaves().esAceptado()) q0();
        else {
            new Error();
            q0();
        }
    }
}
