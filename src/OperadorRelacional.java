public final class OperadorRelacional extends Automata {
    public static int cantidadOperadorRelacional = 0;

    public OperadorRelacional() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        // Saber si el operador s<olo cuenta con un signo
        if ((Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>')
                && cadena.charAt(Automata.position + 1) == ' ') {
            aceptado = true;
            return;
        }
        // Saber si el operador cuenta con dos signos
        if (Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>' ||
                Automata.cadena.charAt(Automata.position) == '=' || Automata.cadena.charAt(Automata.position) == '!') {
            Automata.position++;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '=' && cadena.charAt(Automata.position + 1) == ' ') {
            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
        }
    }
}
