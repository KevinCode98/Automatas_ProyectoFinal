public final class NumeroEntero extends Automata {
    public static int cantidadNumeroEntero = 0;

    public NumeroEntero(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(Automata.position) >= 48 && cadena.charAt(Automata.position) <= 57) {
            if (cadena.charAt(Automata.position + 1) == ' ') {
                aceptado =  ;
                ++NumeroEntero.cantidadNumeroEntero;
                return;
            }
            Automata.position++;
            q0();
        }
    }
}
