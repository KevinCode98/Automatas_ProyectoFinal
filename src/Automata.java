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
            System.out.println("Es un " + this.getClass().getSimpleName() + ".");
            GUI.textArea.setText(GUI.textArea.getText() + "\n" + GUI.textArea.getText() + "\n" + "Es un " + this.getClass().getSimpleName() + ".");
            if (Automata.position <= Automata.cadena.length()) {
                Automata.position++;
                new ControlAutomata();
                return this.aceptado;
            }
        } else {
            System.out.println("No es un " + this.getClass().getSimpleName() + ".");
            GUI.textArea.setText(GUI.textArea.getText() + "\n" + GUI.textArea.getText() + "\n" + "No es un " + this.getClass().getSimpleName() + ".");
            Automata.position = Automata.inicioPosition;
            return this.aceptado;
        }
        return this.aceptado;
    }
}
