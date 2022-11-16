public final class OperadorAritmetico extends Automata {
    public static int cantidadOperadorAritmetico = 0;

    public OperadorAritmetico(String cadena) {
        super(cadena);
        q0();
    }

    protected void q0() {
        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());
        if (cadena.equals("+") || cadena.equals("-") || cadena.equals("*") || cadena.equals("/") || cadena.equals("%")) {
            aceptado = true;
            ++OperadorAritmetico.cantidadOperadorAritmetico;
        }
    }
}
