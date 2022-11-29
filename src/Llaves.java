public class Llaves extends Automata {
    public static int cantidadLlaves = 0;

    public Llaves() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Automata.cadena.charAt(Automata.position) = " + Automata.cadena.charAt(Automata.position));

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if ((Automata.cadena.charAt(Automata.position) == '{' ||
                Automata.cadena.charAt(Automata.position) == '}')
                && ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
            aceptado = true;
            ++Llaves.cantidadLlaves;
        }
    }
}
