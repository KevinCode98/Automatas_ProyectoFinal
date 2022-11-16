public final class Comentario extends Automata {

    public Comentario(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) == '/') {
            position++;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) == '*') {
            position++;
            q2();
        }
    }

    private void q2() {
        if (position + 1 == cadena.length()) return;
        System.out.println("Entro en el estado q2 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(position) == '*') {
            position++;
            q3();
        } else {
            position++;
            q2();
        }
    }

    private void q3() {
        System.out.println("Entro en el estado q3 -> " + this.getClass().getSimpleName());
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
        System.out.println("Entro en el estado q4 -> " + this.getClass().getSimpleName());
        aceptado = position == cadena.length();
    }
}
