public final class NumeroFlotante extends Automata {
    public static int cantidadNumeroFlotante = 0;

    public NumeroFlotante() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName() + "\n");
        if ((Automata.cadena.charAt(Automata.position) >= 48 && Automata.cadena.charAt(Automata.position) <= 57) ||
                (Automata.cadena.charAt(Automata.position) == '-' && Automata.cadena.charAt(position + 1) != ' ')) {
            Automata.position++;
            q0();
        } else if (Automata.cadena.charAt(Automata.position) == '.') {
            Automata.position++;
            q1();
        }
        GUI.appendLogTextArea();
    }

    private void q1() {
        if (Automata.position == Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q1 -> " + this.getClass().getSimpleName() + "\n");
        if ((Automata.cadena.charAt(Automata.position) >= 48 && Automata.cadena.charAt(Automata.position) <= 57)) {
            Automata.position++;
            q2();
        }
        GUI.appendLogTextArea();
    }

    private void q2() {
        if (Automata.position == Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q2 -> " + this.getClass().getSimpleName() + "\n");
        aceptado = true;
        ++NumeroFlotante.cantidadNumeroFlotante;
        GUI.appendLogTextArea();
    }
}
