public final class Asignacion extends Automata {
    public static int cantidadAsignacion = 0;

    public Asignacion() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Entro en el estado q0 -> " + this.getClass().getSimpleName() + "\n");
        if (Automata.cadena.charAt(Automata.position) == '=') {
            aceptado = true;
            ++Asignacion.cantidadAsignacion;
        }
        GUI.appendLogTextArea();
    }
}
