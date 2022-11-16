public final class Asignacion extends Automata {
    public static int cantidadAsignacion = 0;

    public Asignacion() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.charAt(Automata.position) == '=' && cadena.charAt(Automata.position + 1) == ' ') {
            aceptado = true;
            ++Asignacion.cantidadAsignacion;
        }
    }
}
