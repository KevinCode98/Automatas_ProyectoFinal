public final class NumeroFlotante extends Automata {
    public static int cantidadNumeroFlotante = 0;

    public NumeroFlotante(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            q0();
        } else if (cadena.charAt(position) == '.') {
            position++;
            q1();
        }
    }

    private void q1() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            if (position == cadena.length()) {
                aceptado = true;
                ++NumeroFlotante.cantidadNumeroFlotante;
            }
            q1();
        }
    }
}
