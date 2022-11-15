public class Comentario {
    private boolean aceptado;
    private final String cadena;
    private int position;

    public Comentario(String cadena) {
        this.position = 0;
        this.cadena = cadena.replace(" ", "");
        q0();
    }

    private void q0() {
        System.out.println("Entro en el estado q0");
        if (cadena.charAt(position) == '/') {
            position++;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1");
        if (cadena.charAt(position) == '*') {
            position++;
            q2();
        }
    }

    private void q2() {
        if (position + 1 == cadena.length()) return;
        System.out.println("Entro en el estado q2");
        if (cadena.charAt(position) == '*') {
            position++;
            q3();
        } else {
            position++;
            q2();
        }
    }

    private void q3() {
        System.out.println("Entro en el estado q3");
        if (cadena.charAt(position) == '/') {
            position++;
            q4();
        } else if (cadena.charAt(position) == '*') {
            position++;
            q3();
        } else {
            position++;
            q2();
        }
    }

    private void q4() {
        System.out.println("Entro en el estado q4");
        aceptado = position == cadena.length();
    }

    public void esComentario() {
        if (this.aceptado) System.out.println("Es un comentario");
        else System.out.println("No es un comentario");
    }
}
