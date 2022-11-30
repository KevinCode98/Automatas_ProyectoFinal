public class Error {
    public static int cantindadError = 0;

    public Error() {
        q0();
    }

    void q0() {
        if (Automata.position + 1 >= Automata.cadena.length()) return;
        GUI.logStringBuilder.append("Error en la posicion-> " + Automata.position + "\n");
        while (!ControlAutomata.saberSiHayEspacio(Automata.position)) {
            ++Automata.position;
        }
        ++Error.cantindadError;
        GUI.appendLogTextArea();
    }
}