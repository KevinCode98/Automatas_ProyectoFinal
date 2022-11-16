public final class OperadoLogico extends Automata {
    public static int cantidadOperadoLogico = 0;

    public OperadoLogico() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '!') {
            aceptado = true;
            ++OperadoLogico.cantidadOperadoLogico;
        }
        if ((Automata.cadena.charAt(Automata.position) == '&') || (Automata.cadena.charAt(Automata.position) == '|')) {
            Automata.position++;
            q1();
        }
    }

    private void q1() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (((Automata.cadena.charAt(Automata.position) == '&') || (Automata.cadena.charAt(Automata.position) == '|')) &&
                (Automata.cadena.charAt(Automata.position + 1) == ' ' || Automata.cadena.charAt(Automata.position + 1) == '\n')) {
            aceptado = true;
            ++OperadoLogico.cantidadOperadoLogico;
        }
    }
}
