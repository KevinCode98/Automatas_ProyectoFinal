public final class NumeroFlotante extends Automata {
    public static int cantidadNumeroFlotante = 0;

    public NumeroFlotante() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if ((Automata.cadena.charAt(Automata.position) >= 48 && Automata.cadena.charAt(Automata.position) <= 57) ||
                Automata.cadena.charAt(Automata.position) == '-') {
            Automata.position++;
            q0();
        } else if (Automata.cadena.charAt(Automata.position) == '.') {
            Automata.position++;
            q1();
        }
    }

    private void q1() {
        if (Automata.position == Automata.cadena.length()) return;

        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) >= 48 && Automata.cadena.charAt(Automata.position) <= 57 ||
                Automata.cadena.charAt(Automata.position) == '-') {
            if (cadena.charAt(Automata.position + 1) == ' ') {
                aceptado = true;
                ++NumeroFlotante.cantidadNumeroFlotante;
            }
            Automata.position++;
            q1();
        }
    }
}
