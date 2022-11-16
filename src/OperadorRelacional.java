public final class OperadorRelacional extends Automata {
    public static int cantidadOperadorRelacional = 0;

    public OperadorRelacional(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        // Saber si el operador s<olo cuenta con un signo
        if ((cadena.charAt(position) == '<' || cadena.charAt(position) == '>') && cadena.length() == 1) {
            aceptado = true;
            return;
        }
        // Saber si el operador cuenta con dos signos
        if (cadena.charAt(position) == '<' || cadena.charAt(position) == '>' ||
                cadena.charAt(position) == '=' || cadena.charAt(position) == '!') {
            position++;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) == '=' && position + 1 == cadena.length()) {
            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
        }
    }
}
