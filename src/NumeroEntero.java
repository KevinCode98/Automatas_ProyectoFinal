public final class NumeroEntero extends Automata {
    public static int cantidadNumeroEntero = 0;

    public NumeroEntero(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            if (position == cadena.length()) {
                aceptado = true;
                ++NumeroEntero.cantidadNumeroEntero;
            }
            q0();
        }
    }
}
