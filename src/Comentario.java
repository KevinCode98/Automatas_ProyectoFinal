public final class Comentario extends Automata {
    public static int cantidadComentario = 0;

    public Comentario() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '/') {
            ++Automata.position;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q2();
        }
    }

    private void q2() {
        if (Automata.position >= Automata.cadena.length()) return;
        System.out.println("Entro en el estado q2 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q2 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q3();
        } else {
            Automata.position++;
            q2();
        }
    }

    private void q3() {
        System.out.println("Entro en el estado q3 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q3 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(Automata.position) == '/') {
            q4();
        } else if (cadena.charAt(Automata.position) == '*') {
            Automata.position++;
            q3();
        } else {
            Automata.position++;
            q2();
        }
    }

    private void q4() {
        System.out.println("Entro en el estado q4 -> " + this.getClass().getSimpleName());
        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q4 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(Automata.position + 1) == ' ' || cadena.charAt(Automata.position + 1) == '\n') {
            aceptado = true;
            ++Comentario.cantidadComentario;
        }
    }
}
