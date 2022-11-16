public final class Asignacion extends Automata {
    public static int cantidadAsignacion = 0;

    public Asignacion(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.equals("=")) {
            aceptado = true;
            ++Asignacion.cantidadAsignacion;
        }
    }
}
