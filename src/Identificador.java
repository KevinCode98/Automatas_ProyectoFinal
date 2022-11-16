public final class Identificador extends Automata {
    public static int cantidadIdentificador = 0;

    public Identificador(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        if (position == cadena.length()) return;
        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if ((cadena.charAt(position) >= 65 && cadena.charAt(position) <= 90) ||
                (cadena.charAt(position) >= 97 && cadena.charAt(position) <= 122) ||
                (cadena.charAt(position) == '_')) {
            if (position + 1 == cadena.length()) {
                aceptado = true;
                ++Identificador.cantidadIdentificador;
                return;
            }
            position++;
            q0();
        }
    }
}
