public final class Comentario extends Automata {
    public static int cantidadComentario = 0;

    public Comentario() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName() + "\n");
        if (Automata.cadena.charAt(Automata.position) == '/') {
            ++Automata.position;
            q1();
        }
        GUI.appendLogTextArea();
    }

    private void q1() {
        GUI.logStringBuilder.append("Entro en el estado q1 -> " + this.getClass().getSimpleName() + "\n");
        if (Automata.cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q2();
        }
        GUI.appendLogTextArea();
    }

    private void q2() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q2 -> " + this.getClass().getSimpleName() + "\n");
        if (Automata.cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q3();
        } else {
            Automata.position++;
            q2();
        }
        GUI.appendLogTextArea();
    }

    private void q3() {
        GUI.logStringBuilder.append("Entro en el estado q3 -> " + this.getClass().getSimpleName() + "\n");
        if (cadena.charAt(Automata.position) == '/') {
            q4();
        } else if (cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q3();
        } else {
            Automata.position++;
            q2();
        }
        GUI.appendLogTextArea();
    }

    private void q4() {
        GUI.logStringBuilder.append("Entro en el estado q4 -> " + this.getClass().getSimpleName() + "\n");
        aceptado = true;
        ++Comentario.cantidadComentario;
        GUI.appendLogTextArea();
    }
}
