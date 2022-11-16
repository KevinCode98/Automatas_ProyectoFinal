public abstract class Automata {
    protected abstract void q0();

    protected boolean aceptado;
    protected static String cadena;
    public static int position = 0;

    public Automata(String cadena) {
        Automata.cadena = cadena;
        this.aceptado = false;
    }

    protected void esAceptado() {
        if (this.aceptado) {
            System.out.println("Es un " + this.getClass().getSimpleName() + ".");
            ++Automata.position;
            if(Automata.position <= Automata.cadena.length()) {
                Main.inicializarAutomata(Automata.cadena);
            }
        } else System.out.println("No es un " + this.getClass().getSimpleName() + ".");
    }
}
