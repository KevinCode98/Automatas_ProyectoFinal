public abstract class Automata {
    protected abstract void q0();

    protected boolean aceptado;
    protected static String cadena;
    public static int position = 0;
    public static int inicioPosition = 0;

    public Automata() {
        this.aceptado = false;
        Automata.inicioPosition = Automata.position;
    }

    protected boolean esAceptado() {
        if (this.aceptado) {
            GUI.logStringBuilder.append("Es un " + this.getClass().getSimpleName() + "." + "\n");
            if (Automata.position <= Automata.cadena.length()) {
                Automata.position++;
                ControlAutomata.automataEncontrado = true;
                return this.aceptado;
            }
        } else {
            GUI.logStringBuilder.append("No es un " + this.getClass().getSimpleName() + "." + "\n");
            ControlAutomata.automataEncontrado = false;
            Automata.position = Automata.inicioPosition;
            return this.aceptado;
        }
        GUI.appendLogTextArea();
        return this.aceptado;
    }
}
