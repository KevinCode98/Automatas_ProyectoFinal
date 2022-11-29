public class OperadorPuntoyComa extends  Automata{
    public static int cantidadOperadorPuntoyComa = 0;

    public OperadorPuntoyComa() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == ';') {
            aceptado = true;
            ++OperadorPuntoyComa.cantidadOperadorPuntoyComa;
        }
    }
}
