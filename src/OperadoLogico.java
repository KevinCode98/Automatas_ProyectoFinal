public final class OperadoLogico extends Automata {
    public static int cantidadOperadoLogico = 0;

    public OperadoLogico(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.equals("!")) aceptado = true;
        if ((cadena.charAt(position) == '&') || (cadena.charAt(position) == '|')) {
            position++;
            q1();
        }
    }

    private void q1() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (((cadena.charAt(position) == '&') || (cadena.charAt(position) == '|')) && position + 1 == cadena.length()) {
            aceptado = true;
            ++OperadoLogico.cantidadOperadoLogico;
        }
    }
}
