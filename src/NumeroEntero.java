public final class NumeroEntero extends Automata {
    public static int cantidadNumeroEntero = 0;

    public NumeroEntero() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if ((cadena.charAt(Automata.position) >= 48 && cadena.charAt(Automata.position) <= 57 )||
                Automata.cadena.charAt(Automata.position) == '-') {
            if (cadena.charAt(Automata.position + 1) == ' ') {
                aceptado = true;
                ++NumeroEntero.cantidadNumeroEntero;
                return;
            }
            Automata.position++;
            q0();
        }
    }
}
