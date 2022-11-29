public final class OperadorAritmetico extends Automata {
    public static int cantidadOperadorAritmetico = 0;

    public OperadorAritmetico() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if ((Automata.cadena.charAt(position) == '+' || Automata.cadena.charAt(Automata.position) == '-' ||
                Automata.cadena.charAt(Automata.position) == '*' || Automata.cadena.charAt(Automata.position) == '/' ||
                Automata.cadena.charAt(Automata.position) == '%') &&
                (ControlAutomata.saberSiHayEspacio(Automata.position + 1))) {
            aceptado = true;
            ++OperadorAritmetico.cantidadOperadorAritmetico;
        }
    }
}
